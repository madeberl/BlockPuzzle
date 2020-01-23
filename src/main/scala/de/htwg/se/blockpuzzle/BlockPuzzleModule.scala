package de.htwg.se.blockpuzzle

import com.google.inject.AbstractModule
import de.htwg.se.blockpuzzle.controller.ControllerInterface
import de.htwg.se.blockpuzzle.model.blockComponent.BlockInterface
import de.htwg.se.blockpuzzle.model.fileIoComponent.FileIoInterface
import de.htwg.se.blockpuzzle.model.cellComponent.CellInterface
import de.htwg.se.blockpuzzle.model.fieldComponent.FieldInterface
import net.codingwell.scalaguice.ScalaModule

class BlockPuzzleModule extends AbstractModule with ScalaModule {

  def configure(): Unit = {
    //bind[BlockInterface].to[model.blockComponent.blockBaseImpl.Block]
    //bind[CellInterface].to[model.cellComponent.cellBaseImpl.Cell]
    //bind[FieldInterface].to[model.fieldComponent.fieldBaseImpl.Field]
    bind[ControllerInterface].to[controller.controllerBaseImpl.Controller]
    //bind[FileIoInterface].to[model.fileIoComponent.fileIoBaseImpl.fileIo]
  }
}
