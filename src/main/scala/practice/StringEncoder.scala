package practice

import java.util.regex.Pattern
import scala.annotation.tailrec

object StringEncoder {

  def main(args: Array[String]) = {
    val array = Array(
      Array(1, 1, 1, 0, 0, 0),
      Array(0, 1, 0, 0, 0, 0),
      Array(1, 1, 1, 0, 0, 0),
      Array(0, 0, 2, 4, 4, 0),
      Array(0, 0, 0, 2, 0, 0),
      Array(0, 0, 1, 2, 4, 0))

    println(hourglassSum(array))
  }


  @tailrec
  def encoderOne(tail: String, head: List[String] = Nil): String = {
    val specialString = '|'
    tail.headOption match {
      case None => head.mkString("").replace(specialString.toString, ")")
      case Some(value) if value == specialString => encoderOne(tail.drop(1), head :+ value.toString)
      case Some(value) if tail.tail.contains(value) => encoderOne(tail.drop(1).replace(value, specialString), head :+ specialString.toString)
      case _ => encoderOne(tail.drop(1), head :+ "(")
    }
  }

  def encoderTwo(word: String): String = {
    word.toLowerCase.groupBy(identity).map {
      case (_, string) => if (string.length > 2) "(" else ")"
    }.mkString("")
  }


  def hourglassSum(arr: Array[Array[Int]]): Int = {
    var hourglass = List[Int]()
    for (i <- 0 until arr.length - 2 ) {
      for (j <- 0 until arr(1).length - 2 ) {
        hourglass = hourglass :+ (arr(i)(j) + arr(i)(j + 1) + arr(i)(j + 2) + arr(i + 1)(j + 1) + arr(i + 2)(j) + arr(i + 2)(j + 1) + arr(i + 2)(j + 2))
      }
    }
    hourglass.max
  }

}
