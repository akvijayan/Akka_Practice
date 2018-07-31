package com.example.supervisor

import akka.actor.{ActorSystem, Props}
import com.example.models.Message

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val parentActor = system.actorOf(Props(new ParentActor), "ParentActor")

  parentActor ! Message("Restart")
}
