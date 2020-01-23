package de.htwg.se.blockpuzzle.model.cellComponent.cellBaseImpl

import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface

case class Cell(var isblocked: Int) extends CellInterface {
  def + (that: Cell): Cell = {
    Cell(this.isblocked + that.isblocked)
  }
}
