package actorselection

import akka.actor.Actor

class ActorSelection extends Actor {

  override def receive: Receive = {
    case message: Message => println("Got message " + message.message)
    case _ => println("Other message ")
  }
}
