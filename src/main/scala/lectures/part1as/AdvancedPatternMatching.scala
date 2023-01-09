package lectures.part1as

object AdvancedPatternMatching extends App {

  val numbers = List(1)
  val firstValue = numbers match {
    case head :: Nil => head
    case _ => ???
  }

  class Person(val name: String, val age: Int)
  val person = new Person("Bob", 12)

  object Person {
    def unapply(aPerson: Person): Option[(String, Int)] =
      if (aPerson.age < 15) None
      else Some((aPerson.name, aPerson.age))
  }

  val personDescription = person match {
    case Person(name, age) => println(s"Hi $name")
    case _ => println("wherever")
  }

  println(personDescription)

  /*
    Exercise
  */
  val n: Int = 12
  val mathProperty = n match {
    case x if x < 10 => "single digit"
    case x if x % 2 == 0 => "an even number"
    case _ => "no property"
  }

  object singleDigit {
    def unapply(arg: Int): Boolean = arg > -10 && arg < 10
  }
  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }

  val mathPropertyPattern = n match {
    case singleDigit() => "single digit"
    case even() => "an even number"
    case _ => "no property"
  }

  println(mathPropertyPattern)

  // infix patterns
  case class Or[A, B](a: A, b: B)
  val either = Or(2, "two")
  val humanDescription = either match {
    case number Or string => s"$number is written as $string"
  }
  println(humanDescription)

  // decomposing sequences
  val vararg = numbers match {
    case List(head, _*) => s"staring with $head"
  }

  abstract class MyList[+A] {
    def head: A = ???
    def tail: MyList[A] = ???
  }
  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  def myList: Unit = {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] =
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
  }

  val monetaryString = "000100.23400"
  val monetaryBigDecimal = BigDecimal(monetaryString)
  println(s"The monetary amount in double is = ${monetaryString.toDouble}")

}
