package de.htwg.se.blockpuzzle.aview.swing
import de.htwg.se.blockpuzzle.controller.{ControllerInterface, FieldChanged}

import scala.swing.Swing.LineBorder
import scala.swing._
import scala.swing.event._


class CellClicked(val x: Int, val y: Int) extends Event

class SwingGui(var controller : ControllerInterface) extends Frame{
  listenTo(controller)
  title = "BlockPuzzle"
  preferredSize = new Dimension(380, 530)

  var cells = Array.ofDim[CellPanel](controller.fieldsize, controller.fieldsize)

  def setChosenBlock(i: Int): Unit = {}

  def fieldPanel: GridPanel = new GridPanel(controller.fieldsize, controller.fieldsize) {

    val WIDTH = 300
    val HEIGHT = 300

    border = LineBorder(java.awt.Color.BLACK, 1)
    background = java.awt.Color.BLACK
    preferredSize = new Dimension(WIDTH, HEIGHT)
    for (y <- 1 to controller.fieldsize;
         x <- 1 to controller.fieldsize) {
      var b = new CellPanel(x, y, controller)
      contents += b
      cells(x-1)(y-1) = b
    }
   }

  def chosePanel: GridPanel = new GridPanel(1, 3) {

    val WIDTH = 300
    val HEIGHT = 20

    preferredSize = new Dimension(WIDTH, HEIGHT)
    contents += Button("Block 1") { controller.setChosenBlock(1) }
    contents += Button("Block 2") { controller.setChosenBlock(2) }
    contents += Button("Block 3") { controller.setChosenBlock(3) }
  }

  def blockPanel: BlockPanel = new BlockPanel(controller)

  var statusline = new TextField("Last event: " + controller.statusText, 20)
  var countLine = new Label("COUNT: " + controller.returnCount.toString + "\t HIGHSCORE: "
    + controller.highscore, null, Alignment.Center)

  contents = new BoxPanel(Orientation.Vertical) {

    val SIDE = 10

    contents += fieldPanel
    contents += chosePanel
    contents += blockPanel
    contents += statusline
    border = Swing.EmptyBorder(SIDE, SIDE, SIDE, SIDE)
  }

  menuBar = new MenuBar {

    contents += new Menu("Game") {
      mnemonic = Key.G
      contents += new MenuItem(Action("New") { controller.reset})
      contents += new MenuItem(Action("Give Up") {controller.giveup})
      contents += new MenuItem(Action("Reverse") { controller.reverse})
      //contents += new MenuItem(Action("Save")) {controller.save}
      contents += new MenuItem(Action("Quit") { System.exit(0) })
    }
    contents += new Label("                ")
    contents += countLine
  }

  visible = true

  reactions += {
    case _: FieldChanged  => redraw
  }

  def redraw: Unit = {
    for (y <- 0 until controller.fieldsize;
      x <- 0 until controller.fieldsize){
      cells(x)(y).redraw
    }

    statusline.text = "last event: " + controller.statusText
    countLine.text = "count: " + controller.returnCount.toString + "\n highscore: " +
      controller.returnHighscore.toString

    repaint
  }
}
