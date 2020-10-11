/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

/**
 *
 * @author jubaer
 */
public class Controller {

    private static final int RECT_SIZE = Main.RECT_SIZE;
    private static final int NUMBER = Main.NUMBER;
    private static final int BOARD_SIZE = Main.BOARD_SIZE;

    public static int[][] GRID = new int[NUMBER][NUMBER];

    public Controller() {
        initializeGrid();
    }

    public static void initializeGrid() {
        for (int row = 0; row < NUMBER; row++) {
            for (int col = 0; col < NUMBER; col++) {
                if (row % 2 == col % 2) {
                    if (row < 3) {
                        GRID[row][col] = Type.BLACK;
                    } else if (row > 4) {
                        GRID[row][col] = Type.RED;
                    } else {
                        GRID[row][col] = Type.EMPTY;
                    }
                } else {
                    GRID[row][col] = Type.EMPTY;
                }
            }
        }
    }

    //If any jump is possible
    public static boolean canJump(int PLAYER, int r, int c, int r1, int c1, int r2, int c2) {

        //Return false for out of the board
        if (r2 < 0 || r2 > 7 || c2 < 0 || c2 > 7) {
            return false;
        }

        //If (r2, c2) is not empty
        if (GRID[r2][c2] != Type.EMPTY) {
            return false;
        }

        if (PLAYER == Type.RED) {
            //Red moves only up
            if (GRID[r][c] == Type.RED && r2 > r1) {
                return false;
            }

            //if middle is not black nor black king
            if (GRID[r1][c1] != Type.BLACK && GRID[r1][c1] != Type.BLACK_KING) {
                return false;
            }

            return true;
        } else {
            //Black moves only down
            if (GRID[r][c] == Type.BLACK && r2 < r1) {
                return false;
            }

            //if middle is not red nor red king
            if (GRID[r1][c1] != Type.RED && GRID[r1][c1] != Type.RED_KING) {
                return false;
            }

            return true;
        }

    }

    //If any move is possible
    static boolean canMove(int PLAYER, int r, int c, int r1, int c1) {
        //Return false for out of the board
        if (r1 < 0 || r1 > 7 || c1 < 0 || c1 > 7) {
            return false;
        }

        //If (r2, c2) is not empty
        if (GRID[r1][c1] != Type.EMPTY) {
            return false;
        }

        if (PLAYER == Type.RED) {
            if (GRID[r][c] == Type.RED && r1 > r) {
                return false;
            }

            return true;
        } else {
            if (GRID[r][c] == Type.BLACK && r1 < r) {
                return false;
            }

            return true;
        }
    }

    //Get type of pices form grid
    public static int getTypeAt(int row, int col) {

        return GRID[row][col];
    }

    //If any move is jump or not
    public static boolean isJump(Move moves) {
        return moves.fromRow - moves.toRow == 2 || moves.fromRow - moves.toRow == -2;
    }

    //for making move on grid
    public static void makeMoveOnGrid(Move moves) {
        //make transition from -> to
        GRID[moves.toRow][moves.toCol] = GRID[moves.fromRow][moves.fromCol];
        GRID[moves.fromRow][moves.fromCol] = Type.EMPTY;

        //if pice is reach to corner make red/black king
        if (moves.toRow == 0 && GRID[moves.toRow][moves.toCol] == Type.RED) {
            GRID[moves.toRow][moves.toCol] = Type.RED_KING;
        }

        if (moves.toRow == 7 && GRID[moves.toRow][moves.toCol] == Type.BLACK) {
            GRID[moves.toRow][moves.toCol] = Type.BLACK_KING;
        }

        //if move is jump then make empty the middle location
        if (moves.fromRow - moves.toRow == 2 || moves.fromRow - moves.toRow == -2) {
            int midRow = (moves.fromRow + moves.toRow) / 2; //Middle row of this two location
            int midCol = (moves.fromCol + moves.toCol) / 2; //Middle row of this two location
            GRID[midRow][midCol] = Type.EMPTY;
        }

    }

}
