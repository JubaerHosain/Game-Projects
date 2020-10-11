package checkers;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author jubaer
 */
public class Board extends Canvas {

    private static final int RECT_SIZE = Main.RECT_SIZE;
    private static final int NUMBER = Main.NUMBER;
    private static final int BOARD_SIZE = Main.BOARD_SIZE;
    private static int PLAYER;
    private static int selectedRow = -1;
    private static int selectedCol;
    private static boolean play = false;
    private static ArrayList<Move> legalMoves = new ArrayList<>();

    public Board() {
        super(BOARD_SIZE, BOARD_SIZE);

        //Mouseclick event
        setOnMouseClicked((event) -> {
            int col = (int) (event.getX() / RECT_SIZE);
            int row = (int) (event.getY() / RECT_SIZE);

            doMouseClick(row, col);
        });

        //initializing for new game
        //Red player get first move in default
        PLAYER = Type.RED;
        Controller.initializeGrid();
        legalMoves = getLegalMoves(PLAYER);
        selectedRow = -1;
        drawBoard();
    }

    public void newGame() {
        //Red player get first move in default
        PLAYER = Type.RED;
        Main.setText("RED: MAKE YOUR MOVE");
        Controller.initializeGrid();
        legalMoves = getLegalMoves(PLAYER);
        selectedRow = -1;
        drawBoard();
    }

    //Drawing checkboard
    public void drawBoard() {

        //Create graphic object
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFont(new Font("arial", 45));

        for (int row = 0; row < NUMBER; row++) {
            for (int col = 0; col < NUMBER; col++) {
                //Alternet rect color
                if (row % 2 == col % 2) {
                    gc.setFill(Color.WHEAT);
                } else {
                    gc.setFill(Color.ALICEBLUE);
                }

                //draw rect
                gc.fillRect(col * RECT_SIZE, row * RECT_SIZE, RECT_SIZE, RECT_SIZE);

                //draw piece
                switch (Controller.getTypeAt(row, col)) {
                    case Type.RED:
                        gc.setFill(Color.BROWN);
                        gc.fillOval(8 + col * RECT_SIZE, 8 + row * RECT_SIZE, RECT_SIZE - 16, RECT_SIZE - 16);
                        break;

                    case Type.RED_KING:
                        gc.setFill(Color.BROWN);
                        gc.fillOval(8 + col * RECT_SIZE, 8 + row * RECT_SIZE, RECT_SIZE - 16, RECT_SIZE - 16);
                        gc.setFill(Color.CORAL);
                        gc.fillText("K", 25 + col * RECT_SIZE, 55 + row * RECT_SIZE);
                        break;

                    case Type.BLACK:
                        gc.setFill(Color.DARKMAGENTA);
                        gc.fillOval(8 + col * RECT_SIZE, 8 + row * RECT_SIZE, RECT_SIZE - 16, RECT_SIZE - 16);
                        break;

                    case Type.BLACK_KING:
                        gc.setFill(Color.DARKMAGENTA);
                        gc.fillOval(8 + col * RECT_SIZE, 8 + row * RECT_SIZE, RECT_SIZE - 16, RECT_SIZE - 16);
                        gc.setFill(Color.CORAL);
                        gc.fillText("K", 25 + col * RECT_SIZE, 55 + row * RECT_SIZE);
                        break;
                }

            }
        }

        //Draw border around all legalMove pices
        for (int i = 0; i < legalMoves.size(); i++) {
            gc.setStroke(Color.CORAL);
            gc.setLineWidth(3);
            gc.strokeRect(legalMoves.get(i).fromCol * RECT_SIZE, legalMoves.get(i).fromRow * RECT_SIZE, RECT_SIZE - 3, RECT_SIZE - 3);
        }

        //If any pice is selected for moving then set different stroke
        if (selectedRow >= 0) {
            gc.setStroke(Color.CHARTREUSE);
            gc.setLineWidth(3);
            gc.strokeRect(selectedCol * RECT_SIZE, selectedRow * RECT_SIZE, RECT_SIZE - 3, RECT_SIZE - 3);

            gc.setStroke(Color.CHARTREUSE);
            gc.setLineWidth(3);
            for (int i = 0; i < legalMoves.size(); i++) {
                if (legalMoves.get(i).fromRow == selectedRow && legalMoves.get(i).fromCol == selectedCol) {
                    gc.strokeRect(legalMoves.get(i).toCol * RECT_SIZE, legalMoves.get(i).toRow * RECT_SIZE, RECT_SIZE - 3, RECT_SIZE - 3);

                }
            }

        }
    }

    //Action on mouseClick
    private void doMouseClick(int row, int col) {
        //If click on any legal pice then select it
        for (int i = 0; i < legalMoves.size(); i++) {
            if (legalMoves.get(i).fromRow == row && legalMoves.get(i).fromCol == col) {
                selectedRow = row;
                selectedCol = col;

                drawBoard();
                return;
            }
        }

        //If no pice is selected to be moved
        if (selectedRow < 0) {
            return;
        }

        //If clicked on a rectangle where a pice would legally moved
        for (int i = 0; i < legalMoves.size(); i++) {
            if (legalMoves.get(i).fromRow == selectedRow && legalMoves.get(i).fromCol == selectedCol
                    && legalMoves.get(i).toRow == row && legalMoves.get(i).toCol == col) {
                makeMove(legalMoves.get(i));
                return;
            }
        }
    }

