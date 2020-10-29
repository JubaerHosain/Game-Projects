/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.util.Duration;
import static ludo.InitialPos.player1InitialPos;
import static ludo.InitialPos.player2InitialPos;
import static ludo.InitialPos.player3InitialPos;
import static ludo.InitialPos.player4InitialPos;
import static ludo.Main.dice;
import static ludo.Main.diceRollButton;
import static ludo.Main.diceValueMessage;
import static ludo.Main.message;
import static ludo.Main.player1;
import static ludo.Main.player1Button;
import static ludo.Main.player2;
import static ludo.Main.player2Button;
import static ludo.Main.player3;
import static ludo.Main.player3Button;
import static ludo.Main.player4;
import static ludo.Main.player4Button;

/**
 * this class for making controls on players
 *
 * @author jubaer
 */
public class Controller {

    //keep track for current player
    private static int currentPlayer;

    private static int win = 0;

    //list of dice values(as one player can have maximum 3 dice value)
    public static ArrayList<Integer> diceValues = new ArrayList<>();

    //images for dice roll section
    private Image gif;
    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;
    private Image image5;
    private Image image6;

    public Controller() {

        //player 1 is default current player
        this.currentPlayer = 1;

        //initializs images
        gif = createImage("dice.gif");
        image1 = createImage("dice1.jpg");
        image2 = createImage("dice2.jpg");
        image3 = createImage("dice3.jpg");
        image4 = createImage("dice4.jpg");
        image5 = createImage("dice5.jpg");
        image6 = createImage("dice6.jpg");

        player1Control();
        player2Control();
        player3Control();
        player4Control();
        diceRollControl();
    }

    private void player1Control() {
        //if clicked this button then
        //make active false of all players pieces
        //make disable all buttons except it
        //set message for it

        player1Button.setOnAction((event) -> {
            player1.setActive(false);
            player2.setActive(false);
            player3.setActive(false);
            player4.setActive(false);

            player1Button.setDisable(true);
            player2Button.setDisable(true);
            player3Button.setDisable(true);
            player4Button.setDisable(true);

            diceRollButton.setDisable(false);

            message.setText("Player 1: Roll your dice");
            diceValueMessage.setText("0");
            diceValues.clear();
        });
    }

    private void player2Control() {
        //if clicked this button then
        //make active false of all players pieces
        //make disable all buttons except it
        //set message for it

        player2Button.setOnAction((event) -> {
            player1.setActive(false);
            player2.setActive(false);
            player3.setActive(false);
            player4.setActive(false);

            player1Button.setDisable(true);
            player2Button.setDisable(true);
            player3Button.setDisable(true);
            player4Button.setDisable(true);

            diceRollButton.setDisable(false);

            message.setText("Player 2: Roll your dice");
            diceValueMessage.setText("0");
            diceValues.clear();
        });
    }

    private void player3Control() {
        //if clicked this button then
        //make active false of all players pieces
        //make disable all buttons except it
        //set message for it

        player3Button.setOnAction((event) -> {
            player1.setActive(false);
            player2.setActive(false);
            player3.setActive(false);
            player4.setActive(false);

            player1Button.setDisable(true);
            player2Button.setDisable(true);
            player3Button.setDisable(true);
            player4Button.setDisable(true);

            diceRollButton.setDisable(false);

            message.setText("Player 3: Roll your dice");
            diceValueMessage.setText("0");
            diceValues.clear();
        });
    }

    private void player4Control() {
        //if clicked this button then
        //make active false of all players pieces
        //make disable all buttons except it
        //set message for it

        player4Button.setOnAction((event) -> {
            player1.setActive(false);
            player2.setActive(false);
            player3.setActive(false);
            player4.setActive(false);

            player1Button.setDisable(true);
            player2Button.setDisable(true);
            player3Button.setDisable(true);
            player4Button.setDisable(true);

            diceRollButton.setDisable(false);

            message.setText("Player 4: Roll your dice");
            diceValueMessage.setText("0");
            diceValues.clear();
        });
    }

