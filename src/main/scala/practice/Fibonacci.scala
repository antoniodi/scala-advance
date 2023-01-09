package practice

object Fibonacci {

  def main(args: Array[String]) = {
    println(fibonacci(1))
    println(fibonacci(2))
    println(fibonacci(3))
    println(fibonacci(4))
    println(fibonacci(5))
    println(fibonacci(6))
    println(fibonacci(7))
    println(fibonacci(8))
    println(fibonacci(9))
  }

  def fibonacci(n: Int): Int = {
    n match {
      case 1 => 1
      case 2 => 2
      case _ => fibonacci( n -1 ) + fibonacci( n - 2 )
    }
  }

}
