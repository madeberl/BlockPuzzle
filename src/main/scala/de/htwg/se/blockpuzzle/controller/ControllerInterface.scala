package de.htwg.se.blockpuzzle.controller

import de.htwg.se.blockpuzzle.model.blockComponent.BlockInterface
import de.htwg.se.blockpuzzle.model.blockComponent.blockBaseImpl.Block
import de.htwg.se.blockpuzzle.model.fieldComponent.FieldInterface
import de.htwg.se.blockpuzzle.model.fieldComponent.fieldBaseImpl.Field

import scala.swing.Publisher

trait ControllerInterface extends Publisher {
  def statusText: String
  def field(): Field
  def b1: Block
  def b2: Block
  def b3: Block
  def chosenBlock: Int
  def fieldsize: Int
  def availableBlocks: Int
  def highscore: Int
  //def history: state

  def reset: Unit
  def giveup: Unit
  def createField: Unit
  def createBlock(x: Int): Block
  def create3RandomBlocks: Unit
  def addBlock(blocknumber: Int, atx: Int, aty: Int): Unit
  def setChosenBlock(chosen: Int): Unit
  def getChosenBlock: Int
  def showBlock(blocknumber: Int): String
  def setAddStatus(block: Int, x: Int, y: Int, failed: Boolean): Unit
  def showField: String
  def getFieldMax: Int
  def showFieldWithCoordinates(): String
  def deleteFullRows: Unit
  def returnCount: Int
  def returnHighscore: Int
  def getBlockType(blocknumber:Int): Int
  def setCellAt(x:Int,y:Int,v:Int): Unit
  def getCellStatusAtField(atx:Int, aty:Int): Int
  def getCellStatusAtBlock(blocknumber:Int, atx:Int, aty:Int): Int
  def reverse: Unit
  def saveState: Unit
  def save: Unit
}

import scala.swing.event.Event

case class state(var f:Field, v1:Block, v2:Block, v3:Block, a:Int)
case class FieldChanged() extends Event