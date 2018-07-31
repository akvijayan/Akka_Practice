package com.example.actorselection

import akka.actor.Actor
import com.example.models.Message

class ActorSelection extends Actor {

  override def receive: Receive = {
    case message: Message => println("Got message " + message.message)
    case _ => println("Other message ")
  }
}
