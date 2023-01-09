package practice

import org.scalatest.funsuite.AnyFunSuite

class TestScalacTest extends AnyFunSuite {
//
//  test("100 should have zero comma") {
//    assert(TestScalac.thereIsAGuardRow(">.A", 2)) // true
//    assert(TestScalac.thereIsAGuardRow("A.<", 0))    // true
//    assert(!TestScalac.thereIsAGuardRow("A..", 0))   // false
//    assert(!TestScalac.thereIsAGuardRow("...A", 3))    // false
//    assert(!TestScalac.thereIsAGuardRow(">X..A", 4)) // false
//    assert(!TestScalac.thereIsAGuardRow("A..X<", 0)) // false
//    assert(!TestScalac.thereIsAGuardRow("<..A", 3)) // false
//    assert(!TestScalac.thereIsAGuardRow("A..>", 0)) // false
//
//  }

  test("100 should have zero comma") {
    assert(TestScalac.thereIsAGuardColumn("A.^", 0))    // true
    assert(TestScalac.thereIsAGuardColumn("v.A", 2)) // true
    assert(!TestScalac.thereIsAGuardColumn("A..", 0))   // false
    assert(!TestScalac.thereIsAGuardColumn("...A", 3))    // false
    assert(!TestScalac.thereIsAGuardColumn("vX..A", 4)) // false
    assert(!TestScalac.thereIsAGuardColumn("A..X^", 0)) // false
    assert(!TestScalac.thereIsAGuardColumn("^..A", 3)) // false
    assert(!TestScalac.thereIsAGuardColumn("A..v", 0)) // false

  }

}