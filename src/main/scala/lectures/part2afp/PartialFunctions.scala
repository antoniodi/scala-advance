package lectures.part2afp

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1

  val aFussyFunction = (x: Int) => {
    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 999
    else throw new FunctionNotApplicableException
  }

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 43
    case 2 => 56
    case 5 => 999
  }

  val aOptionalFunction: Int => Option[Int] = {
    case 1 => None
    case x => Some(x)
  }

//  println(aOptionalFunction.unlift(1))
//  println(aOptionalFunction.unlift(0))


  /**
   * Exercises
   * 1 - construct a PF instance yourself (anonymous class)
   * 2 - dumb chabot as a PF
   */
  val aPartialFunction: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    override def isDefinedAt(x: Int): Boolean = x == 10
    override def apply(v1: Int): Int = 20

  }

  println(aPartialFunction(10))

  val aPatterPartialFunction: PartialFunction[Int, Int]  = {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  } // partial function value

//  println(aPatterPartialFunction andThen aPatterPartialFunction)

  // PF extends normal functions
  val aTotalFunction: Int => Int = {
    case 1 => 99
  }

   /*
    Note: PF can only have one parameter
   */

    /**
     * Exercises
     *
     * 1 - Construct a PF instance yourself (anonymouse class)
     * 2 - dumb chatbot as a PF
    */
    val anonymousFunction : PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
      override def apply(v1: Int): Int = ???

      override def isDefinedAt(x: Int): Boolean = ???
    }

    val chatBotPF: PartialFunction[String,String] = {
      case "1" => "Is a pleasure help to you"
      case "2" => "great questions"
      case _ => "The right options are 1 and 2"
    }

    println("How can I help you?")
    println("1 - for help")
    println("2 - write a question")
    scala.io.Source.stdin.getLines().foreach(lines => println(chatBotPF(lines)))

}
