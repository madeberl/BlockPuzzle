package de.htwg.se.blockpuzzle.controller
import org.scalatest._
import de.htwg.se.blockpuzzle.model.{Block, Field}


class ControllerSpec extends WordSpec with Matchers {
  "A controller" when {
    val controller1 = new Controller()
    "new" should {
      "will call the reset funktion, create a field and three random blocks" in {
        controller1.field.fieldsize should be(controller1.fieldsize)
        controller1.availableBlocks should be(3)
        controller1.b1.blocktype should not be(-1)
        controller1.b2.blocktype should not be(-1)
        controller1.b3.blocktype should not be(-1)
      }
      "also should set a new stack of states for the play-history" in {
        controller1.history.size should be (0)
      }
    }

    "in use" should {
      "create a new and empty field with the funktion createField" in {
        controller1.createField
        controller1.field.fieldsize should be(controller1.fieldsize)
        for(y <- 0 until controller1.field.fieldsize;
            x <- 0 until controller1.field.fieldsize){
          controller1.field.cells(x)(y).isblocked should be(0)
        }
      }

      "reset the game to its default and set all blocks new. Count is 0 and field is empty" in {
        controller1.reset
        controller1.availableBlocks should be(3)
        for(y <- 0 until controller1.field.fieldsize;
            x <- 0 until controller1.field.fieldsize){
          controller1.field.cells(x)(y).isblocked should be(0)
        }
        controller1.b1.blocktype should not be(-1)
        controller1.b2.blocktype should not be(-1)
        controller1.b3.blocktype should not be(-1)
      }

      "reset the game but keep highscore and set all blocks new" in {
        controller1.field.count = 15
        controller1.giveup
        controller1.availableBlocks should be(3)
        controller1.b1.blocktype should not be(-1)
        controller1.b2.blocktype should not be(-1)
        controller1.b3.blocktype should not be(-1)
        controller1.highscore should be(15)
        controller1.field.count = 10
        controller1.giveup
        controller1.availableBlocks should be(3)
        controller1.b1.blocktype should not be(-1)
        controller1.b2.blocktype should not be(-1)
        controller1.b3.blocktype should not be(-1)
        controller1.highscore should be(15)

      }

      "create 3 new blocks with random blocktype between 0 and 17" in {
        controller1.create3RandomBlocks
        controller1.availableBlocks should be(3)
      }

      "create one block with blocktype x. the funktion can be called three times from create3RandomBlocks or manual," +
        " to create only one block" in {
        controller1.b1 = controller1.createBlock(3)
        controller1.b1.blocktype should be(3)
        controller1.b2 = controller1.createBlock(13)
        controller1.b2.blocktype should be(13)
      }

      "call the toString-funktion of its field with the funktion showField" in {
        controller1.createField
        controller1.field.toString should be(controller1.showField())
      }

      "call the toString-funktion of its blocks with the funktion showBlock(x). x is a number between 1 and 3." in {
        controller1.create3RandomBlocks
        controller1.b1.toString should be(controller1.showBlock(1))
        controller1.b2.toString should be(controller1.showBlock(2))
        controller1.b3.toString should be(controller1.showBlock(3))
        controller1.showBlock(4) should be("Block doesn't exist")
        controller1.showBlock(-20) should be("Block doesn't exist")
      }

      "return the status of a cell at the coordinates atx,aty in a field. returns 0 for free," +
        " 1 for blocked and -1 if the coordinates aren't inside the field" in {
        controller1.createField
        controller1.field.cells(1)(1).isblocked = 1
        controller1.getCellStatusAtField(1,1) should be(0)
        controller1.getCellStatusAtField(2,2) should be(1)
        controller1.getCellStatusAtField(20,20) should be(-1)
      }

      "return the status of a cell at the coordinates atx,aty in one of the 3 blocks. Returns 0 for free, 1 for" +
        " blockedand -1 if the coordinates aren't inside the block or the block doesn't exists" in {
        controller1.create3RandomBlocks
        controller1.b1.cells(0)(0).isblocked = 1
        controller1.b2.cells(0)(0).isblocked = 1
        controller1.b3.cells(0)(0).isblocked = 1
        controller1.getCellStatusAtBlock(1,0,0) should be(1)
        controller1.getCellStatusAtBlock(2,0,0) should be(1)
        controller1.getCellStatusAtBlock(3,0,0) should be(1)

        controller1.getCellStatusAtBlock(1,20,20) should be(-1)
        controller1.getCellStatusAtBlock(2,20,20) should be(-1)
        controller1.getCellStatusAtBlock(3,20,20) should be(-1)
        controller1.getCellStatusAtBlock(5,0,0) should be(-1)
      }

      "return the count of the field and set the highscore, if count is higher than the prefious hightscore" in {
        controller1.reset
        controller1.field.count = 5
        controller1.field.count should be(5)
        controller1.highscore should be(0)
        controller1.returnHighscore should be(0)
        controller1.giveup
        controller1.highscore should be(5)
        controller1.returnHighscore should be(5)
        controller1.field.count = 23
        controller1.giveup
        controller1.highscore should be(23)
        controller1.returnHighscore should be(23)
        controller1.reset
        controller1.highscore should be(0)
        controller1.returnHighscore should be(0)
      }

      "add a block to the field at coordinates x,y" in {
        """be carefull, the coordinates for this funktion go from 1 to 8, not from 0 to 7,
          |because the player will see coordinates from 1 to 8.""".stripMargin
        controller1.reset
        controller1.create3RandomBlocks
        val blockedat00 = controller1.b1.cells(0)(0).isblocked
        controller1.addBlock(1, 1, 1)
        controller1.getCellStatusAtField(1, 1) should be(blockedat00)
      }
      "calls the eightInARow-funktion of its Field." in {
        controller1.field.cells(0)(0).isblocked = 1
        controller1.field.cells(1)(0).isblocked = 1
        controller1.field.cells(2)(0).isblocked = 1
        controller1.field.cells(3)(0).isblocked = 1
        controller1.field.cells(4)(0).isblocked = 1
        controller1.field.cells(5)(0).isblocked = 1
        controller1.field.cells(6)(0).isblocked = 1
        controller1.field.cells(7)(0).isblocked = 1
        controller1.deleteFullRows
        controller1.returnCount should be(8)
        controller1.field.cells(0)(0).isblocked should be(0)
        controller1.field.cells(1)(0).isblocked should be(0)
        controller1.field.cells(2)(0).isblocked should be(0)
        controller1.field.cells(3)(0).isblocked should be(0)
        controller1.field.cells(4)(0).isblocked should be(0)
        controller1.field.cells(5)(0).isblocked should be(0)
        controller1.field.cells(6)(0).isblocked should be(0)
        controller1.field.cells(7)(0).isblocked should be(0)
      }

      "set a status for all relevant events, that happend recently" in {
        controller1.reset
        controller1.b1 = Block(0)
        controller1.addBlock(1, 1, 1)
        controller1.statusText should be("add block 1 to 1 1")
        controller1.b1 = Block(0)
        controller1.addBlock(1, 1, 1)
        controller1.statusText should be("add block 1 to 1 1 failed")
        controller1.giveup
        controller1.statusText should be("give up")
        controller1.reset
        controller1.statusText should be("reset")
      }

      "can use a var called chosenBlock to call the addBlock from a view without inserting a number every time." in {
        controller1.reset
        controller1.setChosenBlock(2)
        controller1.getChosenBlock() should be (2)
        controller1.chosenBlock should be (2)
        controller1.addBlock(controller1.getChosenBlock(),1,1)
        controller1.b2.blocktype should be (-1)
      }
      "nothing should change, if we try to add a empty block with blocktype = -1 to a field" in{
        controller1.reset
        controller1.b1 = Block(3)
        controller1.addBlock(1,1,1)
        controller1.availableBlocks should be(2)
        controller1.addBlock(1, 4, 4)
        controller1.availableBlocks should be(2)
      }
      "can reverse all moves since the last reset"in{
        controller1.reset
        controller1.addBlock(1,1,1)
        controller1.reverse()
        for(y <- 0 until controller1.field.fieldsize;
            x <- 0 until controller1.field.fieldsize){
          controller1.field.cells(x)(y).isblocked should be(0)
        }
        controller1.statusText should be("reverse")
      }
    }
  }
}
