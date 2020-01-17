package de.htwg.se.mastermind

import de.htwg.se.mastermind.aview.Tui
import de.htwg.se.mastermind.controller.Controller

import scala.io.StdIn.readLine

object Mastermind {
  val controller = new Controller()
  val tui = new Tui(controller)
  controller.notifyObservers()

  def main(args: Array[String]):Unit = {
    var input: String = ""
    tui.output("-- MASTERMIND --\nstart a new game by typing either 'e' (easy) or 'h' (hard)")
    tui.chooseDif(readLine())
    do {
      input = readLine()
      tui.processInput(input)
    }
    while (input != "q")
  }
}
