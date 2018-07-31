package monitoring

import akka.actor.{Actor, Props, Terminated}

class MonitorActor extends Actor {

  val childActor = context.actorOf(Props(new ChildActor), "ChildActor")

  override def preStart() = {
    println(self.path.name + " Prestart called")
  }

  override def postStop(): Unit = {
    println(self.path.name + " PostStop called")
  }

  override def receive: Receive = {
    case Terminated =>
      context.watch(childActor)
      childActor ! Terminated
  }
}
