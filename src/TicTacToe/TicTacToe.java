package TicTacToe;

import TicTacToe.Model.*;
import TicTacToe.Utils.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;

    public void initialise() {
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Bhanuj", crossPiece);

        PlayingPieceO circlePiece = new PlayingPieceO();
        Player player2 = new Player("Raj", circlePiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player currPlayer = players.removeFirst();

            gameBoard.printBoard();

            List<Pair> freeSpaces = gameBoard.getFreeCells();

            if(freeSpaces.isEmpty()) {
                break;
            }

            System.out.println("Player: " + currPlayer.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            if(!gameBoard.addPiece(inputRow, inputColumn, currPlayer.getPlayingPiece())) {
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(currPlayer);
                continue;
            }

            players.addLast(currPlayer);

            if(checkWinner(inputRow, inputColumn, currPlayer.getPlayingPiece().piece)) {
                return currPlayer.getName();
            }
        }
        return "Tie";
    }

    private boolean checkWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].piece != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].piece != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].piece != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].piece != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

    }
}