    private void diceRollControl() {
        //if clicked this button then
        //roolldice to find diceValue
        //initialize dice with gif 
        //set image according to diceValue

        diceRollButton.setOnAction((event) -> {
            int diceValue = rollDice();
            diceValues.add(diceValue);
            diceValueMessage.setText(getValuesString());

            //this timeline for animating dice
            dice.setImage(gif);
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), (event1) -> {
                switch (diceValue) {
                    case 1:
                        dice.setImage(image1);
                        break;

                    case 2:
                        dice.setImage(image2);
                        break;

                    case 3:
                        dice.setImage(image3);
                        break;

                    case 4:
                        dice.setImage(image4);
                        break;

                    case 5:
                        dice.setImage(image5);
                        break;

                    case 6:
                        dice.setImage(image6);
                        break;
                }
            }));
            timeline.play();

            //this timeline for the logic, timeline used for perform operation after first timeline
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(520), (event1) -> {
                switch (currentPlayer) {
                    case 1: {
                        if (diceValue == 6) {
                            //if current player find dice value 6 then he shuld roll dice again
                            message.setText("Player 1: Roll your dice again!");
                            diceValueMessage.setText(getValuesString());

                            //if current player find three 6 then destroy all values
                            if (diceValues.size() == 3) {
                                diceValues.clear();
                                message.setText("Player 1: Your 6's are distroyed!\nPlayer 1: Roll your dice again!");
                                diceValueMessage.setText("0");
                            }
                        } else if (hasRunnablePiece(player1)) {
                            //if current player has any runnable piece according to diceValues
                            //active currentPlayer
                            //move the piece/pieces

                            player1.setActive(true);
                            message.setText("Player 1: Move your piece/ \npieces!");
                            diceValueMessage.setText(getValuesString());
                            diceRollButton.setDisable(true);

                        } else {
                            //if current player has no runnable piece 
                            //automitacally switch player
                            //update message

                            switchPlayer(player1Button, player2Button, player1, currentPlayer);

                            message.setText("Player 1: Your have no \nrunnable piece!\nPlayer 2: Click your button!");
                        }

                    }
                    break;

                    case 2: {
                        if (diceValue == 6) {
                            //if current player find dice value 6 then he shuld roll dice again
                            message.setText("Player 2: Roll your dice again!");
                            diceValueMessage.setText(getValuesString());

                            //if current player find three 6 then destroy all values
                            if (diceValues.size() == 3) {
                                diceValues.clear();
                                message.setText("Player 2: Your 6's are distroyed!\nPlayer 2: Roll your dice again!");
                                diceValueMessage.setText("0");
                            }
                        } else if (hasRunnablePiece(player2)) {
                            //if current player has any runnable piece according to diceValues
                            //active currentPlayer
                            //move the piece/pieces

                            player2.setActive(true);
                            message.setText("Player 2: Move your piece/ \npieces!");
                            diceValueMessage.setText(getValuesString());
                            diceRollButton.setDisable(true);

                        } else {
                            //if current player has no runnable piece 
                            //automitacally switch player
                            //update message

                            switchPlayer(player2Button, player3Button, player2, currentPlayer);

                            message.setText("Player 2: Your have no \nrunnable piece!\nPlayer 3: Click your button!");
                        }

                    }
                    break;

                    case 3: {
                        if (diceValue == 6) {
                            //if current player find dice value 6 then he shuld roll dice again
                            message.setText("Player 3: Roll your dice again!");
                            diceValueMessage.setText(getValuesString());

                            //if current player find three 6 then destroy all values
                            if (diceValues.size() == 3) {
                                diceValues.clear();
                                message.setText("Player 3: Your 6's are distroyed!\nPlayer 3: Roll your dice again!");
                                diceValueMessage.setText("0");
                            }
                        } else if (hasRunnablePiece(player3)) {
                            //if current player has any runnable piece according to diceValues
                            //active currentPlayer
                            //move the piece/pieces

                            player3.setActive(true);
                            message.setText("Player 3: Move your piece/ \npieces!");
                            diceValueMessage.setText(getValuesString());
                            diceRollButton.setDisable(true);

                        } else {
                            //if current player has no runnable piece 
                            //automitacally switch player
                            //update message

                            switchPlayer(player3Button, player4Button, player3, currentPlayer);

                            message.setText("Player 3: Your have no \nrunnable piece!\nPlayer 4: Click your button!");
                        }

                    }
                    break;

                    case 4: {
                        if (diceValue == 6) {
                            //if current player find dice value 6 then he shuld roll dice again
                            message.setText("Player 4: Roll your dice again!");
                            diceValueMessage.setText(getValuesString());

                            //if current player find three 6 then destroy all values
                            if (diceValues.size() == 3) {
                                diceValues.clear();
                                message.setText("Player 4: Your 6's are distroyed!\nPlayer 4: Roll your dice again!");
                                diceValueMessage.setText("0");
                            }
                        } else if (hasRunnablePiece(player4)) {
                            //if current player has any runnable piece according to diceValues
                            //active currentPlayer
                            //move the piece/pieces

                            player4.setActive(true);
                            message.setText("Player 4: Move your piece/ \npieces!");
                            diceValueMessage.setText(getValuesString());
                            diceRollButton.setDisable(true);

                        } else {
                            //if current player has no runnable piece 
                            //automitacally switch player
                            //update message

                            switchPlayer(player4Button, player1Button, player4, currentPlayer);

                            message.setText("Player 4: Your have no \nrunnable piece!\nPlayer 1: Click your button!");
                        }

                    }
                    break;
                }
            }));
            timeline1.play();

        });
    }

    public static void switchPlayer(Button currentPlayerButton, Button nextPlayerButton, Player currentPlayerObject, int currentPlayer) {
        //disable currentPlayerButton
        //enable nextPlayerButton
        //disabel rolldicebutton(will activate when next player clicked his button)
        //deactivate currentPlayerObj(may have activated previously)
        //clear diceValues
        //update diceValueMessage
        //update currentPlayer to next

        currentPlayerButton.setDisable(true);
        nextPlayerButton.setDisable(false);
        diceRollButton.setDisable(true);

        currentPlayerObject.setActive(false);
        diceValueMessage.setText("0");
        diceValues.clear();

        currentPlayer = (currentPlayer + 1) % 5;
        Controller.currentPlayer = (currentPlayer == 0) ? 1 : currentPlayer;
    }

    //this method creates an instance of image by url
    private Image createImage(String url) {
        return new Image(this.getClass().getResource(url).toExternalForm());
    }

    //this method 
    private int rollDice() {
        Random rand = new Random();
        int diceValue = rand.nextInt(7);

        return diceValue == 0 ? 1 : diceValue;
    }

    public static String getValuesString() {
        String string = "";

        for (Integer val : diceValues) {
            string += (val + ">");
        }

        return string.isEmpty() ? "0" : string;
    }

    private boolean hasRunnablePiece(Player player) {
        //if player has more than one nonRunnable piece (if dice value is 6 then it is possible to make runnable)
        //initial case

        if (getNonRunnablePiece(player) >= 1 && diceValues.get(0) == 6) {
            return true;
        }

        //total sum of diceValues for current player
        int sum = 0;
        for (Integer val : diceValues) {
            sum += val;
        }

        //distance from end for all runnable piece
        //if reached to the end its already nonRunnable
        ArrayList<Integer> dists = new ArrayList<>();
        int dist = 0;
        if (player.firstPiece.runnable) {
            dist += (57 - player.firstPiece.currentPosition);
            dists.add(57 - player.firstPiece.currentPosition);
        }
        if (player.secondPiece.runnable) {
            dist += (57 - player.secondPiece.currentPosition);
            dists.add(57 - player.secondPiece.currentPosition);
        }
        if (player.thirdPiece.runnable) {
            dist += (57 - player.thirdPiece.currentPosition);
            dists.add(57 - player.thirdPiece.currentPosition);
        }
        if (player.fourthPiece.runnable) {
            dist += (57 - player.fourthPiece.currentPosition);
            dists.add(57 - player.fourthPiece.currentPosition);
        }

        //all diceValues can cover total distance(trying out all runnable pieces)
        if (sum <= dist) {
            //for some special case (6,5)->(5,5)
            //(6,6,5)->(5,5,7)
            //use of priority queue is better, second sort is not needed
            Collections.sort(dists, Collections.reverseOrder());
            for (Integer val : diceValues) {
                if (dists.isEmpty()) {
                    return false;
                }
                if (val <= dists.get(0)) {
                    dists.add(0, dists.get(0) - val);
                    Collections.sort(dists, Collections.reverseOrder());
                } else {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    //return number of nonRunnable piece
    private int getNonRunnablePiece(Player player) {
        int count = 0;

        if (!player.firstPiece.end && !player.firstPiece.runnable) {
            count++;
        }
        if (!player.secondPiece.end && !player.secondPiece.runnable) {
            count++;
        }
        if (!player.thirdPiece.end && !player.thirdPiece.runnable) {
            count++;
        }
        if (!player.fourthPiece.end && !player.fourthPiece.runnable) {
            count++;
        }

        return count;
    }

    public static void removePiece(int id, Point currPos) {
        switch (id) {
            case 1:
                //if any pieces belong to player 2/3/4 is same as current pos then make initialize it in initialType
                removePlayer2Piece(currPos);
                removePlayer3Piece(currPos);
                removePlayer4Piece(currPos);
                break;

            case 2:
                removePlayer1Piece(currPos);
                removePlayer3Piece(currPos);
                removePlayer4Piece(currPos);
                break;

            case 3:
                removePlayer1Piece(currPos);
                removePlayer2Piece(currPos);
                removePlayer4Piece(currPos);
                break;

            case 4:
                removePlayer1Piece(currPos);
                removePlayer2Piece(currPos);
                removePlayer3Piece(currPos);
                break;
        }
    }

    private static void removePlayer1Piece(Point currPos) {
        //current positions of player1 pieces
        Point pos1 = new Point(player1.firstPiece.getLayoutX(), player1.firstPiece.getLayoutY());
        Point pos2 = new Point(player1.secondPiece.getLayoutX(), player1.secondPiece.getLayoutY());
        Point pos3 = new Point(player1.thirdPiece.getLayoutX(), player1.thirdPiece.getLayoutY());
        Point pos4 = new Point(player1.fourthPiece.getLayoutX(), player1.fourthPiece.getLayoutY());

        //if any one intersects currentPlayer piece
        //remove this piece from current position and make initial
        if (currPos.equals(pos1)) {
            player1.firstPiece.reNew();
            player1.firstPiece.setLayoutX(player1InitialPos.get(0).x);
            player1.firstPiece.setLayoutY(player1InitialPos.get(0).y);
        }

        if (currPos.equals(pos2)) {
            player1.secondPiece.reNew();
            player1.secondPiece.setLayoutX(player1InitialPos.get(1).x);
            player1.secondPiece.setLayoutY(player1InitialPos.get(1).y);
        }

        if (currPos.equals(pos3)) {
            player1.thirdPiece.reNew();
            player1.thirdPiece.setLayoutX(player1InitialPos.get(2).x);
            player1.thirdPiece.setLayoutY(player1InitialPos.get(2).y);
        }

        if (currPos.equals(pos4)) {
            player1.fourthPiece.reNew();
            player1.fourthPiece.setLayoutX(player1InitialPos.get(3).x);
            player1.fourthPiece.setLayoutY(player1InitialPos.get(3).y);
        }
    }

    private static void removePlayer2Piece(Point currPos) {
        //current positions of player2 pieces
        Point pos1 = new Point(player2.firstPiece.getLayoutX(), player2.firstPiece.getLayoutY());
        Point pos2 = new Point(player2.secondPiece.getLayoutX(), player2.secondPiece.getLayoutY());
        Point pos3 = new Point(player2.thirdPiece.getLayoutX(), player2.thirdPiece.getLayoutY());
        Point pos4 = new Point(player2.fourthPiece.getLayoutX(), player2.fourthPiece.getLayoutY());

        //if any one intersects currentPlayer piece
        //remove this piece from current position and make initial
        if (currPos.equals(pos1)) {
            player2.firstPiece.reNew();
            player2.firstPiece.setLayoutX(player2InitialPos.get(0).x);
            player2.firstPiece.setLayoutY(player2InitialPos.get(0).y);
        }

        if (currPos.equals(pos2)) {
            player2.secondPiece.reNew();
            player2.secondPiece.setLayoutX(player2InitialPos.get(1).x);
            player2.secondPiece.setLayoutY(player2InitialPos.get(1).y);
        }

        if (currPos.equals(pos3)) {
            player2.thirdPiece.reNew();
            player2.thirdPiece.setLayoutX(player2InitialPos.get(2).x);
            player2.thirdPiece.setLayoutY(player2InitialPos.get(2).y);
        }

        if (currPos.equals(pos4)) {
            player2.fourthPiece.reNew();
            player2.fourthPiece.setLayoutX(player2InitialPos.get(3).x);
            player2.fourthPiece.setLayoutY(player2InitialPos.get(3).y);
        }
    }

    private static void removePlayer3Piece(Point currPos) {
        //current positions of player3 pieces
        Point pos1 = new Point(player3.firstPiece.getLayoutX(), player3.firstPiece.getLayoutY());
        Point pos2 = new Point(player3.secondPiece.getLayoutX(), player3.secondPiece.getLayoutY());
        Point pos3 = new Point(player3.thirdPiece.getLayoutX(), player3.thirdPiece.getLayoutY());
        Point pos4 = new Point(player3.fourthPiece.getLayoutX(), player3.fourthPiece.getLayoutY());

        //if any one intersects currentPlayer piece
        //remove this piece from current position and make initial
        if (currPos.equals(pos1)) {
            player3.firstPiece.reNew();
            player3.firstPiece.setLayoutX(player3InitialPos.get(0).x);
            player3.firstPiece.setLayoutY(player3InitialPos.get(0).y);
        }

        if (currPos.equals(pos2)) {
            player3.secondPiece.reNew();
            player3.secondPiece.setLayoutX(player3InitialPos.get(1).x);
            player3.secondPiece.setLayoutY(player3InitialPos.get(1).y);
        }

        if (currPos.equals(pos3)) {
            player3.thirdPiece.reNew();
            player3.thirdPiece.setLayoutX(player3InitialPos.get(2).x);
            player3.thirdPiece.setLayoutY(player3InitialPos.get(2).y);
        }

        if (currPos.equals(pos4)) {
            player3.fourthPiece.reNew();
            player3.fourthPiece.setLayoutX(player3InitialPos.get(3).x);
            player3.fourthPiece.setLayoutY(player3InitialPos.get(3).y);
        }
    }

    private static void removePlayer4Piece(Point currPos) {
        //current positions of player4 pieces
        Point pos1 = new Point(player4.firstPiece.getLayoutX(), player4.firstPiece.getLayoutY());
        Point pos2 = new Point(player4.secondPiece.getLayoutX(), player4.secondPiece.getLayoutY());
        Point pos3 = new Point(player4.thirdPiece.getLayoutX(), player4.thirdPiece.getLayoutY());
        Point pos4 = new Point(player4.fourthPiece.getLayoutX(), player4.fourthPiece.getLayoutY());

        //if any one intersects currentPlayer piece
        //remove this piece from current position and make initial
        if (currPos.equals(pos1)) {
            player4.firstPiece.reNew();
            player4.firstPiece.setLayoutX(player4InitialPos.get(0).x);
            player4.firstPiece.setLayoutY(player4InitialPos.get(0).y);
        }

        if (currPos.equals(pos2)) {
            player4.secondPiece.reNew();
            player4.secondPiece.setLayoutX(player4InitialPos.get(1).x);
            player4.secondPiece.setLayoutY(player4InitialPos.get(1).y);
        }

        if (currPos.equals(pos3)) {
            player4.thirdPiece.reNew();
            player4.thirdPiece.setLayoutX(player4InitialPos.get(2).x);
            player4.thirdPiece.setLayoutY(player4InitialPos.get(2).y);
        }

        if (currPos.equals(pos4)) {
            player4.fourthPiece.reNew();
            player4.fourthPiece.setLayoutX(player4InitialPos.get(3).x);
            player4.fourthPiece.setLayoutY(player4InitialPos.get(3).y);
        }
    }

    public static void isWin(int id) {
        switch (id) {
            case 1:
                if (isWin(player1)) {
                    System.out.println((++win) + ": Player1");
                }
                break;
            case 2:
                if (isWin(player2)) {
                    System.out.println((++win) + ": Player2");
                }
                break;
            case 3:
                if (isWin(player3)) {
                    System.out.println((++win) + ": Player3");
                }
                break;
            case 4:
                if (isWin(player4)) {
                    System.out.println((++win) + ": Player4");
                }
                break;
        }
    }

    private static boolean isWin(Player player) {
        int count = 0;

        if (player.firstPiece.end) {
            count++;
        }

        if (player.secondPiece.end) {
            count++;
        }

        if (player.thirdPiece.end) {
            count++;
        }

        if (player.fourthPiece.end) {
            count++;
        }

        return count == 4;
    }

}
