package de.htwg.se.blockpuzzle.model


case class Cell(var isblocked: Int) {
  def + (that: Cell): Cell = {
    Cell(this.isblocked + that.isblocked)
  }
}
