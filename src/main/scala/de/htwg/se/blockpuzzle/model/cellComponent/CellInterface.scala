package de.htwg.se.blockpuzzle.model.cellComponent

trait CellInterface {
  def isblocked: Int
}

case class Cell(isblocked: Int)