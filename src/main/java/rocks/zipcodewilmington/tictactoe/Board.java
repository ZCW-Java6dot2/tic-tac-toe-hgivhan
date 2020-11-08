package rocks.zipcodewilmington.tictactoe;

import java.util.logging.XMLFormatter;

/**
 * @author leon on 6/22/18.
 */

/*
    8 ways you can win
    2 nested loops, 1 checks rows, 1 checks columns
    count x's and o's for 3 in a row
    count start at 0 first loop,
    second loop use switch case, whatever first character it finds, check for that across loop
    second loop will be for columns
    ^^ this nested loop gives me rows and tracks row input
    write another nested loop flip flopped to track column input
    if statement outside of both loops and typed matrix locations for diagonal
    00, 01, etc grid locations
    ties, initialize a moveCount, if it gets to 9 (9 spaces on board) and nb won, it's a tie


 */
public class Board {
    private Character [][] board;
    private int resolvedBoard(){
        int totalMoveCount = 0;


        for (int row = 0; row < board.length; row++) {
            int countX = 0;
            int countO = 0;
            for (int column = 0; column < board.length; column++) {
                switch (board[row][column]) {
                    case 'X':
                        countX++;
                        break;
                    case 'O':
                        countO++;
                        break;
                }
                if (countX == 3) {
                    return 1;
                }
                else if (countO == 3) {
                    return -1;
                }
            }
        }
        for (int column = 0; column < board.length; column++){
            int countX = 0;
            int countO = 0;
            for (int row = 0; row < board.length; row++){
                switch (board[row][column]) {
                    case 'X':
                        countX++;
                        totalMoveCount++;
                        break;
                    case 'O':
                        countO++;
                        totalMoveCount++;
                        break;
                }
                if (countX == 3) {
                    return 1;
                }
                else if (countO == 3) {
                    return -1;
                }
                }
            }
        if (totalMoveCount == 9){
            return 0;
        }
        if ((board[0][0] == 'X' &&  board[1][1] == 'X' && board[2][2] ==
        'X') || (board[2][0] == 'X' && board[1][1] == 'X' && board [0][2] == 'X')) {
             return 1;
        }
        else if ((board[0][0] == 'O' &&  board[1][1] == 'O' && board[2][2] ==
        'O') || (board[2][0] == 'O' && board[1][1] == 'O' && board [0][2] == 'O')){
            return -1;
        }
        return 7;
        }
        //call upon boards entered-matrix, and run everything within this method
        //here is where i do for loops and use this method.. set number for who wins and use this method
        //return resolvedBoard() == number in each method below

    public Board(Character[][] matrix) {
        this.board = matrix;

    }

    public Boolean isInFavorOfX() {
        return resolvedBoard() == 1;
    }

    public Boolean isInFavorOfO() {
        return resolvedBoard() == -1;
    }

    public Boolean isTie() {
        return resolvedBoard() == 0;
    }

    public String getWinner() {
        switch(resolvedBoard()){
            case 1:
                return "X";
            case -1:
                return "O";
            case 0:
                return "";
            default:
                return null;
        }

    }

}
