import java.util.Scanner;

public class TicTacToe {

    public Player[][] board;
    private int ROWS = 3;
    private int COLS = 3;
    private Player currentPlayer;
    private Player winner;
    private Scanner sc = new Scanner(System.in);

    public TicTacToe() {
        this.initialiazeBoard();
        this.currentPlayer = Player.O;
        while (!this.isGameOver()) {
			System.out.println("Please insert the column of your choice (from " + this.ROWS + " - " + this.COLS + "):");
			byte col = sc.nextByte(); - 1 //-1 cause of array-index
			System.out.println("Please insert the row of your choice (from " + this.ROWS + " - " + this.COLS + "):");
			byte row = sc.nextByte(); - 1 //-1 cause of array-index
            this.play(row, col);
        }
        if (this.isGameWon()) {
            System.out.println("The winner is: " + this.getWinner());
        }
        if (this.isDraw()) {
            System.out.println("Its a draw!");
        }
        sc.close();
    }

    public void play(int row, int col) {
    	try {
			this.board[col][row] = this.getCurrentPlayer();
		}
    	catch (IndexOutOfBoundsException e){
			System.out.println("You have entered a number outside the grid.\nNext player gets the turn!");
		}

        if (this.getCurrentPlayer() == Player.O){
        	this.currentPlayer = Player.X
		}
        else if (this.getCurrentPlayer() == Player.X){
        	this.currentPlayer = Player.O
		}
    }

    public void initialiazeBoard() {
        this.board = new Player[this.ROWS][this.COLS];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = Player.Unknown;
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
        for (int i = 0; i < this.board.length; i++) //horizontal win
            if (this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2]) {
                won = true;
                this.winner = this.board[i][0];
            }
        for (int i = 0; i < this.board[0].length; i++) //vertical win
            if (this.board[0][i] == this.board[1][i] && this.board[0][i] == this.board[2][i]) {
                won = true;
                this.winner = this.board[0][i];
            }
        if (this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2]) { //diagonal win
            won = true;
            this.winner = this.board[0][0];
        }
        if (this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0]) { //diagonal win 2nd
            won = true;
            this.winner = this.board[0][2];
        }
        return won;
    }

    public boolean isDraw() {
        boolean draw = true;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == Player.Unknown) {
                    draw = false;
                }
            }
        }
        return draw;
    }

    public boolean isGameOver() {
        return this.isDraw() || this.isGameWon();
    }

    public Player getWinner() {
        return this.winner;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public enum Player {
        Unknown, X, O
    }
}
