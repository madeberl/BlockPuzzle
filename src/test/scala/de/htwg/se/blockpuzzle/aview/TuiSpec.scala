package de.htwg.se.blockpuzzle.aview.tui
import de.htwg.se.blockpuzzle.controller.controllerBaseImpl.Controller
import org.scalatest._


class TuiSpec  extends WordSpec with Matchers{
  "A Tui"when{
    var controller = new Controller
    var tui = new Tui(controller)
    "new" should{
      "get controller as parameter and print the current count, highscore, field with coordinates and all 3 blocks" in {
        // Nothing
      }
    }

    "in use" should {
      "quit the input if q was put in" in {
        tui.processInputLine("q") should be(false)
      }
      "return true if the input was correct" in {
        tui.processInputLine("n") should be(true)
      }
    }
  }
}
