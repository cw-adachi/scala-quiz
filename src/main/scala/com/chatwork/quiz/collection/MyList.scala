package com.chatwork.quiz.collection

import com.chatwork.quiz.{MySome, MyNone, MyOption}

import scala.annotation.tailrec

sealed trait MyList[+A] { self =>

  def head: A

  def isEmpty: Boolean

  def length: Int =
    foldLeft(0)((acc, _) => acc + 1)

  def foldLeft[B](z: B)(f: (B, A) => B): B = ???

  def foldRight[B](z: B)(f: (A, B) => B): B = ???

  def reduceLeft[B >: A] (f: (B, A) => B): B = ???

  def reduceRight[B >: A](f: (A, B) => B): B = ???
  def reduce[B >: A](f: (B, B) => B): B = ???

  def max[B >: A](implicit cmp: Ordering[B]): A = ???

  def min[B >: A](implicit cmp: Ordering[B]): A = ???

  def exists(p: A => Boolean): Boolean = ???

  def ::[B >: A](b: B): MyList[B] = ???

  def reverse: MyList[A] = ???

  def ++[B >: A](b: MyList[B]): MyList[B] = ???

  def map[B](f: A => B): MyList[B] = ???

  def flatMap[B](f: A => MyList[B]): MyList[B] = ???

  def find(f: A => Boolean): MyOption[A] = ???

  def startsWith[B >: A](prefix: MyList[B]): Boolean = ???

  def zip[B](other: MyList[B]): MyList[(A, B)] = ???

  def filter(p: A => Boolean): MyList[A] =
    foldRight(MyList[A]())((a, acc) => if (p(a)) a :: acc else acc)

  def withFilter(p: A => Boolean): MyList[A] = ???

  def forall(p: A => Boolean): Boolean = ???

  def toIndexSeq: IndexedSeq[A] = ???

  def headOption: MyOption[A] = ???

  def lastOption: MyOption[A] = ???

  def mkString(start: String, separator: String, end: String): String = ???

  def mkString(separator: String): String = ???

  def mkString: String = ???

}

case object MyNil extends MyList[Nothing] {

  def head = ???

  def isEmpty: Boolean = ???

}

case class MyCons[+A](head: A, tail: MyList[A]) extends MyList[A] {

  def isEmpty: Boolean = ???

}

object MyList {

  def empty[A]: MyList[A] = ???

  def apply[A](as: A*): MyList[A] = ???

  def fill[A](n: Int)(element: => A): MyList[A] = ???

}
