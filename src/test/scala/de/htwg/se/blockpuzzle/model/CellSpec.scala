package de.htwg.se.blockpuzzle.model

import org.scalatest._


class CellSpec extends WordSpec with Matchers {
  "A Cell" when {
    "new" should {
      val cell = Cell(0)
      "isblocked be 0" in {
        cell.isblocked should be(0)
      }
    }
  }
  "A blocked Cell" when{
    "added with a unblocked Cell" should{
      val cell1 = Cell(0)
      val cell2 = Cell(1)
      "isblocked should be 1" in {
        val result = cell1+cell2
        result.isblocked should be(1)
      }
    }
  }
  "A unblocked Cell" when{
    "added with a blocked Cell" should{
      val cell1 = Cell(1)
      val cell2 = Cell(0)
      "isblocked should be 1" in {
        val result = cell1+cell2
        result.isblocked should be(1)
      }
    }
  }
  "A unblocked Cell" when{
    "added with a unblocked Cell" should{
      val cell1 = Cell(0)
      val cell2 = Cell(0)
      "isblocked should be 0" in {
        val result = cell1+cell2
        result.isblocked should be(0)
      }
    }
  }
  "A blocked Cell" when {
    "added with another blocked Cell" should {
      val cell1 = Cell(1)
      val cell2 = Cell(1)
      "isblocked should be 2" in {
        val result = cell1+cell2
        result.isblocked should be(2)
      }
    }
  }
}
