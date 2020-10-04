package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    //The variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = SIZE * 16;
    public static final int YMAX = SIZE * 22;
    private static int score = 0;
    private static int lines = 0;
    public static boolean[][] GRID = new boolean[XMAX / SIZE][YMAX / SIZE];
    private static boolean play = true;
    private static int height = 0;

    private Pane root = new Pane();
    private AnchorPane nextObjectPane = new AnchorPane();
    private Scene scene = new Scene(root, XMAX + 150, YMAX);
    private Tetromino currTetromino, next;
    private Tetromino nextTetromino = Controller.makeTetromino();

    @Override
    public void start(Stage stage) throws Exception {
        for (boolean[] g : GRID) {
            Arrays.fill(g, false);
        }

        currTetromino = nextTetromino;
        nextTetromino = Controller.makeTetromino();
        next = Controller.makeNextTetromino(nextTetromino.formName);

        //this is vertical line
        Line line = new Line(XMAX, 0, XMAX, YMAX);

        //this part for nextObjectPane
        //nextObjectPane.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; -fx-border-color: blue;");
        nextObjectPane.setPrefSize(150, 50);
        nextObjectPane.setLayoutX(XMAX);
        nextObjectPane.setLayoutY(0);
        nextObjectPane.getChildren().addAll(next.a, next.b, next.c, next.d);

        //label under nextObjectPane
        Label nextLabel = new Label("NEXT");
        nextLabel.setFont(Font.font("arial", 25));
        nextLabel.setLayoutX(XMAX + 45);
        nextLabel.setLayoutY(55);

        //label for score
        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.setFont(Font.font("arial", 25));
        scoreLabel.setLayoutX(XMAX + 5);
        scoreLabel.setLayoutY(270);

        //label for score
        Label lineLabel = new Label("Lines: " + lines);
        lineLabel.setFont(Font.font("arial", 25));
        lineLabel.setLayoutX(XMAX + 5);
        lineLabel.setLayoutY(300);

        //set style on root pane and add childrens
        root.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; -fx-border-color: blue;");
        root.getChildren().addAll(line, nextObjectPane, nextLabel, scoreLabel, lineLabel);
        root.getChildren().addAll(currTetromino.a, currTetromino.b, currTetromino.c, currTetromino.d);
        stage.setScene(scene);
        stage.setTitle("TETRIS");
        stage.show();

        //set action on scene
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            switch (key.getCode()) {
                case LEFT:
                    Controller.moveLeftTetromino(currTetromino);
                    break;

                case RIGHT:
                    Controller.moveRightTetromino(currTetromino);
                    break;

                case UP:
                    Controller.moveTurnTetromino(currTetromino);
                    break;

                case DOWN:
                    moveDownTetromino(currTetromino);
                    break;

            }
        });

        //this is timer that controls calling moveDownTetromino
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), (event) -> {
            if (currTetromino.a.getY() == 0 || currTetromino.b.getY() == 0
                    || currTetromino.c.getY() == 0 || currTetromino.d.getY() == 0) {
                height++;
            } else {
                height = 0;
            }

            if(height == 2){
                play = false;
                System.out.println("Game Over");
            }
            
            if (play) {
                moveDownTetromino(currTetromino);
                scoreLabel.setText("Score: " + score);
                lineLabel.setText("Lines: " + lines);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    //make nextTetromino
    private Tetromino makeNextTetromino(Tetromino next) {

        next.a.setX(next.a.getX() - XMAX / 2);
        next.b.setX(next.b.getX() - XMAX / 2);
        next.c.setX(next.c.getX() - XMAX / 2);
        next.d.setX(next.d.getX() - XMAX / 2);

        return next;
    }

    //Move Down Tetromino==============================================================================
    private void moveDownTetromino(Tetromino tetromino) {
        //if reaches the bottom or touch privious any form
        if (tetromino.a.getY() == YMAX - SIZE || tetromino.b.getY() == YMAX - SIZE
                || tetromino.c.getY() == YMAX - SIZE || tetromino.d.getY() == YMAX - SIZE
                || isMovableRect(tetromino.a) || isMovableRect(tetromino.b) || isMovableRect(tetromino.c) || isMovableRect(tetromino.d)) {
            GRID[(int) (tetromino.a.getX() / SIZE)][(int) (tetromino.a.getY() / SIZE)] = true;
            GRID[(int) (tetromino.b.getX() / SIZE)][(int) (tetromino.b.getY() / SIZE)] = true;
            GRID[(int) (tetromino.c.getX() / SIZE)][(int) (tetromino.c.getY() / SIZE)] = true;
            GRID[(int) (tetromino.d.getX() / SIZE)][(int) (tetromino.d.getY() / SIZE)] = true;

            //remove those rows filled by rectangles
            removeRows();

            currTetromino = nextTetromino;
            nextTetromino = Controller.makeTetromino();
            next = Controller.makeNextTetromino(nextTetromino.formName);
            root.getChildren().addAll(currTetromino.a, currTetromino.b, currTetromino.c, currTetromino.d);
            nextObjectPane.getChildren().clear();
            nextObjectPane.getChildren().addAll(next.a, next.b, next.c, next.d);
        }

        //if there has free space to move down
        if (tetromino.a.getY() + MOVE < YMAX && tetromino.b.getY() + MOVE < YMAX && tetromino.c.getY() + MOVE < YMAX && tetromino.d.getY() + MOVE < YMAX
                && !isMovableRect(tetromino.a) && !isMovableRect(tetromino.b) && !isMovableRect(tetromino.c) && !isMovableRect(tetromino.d)) {
            tetromino.a.setY(tetromino.a.getY() + MOVE);
            tetromino.b.setY(tetromino.b.getY() + MOVE);
            tetromino.c.setY(tetromino.c.getY() + MOVE);
            tetromino.d.setY(tetromino.d.getY() + MOVE);
        }
    }

    private boolean isMovableRect(Rectangle rect) {
        return GRID[(int) (rect.getX() / SIZE)][(int) (rect.getY() / SIZE) + 1];
    }

    private void removeRows() {
        ArrayList<Node> rects = new ArrayList<>();
        ArrayList<Node> upperRects = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();

        //if any rows full of rectangles
        for (int i = 0; i < GRID[0].length; i++) {
            int full = 0;
            for (int j = 0; j < GRID.length; j++) {
                if (GRID[j][i]) {
                    full++;
                }
            }

            if (full == GRID.length) {
                rows.add(i);
            }
        }

        while (rows.size() > 0) {
            score += 10;
            lines++;

            //Only rectangles are added to rects list
            for (Node node : root.getChildren()) {
                if (node instanceof Rectangle) {
                    rects.add(node);
                }
            }

            //if any rec is stays at rows being deleted
            for (Node node : rects) {
                Rectangle r = (Rectangle) node;

                if (r.getY() == rows.get(0) * SIZE) {
                    GRID[(int) r.getX() / SIZE][(int) r.getY() / SIZE] = false;
                    root.getChildren().remove(node);
                } else {
                    upperRects.add(node);
                }
            }

            //down upper Rectangles one by one
            for (Node node : upperRects) {
                Rectangle r = (Rectangle) node;

                if (r.getY() < rows.get(0) * SIZE) {
                    GRID[(int) r.getX() / SIZE][(int) r.getY() / SIZE] = false;
                    r.setY(r.getY() + SIZE);
                }
            }

            rects.clear();
            upperRects.clear();
            rows.remove(0);

            //again Only rectangles are added to rects list. this is for updating GRID true where stays rects
            for (Node node : root.getChildren()) {
                if (node instanceof Rectangle) {
                    rects.add(node);
                }
            }

            //make true GRID which position contains rects
            for (Node node : rects) {
                Rectangle r = (Rectangle) node;

                try {
                    GRID[(int) r.getX() / SIZE][(int) r.getY() / SIZE] = true;
                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }

            rects.clear();
        }
    }

    //Main method==================================================================================
    public static void main(String[] args) {
        launch(args);
    }
}
