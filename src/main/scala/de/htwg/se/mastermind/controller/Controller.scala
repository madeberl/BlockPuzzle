package de.htwg.se.mastermind.controller

import de.htwg.se.mastermind.model.{Player, Signal, Tries}
import de.htwg.se.mastermind.util.Observable

class Controller extends Observable {
  var counter = 0

  object createGame(d: String):List[Int] = {
    val player = new Player("John")
    val game = Tries.gameMode(d)
    val winSequence = game.genCombination()
    counter =  game.getCount()
    notifyObservers()
    winSequence
  }
  def checkSequence(w:List[Int], t:List[Int]):(List[String], Boolean, Int) = {
    val signal = Signal(w)
    val feedback = signal.returnSignal(t)
    notifyObservers()
    counter -= 1
    (feedback, signal.checkWin(feedback), counter)
  }


}
