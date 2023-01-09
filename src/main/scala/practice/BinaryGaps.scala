package practice

import practice.CodilityDemoTest.solution

import scala.collection.immutable.{AbstractMap, SeqMap, SortedMap}

object BinaryGaps {

  def main(args: Array[String]): Unit = {
    val number = 10
    println(number.toBinaryString)
    println(solution(number))
  }

  def solution(n: Int): Int = {
    val binaryGrouped = n.toBinaryString
    val binaryWithoutZeroLeft = binaryGrouped.toCharArray.dropWhile(_ == '0')
    val binaryWithoutZero = binaryWithoutZeroLeft.reverse.dropWhile(_ == '0').reverse
    val strings = binaryWithoutZero.mkString("").split('1')
    if (strings.length < 1) 0
    else {
      strings.maxBy(_.length).length
    }
  }
}
