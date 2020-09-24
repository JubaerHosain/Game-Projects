/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int sceneWidth = 1346;
    private static final int sceneHeiht = 690;
    private static final int canvasWidth = 1340;
    private static final int canvasHeiht = 660;
    private static PlayGame play = new PlayGame(canvasWidth, canvasHeiht);
    private boolean pause = false;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            //main pane
            VBox root = new VBox();
            root.setStyle("-fx-padding:4;-fx-spacing: 2; -fx-border-style: solid inside; -fx-border-width: 1; -fx-border-color: red;");
            root.setAlignment(Pos.CENTER);
            
            //for top part
            HBox top = new HBox();
            //top.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 5; -fx-border-color: blue;");
            top.setPrefSize(canvasWidth, 25);
            top.setAlignment(Pos.CENTER);

            //down part that contains canvas
            HBox canvasContainer = new HBox();
            canvasContainer.setStyle("-fx-border-style: solid inside; -fx-border-width: 3; -fx-border-color: blue;");
            canvasContainer.setPrefSize(canvasWidth, canvasHeiht);
            canvasContainer.setAlignment(Pos.CENTER);

            //canvas
            Canvas canvas = new Canvas(canvasWidth, canvasHeiht);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvasContainer.getChildren().add(canvas);

            play.newFood();
            AnimationTimer timer = new AnimationTimer() {
                long current = 0;

                @Override
                public void handle(long now) {
                    if (current == 0) {
                        current = now;
                        play.play(gc);
                    }

                    if (now - current >= 1000000000/play.getSpeed()) {
                        current = now;
                        play.play(gc);
                    }
                }
            };
            timer.start();
            
            //this is for controlling play pause--------------------------------------------------------
            Button control = new Button("PAUSE");
            control.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            control.setAlignment(Pos.CENTER);
            control.setPrefSize(100, 26);
            control.setTextFill(Color.BLUE);
            control.setOnAction((ActionEvent event) -> {
                if(pause){
                    pause = false;
                    control.setText("PAUSE");
                    timer.start();
                }
                else{
                    pause = true;
                    control.setText("PLAY");
                    timer.stop();
                }
            });
            
            top.getChildren().addAll(control);
            root.getChildren().addAll(top, canvasContainer);
            Scene scene = new Scene(root, sceneWidth, sceneHeiht);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
                if(key.getCode() == KeyCode.UP){
                    if(!play.getDirection().equals("DOWN")){
                        play.setDirection("UP");
                    }
                }
                else if(key.getCode() == KeyCode.DOWN){
                    if(!play.getDirection().equals("UP")){
                        play.setDirection("DOWN");
                    }
                }
                else if(key.getCode() == KeyCode.LEFT){
                    if(!play.getDirection().equals("RIGHT")){
                        play.setDirection("LEFT");
                    }
                }
                else if(key.getCode() == KeyCode.RIGHT){
                    if(!play.getDirection().equals("LEFT")){
                        play.setDirection("RIGHT");
                    }
                }
            });
            stage.setScene(scene);
            stage.setTitle("SNAKE GAME");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

