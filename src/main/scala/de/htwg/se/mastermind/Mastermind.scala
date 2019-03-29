package de.htwg.se.mastermind

import de.htwg.se.mastermind.model._

object Mastermind {
    def main(args: Array[String]):Unit = {
        val cpu = new Computer
        println(cpu.winSequence)
    }
}
