package monitoring

import akka.actor.{ActorSystem, Props, Terminated}

object ExternalClass extends App {

  val system = ActorSystem("ActorSystem")

  val parentActor = system.actorOf(Props(new MonitorActor), "ParentActor")

  parentActor ! Terminated
}
