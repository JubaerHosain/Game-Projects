package tetris;

import java.util.Random;
import javafx.scene.shape.Rectangle;

public class Controller {

    //The variables
    private static final int MOVE = Main.MOVE;
    private static final int SIZE = Main.SIZE;
    private static final int XMAX = Main.XMAX;
    private static final int YMAX = Main.YMAX;
    public static boolean[][] GRID = Main.GRID;

    private static final String[] tetrominoNames = {"S", "O", "L", "Z", "I", "J", "T"};
    private static final Random rand = new Random();

    //Make a new Tetromino=============================================================================
    public static Tetromino makeTetromino() {
        int index = rand.nextInt(7);

        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1);   //-1 for spacing among small rectangl's
        Rectangle b = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle c = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle d = new Rectangle(SIZE - 1, SIZE - 1);

        switch (tetrominoNames[index]) {
            case "S":
                a.setX(XMAX / 2 + SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 - SIZE);
                d.setY(SIZE);
                break;

            case "O":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2 - SIZE);
                c.setY(SIZE);
                d.setX(XMAX / 2);
                d.setY(SIZE);
                break;

            case "L":
                a.setX(XMAX / 2 + SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "Z":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "I":
                a.setX(XMAX / 2 - SIZE - SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(0);
                d.setX(XMAX / 2 + SIZE);
                d.setY(0);
                break;

            case "J":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "T":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(0);
                break;
        }

        return new Tetromino(a, b, c, d, tetrominoNames[index]);

    }

    //Make a new nexttetrominoByName=============================================================================
    public static Tetromino makeNextTetromino(String name) {

        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1);   //-1 for spacing among small rectangl's
        Rectangle b = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle c = new Rectangle(SIZE - 1, SIZE - 1);
        Rectangle d = new Rectangle(SIZE - 1, SIZE - 1);

        switch (name) {
            case "S":
                a.setX(XMAX / 2 + SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 - SIZE);
                d.setY(SIZE);
                break;

            case "O":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2 - SIZE);
                c.setY(SIZE);
                d.setX(XMAX / 2);
                d.setY(SIZE);
                break;

            case "L":
                a.setX(XMAX / 2 + SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "Z":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "I":
                a.setX(XMAX / 2 - SIZE - SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(0);
                d.setX(XMAX / 2 + SIZE);
                d.setY(0);
                break;

            case "J":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(SIZE);
                break;

            case "T":
                a.setX(XMAX / 2 - SIZE);
                a.setY(0);
                b.setX(XMAX / 2);
                b.setY(0);
                c.setX(XMAX / 2);
                c.setY(SIZE);
                d.setX(XMAX / 2 + SIZE);
                d.setY(0);
                break;
        }

        //changing position of rectangles so that fit with nextObjectPane
        a.setX(a.getX() - XMAX / 2 + SIZE + SIZE + SIZE);
        b.setX(b.getX() - XMAX / 2 + SIZE + SIZE + SIZE);
        c.setX(c.getX() - XMAX / 2 + SIZE + SIZE + SIZE);
        d.setX(d.getX() - XMAX / 2 + SIZE + SIZE + SIZE);

        return new Tetromino(a, b, c, d, name);

    }

    //Move the form to right======================================================================
    public static void moveLeftTetromino(Tetromino tetromino) {
        if (tetromino.a.getX() - MOVE >= 0 && tetromino.b.getX() - MOVE >= 0
                && tetromino.c.getX() - MOVE >= 0 && tetromino.d.getX() - MOVE >= 0) {

            boolean a = GRID[(int) (tetromino.a.getX() / SIZE) - 1][(int) (tetromino.a.getY() / SIZE)];
            boolean b = GRID[(int) (tetromino.b.getX() / SIZE) - 1][(int) (tetromino.b.getY() / SIZE)];
            boolean c = GRID[(int) (tetromino.c.getX() / SIZE) - 1][(int) (tetromino.c.getY() / SIZE)];
            boolean d = GRID[(int) (tetromino.d.getX() / SIZE) - 1][(int) (tetromino.d.getY() / SIZE)];

            if (!a && !b && !c && !d) {
                tetromino.a.setX(tetromino.a.getX() - MOVE);
                tetromino.b.setX(tetromino.b.getX() - MOVE);
                tetromino.c.setX(tetromino.c.getX() - MOVE);
                tetromino.d.setX(tetromino.d.getX() - MOVE);
            }
        }
    }

