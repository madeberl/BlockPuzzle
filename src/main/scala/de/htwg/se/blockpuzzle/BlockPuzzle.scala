package de.htwg.se.blockpuzzle

import de.htwg.se.blockpuzzle.controller.Controller
import de.htwg.se.blockpuzzle.aview.swing.SwingGui
import de.htwg.se.blockpuzzle.aview.tui.Tui
object BlockPuzzle {

  var controller = new Controller
  var tui = new Tui(controller)
  var swing = new SwingGui(controller)


  def main(args: Array[String]): Unit = {
    while(tui.processInputLine(scala.io.StdIn.readLine())){}
  }
}
