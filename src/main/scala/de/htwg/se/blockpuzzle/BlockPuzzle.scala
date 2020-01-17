package de.htwg.se.blockpuzzle

import de.htwg.se.blockpuzzle.controller.Controller
import de.htwg.se.blockpuzzle.aview.tui.Tui
import de.htwg.se.blockpuzzle.model.Field
object BlockPuzzle {

  val field = new Field(8)
  var controller = new Controller
  var tui = new Tui(controller)


  def main(args: Array[String]): Unit = {
    while(tui.processInputLine(readLine())){}
  }
}