    //Move the form to left=======================================================================
    public static void moveRightTetromino(Tetromino tetromino) {
        if (tetromino.a.getX() + MOVE <= XMAX - SIZE && tetromino.b.getX() + MOVE <= XMAX - SIZE
                && tetromino.c.getX() + MOVE <= XMAX - SIZE && tetromino.d.getX() + MOVE <= XMAX - SIZE) {

            boolean a = GRID[(int) (tetromino.a.getX() / SIZE) + 1][(int) (tetromino.a.getY() / SIZE)];
            boolean b = GRID[(int) (tetromino.b.getX() / SIZE) + 1][(int) (tetromino.b.getY() / SIZE)];
            boolean c = GRID[(int) (tetromino.c.getX() / SIZE) + 1][(int) (tetromino.c.getY() / SIZE)];
            boolean d = GRID[(int) (tetromino.d.getX() / SIZE) + 1][(int) (tetromino.d.getY() / SIZE)];

            if (!a && !b && !c && !d) {
                tetromino.a.setX(tetromino.a.getX() + MOVE);
                tetromino.b.setX(tetromino.b.getX() + MOVE);
                tetromino.c.setX(tetromino.c.getX() + MOVE);
                tetromino.d.setX(tetromino.d.getX() + MOVE);
            }
        }
    }

    //Move up rectangle============================================================================
    public static void moveUpRect(Rectangle rect) {
        if (rect.getY() - MOVE > 0) {
            rect.setY(rect.getY() - MOVE);
        }
    }

