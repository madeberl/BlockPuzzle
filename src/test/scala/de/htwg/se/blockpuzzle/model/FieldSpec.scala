package de.htwg.se.blockpuzzle.model
<<<<<<< HEAD
=======

>>>>>>> SE-05_MVC
import org.scalatest._


class FieldSpec extends WordSpec with Matchers {
  "A new Field" when {
    "new" should {
      "each cell isblocked should be 0" in {
        var field = Field(8)
        for (y <- 0 until field.fieldsize;
             x <- 0 until field.fieldsize) {
          field.cells(x)(y).isblocked should be(0)
        }
        field.count should be(0)
      }
    }
<<<<<<< HEAD

    "in use" should {
=======
    "in use" should {
      "add a Block, by adding each Cell of Field with each Cell of Block"
>>>>>>> SE-05_MVC
      "add a not empty block to a empty field" in {
        var field = Field(8)
        val block = Block(3)
        var backup = Field(8)
        for (y <- 0 until field.fieldsize){
          for (x <- 0 until field.fieldsize) {
            backup.cells(x)(y) = field.cells(x)(y)
          }
        }
        field = field + (block, 0, 0)
        field.toString shouldNot be(backup.toString)
      }
<<<<<<< HEAD

=======
>>>>>>> SE-05_MVC
      "add a type 7 block, which is one of our biggest blocks, to a not empty field" in {
        var field = Field(8)
        val block = Block(7)
        field = field + (block, 0, 0)
        field.cells(0)(0).isblocked should be(1)
        field.cells(1)(0).isblocked should be(1)
        field.cells(2)(0).isblocked should be(1)
        field.cells(0)(1).isblocked should be(1)
        field.cells(1)(1).isblocked should be(1)
        field.cells(2)(1).isblocked should be(1)
        field.cells(0)(2).isblocked should be(1)
        field.cells(1)(2).isblocked should be(1)
        field.cells(2)(2).isblocked should be(1)
      }

      "checks if a block fits in the field, after checking, that the coordinates are " +
        "inside the field and the block wont create a index-out-of-Bounds-Error. Fitting in the field means," +
        " that the block wont overlap with a block, added before. The count should be kept, if the backup was returned." in {
        var field = Field(8)
        val block = Block(8)
        field = field +(block, 0, 0)
        field.count = 24
        var backup = Field(8)
        backup.count = field.count
        for (y <- 0 until field.fieldsize){
          for (x <- 0 until field.fieldsize) {
            backup.cells(x)(y) = field.cells(x)(y)
          }
        }
        field = field +(block, 0, 0)
        field.toString should be(backup.toString)
        field.count should be(backup.count)
      }
<<<<<<< HEAD

      """have the method fit, that gets a field as parameter and checks the cells of their number. fit returns false,
        | if any cell.isblocked equals 2 or higher.""".stripMargin in {
=======
      "have the method fit, that gets a field as parameter and checks the cells of their number. fit returns false, if any cell.isblocked equals 2 or higher." in {
>>>>>>> SE-05_MVC
        var field = Field(8)
        field.cells(2)(2).isblocked = 2
        field.fit should be(false)
      }

<<<<<<< HEAD
      """have the method eightInARow, that copies the field, checks it for full rows and deletes them, if they found
        | them. in this way we can delete rows, similar to tetris""".stripMargin in {
=======
      "have the method eightInARow, that copies the field, checks it for full rows and deletes them, if they found them. in this way we can delete rows, similar to tetris" in {
>>>>>>> SE-05_MVC
        var field = Field(8)
        field.cells(0)(0).isblocked = 1
        field.cells(1)(0).isblocked = 1
        field.cells(2)(0).isblocked = 1
        field.cells(3)(0).isblocked = 1
        field.cells(4)(0).isblocked = 1
        field.cells(5)(0).isblocked = 1
        field.cells(6)(0).isblocked = 1
        field.cells(7)(0).isblocked = 1
        field.eightInARow()
        field.count should be(8)
        field.cells(0)(0).isblocked should be(0)
        field.cells(1)(0).isblocked should be(0)
        field.cells(2)(0).isblocked should be(0)
        field.cells(3)(0).isblocked should be(0)
        field.cells(4)(0).isblocked should be(0)
        field.cells(5)(0).isblocked should be(0)
        field.cells(6)(0).isblocked should be(0)
        field.cells(7)(0).isblocked should be(0)
      }
<<<<<<< HEAD

=======
      "toString returns a string that represents the field"
>>>>>>> SE-05_MVC
      "toString of an empty field should return a string filled with 0" in {
        var field = Field(4)
        val s = field.toString
        s should be("0 0 0 0 \n0 0 0 0 \n0 0 0 0 \n0 0 0 0 \n")
      }
<<<<<<< HEAD

=======
>>>>>>> SE-05_MVC
      "toString of an not empty field should return a string filled with 0 and 1" in {
        var field = Field(4)
        field.cells(0)(0).isblocked = 1
        field.cells(1)(0).isblocked = 1
        field.cells(2)(0).isblocked = 1
        field.cells(3)(0).isblocked = 1
        val s = field.toString
        s should be("1 1 1 1 \n0 0 0 0 \n0 0 0 0 \n0 0 0 0 \n")
      }
    }
  }
}
