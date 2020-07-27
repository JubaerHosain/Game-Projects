package mainPackage;

import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static boolean isPlayer1 = true;
    private static boolean isPlayer2 = false;
    private static GamePlay play = new GamePlay();
    private static int player1pos = 0;
    private static int player2pos = 0;
    private static final int WINPOINT = 100;

    @Override
    public void start(Stage pStage) throws FileNotFoundException {
        AnchorPane pane = new AnchorPane();
        //Snake and Ladder board  image---------------------------------------------------------------------------
        ImageView boardImage = new ImageView(new Image(this.getClass().getResource("board.png").toExternalForm()));

        //Label for player whose move-----------------------------------------------------------------------------
        Label topLabel = new Label("Player:1 Move");
        topLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        topLabel.setTextFill(Color.RED);
        topLabel.setLayoutX(650);
        topLabel.setLayoutY(80);

        //Label for player1 name----------------------------------------------------------------------------------
        Label p1Label = new Label("Player:1");
        p1Label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        p1Label.setTextFill(Color.RED);
        p1Label.setLayoutX(625);
        p1Label.setLayoutY(150);

        //Label for player2 name----------------------------------------------------------------------------------
        Label p2Label = new Label("Player:2");
        p2Label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        p2Label.setTextFill(Color.GOLD);
        p2Label.setLayoutX(740);
        p2Label.setLayoutY(150);
        
        //result label--------------------------------------------------------------------------------------------
        Label resultLabel = new Label("");
        resultLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        resultLabel.setTextFill(Color.INDIGO);
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setPrefSize(200, 50);
        resultLabel.setLayoutX(620);
        resultLabel.setLayoutY(520);
        

        //image for player1 below p1Label-------------------------------------------------------------------------
        ImageView player1Image = new ImageView(new Image(this.getClass().getResource("player1.png").toExternalForm()));
        player1Image.setLayoutX(645);
        player1Image.setLayoutY(180);

        //image for player2 below p1Labe2-------------------------------------------------------------------------
        ImageView player2Image = new ImageView(new Image(this.getClass().getResource("player2.png").toExternalForm()));
        player2Image.setLayoutX(760);
        player2Image.setLayoutY(180);

        //image for player1 for moving----------------------------------------------------------------------------
        ImageView player1move = new ImageView(new Image(this.getClass().getResource("move1.png").toExternalForm()));
        player1move.setLayoutX(645);
        player1move.setLayoutY(180);
        
        //image for player1 for moving----------------------------------------------------------------------------
        ImageView player2move = new ImageView(new Image(this.getClass().getResource("move2.png").toExternalForm()));
        player2move.setLayoutX(760);
        player2move.setLayoutY(180);

        //rrolling dice-------------------------------------------------------------------------------------------
        ImageView dice = new ImageView(new Image(this.getClass().getResource("dice1.jpg").toExternalForm()));
        dice.setFitHeight(100);
        dice.setFitWidth(100);

        //place for dice for moving-------------------------------------------------------------------------------
        HBox rollPlace = new HBox();
        rollPlace.setLayoutX(680);
        rollPlace.setLayoutY(260);
        rollPlace.setPrefHeight(100);
        rollPlace.setPrefWidth(100);
        rollPlace.getChildren().add(dice);

        //Button for rolling dice---------------------------------------------------------------------------------
        Button rollDiceBtn = new Button("Roll Dice");
        
        //Button for reset/newGame--------------------------------------------------------------------------------
        Button resetBtn = new Button("Reset");
        resetBtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        resetBtn.setTextFill(Color.INDIGO);
        resetBtn.setLayoutX(790);
        resetBtn.setLayoutY(0);
        resetBtn.setOnAction((ActionEvent event) -> {
            isPlayer1 = true;
            isPlayer2 = false;
            player1pos = 0;
            player2pos = 0;
            
            rollDiceBtn.setDisable(false);
            resultLabel.setText("");
            player1move.setLayoutX(645);
            player1move.setLayoutY(180);
            player2move.setLayoutX(760);
            player2move.setLayoutY(180);
            topLabel.setText("Player:1 Move");
            p1Label.setTextFill(Color.RED);
            p2Label.setTextFill(Color.GOLD);
            dice.setImage(new Image(this.getClass().getResource("dice1.jpg").toExternalForm()));
        });
        
        //button rolling dice-------------------------------------------------------------------------------------
        rollDiceBtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        rollDiceBtn.setTextFill(Color.INDIGO);
        rollDiceBtn.setLayoutX(665);
        rollDiceBtn.setLayoutY(400);
        rollDiceBtn.setOnAction((ActionEvent event) -> {
            dice.setImage(new Image(this.getClass().getResource("dice.gif").toExternalForm()));
            
            int diceVlaue = play.rollDice();
            Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    switch(diceVlaue){
                        case 1:
                            dice.setImage(new Image(this.getClass().getResource("dice1.jpg").toExternalForm()));
                            break;
                        case 2:
                            dice.setImage(new Image(this.getClass().getResource("dice2.jpg").toExternalForm()));
                            break;
                        case 3:
                            dice.setImage(new Image(this.getClass().getResource("dice3.jpg").toExternalForm()));
                            break;
                        case 4:
                            dice.setImage(new Image(this.getClass().getResource("dice4.jpg").toExternalForm()));
                            break;
                        case 5:
                            dice.setImage(new Image(this.getClass().getResource("dice5.jpg").toExternalForm()));
                            break;
                        case 6:
                            dice.setImage(new Image(this.getClass().getResource("dice6.jpg").toExternalForm()));
                            break;
                    }
                    
                    //for player1 move
                    if (isPlayer1) {
                        topLabel.setText("Player:2 Move");
                        p1Label.setTextFill(Color.GOLD);
                        p2Label.setTextFill(Color.RED);
                        isPlayer1 = false;
                        isPlayer2 = true;
                        
                        //calculating position
                        player1pos += diceVlaue;
                        //if player1 position exceed winpoint then stay as it is
                        if(player1pos > WINPOINT){
                            player1pos -= diceVlaue;
                        }
                        else{
                            int startPos = (player1pos-diceVlaue)+1;
                            int endPos = player1pos;
                            
                            //this tmer for moving player start point to end point of a dice roll
                            Timeline tl = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                                private int i = startPos;
                                @Override
                                public void handle(ActionEvent event) {
                                    if(i <= endPos){
                                        int[] xy = play.getplayerImagePos(i);
                                        player1move.setLayoutX(xy[0]+5);
                                        player1move.setLayoutY(xy[1]+5);
                                        i++;
                                    }
                                    else{
                                        //if snake found after dice rolling
                                        if(play.SnakeSwallow(player1pos) != 0){
                                            player1pos = play.SnakeSwallow(player1pos);
                                            int[] xy = play.getplayerImagePos(player1pos);
                                            player1move.setLayoutX(xy[0]+5);
                                            player1move.setLayoutY(xy[1]+5);
                                        }
                                        
                                        //if ladder found after dice rolling
                                        if(play.LadderClimb(player1pos) != 0){
                                            player1pos = play.LadderClimb(player1pos);
                                            int[] xy = play.getplayerImagePos(player1pos);
                                            player1move.setLayoutX(xy[0]+5);
                                            player1move.setLayoutY(xy[1]+5);
                                        }
                                    }
                                    
                                    if(play.isWin(player1pos)){
                                        resultLabel.setText("Player 1 Wins");
                                        rollDiceBtn.setDisable(true);
                                    }
                                }
                            }));
                            tl.setCycleCount(endPos-startPos+2);
                            tl.play();
                        }
                    }
                    //for player2 move
                    else {
                        topLabel.setText("Player:1 Move");
                        p1Label.setTextFill(Color.RED);
                        p2Label.setTextFill(Color.GOLD);
                        isPlayer1 = true;
                        isPlayer2 = false;
                        
                        
                        //calculating position
                        player2pos += diceVlaue;
                        //if player1 position exceed winpoint then stay as it is
                        if(player2pos > WINPOINT){
                            player2pos -= diceVlaue;
                        }
                        else{
                            int startPos = (player2pos-diceVlaue)+1;
                            int endPos = player2pos;
                            
                            //this tmer for moving player start point to end point of a dice roll
                            Timeline tl = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                                private int i = startPos;
                                @Override
                                public void handle(ActionEvent event) {
                                    if(i <= endPos){
                                        int[] xy = play.getplayerImagePos(i);
                                        player2move.setLayoutX(xy[0]+5);
                                        player2move.setLayoutY(xy[1]+5);
                                        i++;
                                    }
                                    else{
                                        //if snake found after dice rolling
                                        if(play.SnakeSwallow(player2pos) != 0){
                                            player2pos = play.SnakeSwallow(player2pos);
                                            int[] xy = play.getplayerImagePos(player2pos);
                                            player2move.setLayoutX(xy[0]+5);
                                            player2move.setLayoutY(xy[1]+5);
                                        }
                                        
                                        //if ladder found after dice rolling
                                        if(play.LadderClimb(player2pos) != 0){
                                            player2pos = play.LadderClimb(player2pos);
                                            int[] xy = play.getplayerImagePos(player2pos);
                                            player2move.setLayoutX(xy[0]+5);
                                            player2move.setLayoutY(xy[1]+5);
                                        }
                                    }
                                    
                                    if(play.isWin(player2pos)){
                                        resultLabel.setText("Player 2 Wins");
                                        rollDiceBtn.setDisable(true);
                                    }
                                }
                            }));
                            tl.setCycleCount(endPos-startPos+2);
                            tl.play();
                        }
                    }
                }
            }));
            timeLine.play();
        });

        
        pane.setStyle("-fx-border-color: green");
        pane.getChildren().addAll(boardImage, resetBtn, topLabel, p1Label, p2Label, player1Image, player2Image, player1move, player2move, rollPlace, rollDiceBtn, resultLabel);

        Scene scene = new Scene(pane, 850, 590);
        pStage.setScene(scene);
        pStage.setTitle("Snakes and Ladders");
        pStage.setResizable(false);
        pStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
