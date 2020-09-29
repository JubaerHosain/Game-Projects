package brickbreaker;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author jubaer
 */
public class PlayGame {

    private boolean play = true;
    private int score = 0;
    private int totalBrick;

    private int paddleX;
    private final int paddleY = 680;
    private final int paddleWidth = 150;
    private final int paddleHeight = 8;

    private int ballXpos;
    private int ballYpos;
    private int ballXdir;
    private int ballYdir;
    private final int ballSize = 20;

    private int canvasWidth;
    private int canvasHeight;

    Random rand = new Random();
    private MapGenerator map;

    public PlayGame(int sceneWidth, int sceneHeight) {
        map = new MapGenerator(4, 12);
        this.totalBrick = 4 * 12;
        this.canvasWidth = sceneWidth;
        this.canvasHeight = sceneHeight;
        this.score = 0;
        this.play = true;
        this.paddleX = 375;
        
        
        ballXpos = rand.nextInt(750) + 150;
        ballYpos = rand.nextInt(350) + 350;
        if(ballXpos < sceneWidth/2){
            ballXdir = -4;
        }
        else{
            ballXdir = 4;
        }
        ballYdir = -4;
    }
    
    public void reset(int sceneWidth, int sceneHeight){
        map.reset(4, 12);
        this.totalBrick = 4 * 12;
        this.canvasWidth = sceneWidth;
        this.canvasHeight = sceneHeight;
        this.score = 0;
        this.play = true;
        this.paddleX = 375;
        
        
        ballXpos = rand.nextInt(550) + 150;
        ballYpos = rand.nextInt(230) + 450;
        if(ballXpos < sceneWidth/2){
            ballXdir = -4;
        }
        else{
            ballXdir = 4;
        }
        ballYdir = -4;
    }

    public void draw(GraphicsContext gc) {
        if (!play) {
            return;
        }

        //Set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);

        //Score text
        gc.setFill(Color.AQUAMARINE);
        gc.setFont(new Font("", 25));
        gc.fillText("Score:" + score, 785, 30);

        //paddle
        gc.setFill(Color.AQUA);
        gc.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        //ball
        gc.setFill(Color.CHARTREUSE);
        gc.fillOval(ballXpos, ballYpos, ballSize, ballSize);

        //drawing bricks
        map.drawBrick(gc);

        //if all brickes brokes
        if (totalBrick <= 0) {
            winGame(gc);
        }

        //if ball is fall down
        if (ballYpos > canvasHeight) {
            fallDown(gc);
        }

        //if any brick borkes
        actioPerformed();
    }

    private void actioPerformed() {
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
        if (paddleRect.intersects(ballXpos, ballYpos, ballSize, ballSize)) {
            ballYdir = -ballYdir;
            moveBall();
            return;
        }

        boolean[][] bricks = map.getBricks();

        label:
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j]) {
                    int brickSize = map.getBrickSize();
                    int x = j * brickSize + 150;
                    int y = i * brickSize + 100;

                    Rectangle brickRect = new Rectangle(x, y, brickSize, brickSize);
                    //Rectangle ballRect = new Rectangle(ballXpos, ballYpos, ballSize, ballSize);

                    if (brickRect.intersects(ballXpos, ballYpos, ballSize, ballSize)) {
                        map.setBrickValue(false, i, j);
                        totalBrick--;
                        score += 10;

                        if (ballXpos + ballSize - 4 <= x || ballXpos + 4 >= x + brickSize) {
                            ballXdir = -ballXdir;
                        } else {
                            ballYdir = -ballYdir;
                        }

                        break label;
                    }
                }
            }
        }

        moveBall();
    }

    public boolean getPlay() {
        return this.play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public void moveBall() {
        ballXpos += ballXdir;
        ballYpos += ballYdir;

        if (ballXpos < 0) {
            ballXdir = -ballXdir;
        }
        if (ballXpos + ballSize > 900 - 3) {
            ballXdir = -ballXdir;
        }
        if (ballYpos < 0) {
            ballYdir = -ballYdir;
        }
    }

    public void moveLeft() {
        this.play = true;
        paddleX -= 50;

        if (paddleX < 0) {
            paddleX = 0;
        }
    }

    public void moveRight() {
        this.play = true;
        paddleX += 50;

        if (paddleX > canvasWidth - paddleWidth) {
            paddleX = canvasWidth - paddleWidth;
        }
    }

    private void winGame(GraphicsContext gc) {
        play = false;
        ballXdir = ballYdir = 0;

        gc.setFill(Color.AQUAMARINE);
        gc.setFont(new Font("serif", 40));
        gc.fillText(" YOU WON", 335, 335);

        gc.setFill(Color.BLUE);
        gc.setFont(new Font("", 40));
        gc.fillText("Score:" + score, 360, 375);

        gc.setFill(Color.MAGENTA);
        gc.setFont(new Font("serif", 30));
        gc.fillText("Press Enter to Restart", 308, 405);
    }

    private void fallDown(GraphicsContext gc) {
        play = false;
        ballXdir = 0;
        ballYdir = 0;

        //print game over
        gc.setFill(Color.RED);
        gc.setFont(new Font("serif", 40));
        gc.fillText("GAME OVER", 325, 335);

        //print score after game over
        gc.setFill(Color.GREEN);
        gc.fillText("Score:" + score, 370, 375);

        //print suggestion
        gc.setFill(Color.MAGENTA);
        gc.setFont(new Font("serif", 30));
        gc.fillText("Press Enter to Restart", 308, 405);
    }
}
