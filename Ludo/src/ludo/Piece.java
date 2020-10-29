/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static ludo.Controller.diceValues;
import static ludo.Controller.getValuesString;
import static ludo.Controller.removePiece;
import static ludo.Controller.switchPlayer;
import static ludo.Controller.isWin;
import static ludo.InitialPos.isNonRemoval;
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
import static ludo.Multiple.multiplePieceSetting;
import static ludo.Path.getPath;

/**
 *
 * @author jubaer
 */
class Piece extends ImageView {

    private final int MAXPOS = 57;

    //This piece belongs to which player
    private int id;

    //current player is active or not
    public boolean active;

    //this piece is runnable or not
    public boolean runnable;

    //if the piece is reached the destination or not
    public boolean end;

    //path for this piece(depends on belongs to which player)
    private HashMap<Integer, Point> path;

    public int currentPosition;

    Piece(Image image, int id) {
        super(image);

        this.id = id;
        this.active = false;
        this.runnable = false;
        this.end = false;
        this.path = getPath(id);
        this.currentPosition = 0;

        //this is for perform action
        setOnMouseClicked((event) -> {
            //it is  the function where action performed
            doClike();
        });
    }

    public void reNew() {
        this.active = false;
        this.runnable = false;
        this.end = false;
        this.currentPosition = 0;
    }

    private void doClike() {
        if (!runnable && active && !diceValues.isEmpty() && diceValues.get(0) == 6) {
            //if this piece is not runnable but it is active and diceValues has 6 
            //make it runnable
            //set currrentPosition at 1
            //remove 6 from diceValues
            //set current messeges

            runnable = true;
            currentPosition = 1;
            setLayoutX(path.get(1).x);
            setLayoutY(path.get(1).y);
            diceValues.remove(0);
            diceValueMessage.setText(getValuesString());

            //if this piece intersects any ther piece then remove it  //draft here
            Point currPos = path.get(1);
            //removePiece(id, currPos);

            //if there have another types of piece
            multiplePieceSetting(currPos);

            if (diceValues.isEmpty()) {
                //diceValue empty means there has no move for current player
                //so switch the player

                switchCurrentPlayer(id);
            }
        } else if (runnable && active && !end && !diceValues.isEmpty()) {
            //if piece is movable, active
            //not out of boundary

            if (currentPosition + diceValues.get(0) > MAXPOS) {
                return;
            }

            int startPos = currentPosition + 1;
            int endPos = currentPosition + diceValues.get(0);
            diceValues.remove(0);
            diceValueMessage.setText(getValuesString());

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
                int pos = startPos;

                @Override
                public void handle(ActionEvent event) {
                    if (pos <= endPos) {
                        setLayoutX(path.get(pos).x);
                        setLayoutY(path.get(pos).y);

                        pos++;
                    } else {
                        currentPosition = endPos;
                        
                        //if start of this piece is nonremoval, then setiing startPos
                        Point start = path.get(startPos-1);
                        if (isNonRemoval(start)) {
                            //if there have another types of piece
                            multiplePieceSetting(start);
                        }

                        //if curr pos is in nonremovalPos
                        Point currPos = path.get(endPos);
                        if (isNonRemoval(currPos)) {
                            //if there have another types of piece
                            multiplePieceSetting(currPos);
                        } else {
                            //if this piece intersects any ther piece then remove it
                            removePiece(id, currPos);
                        }

                        //when this piece reaches the destination
                        if (currentPosition == MAXPOS) {
                            runnable = false;
                            end = true;
                            setDisable(true);
                            isWin(id);
                        }

                        //if ends move for currentPlayer
                        if (diceValues.isEmpty()) {
                            switchCurrentPlayer(id);
                        }
                    }
                }
            }));
            timeline.setCycleCount(endPos - startPos + 1 + 1);
            timeline.play();

        }

    }

    private void switchCurrentPlayer(int id) {
        switch (id) {
            case 1:
                switchPlayer(player1Button, player2Button, player1, id);
                message.setText("Player 1: Your move is ended!\nPlayer 2: Click your button");
                break;

            case 2:
                switchPlayer(player2Button, player3Button, player2, id);
                message.setText("Player 2: Your move is ended!\nPlayer 3: Click your button");
                break;

            case 3:
                switchPlayer(player3Button, player4Button, player3, id);
                message.setText("Player 3: Your move is ended!\nPlayer 4: Click your button");
                break;

            case 4:
                switchPlayer(player4Button, player1Button, player4, id);
                message.setText("Player 4: Your move is ended!\nPlayer 1: Click your button");
                break;
        }
    }
}
