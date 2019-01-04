package com.example.replayactorbehaviorwithbecome

import akka.actor.{ActorSystem, Props, Terminated}
import com.example.models.Message

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val parentActor = system.actorOf(Props(new BecomeActor), "BecomeActor")

  parentActor ! Message("Connect")

//  parentActor ! Message("disconnect")
}
