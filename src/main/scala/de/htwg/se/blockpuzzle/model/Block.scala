package de.htwg.se.blockpuzzle.model

case class Block(var blocktype: Int) {
  var blockmaxx = 0
  var blockmaxy = 0
  var cells : Array[Array[Cell]] = Array.ofDim[Cell](blockmaxx, blockmaxy)
  val YES = 1

  blocktype match {
    case 0 =>
      blockmaxx = 1
      blockmaxy = 1
      fill
      cells(0)(0).isblocked = YES
    case 1 =>
      blockmaxx = 2
      blockmaxy = 1
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
    case 2 =>
      blockmaxx = 2
      blockmaxy = 2
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(1)(1).isblocked = YES
    case 3 =>
      blockmaxx = 1
      blockmaxy = 2
      fill
      cells(0)(0).isblocked = YES
      cells(0)(1).isblocked = YES
    case 4 =>
      blockmaxx = 1
      blockmaxy = 3
      fill
      cells(0)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(0)(2).isblocked = YES
    case 5 =>
      blockmaxx = 3
      blockmaxy = 1
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(2)(0).isblocked = YES
    case 6 =>
      blockmaxx = 2
      blockmaxy = 2
      fill
      cells(0)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(1)(1).isblocked = YES
    case 7 =>
      blockmaxx = 3
      blockmaxy = 3
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(2)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(1).isblocked = YES
      cells(0)(2).isblocked = YES
      cells(1)(2).isblocked = YES
      cells(2)(2).isblocked = YES
    case 8 =>
      blockmaxx = 2
      blockmaxy = 2
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(0)(1).isblocked = YES
    case 9 =>
      blockmaxx = 3
      blockmaxy = 2
      fill
      cells(1)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(1).isblocked = YES
    case 10 =>
      blockmaxx = 1
      blockmaxy = 4
      fill
      cells(0)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(0)(2).isblocked = YES
      cells(0)(3).isblocked = YES
    case 11 =>
      blockmaxx = 4
      blockmaxy = 1
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(2)(0).isblocked = YES
      cells(3)(0).isblocked = YES
    case 12 =>
      blockmaxx = 1
      blockmaxy = 5
      fill
      cells(0)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(0)(2).isblocked = YES
      cells(0)(3).isblocked = YES
      cells(0)(4).isblocked = YES
    case 13 =>
      blockmaxx = 5
      blockmaxy = 1
      fill
      cells(0)(0).isblocked = YES
      cells(1)(0).isblocked = YES
      cells(2)(0).isblocked = YES
      cells(3)(0).isblocked = YES
      cells(4)(0).isblocked = YES
    case 14 =>
      blockmaxx = 3
      blockmaxy = 2
      fill
      cells(0)(1).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(1).isblocked = YES
      cells(2)(0).isblocked = YES
    case 15 =>
      blockmaxx = 3
      blockmaxy = 2
      fill
      cells(0)(1).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(1).isblocked = YES
      cells(0)(0).isblocked = YES
    case 16 =>
      blockmaxx = 3
      blockmaxy = 2
      fill
      cells(1)(0).isblocked = YES
      cells(0)(1).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(0).isblocked = YES
    case 17 =>
      blockmaxx = 3
      blockmaxy = 2
      fill
      cells(1)(0).isblocked = YES
      cells(0)(0).isblocked = YES
      cells(1)(1).isblocked = YES
      cells(2)(1).isblocked = YES
    case -1 =>
      blockmaxx = 0
      blockmaxy = 0
      fill
    case _ => ;
  }

  def fill: Unit ={
    cells = Array.ofDim[Cell](blockmaxx, blockmaxy)
    for(y <- 0 until blockmaxy) {
      for (x <- 0 until blockmaxx) {
        cells(x)(y) = Cell(0)
      }
    }
  }

  override def toString: String = {
    var str = ""
    for (y <- 0 until blockmaxy){
      for (x <- 0 until blockmaxx) {
        str += this.cells(x)(y).isblocked + " "
      }
      str += ("\n")
    }
    str
  }
}
