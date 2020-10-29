/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author jubaer
 */
public class Main extends Application {

    //container and others
    private AnchorPane board;
    private AnchorPane control;
    private Pane root;
    private Scene scene;

    //control button's for each player
    public static Button player1Button = new Button("Player: 1");
    public static Button player2Button = new Button("Player: 2");
    public static Button player3Button = new Button("Player: 3");
    public static Button player4Button = new Button("Player: 4");
    public static Button diceRollButton = new Button("Dice Roll");

    //message button's
    public static Label message = new Label();
    public static Label diceValueMessage = new Label();

    //Imageview for dice
    public static ImageView dice;

    //Player object for each player
    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;

    private static final int BOARD_SIZE = 695;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializer();

        //Imageview for board image
        ImageView boardImage = new ImageView(new Image(this.getClass().getResource("Board.png").toExternalForm()));

        //board is a Anchorpane that contains board image and piece images
        board = new AnchorPane();
        board.setPrefSize(BOARD_SIZE, BOARD_SIZE);
        board.getChildren().add(boardImage);
        board.getChildren().addAll(player1.firstPiece, player1.secondPiece, player1.thirdPiece, player1.fourthPiece);
        board.getChildren().addAll(player2.firstPiece, player2.secondPiece, player2.thirdPiece, player2.fourthPiece);
        board.getChildren().addAll(player3.firstPiece, player3.secondPiece, player3.thirdPiece, player3.fourthPiece);
        board.getChildren().addAll(player4.firstPiece, player4.secondPiece, player4.thirdPiece, player4.fourthPiece);

        //this is for button and another menu controls
        control = new AnchorPane();
        control.setPrefSize(260, BOARD_SIZE);
        control.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-color: black;");
        control.getChildren().addAll(player1Button, player2Button, player3Button, player4Button, dice, diceRollButton, message, diceValueMessage);
        control.setLayoutX(BOARD_SIZE);

        //this is root pane
        root = new Pane();
        root.setPrefSize(BOARD_SIZE + 260, BOARD_SIZE);
        root.getChildren().addAll(board, control);

        scene = new Scene(root, BOARD_SIZE + 260, BOARD_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LUDO KING");
        primaryStage.show();
    }

    //create image
    private Image createImage(String url) {
        return new Image(this.getClass().getResource(url).toExternalForm());
    }

