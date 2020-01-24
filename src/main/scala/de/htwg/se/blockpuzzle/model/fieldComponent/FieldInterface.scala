package de.htwg.se.blockpuzzle.model.fieldComponent

trait FieldInterface {

  def fs: Int
  def returnedBackup: Boolean
  def fieldsize: Int
  def count: Int
  def isReturnedBackup: Boolean
  def toString: String
  def toStringWithCoordinates: String
  def fit(): Boolean
  def isBlocked(no: Int, pos: Int): Boolean
  def eightInARow(): Unit
}

case class Field(fs: Int)