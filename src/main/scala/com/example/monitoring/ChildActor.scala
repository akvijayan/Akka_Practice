package com.example.monitoring

import akka.actor.{Actor, PoisonPill, Terminated}

class ChildActor extends Actor {

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(self.path.name + " preRestart")
  }

  override def postRestart(reason: Throwable): Unit = {
    println(self.path.name + " postRestart")
  }

  override def receive: Receive = {
    case Terminated =>
      self ! PoisonPill
  }
}
