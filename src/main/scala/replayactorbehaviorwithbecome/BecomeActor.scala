package replayactorbehaviorwithbecome

import akka.actor.Actor

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