    //this method initialize the primary positions
    private void initializer() {
        //initialize path maps
        new Path();

        //initialize initial positions
        new InitialPos();

        //initialize diceview position
        dice = new ImageView(createImage("dice1.jpg"));
        dice.setLayoutX(95);
        dice.setLayoutY(270);

        //initialize player 1
        player1 = new Player(createImage("piece11.jpg"), createImage("piece12.jpg"), createImage("piece13.jpg"), createImage("piece14.jpg"), 1);
        player1.firstPiece.setLayoutX(InitialPos.player1InitialPos.get(0).x);
        player1.firstPiece.setLayoutY(InitialPos.player1InitialPos.get(0).y);
        player1.secondPiece.setLayoutX(InitialPos.player1InitialPos.get(1).x);
        player1.secondPiece.setLayoutY(InitialPos.player1InitialPos.get(1).y);
        player1.thirdPiece.setLayoutX(InitialPos.player1InitialPos.get(2).x);
        player1.thirdPiece.setLayoutY(InitialPos.player1InitialPos.get(2).y);
        player1.fourthPiece.setLayoutX(InitialPos.player1InitialPos.get(3).x);
        player1.fourthPiece.setLayoutY(InitialPos.player1InitialPos.get(3).y);

        //initialize player 2
        player2 = new Player(createImage("piece21.jpg"), createImage("piece22.jpg"), createImage("piece23.jpg"), createImage("piece24.jpg"), 2);
        player2.firstPiece.setLayoutX(InitialPos.player2InitialPos.get(0).x);
        player2.firstPiece.setLayoutY(InitialPos.player2InitialPos.get(0).y);
        player2.secondPiece.setLayoutX(InitialPos.player2InitialPos.get(1).x);
        player2.secondPiece.setLayoutY(InitialPos.player2InitialPos.get(1).y);
        player2.thirdPiece.setLayoutX(InitialPos.player2InitialPos.get(2).x);
        player2.thirdPiece.setLayoutY(InitialPos.player2InitialPos.get(2).y);
        player2.fourthPiece.setLayoutX(InitialPos.player2InitialPos.get(3).x);
        player2.fourthPiece.setLayoutY(InitialPos.player2InitialPos.get(3).y);

        //initialize player 3
        player3 = new Player(createImage("piece31.jpg"), createImage("piece32.jpg"), createImage("piece33.jpg"), createImage("piece34.jpg"), 3);
        player3.firstPiece.setLayoutX(InitialPos.player3InitialPos.get(0).x);
        player3.firstPiece.setLayoutY(InitialPos.player3InitialPos.get(0).y);
        player3.secondPiece.setLayoutX(InitialPos.player3InitialPos.get(1).x);
        player3.secondPiece.setLayoutY(InitialPos.player3InitialPos.get(1).y);
        player3.thirdPiece.setLayoutX(InitialPos.player3InitialPos.get(2).x);
        player3.thirdPiece.setLayoutY(InitialPos.player3InitialPos.get(2).y);
        player3.fourthPiece.setLayoutX(InitialPos.player3InitialPos.get(3).x);
        player3.fourthPiece.setLayoutY(InitialPos.player3InitialPos.get(3).y);

        //initialize player 4
        player4 = new Player(createImage("piece41.jpg"), createImage("piece42.jpg"), createImage("piece43.jpg"), createImage("piece44.jpg"), 4);
        player4.firstPiece.setLayoutX(InitialPos.player4InitialPos.get(0).x);
        player4.firstPiece.setLayoutY(InitialPos.player4InitialPos.get(0).y);
        player4.secondPiece.setLayoutX(InitialPos.player4InitialPos.get(1).x);
        player4.secondPiece.setLayoutY(InitialPos.player4InitialPos.get(1).y);
        player4.thirdPiece.setLayoutX(InitialPos.player4InitialPos.get(2).x);
        player4.thirdPiece.setLayoutY(InitialPos.player4InitialPos.get(2).y);
        player4.fourthPiece.setLayoutX(InitialPos.player4InitialPos.get(3).x);
        player4.fourthPiece.setLayoutY(InitialPos.player4InitialPos.get(3).y);

        //Initiazize button setting
        player1Button.setTextAlignment(TextAlignment.CENTER);
        player1Button.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.ITALIC, 25));
        player1Button.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 10; -fx-border-color: chartreuse;");
        player1Button.setTextFill(Color.CHARTREUSE);
        player1Button.setPrefSize(160, 30);
        player1Button.setLayoutX(50);
        player1Button.setLayoutY(10);

        player2Button.setTextAlignment(TextAlignment.CENTER);
        player2Button.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.ITALIC, 25));
        player2Button.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 10; -fx-border-color: red;");
        player2Button.setTextFill(Color.RED);
        player2Button.setPrefSize(160, 30);
        player2Button.setLayoutX(50);
        player2Button.setLayoutY(70);
        player2Button.setDisable(true);

        player3Button.setTextAlignment(TextAlignment.CENTER);
        player3Button.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.ITALIC, 25));
        player3Button.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 10; -fx-border-color: blue;");
        player3Button.setTextFill(Color.BLUE);
        player3Button.setPrefSize(160, 30);
        player3Button.setLayoutX(50);
        player3Button.setLayoutY(130);
        player3Button.setDisable(true);

        player4Button.setTextAlignment(TextAlignment.CENTER);
        player4Button.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.ITALIC, 25));
        player4Button.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 10; -fx-border-color: yellow;");
        player4Button.setTextFill(Color.YELLOW);
        player4Button.setPrefSize(160, 30);
        player4Button.setLayoutX(50);
        player4Button.setLayoutY(190);
        player4Button.setDisable(true);

        diceRollButton.setTextAlignment(TextAlignment.CENTER);
        diceRollButton.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.ITALIC, 25));
        diceRollButton.setStyle("-fx-border-style: solid inside; -fx-border-width: 2; -fx-border-radius: 10; -fx-border-color: darkorange;");
        diceRollButton.setTextFill(Color.DARKORANGE);
        diceRollButton.setPrefSize(160, 30);
        diceRollButton.setLayoutX(50);
        diceRollButton.setLayoutY(350);
        diceRollButton.setDisable(true);

        //this for message level
        message.setText("Player 1: Click your button");
        message.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.ITALIC, 15));
        message.setTextFill(Color.CHOCOLATE);
        message.setPrefSize(200, 100);
        message.setLayoutX(30);
        message.setLayoutY(450);

        //this for diceValueMessage
        diceValueMessage.setText("0");
        diceValueMessage.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.ITALIC, 30));
        diceValueMessage.setTextFill(Color.CHOCOLATE);
        diceValueMessage.setPrefSize(200, 100);
        diceValueMessage.setLayoutX(30);
        diceValueMessage.setLayoutY(600);

        //create controller constructor
        new Controller();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
