/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo;

import javafx.scene.image.Image;

/**
 *
 * @author jubaer
 */
public class Player {

    //Each player contains four pice 
    //Piece class extends ImageView class
    public Piece firstPiece;
    public Piece secondPiece;
    public Piece thirdPiece;
    public Piece fourthPiece;

    //this player is active or not
    private boolean active;

    public Player(Image image1, Image image2, Image image3, Image image4, int id) {
        firstPiece = new Piece(image1, id);
        secondPiece = new Piece(image2, id);
        thirdPiece = new Piece(image3, id);
        fourthPiece = new Piece(image4, id);

        active = false;
    }

    public void setActive(boolean active) {
        firstPiece.active = active;
        secondPiece.active = active;
        thirdPiece.active = active;
        fourthPiece.active = active;

        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

}
