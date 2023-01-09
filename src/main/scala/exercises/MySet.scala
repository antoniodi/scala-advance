package exercises

import org.scalactic.anyvals.NonEmptySet

import scala.annotation.tailrec

trait MySet[A] extends (A => Boolean) {

  def apply(elem: A): Boolean = contains(elem)
  def contains(elem: A): Boolean
  def +(elem: A): MySet[A]
  def ++(set: MySet[A]): MySet[A]

  def map[B](f: A => B): MySet[B]
  def flatMap[B](f: A => MySet[B]): MySet[B]
  def filter(predicate: A => Boolean): MySet[A]
  def foreach(f: A => Unit): Unit
}

class EmptySet[A] extends MySet[A] {

  def contains(elem: A): Boolean = false

  def +(elem: A): MySet[A] = NonEmptySet(elem, EmptySet())

  def ++(anotherSet: MySet[A]): MySet[A] = anotherSet

  def map[B](f: A => B): MySet[B] = EmptySet()

  def flatMap[B](f: A => MySet[B]): MySet[B] = EmptySet()

  def filter(predicate: A => Boolean): MySet[A] = this

  def foreach(f: A => Unit): Unit = ()

}

case class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A] {

  def contains(elem: A): Boolean = head == elem || tail.contains(elem)

  def +(elem: A): MySet[A] = if (this.contains(elem)) this else NonEmptySet(elem, this)

  def ++(anotherSet: MySet[A]): MySet[A] = tail ++ anotherSet + head

  def map[B](f: A => B): MySet[B] = this.tail.map(f) + f(this.head)

  def flatMap[B](f: A => MySet[B]): MySet[B] = this.tail.flatMap(f) ++ f(this.head)

  def filter(predicate: A => Boolean): MySet[A] = this match
    case NonEmptySet(head, tail) if predicate(head) => filter(tail)
    case NonEmptySet(head, tail) => NonEmptySet(head, filter(tail))

  def foreach(f: A => Unit): Unit = {
    f(this.head)
    this.tail.foreach(f)
  }

}


object MySet {

  def apply[A](values: A*): MySet[A] = {
    @tailrec
    def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] =
      if (valSeq.isEmpty) acc
      else buildSet(valSeq.tail, acc + valSeq.head)

    buildSet(values.toSeq, new EmptySet[A])
  }

}