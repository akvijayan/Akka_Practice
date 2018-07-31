package supervisor

import akka.actor.{ActorSystem, Props}

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val parentActor = system.actorOf(Props(new ParentActor), "ParentActor")

  parentActor ! Message("Restart")
}
