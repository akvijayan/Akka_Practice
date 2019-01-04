package com.example.models

sealed trait Operation {
  val count: Int
}

case class Increment(override val count: Int) extends Operation

case class Decrement(override val count: Int) extends Operation
