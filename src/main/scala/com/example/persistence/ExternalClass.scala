package com.example.persistence

import akka.actor.{ActorSystem, Props}
import com.example.models.{Decrement, Increment}

object ExternalClass extends App {

  val system = ActorSystem("PersistenceActor")

  val counterPersistentActor = system.actorOf(Props(new CounterPersistentActor), "CounterPersistentActor")

  counterPersistentActor ! Command(Increment(3))
  counterPersistentActor ! Command(Increment(4))
  counterPersistentActor ! Command(Decrement(2))
  counterPersistentActor ! "print"

  Thread.sleep(1000)

  system.terminate()
}
