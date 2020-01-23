package de.htwg.se.blockpuzzle.aview.tui
import de.htwg.se.blockpuzzle.controller.{ControllerInterface, FieldChanged}

import scala.swing._


class Tui(var controller : ControllerInterface) extends Reactor {
  listenTo(controller)
  printTui
  reactions += {
    case e: FieldChanged => printTui
  }

  def printTui : Unit = {
    println("Count: " + controller.returnCount)
    println("Highscore: " + controller.returnHighscore)
    println(controller.showFieldWithCoordinates())
    print("b1\n" + controller.showBlock(1) + "\nb2\n" + controller.showBlock(2)
      + "\nb3\n" + controller.showBlock(3) + "\n")
    println("Enter command: q-Quit. n-New game. bxy - Set block b to x y. g-Give up & ceep points.")
  }

  def processInputLine(input: String) : Boolean = {
    var continue = true
    if (null == input|| input.isEmpty) {
        println("insert a correct command, please")
    } else {
      input.charAt(0) match {
        case 'q' => continue = false
        case 'n' =>
          controller.reset
          println("Lets start new!")
        case 'g' =>
          controller.giveup
          println("keep your highscore and try again!")
        case 'r' => controller.reverse
        case _ =>
          try {
            input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
              case number :: column :: row :: Nil => controller.addBlock(number, column, row)
              case _ => println("False Input")
            }
          } catch {
            case e:Exception => println("An error occurred while drawing a block")
          }
      }
    }

    if (continue) {
      printTui
    }
    continue
  }
}
