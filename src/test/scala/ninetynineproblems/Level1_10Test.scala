package ninetynineproblems

import java.util.NoSuchElementException

import org.scalatest._
import ninetynineproblems.Level1_10._

class Level1_10Test extends FlatSpec with Matchers {

  "The lastListElement method" should "return last element in a list" in {
    val lastElement = 9
    val list = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: lastElement :: Nil
    val list2 = 0 :: 1 :: lastElement :: Nil
    lastListElement(list) shouldEqual lastElement
    lastListElement(list2) shouldEqual lastElement
    noException should be thrownBy lastListElement(list)
  }

  "The lastListElement method" should "throw an exception with empty list" in {
    the [NoSuchElementException] thrownBy {
      lastListElement(Nil)
    } should have message "Bad input"
  }

  "The penultimate method" should "return last but one element in a list" in {
    val lastElement = 9
    val lastButOneElement = 8
    val list = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: lastButOneElement :: lastElement :: Nil
    val list2 = 0 :: lastButOneElement :: lastElement :: Nil
    penultimate(list) shouldEqual lastButOneElement
    penultimate(list2) shouldEqual lastButOneElement
    noException should be thrownBy penultimate(list)
  }

  "The penultimate method" should "throw an exception with empty list" in {
    the [NoSuchElementException] thrownBy {
      penultimate(Nil)
    } should have message "Bad input"
  }

  "The penultimate method" should "throw an exception with list with only one element" in {
    the [NoSuchElementException] thrownBy {
      penultimate(0 :: Nil)
    } should have message "Bad input, list with only one element"
  }

  "The nth method" should "return nth element in a list" in {
    val nthPos = 2
    val nthValue = 42
    val list = 0 :: 1 :: nthValue :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil
    val list2 = 0 :: 1 :: nthValue :: Nil
    nth(nthPos,list) shouldEqual nthValue
    nth(nthPos,list2) shouldEqual nthValue
    noException should be thrownBy nth(nthPos,list)
  }

  "The nth method" should "throw an exception with short list" in {
    the [NoSuchElementException] thrownBy {
      nth(0,Nil)
    } should have message "List too short"
    the [NoSuchElementException] thrownBy {
      nth(100,1 :: Nil)
    } should have message "List too short"
  }

  "The nth method" should "throw an exception with a negative element" in {
    the [NoSuchElementException] thrownBy {
      nth(-1,1 :: Nil)
    } should have message "Element must be greater or equals to 0"
  }

  "The length method" should "return length in a list" in {
    val length1 = 10
    val length2 = 3
    val list = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil
    val list2 = 0 :: 1 :: 2 :: Nil
    lengthList(list) shouldEqual length1
    lengthList(list2) shouldEqual length2
    lengthList(Nil) shouldEqual 0
    noException should be thrownBy lengthList(list)
  }

  "The reverse method" should "return the reversed list" in {
    val list = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil
    val listReverse = 9 :: 8 :: 7 :: 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: 0 :: Nil
    reverse(list) shouldEqual listReverse
    reverse(listReverse) shouldEqual list
    reverse(Nil) shouldEqual Nil
    noException should be thrownBy reverse(list)
  }

  "The isPalindrome method" should "return if the list is a palindrome" in {
    val listNotPalindrome = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: Nil
    val listPalindrome = 0 :: 1 :: 2 :: 3 :: 4 :: 4 :: 3 :: 2 :: 1 :: 0 :: Nil
    isPalindrome(listPalindrome) shouldEqual true
    isPalindrome(listNotPalindrome) shouldEqual false
    isPalindrome(Nil) shouldEqual true
    noException should be thrownBy isPalindrome(listPalindrome)
  }

  "The flattenList method" should "return the list flatten" in {
    val list = List(1,2,List(3,4,5,List(6,7,8,(List(9)))))
    val flattenedlist = List(1,2,3,4,5,6,7,8,9)
    flattenList(list) shouldEqual flattenedlist
    flattenList(Nil) shouldEqual Nil
    noException should be thrownBy flattenList(list)
  }

  "The removeConsecutiveDuplicates method" should "return the list without consecutive duplicates" in {
    val list = List(1,2,2,2,3,3,4,5,6,6,6,6,6,7,5,4,3,2,1,8,8,9)
    val listNoduplicates = List(1,2,3,4,5,6,7,5,4,3,2,1,8,9)
    removeConsecutiveDuplicates(list) shouldEqual listNoduplicates
    removeConsecutiveDuplicates(Nil) shouldEqual Nil
    noException should be thrownBy removeConsecutiveDuplicates(list)
  }

  "The packList method" should "return the list ..." in {
    val list = List(1,2,2,2,3,3,6,6,6,6,6,4,5,7,5,5)
    val packedList = List(List(1),List(2,2,2),List(3,3),List(6,6,6,6,6),List(4),List(5),List(7),List(5,5))
    packList(list) shouldEqual packedList
    packList(Nil) shouldEqual List(Nil)
    noException should be thrownBy packList(list)
  }

}
