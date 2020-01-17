package de.htwg.se.blockpuzzle.aview.tui

import de.htwg.se.blockpuzzle.controller.Controller
import de.htwg.se.blockpuzzle.controller.fieldChanged
import de.htwg.se.blockpuzzle.util.{Observable, Observer}
import scala.io.Source._
import swing._

class Tui(var controller : Controller) extends Reactor{
  listenTo(controller)
  printTui
  reactions += {
    case e: fieldChanged => printTui
  }

  def printTui = {
    println("Count: "+controller.returnCount)
    println("Highscore: "+controller.returnHighscore)
    println(controller.showFieldWithCoordinates())
    print("b1\n"+controller.showBlock(1)+"\nb2\n"+controller.showBlock(2)+"\nb3\n"+controller.showBlock(3)+"\n")
    println("Enter command: q-Quit. n-New game. bxy - Set block b to x y. g-Give up & ceep points.")
  }
  def processInputLine(input: String):Boolean = {
    var continue = true
    input.charAt(0) match {
      case 'q' => continue = false
      case 'n' => {
        controller.reset
        controller.create3RandomBlocks
        println("Lets start new!")
      }
      case 'g' => {
        controller.giveup
        controller.create3RandomBlocks
        println("keep your highscore and try again!")
      }
      case 'r' => controller.reverse
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case number :: column :: row :: Nil => controller.addBlock(number, column, row)
          case _ => println("False Input")
        }
      }
    }
    if(continue)printTui
    continue
  }

}
