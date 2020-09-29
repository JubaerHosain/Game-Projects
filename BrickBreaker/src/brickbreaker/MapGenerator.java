package brickbreaker;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author jubaer
 */
public class MapGenerator {

    private boolean[][] bricks;
    private int brickSize;

    public MapGenerator(int row, int col) {
        this.bricks = new boolean[row][col];
        this.brickSize = 50;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.bricks[i][j] = true;
            }
        }
    }
    
    public void reset(int row, int col){
        this.bricks = new boolean[row][col];
        this.brickSize = 50;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.bricks[i][j] = true;
            }
        }
    }

    public void drawBrick(GraphicsContext gc) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j]) {
                    int x = j * brickSize + 150;
                    int y = i * brickSize + 100;

                    gc.setFill(Color.AQUA);
                    gc.fillRect(x, y, brickSize, brickSize);

                    gc.setStroke(Color.BLACK);
                    gc.strokeRect(x, y, brickSize, brickSize);
                }
            }
        }
    }

    public boolean[][] getBricks() {
        return this.bricks;
    }

    public int getBrickSize() {
        return this.brickSize;
    }

    public void setBrickValue(boolean val, int row, int col) {
        this.bricks[row][col] = val;
    }
}
