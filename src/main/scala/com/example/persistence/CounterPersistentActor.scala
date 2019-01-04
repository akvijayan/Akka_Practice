package com.example.persistence

import akka.persistence.{PersistentActor, SnapshotOffer}
import com.example.models.{Decrement, Increment}

class CounterPersistentActor extends PersistentActor {

  override val persistenceId: String = "counter-actor"
  var state = State(count = 0)

  def updateState(event:Event) = {
    event match {
      case Event(Increment(count)) => state = State(state.count + count)
      case Event(Decrement(count)) => state = State(state.count - count)
    }
  }

  override def receiveRecover: Receive = {
    case event: Event =>
      println(s"Counter receive $event on recovering mood")
      updateState(event)
    case SnapshotOffer(_, snapshot: State) =>
      println(s"Counter receive snapshot with data: $snapshot on recovering mood")
      state = snapshot
  }

  override def receiveCommand: Receive = {
    case command @ Command(op) =>
      println(s"Counter receive $command")
      persist(Event(op)) { event =>
        updateState(event)
      }
    case "print" => println(s"Current State: ${state.count}")
  }
}
