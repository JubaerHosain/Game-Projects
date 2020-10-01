package inversegrid;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author jubaer
 */
public class Main extends Application {

    private Pane root;
    private Stage stage;

    private final int cellSize = 100;
    private int cellNumber = 3;

    @Override
    public void start(Stage stage) throws Exception {
        this.root = new Pane();
        this.stage = stage;
        newGame();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inverse Grid");
        stage.show();
    }

    private void newGame() {
        this.root.setPrefSize(cellSize * cellNumber, cellSize * cellNumber);
        this.root.getChildren().clear();

        this.stage.setWidth(cellSize * cellNumber + 16);
        this.stage.setHeight(cellSize * cellNumber + 38);

        for (int i = 0; i < cellNumber; i++) {
            for (int j = 0; j < cellNumber; j++) {
                Cell cell = new Cell(i, j);

                root.getChildren().add(cell);
            }
        }
    }

    public boolean isWin() {
        int size = root.getChildren().size();

        for (int i = 0; i < size; i++) {
            Cell cell = (Cell) root.getChildren().get(i);

            if (!cell.flip) {
                return false;
            }
        }

        return true;
    }

    //Main method---------------------------------------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }
    //Main method---------------------------------------------------------------------------------------

    //this inner class for each cell
    class Cell extends Rectangle {

        public int x;
        public int y;
        private boolean flip = false;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;

            setLayoutX(x * cellSize);
            setLayoutY(y * cellSize);
            setWidth(cellSize);
            setHeight(cellSize);
            setFill(Color.BLACK);
            setStroke(Color.GREENYELLOW);

            setOnMouseClicked((MouseEvent event) -> {
                if (!flip) {
                    flip = true;
                    setFill(Color.AQUA);
                } else {
                    flip = false;
                    setFill(Color.BLACK);
                }

                flip();
                if (isWin()) {
                    cellNumber++;
                    if (cellNumber > 7) {
                        System.out.println("You Win");
                        System.exit(0);
                    }
                    System.out.println("Wins " + (cellNumber-1) + "X" + (cellNumber-1) + " Grid");
                    newGame();
                }
            });

        }

        private void flip() {

            //adjacent points
            ArrayList<Point> points = new ArrayList<>();
            points.add(new Point(x, y - 1));
            points.add(new Point(x, y + 1));
            points.add(new Point(x - 1, y));
            points.add(new Point(x + 1, y));

            for (Point p : points) {
                if (p.isValid()) {
                    int size = root.getChildren().size();

                    for (int i = 0; i < size; i++) {
                        Cell cell = (Cell) root.getChildren().get(i);

                        if (cell.x == p.x && cell.y == p.y) {
                            if (!cell.flip) {
                                cell.flip = true;
                                cell.setFill(Color.AQUA);
                            } else {
                                cell.flip = false;
                                cell.setFill(Color.BLACK);
                            }
                            break;
                        }
                    }
                }
            }
        }

        // this inner class inside Cell for checking valid points
        class Point {

            public int x;
            public int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean isValid() {
                return x >= 0 && x < cellNumber && y >= 0 && y < cellNumber;
            }
        }
    }
}
