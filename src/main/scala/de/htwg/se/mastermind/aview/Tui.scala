package de.htwg.se.mastermind.aview

import de.htwg.se.mastermind.controller.Controller
import de.htwg.se.mastermind.util.Observer

import scala.util.matching.Regex

class Tui(controller: Controller) extends Observer {
  controller.add(this)


  def chooseDif(d: String):Unit = {
    if(d == "h") {
      output("[-] Difficulty: hard")
      val win: List[Int] = controller.createGame("hard")
    } else {
      output("[-] Difficulty: hard")
      val win: List[Int] = controller.createGame("easy")
    }
  }
  val win: List[Int] = controller.createGame
  val numbers: Regex = """(\d)-(\d)-(\d)-(\d)""".r

  def processInput(input: String):Unit = {
    input match {
      case "s" =>
        output("Printing solution ..\n" + win)
      case "q" => output("Bye bye!")
      case numbers(c1, c2, c3, c4) =>
        val signal = controller.checkSequence(win, List(c1.toInt, c2.toInt, c3.toInt, c4.toInt))
        output("CPU responds: " + signal._1)
        if (signal._2) output("WON! Thanks for playing!") else output("Try harder! Tries left: " + signal._3)
      case _ =>
        output("Please enter a valid combination (e.g. 1-2-3-4) OR 's' for printing the solution OR 'q' for quitting the game!")
    }
  }

  def output(s: String):Unit = println(s)
  override def update():Unit = ""
}
