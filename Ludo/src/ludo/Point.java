package ludo;

/**
 *
 * @author jubaer
 */
public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        }

        //this logics for multiposition
        //for 4 type of piece
        if ((this.x == point.x - 20 && this.y == point.y - 20) || (this.x == point.x + 20 && this.y == point.y - 20)
                || (this.x == point.x - 20 && this.y == point.y + 20) || (this.x == point.x + 20 && this.y == point.y + 20)) {
            return true;
        }

        //for 3 type of piece
        if ((this.x == point.x - 20 && this.y == point.y - 20) || (this.x == point.x - 20 && this.y == point.y + 20)
                || (this.x == point.x + 20 && this.y == point.y)) {
            return true;
        }

        //for 2 type of piece
        if ((this.x == point.x && this.y == point.y - 20) || (this.x == point.x && this.y == point.y + 20)) {
            return true;
        }

        return false;
    }
}
