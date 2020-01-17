package de.htwg.se.mastermind.model

import org.scalatest._

class SignalSpec extends WordSpec with Matchers {
  "A Signal" when {
    "new" should {
      val signal = Signal(List(1, 2, 3, 4))

      "signal white" in {
        signal.signalWhite(1, List(1, 2, 3, 4)) should be (true)
        signal.signalWhite(5, List(1, 2, 3, 5)) should be (false)
      }
      "signal red" in {
        signal.signalRed(1, List(1, 2, 3, 4)) should be (true)
        signal.signalRed(1, List(4, 3, 2, 1)) should be (false)
      }
      "return a signal-set" in {
        signal.returnSignal(List(1, 2, 3, 4)) should be (List("RED", "RED", "RED", "RED"))
        signal.returnSignal(List(2, 1, 3, 4)) should be (List("WHITE", "WHITE", "RED", "RED"))
        signal.returnSignal(List(2, 1, 3, 5)) should be (List("WHITE", "WHITE", "RED", "BLACK"))
      }
      "return a result" in {
        signal.checkWin(List("RED", "RED", "RED", "RED")) should be (true)
        signal.checkWin(List("BLACK", "WHITE", "WHITE", "BLACK")) should be (false)
      }
    }
  }
}
