package de.htwg.se.mastermind.aview

import de.htwg.se.mastermind.controller.Controller
import org.scalatest._

class TuiSpec extends WordSpec with Matchers {
  "A Tui" should {
    val controller = new Controller()
    val tui = new Tui(controller)
    val win = controller.createGame
    val numbers = """(\d)-(\d)-(\d)-(\d)""".r

    "show the solution of a new sequence" in {
      tui.processInput("s")
    }
    "quit the game" in {
      tui.processInput("q")
    }
    "guess a number" in {
      tui.processInput("1-2-3-4")
    }
    "print the help-text when giving invalid input" in {
      tui.processInput("asd")
    }
  }
}