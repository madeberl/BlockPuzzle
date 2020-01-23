package de.htwg.se.blockpuzzle.aview.swing
import de.htwg.se.blockpuzzle.controller.FieldChanged
import de.htwg.se.blockpuzzle.controller.ControllerInterface
import de.htwg.se.blockpuzzle.controller.ControllerInterface

import scala.swing.Button
import scala.swing.event.MouseClicked


class FieldButton(x: Int, y: Int, controller: ControllerInterface) extends Button{
  text = controller.getCellStatusAtField(x,y).toString
  reactions += {
    case _: FieldChanged => {
      redraw
      repaint
    }
    case MouseClicked(_, _, _, _, _) => {
      controller.addBlock(1,x,y)
      redraw
      repaint
    }
  }
  def redraw: Unit = {
    this.text = controller.getCellStatusAtField(x,y).toString
    repaint
  }
}
