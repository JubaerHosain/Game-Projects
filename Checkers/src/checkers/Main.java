package checkers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * this is a two player checker game
 *
 * @author jubaer
 */
public class Main extends Application {

    //Container variables==========================================================================
    private Board board;
    private Pane root;
    private Scene scene;
    
    private static Label message;
    private static Button btn;
    public static final int RECT_SIZE = 80;
    public static final int NUMBER = 8;
    public static final int BOARD_SIZE = RECT_SIZE * NUMBER;
    
    @Override
    public void start(Stage stage) throws Exception {
        board = new Board();
        board.drawBoard();
        
        btn = new Button("NEW GAME");
        btn.setLayoutX(BOARD_SIZE + 90);
        btn.setLayoutY(BOARD_SIZE / 2 - 50);
        btn.setOnAction((event) -> {
            board.newGame();
        });
        
        message = new Label("RED: MAKE YOUR MOVE");
        message.setFont(new Font("serif", 20));
        message.setLayoutX(BOARD_SIZE + 10);
        message.setLayoutY(BOARD_SIZE / 2);
        
        root = new Pane();
        root.setPrefSize(BOARD_SIZE + 270, BOARD_SIZE);
        root.getChildren().addAll(board, message, btn);
        
        scene = new Scene(root, BOARD_SIZE + 250, BOARD_SIZE);
        scene.setFill(Color.CORAL);
        stage.setScene(scene);
        stage.setTitle("TWO PLAYER CHECKER");
        stage.show();
    }
    
    public static void setText(String text){
        message.setText(text);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
