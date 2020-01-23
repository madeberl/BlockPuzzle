package de.htwg.se.blockpuzzle.aview.swing
import de.htwg.se.blockpuzzle.controller.FieldChanged
import de.htwg.se.blockpuzzle.controller.ControllerInterface
import javax.swing.{ImageIcon, SwingUtilities}

import scala.swing.Swing.LineBorder
import scala.swing._
import scala.swing.event.MouseClicked
import scala.util.Random


class BlockPanel(controller: ControllerInterface) extends GridPanel(1,3) {

  val WIDTH = 300
  val HEIGHT = 120

  border = LineBorder(java.awt.Color.BLACK, 2)
  background = java.awt.Color.darkGray
  var clickedLabel = 1
  preferredSize = new Dimension(WIDTH, HEIGHT)
  contents += getLabel(1)
  contents += getLabel(2)
  contents += getLabel(3)

  listenTo(controller)

  reactions += {
    case _: FieldChanged => redraw()
  }

  def redraw(): Unit = {
    print("Blocks: " + controller.availableBlocks + "\n")
    SwingUtilities.invokeLater(() => {
      contents.clear
      contents += getLabel(1)
      contents += getLabel(2)
      contents += getLabel(3)
      revalidate
      repaint
    })
  }

  def getLabel(i: Int): Label = {
    var label: Label = new Label() {
      preferredSize = new Dimension(100,100)

      var colorChoice = ""
      val randomizer: Random.type = scala.util.Random
      randomizer.nextInt(3) match {
        case 0 => colorChoice = ""
        case 1 => colorChoice = "red "
        case 2 => colorChoice = "blue "
      }

      icon = new ImageIcon("src/main/scala/de/htwg/se/blockpuzzle/aview/swing/blockImages/" +
                                      colorChoice + "b" + controller.getBlockType(i) + ".png")
      listenTo(mouse.clicks)
      reactions += {
        case MouseClicked(_, _, _, _, _) =>
          clicked(i)
      }
    }
    label
  }

  def clicked(i: Int): Unit = {
    controller.setChosenBlock(i)
    this.clickedLabel = i
  }
}