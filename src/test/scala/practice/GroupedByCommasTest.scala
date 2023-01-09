package practice

import org.scalatest.funsuite.AnyFunSuite

class GroupedByCommasTest extends AnyFunSuite {

  test("100 should have zero comma") {
    assert(GroupedByCommas.groupByCommas(100) == "100")
  }

  test("1000 should have one comma") {
    assert(GroupedByCommas.groupByCommas(1000) == "1,000")
  }

  test("10001 should have one comma") {
    assert(GroupedByCommas.groupByCommas(10001) == "10,001")
  }

  test("100011 should have one comma") {
    assert(GroupedByCommas.groupByCommas(100011) == "100,011")
  }

  test("1000111 should have one comma") {
    assert(GroupedByCommas.groupByCommas(1000111) == "1,000,111")
  }

}
