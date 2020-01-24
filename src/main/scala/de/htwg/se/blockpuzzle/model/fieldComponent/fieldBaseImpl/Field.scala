package de.htwg.se.blockpuzzle.model.fieldComponent.fieldBaseImpl

import de.htwg.se.blockpuzzle.model.blockComponent.blockBaseImpl.Block
import de.htwg.se.blockpuzzle.model.blockComponent.BlockInterface
import de.htwg.se.blockpuzzle.model.cellComponent.cellBaseImpl.Cell
import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface
import de.htwg.se.blockpuzzle.model.fieldComponent.FieldInterface

case class Field(fs: Int) extends FieldInterface {
  var returnedBackup = true
  val fieldsize = fs
  val cells: Array[Array[Cell]] = Array.ofDim[Cell](fieldsize, fieldsize)
  var count = 0
  for(y <- 0 until fieldsize) {
    for(x <- 0 until fieldsize) {
      cells(x)(y) = Cell(0)
    }
  }


  def +(that:Block, atx:Int, aty:Int): Field = {
    if(that.blocktype == -1){
      returnedBackup = true
      return this
    }
    returnedBackup = false
    var backup = Field(8)
    backup.count = this.count
    for (y <- 0 until fieldsize){
      for (x <- 0 until fieldsize) {
        backup.cells(x)(y) = this.cells(x)(y)
      }
    }
    if (aty + that.blockmaxy > fieldsize || atx + that.blockmaxx > fieldsize){
      returnedBackup = true
      return backup
    }
    for (y <- 0 until that.blockmaxy;
         x <- 0 until that.blockmaxx) {
      if (x <= fieldsize && y <= fieldsize){
        this.cells(atx + x)(aty + y) = this.cells(atx + x)(aty + y) + that.cells(x)(y)
      } else {
        returnedBackup = true
        return backup
      }
    }
    if(!fit) {
      returnedBackup = true
      return backup
    }
    this
  }

  def isReturnedBackup: Boolean = returnedBackup

  override def toString: String = {
    var str = ""
    for (y <- 0 until fieldsize){
      for (x <- 0 until fieldsize) {
        str += this.cells(x)(y).isblocked + " "
      }
      str += ("\n")
    }
    str
  }

  def toStringWithCoordinates: String = {
    var str = " |1_2_3_4_5_6_7_8\n"
    for (y <- 0 until fieldsize){
      str += (y + 1) + "|"
      for (x <- 0 until fieldsize) {
        str += this.cells(x)(y).isblocked + " "
      }
      str += ("\n")
    }
    str
  }

  def fit(): Boolean = {
    for (y <- 0 until fieldsize;
         x <- 0 until fieldsize){
      if(this.cells(x)(y).isblocked >= 2){
        return false
      }
    }
    true
  }

  def isBlocked(no: Int, pos: Int): Boolean = {
    this.cells(no)(pos).isblocked == 1
  }

  def eightInARow(): Unit = {
    for (pos <- 0 until fieldsize) {
      if (isBlocked(0, pos) && isBlocked(1, pos) && isBlocked(2, pos) && isBlocked(3, pos) &&
        isBlocked(4, pos) && isBlocked(5, pos) && isBlocked(6, pos) && isBlocked(7, pos)) {

        for (i <- 0 to 7) {
          this.cells(i)(pos).isblocked = 0
        }

        this.count = this.count + fieldsize
      }

      if (isBlocked(pos, 0) && isBlocked(pos, 1) && isBlocked(pos, 2) && isBlocked(pos, 3) &&
        isBlocked(pos, 4) && isBlocked(pos, 5) && isBlocked(pos, 6) && isBlocked(pos, 7)) {

        for (i <- 0 to 7) {
          this.cells(pos)(i).isblocked = 0
        }

        this.count = this.count + fieldsize
      }
    }
  }
}
