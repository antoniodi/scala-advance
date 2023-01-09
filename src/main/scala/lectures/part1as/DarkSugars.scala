package lectures.part1as

import java.awt.Composite

object DarkSugars extends App {

  //  syntax sugar #2: single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = (x: Int) => x + 1

  //  example: Rnnables
  val aThread = new Thread(new Runnable {
    def run(): Unit = println("Hello, Scala")
  })

  val aSweeterThread = new Thread(() => println("Hello, Scala"))

  //  syntax sugar #3: the :: and #:: methods are special

  val prependedList = 2 :: List(3,4)
  val aPrependedList = List(3,4) :+ 1
  val bPrependedList = 1 +: List(3,4)
  val cPrependedList = List(3,4) :: List(3,4)

  //  syntax sugar #5: infix types and infix generics types
  class Composite[A, B]
//  val composite: Unit = Int Composite String = ???

  //  syntax sugar #7: setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member = internalMember // getter
    def member_=(value: Int): Unit = internalMember = value
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 43 // rewritten as aMutableContainer.member
}
