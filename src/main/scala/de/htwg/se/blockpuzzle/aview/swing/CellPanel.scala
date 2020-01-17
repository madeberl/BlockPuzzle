package de.htwg.se.blockpuzzle.aview.swing
import scala.swing._
import scala.swing.event._
import de.htwg.se.blockpuzzle.controller.Controller
import de.htwg.se.blockpuzzle.controller.FieldChanged


class CellPanel(x: Int, y: Int, controller: Controller) extends FlowPanel {
  val emptyCellColor: java.awt.Color = java.awt.Color.darkGray

  var color: java.awt.Color = java.awt.Color.green
  //val randomizer: scala.util.Random = scala.util.Random
  /*randomizer.nextInt(3) match {
    case 0 => color = java.awt.Color.green
    case 1 => color = java.awt.Color.red
    case 2 => color = java.awt.Color.blue
  }*/

  val blockedCellColor: java.awt.Color = color
  var cellBlocked: Boolean = controller.getCellStatusAtField(x, y) == 1

  background = if (!cellBlocked) emptyCellColor else blockedCellColor
  border = Swing.BeveledBorder(Swing.Raised)
  listenTo(mouse.clicks)
  listenTo(controller)
  reactions += {
    case _: FieldChanged =>
      repaint

    case MouseClicked(_, _, _, _, _) =>
      controller.addBlock(controller.chosenBlock,x,y)
      repaint
  }

  def redraw(): Unit = {
    cellBlocked = controller.getCellStatusAtField(x, y) == 1
    setBackground(this)
    repaint
  }

  def setBackground(p: Panel): Unit = p.background = if(!cellBlocked) emptyCellColor else blockedCellColor
}