    //make move on board
    private void makeMove(Move moves) {
        Controller.makeMoveOnGrid(moves);

        //If move is jump user must jump
        if (Controller.isJump(moves)) {
            //If there was a jump there may be another jump from where this pice just jumped
            legalMoves = getLegalJumpsFrom(PLAYER, moves.toRow, moves.toCol);

            if (!legalMoves.isEmpty()) {
                //where reached the pice, now this is our movable pice
                selectedRow = moves.toRow;
                selectedCol = moves.toCol;

                //draw board as update
                drawBoard();
                return;
            }
        }

        //Change player move
        if (PLAYER == Type.RED) {
            PLAYER = Type.BLACK;
            legalMoves = getLegalMoves(PLAYER);
            
            if(legalMoves.isEmpty()){
                Main.setText("RED WINS");
            }
            else{
                Main.setText("BLACK: MAKE YOUR MOVE");
            }
            
        } else {
            PLAYER = Type.RED;
            legalMoves = getLegalMoves(PLAYER);
            
            if(legalMoves.isEmpty()){
                Main.setText("BLACK WINS");
            }
            else{
                Main.setText("RED: MAKE YOUR MOVE");
            }
        }

        //make sure that player is not selected any squre
        selectedRow = -1;

        //redraw the new state
        drawBoard();
    }

    //Find all legal moves/jumps
    private ArrayList<Move> getLegalMoves(int PLAYER) {
        ArrayList<Move> moves = new ArrayList<>();
        int KING = (PLAYER == Type.RED) ? Type.RED_KING : Type.BLACK_KING;

        //If any jumps are possible add to the moves list
        for (int row = 0; row < NUMBER; row++) {
            for (int col = 0; col < NUMBER; col++) {
                if (Controller.GRID[row][col] == PLAYER || Controller.GRID[row][col] == KING) {
                    if (Controller.canJump(PLAYER, row, col, row + 1, col + 1, row + 2, col + 2)) {
                        moves.add(new Move(row, col, row + 2, col + 2));
                    }
                    if (Controller.canJump(PLAYER, row, col, row - 1, col - 1, row - 2, col - 2)) {
                        moves.add(new Move(row, col, row - 2, col - 2));
                    }
                    if (Controller.canJump(PLAYER, row, col, row - 1, col + 1, row - 2, col + 2)) {
                        moves.add(new Move(row, col, row - 2, col + 2));
                    }
                    if (Controller.canJump(PLAYER, row, col, row + 1, col - 1, row + 2, col - 2)) {
                        moves.add(new Move(row, col, row + 2, col - 2));
                    }
                }
            }
        }

        //If any jumps is found user must jump so we didnt need to any move
        if (moves.size() == 0) {
            for (int row = 0; row < NUMBER; row++) {
                for (int col = 0; col < NUMBER; col++) {
                    if (Controller.GRID[row][col] == PLAYER || Controller.GRID[row][col] == KING) {
                        if (Controller.canMove(PLAYER, row, col, row + 1, col + 1)) {
                            moves.add(new Move(row, col, row + 1, col + 1));
                        }
                        if (Controller.canMove(PLAYER, row, col, row - 1, col - 1)) {
                            moves.add(new Move(row, col, row - 1, col - 1));
                        }
                        if (Controller.canMove(PLAYER, row, col, row - 1, col + 1)) {
                            moves.add(new Move(row, col, row - 1, col + 1));
                        }
                        if (Controller.canMove(PLAYER, row, col, row + 1, col - 1)) {
                            moves.add(new Move(row, col, row + 1, col - 1));
                        }
                    }
                }
            }
        }

        return moves;
    }

    private ArrayList<Move> getLegalJumpsFrom(int PLAYER, int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();
        int KING = (PLAYER == Type.RED) ? Type.RED_KING : Type.BLACK_KING;

        //If any jumps are possible add to the moves list
        if (Controller.GRID[row][col] == PLAYER || Controller.GRID[row][col] == KING) {
            if (Controller.canJump(PLAYER, row, col, row + 1, col + 1, row + 2, col + 2)) {
                moves.add(new Move(row, col, row + 2, col + 2));
            }
            if (Controller.canJump(PLAYER, row, col, row - 1, col - 1, row - 2, col - 2)) {
                moves.add(new Move(row, col, row - 2, col - 2));
            }
            if (Controller.canJump(PLAYER, row, col, row - 1, col + 1, row - 2, col + 2)) {
                moves.add(new Move(row, col, row - 2, col + 2));
            }
            if (Controller.canJump(PLAYER, row, col, row + 1, col - 1, row + 2, col - 2)) {
                moves.add(new Move(row, col, row + 2, col - 2));
            }
        }

        return moves;
    }

}
