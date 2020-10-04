package tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tetromino {

    //The variables
    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;
    public int form = 1;
    public String formName;

    private Color color;

    public Tetromino(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String formName) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.formName = formName;

        switch (formName) {
            case "S":
                color = Color.FUCHSIA;
                break;
            case "O":
                color = Color.DARKGREEN;
                break;
            case "L":
                color = Color.DARKVIOLET;
                break;
            case "Z":
                color = Color.YELLOWGREEN;
                break;
            case "I":
                color = Color.CRIMSON;
                break;
            case "J":
                color = Color.ORANGERED;
                break;
            case "T":
                color = Color.AQUA;
                break;
        }

        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);

    }

    public void changeForm() {
        if (form < 4) {
            form++;
        } else {
            form = 1;
        }
    }
}
