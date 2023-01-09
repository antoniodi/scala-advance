package practice

import practice.CodilityDemoTest.solution

object TestScalac {

  def main(args: Array[String]): Unit = {
    println(solution(
      Array("...", ">.A")
    ))
  }

  def solution(b: Array[String]): Boolean = {
    val board = b.map(_.toCharArray)
    var i = 0
    var j = 0
    while ( i < board.length ) {
        while ( j < board(i).length ) {
          if ( board(i)(j) == 'A' ) {
            val a = b(i)
            if ( thereIsAGuardRow(b(i), j) || thereIsAGuardColumn(b.map(row => row(j)).mkString(""), i)) {
              return false
            }
          }
          j = j + 1
        }
      println("1")
      i = i + 1
    }
    true
  }

  def thereIsAGuardRow(boardRow: String, assassinLocation: Int): Boolean = {
    if (boardRow.substring(0, assassinLocation).reverse.dropWhile(_ == '.').headOption.contains('>')) {
      true
    } else if ( boardRow.substring(assassinLocation + 1, boardRow.length).dropWhile(_ == '.').headOption.contains('<') ) true
    else false
  }

  def thereIsAGuardColumn(boardRow: String, assassinLocation: Int): Boolean = {
    if (boardRow.substring(0, assassinLocation).reverse.dropWhile(_ == '.').headOption.contains('v')) {
      true
    } else if ( boardRow.substring(assassinLocation + 1, boardRow.length).dropWhile(_ == '.').headOption.contains('^') ) true
    else false
  }



//  while ( j < board(i).length ) {
//    if ( board(i)(j) == 'A' ) {
//      if ( thereIsAGuard(b(i), j) ) {
//        return false
//      }
//      return true
//    }
//    j = j + 1
//  }

}
