package supervisor

import akka.actor.Actor
import supervisor.exception.{RestartException, ResumeException, StopException}

class ChildActor extends Actor {

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(self.path.name + " preRestart")
  }

  override def postRestart(reason: Throwable): Unit = {
    println(self.path.name + " postRestart")
  }

  override def receive: Receive = {
    case message: Message =>
      if(message.message == "Restart") {
        throw new RestartException
      }
      else if(message.message == "Resume") {
        throw new ResumeException
      }
      else {
        throw new StopException
      }
  }
}
