package practice

object ArrayDiff {

  def main(args: Array[String]): Unit = {
//    println(solution(Array(1, 3, 6 ,4 ,1 ,2)))
    println(solution(Array(1, 2, 3)))
  }

  def solution(a: Array[Int]): Int = {
    val sorted = a.filter(_ >= 0).sorted
    sorted.headOption match {
      case None => 1
      case Some( 1 ) if sorted.length == 1 => 1
      case _ => {
        var i = 1
        var minNonOccurs = 1
        while (i < sorted.length) {
          val difference = sorted( i ) - sorted(i - 1)
          if (difference > 1) {
            return sorted(i - 1) + 1
          }
          i = i + 1
        }
        if (minNonOccurs == 1) sorted.last + 1 else minNonOccurs
      }
    }

  }
}
