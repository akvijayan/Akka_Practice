package replayactorbehaviorwithbecome

import akka.actor.{ActorSystem, Props, Terminated}

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val parentActor = system.actorOf(Props(new BecomeActor), "BecomeActor")

  parentActor ! Message("Connect")

  parentActor ! Message("disconnect")
}
