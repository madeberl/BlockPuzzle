package de.htwg.se.blockpuzzle.model.blockComponent

import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface

trait BlockInterface {
  def blocktype: Int;
  def blockmaxx: Int;
  def blockmaxy: Int;
  //def cells: CellInterface
  def YES: Int;
  def fill: Unit
  def toString: String
}