    //Move down rectangle==========================================================================
    public static void moveDownRect(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX) {
            rect.setY(rect.getY() + MOVE);
        }
    }

    //Move left rectangle==========================================================================
    public static void moveLeftRect(Rectangle rect) {
        if (rect.getX() - MOVE >= 0) {
            rect.setX(rect.getX() - MOVE);
        }
    }

    //Move right rectangle=========================================================================
    public static void moveRightRect(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE) {
            rect.setX(rect.getX() + MOVE);
        }
    }

    //if the form turnable or not=================================================================
    public static boolean isTurnable(Rectangle rect, int x, int y) {
        boolean xt = false;
        boolean yt = false;

        if (x >= 0) {
            xt = (rect.getX() + x * MOVE <= XMAX - SIZE);
        } else {
            xt = (rect.getX() + x * MOVE >= 0);
        }

        if (y >= 0) {
            yt = (rect.getY() - y * MOVE > 0);
        } else {
            yt = (rect.getY() + y * MOVE < YMAX);
        }

        return xt && yt && !GRID[(int) (rect.getX() / SIZE) + x][(int) (rect.getY() / SIZE) - y];
    }

    //for changing the form=======================================================================
    public static void moveTurnTetromino(Tetromino tetromino) {
        int form = tetromino.form;

        switch (tetromino.formName) {
            case "S":
                if (form == 1 && isTurnable(tetromino.a, -1, -1) && isTurnable(tetromino.c, -1, 1) && isTurnable(tetromino.d, 0, 2)) {
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, 1, 1) && isTurnable(tetromino.c, 1, -1) && isTurnable(tetromino.d, 0, -2)) {
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, -1, -1) && isTurnable(tetromino.c, -1, 1) && isTurnable(tetromino.d, 0, 2)) {
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, 1, 1) && isTurnable(tetromino.c, 1, -1) && isTurnable(tetromino.d, 0, -2)) {
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                }
                break;

            //=====================================================================================   
            case "O":
                //no turn need for the O form
                break;

            //=====================================================================================   
            case "L":
                if (form == 1 && isTurnable(tetromino.a, 1, -1) && isTurnable(tetromino.c, 1, 1) && isTurnable(tetromino.b, 2, 2)) {
                    moveRightRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveRightRect(tetromino.b);
                    moveRightRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, -1, -1) && isTurnable(tetromino.c, 1, -1) && isTurnable(tetromino.b, 2, -2)) {
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveRightRect(tetromino.b);
                    moveRightRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, -1, 1) && isTurnable(tetromino.c, -1, -1) && isTurnable(tetromino.b, -2, -2)) {
                    moveLeftRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveLeftRect(tetromino.b);
                    moveLeftRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, 1, 1) && isTurnable(tetromino.c, -1, 1) && isTurnable(tetromino.b, -2, 2)) {
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveLeftRect(tetromino.b);
                    moveLeftRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    tetromino.changeForm();
                }
                break;

            //=====================================================================================   
            case "Z":
                if (form == 1 && isTurnable(tetromino.a, 1, -1) && isTurnable(tetromino.c, 1, 1) && isTurnable(tetromino.d, 0, 2)) {
                    moveRightRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, -1, 1) && isTurnable(tetromino.c, -1, -1) && isTurnable(tetromino.d, 0, -2)) {
                    moveLeftRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, 1, -1) && isTurnable(tetromino.c, 1, 1) && isTurnable(tetromino.d, 0, 2)) {
                    moveRightRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, -1, 1) && isTurnable(tetromino.c, -1, -1) && isTurnable(tetromino.d, 0, -2)) {
                    moveLeftRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                }
                break;

            //=====================================================================================   
            case "I":
                if (form == 1 && isTurnable(tetromino.a, 2, 2) && isTurnable(tetromino.b, 1, 1) && isTurnable(tetromino.d, -1, -1)) {
                    moveRightRect(tetromino.a);
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    moveLeftRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, -2, -2) && isTurnable(tetromino.b, -1, -1) && isTurnable(tetromino.d, 1, 1)) {
                    moveLeftRect(tetromino.a);
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    moveRightRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, 2, 2) && isTurnable(tetromino.b, 1, 1) && isTurnable(tetromino.d, -1, -1)) {
                    moveRightRect(tetromino.a);
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.b);
                    moveUpRect(tetromino.b);
                    moveLeftRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, -2, -2) && isTurnable(tetromino.b, -1, -1) && isTurnable(tetromino.d, 1, 1)) {
                    moveLeftRect(tetromino.a);
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.b);
                    moveDownRect(tetromino.b);
                    moveRightRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                }
                break;

            //=====================================================================================   
            case "J":
                if (form == 1 && isTurnable(tetromino.a, 1, -1) && isTurnable(tetromino.c, -1, -1) && isTurnable(tetromino.d, -2, -2)) {
                    moveRightRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveLeftRect(tetromino.d);
                    moveLeftRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, -1, -1) && isTurnable(tetromino.c, -1, 1) && isTurnable(tetromino.d, -2, 2)) {
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveLeftRect(tetromino.d);
                    moveLeftRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, -1, 1) && isTurnable(tetromino.c, 1, 1) && isTurnable(tetromino.d, 2, 2)) {
                    moveLeftRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveRightRect(tetromino.d);
                    moveRightRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, 1, 1) && isTurnable(tetromino.c, 1, -1) && isTurnable(tetromino.d, 2, -2)) {
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveRightRect(tetromino.d);
                    moveRightRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                }
                break;

            //=====================================================================================   
            case "T":
                if (form == 1 && isTurnable(tetromino.a, 1, 1) && isTurnable(tetromino.c, -1, 1) && isTurnable(tetromino.d, -1, -1)) {
                    moveRightRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveLeftRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 2 && isTurnable(tetromino.a, 1, -1) && isTurnable(tetromino.c, 1, 1) && isTurnable(tetromino.d, -1, 1)) {
                    moveRightRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveUpRect(tetromino.c);
                    moveLeftRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 3 && isTurnable(tetromino.a, -1, -1) && isTurnable(tetromino.c, 1, -1) && isTurnable(tetromino.d, 1, 1)) {
                    moveLeftRect(tetromino.a);
                    moveDownRect(tetromino.a);
                    moveRightRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveRightRect(tetromino.d);
                    moveUpRect(tetromino.d);
                    tetromino.changeForm();
                } else if (form == 4 && isTurnable(tetromino.a, -1, 1) && isTurnable(tetromino.c, -1, -1) && isTurnable(tetromino.d, 1, -1)) {
                    moveLeftRect(tetromino.a);
                    moveUpRect(tetromino.a);
                    moveLeftRect(tetromino.c);
                    moveDownRect(tetromino.c);
                    moveRightRect(tetromino.d);
                    moveDownRect(tetromino.d);
                    tetromino.changeForm();
                }
                break;
        }

    }
}
