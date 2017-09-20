package monplay

import monix.eval.{TaskApp, Task}

object Playground extends TaskApp {
  override def runc = Task {
    println("Hello, world!")
  }    
}