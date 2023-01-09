package practice

import scala.annotation.tailrec

object GroupedByCommas {

  def main(args: Array[String]): Unit = {
    val list = List(7,8)
    val result = list match {
      case h@ List(head, two, l, _*) => h
//      case h@ head :+ two :+ _ => head :+ two
      case _ => list(1)
    }
    println(result)
  }

  def groupByCommas2(n: Int): String = {
    f"$n%,d"
  }

  def groupByCommas3(n: Int): String = {
    n.toString.reverse.grouped(3).mkString(",").reverse
  }

  def groupByCommas(n: Int): String = {
    groupListByCommas(n.toString.reverse.toList).reverse
  }

  @tailrec
  def groupListByCommas(numbers: List[Char], numberWithCommas: String = ""): String = {
    numbers match {
      case number if number.length <= 3 => s"$numberWithCommas${number.mkString("")}"
      case list@ List(one, two, three, _*) => groupListByCommas( list.drop(3), s"$numberWithCommas$one$two$three,")
    }
  }

//                mod 10  div / 10
//  123 -> 321 -> 3    12.3               n - mod 10 * 10

  def reverse(n: Int): Int = {
    var restN: Int = n
    var reverseN: Int = 0
    while (restN > 0 ) {
      reverseN = reverseN * 10 + ( restN % 10 )
      restN = restN / 10
    }
    reverseN
  }
}
