package de.htwg.se.blockpuzzle.controller.controllerBaseImpl

import com.google.inject.name.Names
import com.google.inject.{Guice, Inject}
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.blockpuzzle.controller.ControllerInterface
import de.htwg.se.blockpuzzle.BlockPuzzleModule
import de.htwg.se.blockpuzzle.model.blockComponent.blockBaseImpl.Block
import de.htwg.se.blockpuzzle.model.blockComponent.BlockInterface
import de.htwg.se.blockpuzzle.model.fieldComponent.fieldBaseImpl.Field
import de.htwg.se.blockpuzzle.model.fieldComponent.FieldInterface

import scala.collection.mutable
import scala.swing.Publisher
import scala.swing.event.Event


case class FieldChanged() extends Event

class Controller @Inject() extends ControllerInterface with Publisher {
  var statusText = "BlockPuzzle"
  var field: Field = Field(0)
  var b1: Block = Block(-1)
  var b2: Block = Block(-1)
  var b3: Block = Block(-1)
  var chosenBlock = 1
  var fieldsize = 8
  var availableBlocks = 0
  var highscore = 0
  var history = mutable.Stack[state]()

  reset

  def reset: Unit = {
    statusText = "reset"
    createField
    this.b1 = Block(-1)
    this.b2 = Block(-1)
    this.b3 = Block(-1)
    this.availableBlocks = 0
    highscore = 0
    create3RandomBlocks
    history.clear()
    publish(new FieldChanged)
  }

  def giveup: Unit = {
    if (this.field.count > highscore) {
      highscore = returnCount
    }
    statusText = "give up"
    createField
    this.b1 = Block(-1)
    this.b2 = Block(-1)
    this.b3 = Block(-1)
    this.availableBlocks = 0
    create3RandomBlocks
    history.clear()
    publish(new FieldChanged)
  }

  def createField: Unit = this.field = Field(fieldsize)

  def createBlock(x: Int): Block = {
    Block(x)
  }

  def create3RandomBlocks: Unit = {
    val r = scala.util.Random
    this.b1 = createBlock(r.nextInt(17))
    this.b2 = createBlock(r.nextInt(17))
    this.b3 = createBlock(r.nextInt(17))
    this.availableBlocks = 3
  }

  def addBlock(blocknumber: Int, atx: Int, aty: Int): Unit = {
    saveState
    blocknumber match {
      case 1 => {
        field = field + (b1, atx - 1, aty - 1)
        if (!field.isReturnedBackup) {
          availableBlocks -= 1
          b1 = Block(-1)
        }
      }
      case 2 => {
        field = field + (b2, atx-1, aty-1)
        if (!field.isReturnedBackup) {
          availableBlocks-=1
          b2 = Block(-1)
        }
      }
      case 3 => {
        field = field + (b3, atx-1, aty-1)
        if (!field.isReturnedBackup) {
          availableBlocks-=1
          b3 = Block(-1)
        }
      }
    }
    if(field.isReturnedBackup){
      history.pop
    }
    setAddStatus(blocknumber, atx, aty, field.returnedBackup)
    deleteFullRows

    if (availableBlocks == 0) create3RandomBlocks
    publish(new FieldChanged)
  }

  def setChosenBlock(chosen: Int): Unit = {
    chosenBlock = chosen
  }

  def getChosenBlock(): Int = chosenBlock

  def showBlock(blocknumber: Int): String = {
    blocknumber match {
      case 1 => b1.toString
      case 2 => b2.toString
      case 3 => b3.toString
      case _ => "Block doesn't exist"
    }
  }

  def setAddStatus(block: Int, x: Int, y: Int, failed: Boolean): Unit = {
    if (failed){
      this.statusText = "add block " + block + " to " + x + " " + y + " failed"
    } else {
      this.statusText = "add block " + block + " to " + x + " " + y
    }
  }

  def showField(): String = this.field.toString

  def getFieldMax(): Int = this.fieldsize

  def showFieldWithCoordinates(): String = this.field.toStringWithCoordinates

  def deleteFullRows(): Unit = this.field.eightInARow()

  def returnCount: Int = this.field.count

  def returnHighscore: Int = this.highscore

  def getBlockType(blocknumber:Int): Int = {
    blocknumber match {
      case 1 => b1.blocktype
      case 2 => b2.blocktype
      case 3 => b3.blocktype
      case _ => -1
    }
  }

  def setCellAt(x:Int,y:Int,v:Int): Unit = if (v < 2) {
    this.field.cells(x)(y).isblocked = v
  }

  def getCellStatusAtField(atx:Int, aty:Int): Int = {
    if (atx <= this.fieldsize && aty <= this.fieldsize) {
      this.field.cells(atx-1)(aty-1).isblocked
    } else {
      -1
    }
  }

  def getCellStatusAtBlock(blocknumber:Int, atx:Int, aty:Int): Int = {
    blocknumber match {
      case 1 =>
        if (atx < this.b1.blockmaxx && aty < this.b1.blockmaxy) this.b1.cells(atx)(aty).isblocked else -1
      case 2 =>
        if (atx < this.b2.blockmaxx && aty < this.b2.blockmaxy) this.b2.cells(atx)(aty).isblocked else -1
      case 3 =>
        if (atx < this.b3.blockmaxx && aty < this.b3.blockmaxy) this.b3.cells(atx)(aty).isblocked else -1
      case _ => -1
    }
  }

  def reverse(): Unit = {
    if(!history.isEmpty) {
      val prevState = history.pop
      for (y <- 0 until this.field.fieldsize) {
        for (x <- 0 until this.field.fieldsize) {
          this.field.cells(x)(y) = prevState.field.cells(x)(y)
        }
      }
      this.b1 = prevState.b1
      this.b2 = prevState.b2
      this.b3 = prevState.b3
      this.availableBlocks = prevState.availableBlocks
      this.field.count = prevState.field.count
      statusText = "reverse"
      publish(new FieldChanged)
    }
  }

  def saveState(): Unit = {
    this.history.push(new state(this.field, this.b1, this.b2, this.b3, this.availableBlocks))
  }

  def save: Unit = {

  }
}

case class state(var f:Field, v1:Block, v2:Block, v3:Block, a:Int){
  var field = Field(8)
  field.count = f.count
  for (y <- 0 until f.fieldsize) {
    for (x <- 0 until f.fieldsize) {
      field.cells(x)(y).isblocked = f.cells(x)(y).isblocked
    }
  }
  var b1: Block = Block(v1.blocktype)
  var b2: Block = Block(v2.blocktype)
  var b3: Block = Block(v3.blocktype)
  var availableBlocks:Int = a
}
