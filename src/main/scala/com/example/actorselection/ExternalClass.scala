package com.example.actorselection

import akka.actor.{ActorRef, ActorSystem, Props}
import com.example.models.Message

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val actor: ActorRef = system.actorOf(Props(new ActorSelection),"ActorSelection")

  println("Actor path "+ actor.path)

  //actor selection select existing actor and if not present it will generate a dead letter
  val actorSelection = system.actorSelection("/user/ActorSelection")

  println("Actor Selection "+ actorSelection)
  actorSelection ! Message("MyActor")
}
