package com.example.replayactorbehaviorwithbecome

import akka.actor.Actor
import com.example.models.Message

class BecomeActor extends Actor {

  override def receive: Receive = disconnect

  def disconnect: Receive = {
    case Message("Connect") =>
      println("Connected")
      context.become(connect)
  }

  def connect: Receive = {
    case Message("disconnect") =>
      println("Disconnected")
  }
}
