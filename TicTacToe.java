public class TicTacToe {

    private int ROWS = 3;
    private int COLS = 3;

    public enum Player {
        Unknown, X, O
    }

    public Player[][] board;
    private Player currentPlayer;
    private Player winner;

    public TicTacToe() {
        initialiazeBoard();
        currentPlayer = Player.O;
        while (!isGameOver()){
			play();
		}
    }

    public void play(int row, in col) {
		
    }

    public void initialiazeBoard() {
        board = new Player[ROWS][COLS];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Player.Unknown;
            }
        }
    }

    public boolean isBoardEmpty() {
        boolean empty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != Player.Unknown) {
                    empty = false;
                }
            }
        }
        return empty;
    }

    public boolean isGameWon() {
        boolean won = false;
        for (int i = 0; i < board.length; i++) //horizontal win
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                won = true;
                winner = board[i][0];
            }
        for (int i = 0; i < board[0].length; i++) //vertical win
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                won = true;
                winner = board[0][i];
            }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) { //diagonal win
            won = true;
            winner = board[0][0];
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) { //diagonal win 2nd
            won = true;
            winner = board[0][2];
        }
    }

    public boolean isDraw() {
        boolean draw = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Player.Unknown) {
                    draw = false;
                }
            }
        }
        return draw;
    }

    public boolean isGameOver() {
        return isDraw() || isGameWon();
    }

    public Player getWinner() {
        return this.winner;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
}
