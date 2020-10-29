package ludo;

import java.util.ArrayList;
import static ludo.Main.player1;
import static ludo.Main.player2;
import static ludo.Main.player3;
import static ludo.Main.player4;

/**
 * this class for designing the non-removal positions contains 1/2/3/4 type of
 * (belongs player) piece
 *
 * @author jubaer
 */
public class Multiple {

    public static void multiplePieceSetting(Point point) {
        ArrayList<Integer> ids = new ArrayList<>();
        int count = getTypeOfPiece(ids, point);

        if (count > 0) {
            ArrayList<Point> pos = getMultiPos(point, count);
            arrangeMultiPieces(ids, pos, point);
        }

    }

    public static ArrayList<Point> getMultiPos(Point point, int count) {
        ArrayList<Point> result = new ArrayList<>();

        switch (count) {
            case 4:
                result.add(new Point(point.x - 20, point.y - 20));
                result.add(new Point(point.x + 20, point.y - 20));
                result.add(new Point(point.x - 20, point.y + 20));
                result.add(new Point(point.x + 20, point.y + 20));
                break;

            case 3:
                result.add(new Point(point.x - 20, point.y - 20));
                result.add(new Point(point.x + 20, point.y));
                result.add(new Point(point.x - 20, point.y + 20));
                break;
                
            case 2:
                result.add(new Point(point.x, point.y - 20));
                result.add(new Point(point.x, point.y + 20));
                break;
            
            default:
                result.add(point);
        }

        return result;
    }

    private static int getTypeOfPiece(ArrayList<Integer> ids, Point point) {
        int count = 0;

        //positions of first player pieces
        Point pos1 = new Point(player1.firstPiece.getLayoutX(), player1.firstPiece.getLayoutY());
        Point pos2 = new Point(player1.secondPiece.getLayoutX(), player1.secondPiece.getLayoutY());
        Point pos3 = new Point(player1.thirdPiece.getLayoutX(), player1.thirdPiece.getLayoutY());
        Point pos4 = new Point(player1.fourthPiece.getLayoutX(), player1.fourthPiece.getLayoutY());

        //if any of player 1 is placed here then add id 1
        if (pos1.equals(point) || pos2.equals(point) || pos3.equals(point) || pos4.equals(point)) {
            count++;
            ids.add(1);
        }

        //current positions of player2 pieces
        pos1 = new Point(player2.firstPiece.getLayoutX(), player2.firstPiece.getLayoutY());
        pos2 = new Point(player2.secondPiece.getLayoutX(), player2.secondPiece.getLayoutY());
        pos3 = new Point(player2.thirdPiece.getLayoutX(), player2.thirdPiece.getLayoutY());
        pos4 = new Point(player2.fourthPiece.getLayoutX(), player2.fourthPiece.getLayoutY());

        //if any of player 2 is placed here then add id 2
        if (pos1.equals(point) || pos2.equals(point) || pos3.equals(point) || pos4.equals(point)) {
            count++;
            ids.add(2);
        }

        //current positions of player3 pieces
        pos1 = new Point(player3.firstPiece.getLayoutX(), player3.firstPiece.getLayoutY());
        pos2 = new Point(player3.secondPiece.getLayoutX(), player3.secondPiece.getLayoutY());
        pos3 = new Point(player3.thirdPiece.getLayoutX(), player3.thirdPiece.getLayoutY());
        pos4 = new Point(player3.fourthPiece.getLayoutX(), player3.fourthPiece.getLayoutY());

        //if any of player 3 is placed here then add id 3
        if (pos1.equals(point) || pos2.equals(point) || pos3.equals(point) || pos4.equals(point)) {
            count++;
            ids.add(3);
        }

        //current positions of player4 pieces
        pos1 = new Point(player4.firstPiece.getLayoutX(), player4.firstPiece.getLayoutY());
        pos2 = new Point(player4.secondPiece.getLayoutX(), player4.secondPiece.getLayoutY());
        pos3 = new Point(player4.thirdPiece.getLayoutX(), player4.thirdPiece.getLayoutY());
        pos4 = new Point(player4.fourthPiece.getLayoutX(), player4.fourthPiece.getLayoutY());

        //if any of player 4 is placed here then add id 4
        if (pos1.equals(point) || pos2.equals(point) || pos3.equals(point) || pos4.equals(point)) {
            count++;
            ids.add(4);
        }

        return count;
    }

