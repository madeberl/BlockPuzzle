package de.htwg.se.blockpuzzle.aview.tui
import de.htwg.se.blockpuzzle.controller.Controller
import org.scalatest._

class TuiSpec  extends WordSpec with Matchers{
  "A Tui"when{
    var controller = new Controller
    var tui = new Tui(controller)
    "new" should{
      "get a controller as parameter and print the actual count, highscore, field with coordinates and all 3 blocks"in{
        //tui = new Tui(controller) should be("Count: "+controller.returnCount+"\n"+"Highscore: "+controller.returnHighscore+"\n"+controller.showFieldWithCoordinates()+"\n"+
        //  "b1\n"+controller.showBlock(1)+"\nb2\n"+controller.showBlock(2)+"\nb3\n"+controller.showBlock(2)+"\n"+"Enter command: q-Quit. n-Reset all & new game. sbxy - Set block b to x y. g-Give up & ceep points.\n")
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
