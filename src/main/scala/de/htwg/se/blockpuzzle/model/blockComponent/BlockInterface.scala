package de.htwg.se.blockpuzzle.model.blockComponent

import de.htwg.se.blockpuzzle.model.cellComponent.cellBaseImpl.Cell
import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface

trait BlockInterface {
  def cells(x: Int) = ???

  def blocktype: Int;
  def blockmaxx: Int;
  def blockmaxy: Int;
  def cells() : Cell
  def YES: Int;
}
