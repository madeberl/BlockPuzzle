package de.htwg.se.mastermind.model

import org.scalatest._

class TriesSpec extends WordSpec with Matchers {
  "A Try" when {
    "new" should {
      val t = Tries(4)
      "have a String representation of color codes" in {
        t.getColor(0) should be ("Rot")
        t.getColor(1) should be ("Grün")
        t.getColor(2) should be ("Blau")
        t.getColor(3) should be ("Gelb")
        t.getColor(4) should be ("Weiß")
        t.getColor(5) should be ("Orange")
        t.getColor(6) should be ("Schwarz")
        t.getColor(7) should be ("Lila")
      }
      "have a valid combination of colors" in {
        t.genCombination shouldBe a [List[Int]]
        t.genCombination should have length 4
      }
    }
  }
}