    private static void arrangeMultiPieces(ArrayList<Integer> ids, ArrayList<Point> pos, Point point) {
        Point pos1, pos2, pos3, pos4;

        for (int i = 0; i < ids.size(); i++) {
            Point setPoint = pos.get(i);

            switch (ids.get(i)) {
                case 1:
                    //positions of first player pieces
                    pos1 = new Point(player1.firstPiece.getLayoutX(), player1.firstPiece.getLayoutY());
                    pos2 = new Point(player1.secondPiece.getLayoutX(), player1.secondPiece.getLayoutY());
                    pos3 = new Point(player1.thirdPiece.getLayoutX(), player1.thirdPiece.getLayoutY());
                    pos4 = new Point(player1.fourthPiece.getLayoutX(), player1.fourthPiece.getLayoutY());

                    if (pos1.equals(point)) {
                        player1.firstPiece.setLayoutX(setPoint.x);
                        player1.firstPiece.setLayoutY(setPoint.y);
                    }

                    if (pos2.equals(point)) {
                        player1.secondPiece.setLayoutX(setPoint.x);
                        player1.secondPiece.setLayoutY(setPoint.y);
                    }

                    if (pos3.equals(point)) {
                        player1.thirdPiece.setLayoutX(setPoint.x);
                        player1.thirdPiece.setLayoutY(setPoint.y);
                    }

                    if (pos4.equals(point)) {
                        player1.fourthPiece.setLayoutX(setPoint.x);
                        player1.fourthPiece.setLayoutY(setPoint.y);
                    }

                    break;

                case 2:
                    //current positions of player2 pieces
                    pos1 = new Point(player2.firstPiece.getLayoutX(), player2.firstPiece.getLayoutY());
                    pos2 = new Point(player2.secondPiece.getLayoutX(), player2.secondPiece.getLayoutY());
                    pos3 = new Point(player2.thirdPiece.getLayoutX(), player2.thirdPiece.getLayoutY());
                    pos4 = new Point(player2.fourthPiece.getLayoutX(), player2.fourthPiece.getLayoutY());

                    if (pos1.equals(point)) {
                        player2.firstPiece.setLayoutX(setPoint.x);
                        player2.firstPiece.setLayoutY(setPoint.y);
                    }

                    if (pos2.equals(point)) {
                        player2.secondPiece.setLayoutX(setPoint.x);
                        player2.secondPiece.setLayoutY(setPoint.y);
                    }

                    if (pos3.equals(point)) {
                        player2.thirdPiece.setLayoutX(setPoint.x);
                        player2.thirdPiece.setLayoutY(setPoint.y);
                    }

                    if (pos4.equals(point)) {
                        player2.fourthPiece.setLayoutX(setPoint.x);
                        player2.fourthPiece.setLayoutY(setPoint.y);
                    }

                    break;

                case 3:
                    //current positions of player3 pieces
                    pos1 = new Point(player3.firstPiece.getLayoutX(), player3.firstPiece.getLayoutY());
                    pos2 = new Point(player3.secondPiece.getLayoutX(), player3.secondPiece.getLayoutY());
                    pos3 = new Point(player3.thirdPiece.getLayoutX(), player3.thirdPiece.getLayoutY());
                    pos4 = new Point(player3.fourthPiece.getLayoutX(), player3.fourthPiece.getLayoutY());
                    
                    if (pos1.equals(point)) {
                        player3.firstPiece.setLayoutX(setPoint.x);
                        player3.firstPiece.setLayoutY(setPoint.y);
                    }

                    if (pos2.equals(point)) {
                        player3.secondPiece.setLayoutX(setPoint.x);
                        player3.secondPiece.setLayoutY(setPoint.y);
                    }

                    if (pos3.equals(point)) {
                        player3.thirdPiece.setLayoutX(setPoint.x);
                        player3.thirdPiece.setLayoutY(setPoint.y);
                    }

                    if (pos4.equals(point)) {
                        player3.fourthPiece.setLayoutX(setPoint.x);
                        player3.fourthPiece.setLayoutY(setPoint.y);
                    }
                    
                    break;

                case 4:
                    //current positions of player4 pieces
                    pos1 = new Point(player4.firstPiece.getLayoutX(), player4.firstPiece.getLayoutY());
                    pos2 = new Point(player4.secondPiece.getLayoutX(), player4.secondPiece.getLayoutY());
                    pos3 = new Point(player4.thirdPiece.getLayoutX(), player4.thirdPiece.getLayoutY());
                    pos4 = new Point(player4.fourthPiece.getLayoutX(), player4.fourthPiece.getLayoutY());
                    
                    if (pos1.equals(point)) {
                        player4.firstPiece.setLayoutX(setPoint.x);
                        player4.firstPiece.setLayoutY(setPoint.y);
                    }

                    if (pos2.equals(point)) {
                        player4.secondPiece.setLayoutX(setPoint.x);
                        player4.secondPiece.setLayoutY(setPoint.y);
                    }

                    if (pos3.equals(point)) {
                        player4.thirdPiece.setLayoutX(setPoint.x);
                        player4.thirdPiece.setLayoutY(setPoint.y);
                    }

                    if (pos4.equals(point)) {
                        player4.fourthPiece.setLayoutX(setPoint.x);
                        player4.fourthPiece.setLayoutY(setPoint.y);
                    }
                    break;
            }
        }
    }
}
