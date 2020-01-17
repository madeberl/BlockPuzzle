package de.htwg.se.mastermind.model

case class Tries(r: Int) {
  val random = scala.util.Random

  def getColor(c: Int):String = List("Rot", "Grün", "Blau", "Gelb", "Weiß", "Orange", "Schwarz", "Lila", "Pink", "Violett")(c)
  def genCombination():List[Int] = {
    val combination = random.shuffle(List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
    combination.take(r)
  }
  def getCount():Int = {
    if(r < 6) 12 else 8
  }
}

// factory
object Tries {
  def gameMode(kind: String) = kind match {
    case "easy" => new Tries(4)
    case "hard" => new Tries(6)
  }
}
