package fr.esgi.iabd.tictactoe

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TicTacToeSpec extends AnyFlatSpec with Matchers {

  "TicTacToe" should "declare Player 0 as the winner for horizontal victory" in {
    val grid = Vector(
      Vector("O", "O", "O"),
      Vector(".", ".", "."),
      Vector(".", ".", ".")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Player 0"
  }

  it should "declare Player 1 as the winner for vertical victory" in {
    val grid = Vector(
      Vector(".", "X", "."),
      Vector(".", "X", "."),
      Vector(".", "X", ".")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Player 1"
  }

  it should "declare Player 0 as the winner for diagonal victory (top-left to bottom-right)" in {
    val grid = Vector(
      Vector("O", ".", "."),
      Vector(".", "O", "."),
      Vector(".", ".", "O")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Player 0"
  }

  it should "declare Player 1 as the winner for diagonal victory (top-right to bottom-left)" in {
    val grid = Vector(
      Vector(".", ".", "X"),
      Vector(".", "X", "."),
      Vector("X", ".", ".")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Player 1"
  }

  it should "declare Nobody as the winner for a draw game" in {
    val grid = Vector(
      Vector("O", "X", "O"),
      Vector("X", "O", "X"),
      Vector("X", "O", "X")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Nobody"
  }

  it should "declare Nobody as the winner for an empty grid" in {
    val grid = Vector(
      Vector(".", ".", "."),
      Vector(".", ".", "."),
      Vector(".", ".", ".")
    )
    val winner = TicTacToe.victory(grid)
    winner shouldEqual "Nobody"
  }

  it should "allow Player 0 to play and update the grid accordingly" in {
    var grid = Vector(
      Vector(".", ".", "."),
      Vector(".", ".", "."),
      Vector(".", ".", ".")
    )
    grid = TicTacToe.play(grid, 1, 1, 0)
    grid(1)(1) shouldEqual "O"
  }

  it should "allow Player 1 to play and update the grid accordingly" in {
    var grid = Vector(
      Vector(".", ".", "."),
      Vector(".", ".", "."),
      Vector(".", ".", ".")
    )
    grid = TicTacToe.play(grid, 1, 1, 1)
    grid(1)(1) shouldEqual "X"
  }


}
