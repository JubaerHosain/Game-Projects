/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;


import java.util.ArrayList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayGame {

    private class Snake {

        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int cornerSize = 20;
    private int speed, score;
    private int canvasWidth, canvasHeight;
    private int width, height;
    private int foodX, foodY, foodcolor;
    private ArrayList<Snake> snake;
    private boolean gameOver, pause;
    private String dir;
    private Random rand;

    public PlayGame(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.speed = 10;
        this.score = 3;
        this.foodX = 0;
        this.foodY = 0;
        this.dir = "LEFT";
        this.width = canvasWidth / cornerSize;
        this.height = canvasHeight / cornerSize;
        this.snake = new ArrayList<>();
        this.gameOver = false;
        this.rand = new Random();

        //initial snake position
        for (int i = 0; i < 4; i++) {
            snake.add(new Snake(width / 2 + i, height / 2));
        }
    }

    public void play(GraphicsContext gc) {
        //if game is  over------------------------------------------------------------------------------
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 50));
            gc.fillText("Game Over", (canvasWidth / 2) - 90, canvasHeight / 2);
            return;
        }

        //shift array list------------------------------------------------------------------------------
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        //choice direction of snake mouth---------------------------------------------------------------
        switch (dir) {
            case "UP":
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    gameOver = true;
                }
                break;

            case "DOWN":
                snake.get(0).y++;
                if (snake.get(0).y >= height) {
                    gameOver = true;
                }
                break;

            case "LEFT":
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    gameOver = true;
                }
                break;

            case "RIGHT":
                snake.get(0).x++;
                if (snake.get(0).x >= width) {
                    gameOver = true;
                }
                break;
        }

        //eat food--------------------------------------------------------------------------------------
        if (snake.get(0).x == foodX && snake.get(0).y == foodY) {
            snake.add(new Snake(-1, -1));
            newFood();
        }

        //self destroy----------------------------------------------------------------------------------
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = true;
            }
        }

        //clear previous fill
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);
        
        //score-----------------------------------------------------------------------------------------
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("", 30));
        gc.fillText("Score: " + score, 10, 30);

        //foodcolor-------------------------------------------------------------------------------------
        Color fc = Color.WHITE;
        switch (foodcolor) {
            case 0:
                fc = Color.CORAL;
                break;
            case 1:
                fc = Color.CRIMSON;
                break;
            case 2:
                fc = Color.YELLOW;
                break;
            case 3:
                fc = Color.GOLD;
                break;
            case 4:
                fc = Color.ORANGE;
                break;
        }

        //draw food-------------------------------------------------------------------------------------
        gc.setFill(fc);
        gc.fillOval(foodX * cornerSize, foodY * cornerSize, cornerSize, cornerSize);

        //draw snake head-------------------------------------------------------------------------------
        gc.setFill(Color.AQUA);
        gc.fillOval(snake.get(0).x * cornerSize, snake.get(0).y * cornerSize, cornerSize + 1, cornerSize + 1);
        gc.setFill(Color.DARKMAGENTA);

        //snake eye-------------------------------------------------------------------------------------
        switch (dir) {
            case "UP":
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize, snake.get(0).y * cornerSize, cornerSize / 4, cornerSize / 4);
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize + 15, snake.get(0).y * cornerSize, cornerSize / 4, cornerSize / 4);
                break;

            case "DOWN":
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize, snake.get(0).y * cornerSize + 15, cornerSize / 4, cornerSize / 4);
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize + 15, snake.get(0).y * cornerSize + 15, cornerSize / 4, cornerSize / 4);
                break;

            case "LEFT":
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize, snake.get(0).y * cornerSize, cornerSize / 4, cornerSize / 4);
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize, snake.get(0).y * cornerSize + 15, cornerSize / 4, cornerSize / 4);
                break;

            case "RIGHT":
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize + 15, snake.get(0).y * cornerSize, cornerSize / 4, cornerSize / 4);
                gc.setFill(Color.BISQUE);
                gc.fillOval(snake.get(0).x * cornerSize + 15, snake.get(0).y * cornerSize + 15, cornerSize / 4, cornerSize / 4);
                break;
        }

        //snake body-------------------------------------------------------------------------------------
        for (int i = 1; i < snake.size(); i++) {
            gc.setFill(Color.RED);
            gc.fillOval(snake.get(i).x * cornerSize, snake.get(i).y * cornerSize, cornerSize, cornerSize);
            gc.setFill(Color.AQUA);
            gc.fillOval(snake.get(i).x * cornerSize, snake.get(i).y * cornerSize, cornerSize - 1, cornerSize - 1);
        }
    }

    public void newFood() {
        label:
        while (true) {
            foodX = rand.nextInt(width);
            foodY = rand.nextInt(height);

            for (Snake s : snake) {
                if (s.x == foodX && s.y == foodY) {
                    continue label;
                }
            }

            foodcolor = rand.nextInt(5);
            score++;
            break;
        }
    }

    public String getDirection() {
        return this.dir;
    }

    public int getSpeed(){
        return this.speed;
    }
    
    public void setDirection(String dir) {
        this.dir = dir;
    }
}

