package ninetynineproblems

import scala.annotation.tailrec

object Level1_10 {

//  P01 (*) Find the last element of a list.
//  Example:
//    scala> lastListElement(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 8
  def lastListElement[A](ls: List[A]): A = ???

//  P02 (*) Find the last but one element of a list.
//  Example:
//    scala> penultimate(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 5
  def penultimate[A](ls: List[A]): A = ???

//  P03 (*) Find the Kth element of a list.
//  By convention, the first element in the list is element 0.
//  Example:
//
//    scala> nth(2, List(1, 1, 2, 3, 5, 8))
//  res0: Int = 2
  def nth[A](element:Int,ls: List[A]): A = ???

//  P04 (*) Find the number of elements of a list.
//    Example:
//    scala> length(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 6
  def lengthList[A](ls: List[A]): Int = ???


//  P05 (*) Reverse a list.
//  Example:
//    scala> reverse(List(1, 1, 2, 3, 5, 8))
//  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  def reverse[A](ls: List[A]): List[A] = ???

//  P06 (*) Find out whether a list is a palindrome.
//    Example:
//    scala> isPalindrome(List(1, 2, 3, 2, 1))
//  res0: Boolean = true
  def isPalindrome[A](ls: List[A]): Boolean = ???

//  P07 (**) Flatten a nested list structure.
//  Example:
//    scala> flattenList(List(List(1, 1), 2, List(3, List(5, 8))))
//  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  def flattenList(ls: List[Any]): List[Any] = ???


//  P08 (**) Eliminate consecutive duplicates of list elements.
//    If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
//    Example:
//
//    scala> removeConsecutiveDuplicates(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  def removeConsecutiveDuplicates[A](ls: List[A]): List[A] = ???

//  P09 (**) Pack consecutive duplicates of list elements into sublists.
//    If a list contains repeated elements they should be placed in separate sublists.
//    Example:
//
//    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def packList[A](ls: List[A]): List[List[A]] = ???


//  P10 (*) Run-length encoding of a list.
//    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
//  Example:
//
//    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encode[A](ls:List[A]):List[(Int, A)] = ???

}
