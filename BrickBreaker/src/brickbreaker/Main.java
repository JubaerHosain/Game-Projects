package brickbreaker;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jubaer
 */
public class Main extends Application {

    private final int sceneWidth = 900;
    private final int sceneHeight = 696;
    private PlayGame play = new PlayGame(sceneWidth, sceneHeight);
//    private final int sceneWidth = 900;
//    private final int sceneWidth = 900;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //canvas for drawing
        Canvas canvas = new Canvas(sceneWidth, sceneHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        play.draw(gc);
        
        //root pane
        Pane root = new AnchorPane();
        root.getChildren().add(canvas);

        //create animation timer
        AnimationTimer timer = new AnimationTimer() {
            private long current = 0;

            @Override
            public void handle(long now) {
                if (now - current >= 10000) {
                    current = now;
                    play.draw(gc);
                }
            }

        };
        timer.start();

        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
        //primaryStage.setResizable(false);
        
        //add action on scene
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key ->{
            if(key.getCode() == KeyCode.LEFT){
                play.moveLeft();
            }
            if(key.getCode() == KeyCode.RIGHT){
                play.moveRight();
            }
            if(key.getCode() == KeyCode.SPACE){
                if(play.getPlay()){
                    play.setPlay(false);
                }
                else{
                    play.setPlay(true);
                }
            }
            if(key.getCode() == KeyCode.ENTER){
                play.reset(sceneWidth, sceneHeight);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
