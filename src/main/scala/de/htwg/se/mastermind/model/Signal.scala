package de.htwg.se.mastermind.model

case class Signal(w: List[Int]) {
  def signalWhite(g: Int, t: List[Int]):Boolean = if(w.contains(g)) true else false
  def signalRed(g: Int, t: List[Int]):Boolean = {
    val index = t.indexOf(g)
    if(w(index) == g) true else false
  }
  def returnSignal(t: List[Int]):List[String] = {
    t map (initSignal(_, t))
  }
  def initSignal(x: Int, t: List[Int]):String = {
    if(signalRed(x, t)) {
        "RED"
    }
    else if (signalWhite(x, t)) {
       "WHITE"
    }
    else {
       "BLACK"
    }
  }
  def checkWin(t:List[String]):Boolean = {
    val seq = t.filter(List("RED", "RED", "RED", "RED").contains(_))
    try {
      seq.groupBy(identity).mapValues(_.size)("RED") == 4
    }
    catch {
      case exceptVal: NoSuchElementException => false
    }
  }
}