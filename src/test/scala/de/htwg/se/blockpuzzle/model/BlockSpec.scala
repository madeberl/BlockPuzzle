package de.htwg.se.blockpuzzle.model
<<<<<<< HEAD
import org.scalatest._


class BlockSpec extends WordSpec with Matchers{
    "A Block" when {
      "new and Blocktype = -1" should {
        var block = Block(-1)
        "this is an empty block, only used for holding a place, without getting called or added to anything" in {
=======

import org.scalatest._

class BlockSpec extends WordSpec with Matchers{
    "A Block" when{
      "new gets filled with cells in dependency of its blocktype and each cell gets initiated with 0." +
        "funktion fill gets called automaticly, when ever a new block was created"
      "new and Blocktype = -1" should{
        var block = Block(-1)
        "this is an empty block, only used for holding a place, without getting called or added to anything" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(0)
          block.blockmaxy should be(0)
          block.blocktype should be(-1)
          block.toString should be("")
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 0" should {
        var block = Block(0)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 0" should{
        var block = Block(0)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(1)
          block.blockmaxy should be(1)
          block.cells(0)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 1" should {
        var block = Block(1)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 1" should{
        var block = Block(1)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(2)
          block.blockmaxy should be(1)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 2" should {
        var block = Block(2)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 2" should{
        var block = Block(2)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(2)
          block.blockmaxy should be(2)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 3" should {
        var block = Block(3)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 3" should{
        var block = Block(3)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(1)
          block.blockmaxy should be(2)
          block.cells(0)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 4" should {
        var block = Block(4)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 4" should{
        var block = Block(4)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(1)
          block.blockmaxy should be(3)
          block.cells(0)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(0)(2).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 5" should {
        var block = Block(5)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 5" should{
        var block = Block(5)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(1)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 6" should {
        var block = Block(6)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 6" should{
        var block = Block(6)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(2)
          block.blockmaxy should be(2)
          block.cells(0)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 7" should {
        var block = Block(7)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 7" should{
        var block = Block(7)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(3)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(1).isblocked should be(1)
          block.cells(0)(2).isblocked should be(1)
          block.cells(1)(2).isblocked should be(1)
          block.cells(2)(2).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 8" should {
        var block = Block(8)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 8" should{
        var block = Block(8)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(2)
          block.blockmaxy should be(2)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 9" should {
        var block = Block(9)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 9" should{
        var block = Block(9)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(2)
          block.cells(1)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(1).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 10" should {
        var block = Block(10)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 10" should{
        var block = Block(10)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(1)
          block.blockmaxy should be(4)
          block.cells(0)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(0)(2).isblocked should be(1)
          block.cells(0)(3).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 11" should {
        var block = Block(11)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 11" should{
        var block = Block(11)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(4)
          block.blockmaxy should be(1)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
          block.cells(3)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 12" should {
        var block = Block(12)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 12" should{
        var block = Block(12)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(1)
          block.blockmaxy should be(5)
          block.cells(0)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(0)(2).isblocked should be(1)
          block.cells(0)(3).isblocked should be(1)
          block.cells(0)(4).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 13" should {
        var block = Block(13)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 13" should{
        var block = Block(13)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(5)
          block.blockmaxy should be(1)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(0).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
          block.cells(3)(0).isblocked should be(1)
          block.cells(4)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 14" should {
        var block = Block(14)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 14" should{
        var block = Block(14)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(2)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(1).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 15" should {
        var block = Block(15)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 15" should{
        var block = Block(15)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(2)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(1).isblocked should be(1)
          block.cells(0)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 16" should {
        var block = Block(16)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 16" should{
        var block = Block(16)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(2)
          block.cells(1)(0).isblocked should be(1)
          block.cells(0)(1).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(0).isblocked should be(1)
        }
      }
<<<<<<< HEAD
      "new and Blocktype = 17" should {
        var block = Block(17)
        "blockmax should be and the body of block should" in {
=======
      "new and Blocktype = 17" should{
        var block = Block(17)
        "blockmax should be and the body of block should" in{
>>>>>>> SE-05_MVC
          block.blockmaxx should be(3)
          block.blockmaxy should be(2)
          block.cells(1)(0).isblocked should be(1)
          block.cells(0)(0).isblocked should be(1)
          block.cells(1)(1).isblocked should be(1)
          block.cells(2)(1).isblocked should be(1)
        }
      }
    }
}
