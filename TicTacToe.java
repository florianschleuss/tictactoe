// Namen: Lenny Müller, Kristin Saueressig, Florian Schleuss


public class TicTacToe {

    public Player[][] board;
    private int ROWS = 3;
    private int COLS = 3;
    private Player currentPlayer;
    private Player winner;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.play(0, 0);
        t.play(1, 0);
        t.play(0, 1);
        t.play(2, 0);
        t.play(0, 2);
        //t.play(0, 0);
        System.out.println(t.isGameOver());
    }

    public TicTacToe() {
        this.initialiazeBoard();
        this.currentPlayer = Player.X;
        this.winner = null;
    }

    public void play(int row, int col) {
        try {
            if (this.board[col][row] == Player.Unknown) {
                this.board[col][row] = this.getCurrentPlayer();
            } else {
                throw new RuntimeException("Fail");
            }
        } catch (Exception e) {
            throw new RuntimeException("Coordinates out of grid or blocked");
        }
        
        //Entfernt aufgrund von nicht eindeutiger Aufgabenstellung
        
        //if (this.isGameOver()) {
        //    throw new RuntimeException("Game Over");
        //}

        if (this.getCurrentPlayer() == Player.O) {
            this.currentPlayer = Player.X;
        } else if (this.getCurrentPlayer() == Player.X) {
            this.currentPlayer = Player.O;
        }
        System.out.println("Next player!");
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
        for (int i = 0; i < this.board.length; i++) // horizontal win
            if (this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2]) {
                won = true;
                this.winner = this.board[i][0];
            }
        for (int i = 0; i < this.board[0].length; i++) // vertical win
            if (this.board[0][i] == this.board[1][i] && this.board[0][i] == this.board[2][i]) {
                won = true;
                this.winner = this.board[0][i];
            }
        if (this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2]) { // diagonal win
            won = true;
            this.winner = this.board[0][0];
        }
        if (this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0]) { // diagonal win 2nd
            won = true;
            this.winner = this.board[0][2];
        }
        // Neu hinzugefügt
        if (this.winner == Player.Unknown) {
            won = false;
            this.winner = null;
        }
        // Hinzugefügt zuende
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
        if (draw){
            this.winner = Player.Unknown;
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