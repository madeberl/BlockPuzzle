package de.htwg.se.blockpuzzle

import com.google.inject.Guice
import de.htwg.se.blockpuzzle.aview.swing.SwingGui
import de.htwg.se.blockpuzzle.aview.tui.Tui
import de.htwg.se.blockpuzzle.controller.ControllerInterface
object BlockPuzzle {

  val injector = Guice.createInjector(new BlockPuzzleModule)
  val controller = injector.getInstance(classOf[ControllerInterface])
  var tui = new Tui(controller)
  var swing = new SwingGui(controller)
  controller.createField

  def main(args: Array[String]): Unit = {
    while(tui.processInputLine(scala.io.StdIn.readLine())){}
  }
}
