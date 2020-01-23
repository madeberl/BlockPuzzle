package de.htwg.se.blockpuzzle.model.fieldComponent

import de.htwg.se.blockpuzzle.model.blockComponent.BlockInterface
import de.htwg.se.blockpuzzle.model.blockComponent.blockBaseImpl.Block
import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface
import de.htwg.se.blockpuzzle.model.cellComponent.cellBaseImpl.Cell

trait FieldInterface {

  def fs: Int
  def returnedBackup: Boolean
  def fieldsize: Int
  def count: Int
  def isReturnedBackup: Boolean
  def toString: String
  def toStringWithCoordinates: String
  def fit(): Boolean
  def isBlocked(): Boolean
  def eightInARow(): Unit
}

case class Field(fs: Int)