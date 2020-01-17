package de.htwg.se.mastermind.model

import org.scalatest._

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = new Player("John")
      "have a name" in {
        player.name should be ("John")
      }
      "have a nice String representation" in {
       player.toString() should be ("John")
      }
    }
  }
}
