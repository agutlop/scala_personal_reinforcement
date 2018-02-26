package ninetynineproblems

import scala.annotation.tailrec

object Level1_10 {

//  P01 (*) Find the last element of a list.
//  Example:
//    scala> lastListElement(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 8
  @tailrec
  def lastListElement[A](ls: List[A]): A = {
    ls match {
      case x :: Nil => x
      case x :: xs => lastListElement(xs)
      case _ => throw new NoSuchElementException("Bad input")
    }
  }

//  P02 (*) Find the last but one element of a list.
//  Example:
//    scala> penultimate(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 5
  @tailrec
  def penultimate[A](ls: List[A]): A = {
    ls match {
      case x :: y :: Nil => x
      case x :: Nil => throw new NoSuchElementException("Bad input, list with only one element")
      case x :: xs => penultimate(xs)
      case _ => throw new NoSuchElementException("Bad input")
    }
  }

//  P03 (*) Find the Kth element of a list.
//  By convention, the first element in the list is element 0.
//  Example:
//
//    scala> nth(2, List(1, 1, 2, 3, 5, 8))
//  res0: Int = 2
  @tailrec
  def nth[A](element:Int,ls: List[A]): A = {
    if (element < 0) throw new NoSuchElementException("Element must be greater or equals to 0")
    (element,ls) match {
      case (0, x :: xs) => x
      case (n, x :: xs) => nth(n-1,xs)
      case (n, Nil) => throw new NoSuchElementException("List too short")
    }
  }

//  P04 (*) Find the number of elements of a list.
//    Example:
//    scala> length(List(1, 1, 2, 3, 5, 8))
//  res0: Int = 6
  def lengthList[A](ls: List[A]): Int = {
    @tailrec
    def lengthRec[A](result:Int, ls: List[A]): Int = {
      ls match {
        case Nil => result
        case x :: xs=> lengthRec(result+1,xs)
      }
    }
    lengthRec(0,ls)
  }


//  P05 (*) Reverse a list.
//  Example:
//    scala> reverse(List(1, 1, 2, 3, 5, 8))
//  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  def reverse[A](ls: List[A]): List[A] = {
    @tailrec
    def reverseRec[A](result: List[A], ls: List[A]): List[A] = {
      ls match {
        case Nil => result
        case x :: xs=> reverseRec(x :: result,xs)
      }
    }
    reverseRec(Nil,ls)
  }

//  P06 (*) Find out whether a list is a palindrome.
//    Example:
//    scala> isPalindrome(List(1, 2, 3, 2, 1))
//  res0: Boolean = true
  def isPalindrome[A](ls: List[A]): Boolean = {
    ls equals reverse(ls)
  }

//  P07 (**) Flatten a nested list structure.
//  Example:
//    scala> flattenList(List(List(1, 1), 2, List(3, List(5, 8))))
//  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  def flattenList(ls: List[Any]): List[Any] =
  ls flatMap {
    case xs: List[_] => flattenList(xs)
    case x => List(x)
  }


//  P08 (**) Eliminate consecutive duplicates of list elements.
//    If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
//    Example:
//
//    scala> removeConsecutiveDuplicates(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  def removeConsecutiveDuplicates[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }

//  P09 (**) Pack consecutive duplicates of list elements into sublists.
//    If a list contains repeated elements they should be placed in separate sublists.
//    Example:
//
//    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def packList[A](ls: List[A]): List[List[A]] = {
    def packRec[A](ls:List[A],lastElem:A,lsInProgress:List[A],result:List[List[A]]):List[List[A]] = {
      ls match {
        case Nil => lsInProgress :: result
        case x :: xs=> {
          if (lastElem equals x) {
            packRec(xs,x,x :: lsInProgress,result)
          } else {
            packRec(xs,x,x :: Nil,lsInProgress::result)
          }
        }
      }
    }
    if (ls isEmpty){
      List(ls)
    } else {
      reverse(packRec(ls tail,ls head, ls.head :: Nil, Nil))
    }
  }
  //official solution, les complex than mine
//  def pack[A](ls: List[A]): List[List[A]] = {
//    if (ls.isEmpty) List(List())
//    else {
//      val (packed, next) = ls span { _ == ls.head }
//      if (next == Nil) List(packed)
//      else packed :: pack(next)
//    }
//  }


//  P10 (*) Run-length encoding of a list.
//    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
//  Example:
//
//    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encode[A](ls:List[A]):List[(Int, A)] = ???

}
