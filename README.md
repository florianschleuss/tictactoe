# TicTacToe Game ![Latest Stable Version](https://img.shields.io/github/v/release/florianschleuss/tictactoe) ![Repository Size](https://img.shields.io/github/repo-size/florianschleuss/tictactoe/total) ![License](https://img.shields.io/github/license/florianschleuss/tictactoe) <img style="float: right; width: 5em" src="https://github.com/simple-icons/simple-icons/blob/master/icons/java.svg">


#### Table of Contents
1. [Basic Instruction](#basic-instruction)
2. [Specifications](#specifications)
3. [License](#license)

## Basic Instruction
The game should be played on a 3×3 square grid by two players. The two players should alternate their symbols (e.g. "X" and "O") in a free space. The first player to place three characters in a row, column or diagonal wins. More background information and rules for this game can be found on [Wikipedia](https://de.wikipedia.org/wiki/Tic-Tac-Toe).

## Specifications
The project had to be carried out under certain conditions. On the one hand it had to be written completely in Java and on the other hand the existing classes and function structure had to be maintained. No further classes and functions were allowed to be added.

```Java
public class TicTacToe {

  private int ROWS = 3;
  private int COLS = 3;
  public Player[][] board;
  public enum Player {
    Unknown, X, O
  }

  private Player currentPlayer;
  private Player winner;

  public TicTacToe() {}
  public void initialiazeBoard() {}
  public void play(int row, int col) {}
  public boolean isBoardEmpty() {
  public boolean isGameWon() {}
  public boolean isDraw() {}
  public boolean isGameOver() {}
  public Player getCurrentPlayer() {}
  public Player getWinner() {}

}
```

## License
The TicTacToe game is licensed under the terms of the [GPL Open Source](LICENSE) license and is available for free.
