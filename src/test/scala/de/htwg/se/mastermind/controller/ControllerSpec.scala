package de.htwg.se.mastermind.controller

import de.htwg.se.mastermind.util.Observer
import org.scalatest._

class ControllerSpec extends WordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer" should {
      val controller = new Controller()
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update(): Unit = updated = true
      }
      controller.add(observer)

      "notify its Observer after creation" in {
        controller.createGame
        observer.updated should be (true)
      }
      "notify its Observer after checking a sequence" in {
        controller.checkSequence(List(1, 2 ,3 ,4), List(1, 2, 3, 4))
        observer.updated should be (true)
      }
    }
  }
}