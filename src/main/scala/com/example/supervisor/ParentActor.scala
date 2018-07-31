package com.example.supervisor

import akka.actor.SupervisorStrategy.{Restart, Resume, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props, SupervisorStrategy}
import com.example.models.Message
import com.example.supervisor.exception.{RestartException, ResumeException, StopException}

class ParentActor extends Actor {

  override def preStart() = {
    println(self.path.name + " Prestart called")
  }

  override def postStop(): Unit = {
    println(self.path.name + " PostStop called")
  }

  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy() {
    case _: RestartException => Restart
    case _: ResumeException => Resume
    case _: StopException => Stop
  }

  val childActor = context.actorOf(Props(new ChildActor), "ChildActor")

  override def receive:Receive = {
    case message: Message =>
      childActor forward message
  }
}
