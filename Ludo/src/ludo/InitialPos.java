/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludo;

import java.util.ArrayList;

/**
 *
 * @author jubaer
 */
public class InitialPos {

    public static ArrayList<Point> player1InitialPos = new ArrayList<Point>();
    public static ArrayList<Point> player2InitialPos = new ArrayList<Point>();
    public static ArrayList<Point> player3InitialPos = new ArrayList<Point>();
    public static ArrayList<Point> player4InitialPos = new ArrayList<Point>();
    public static ArrayList<Point> nonRemovalPos = new ArrayList<>();

    public InitialPos() {
        //for player 1 add four pice position
        player1InitialPos.add(new Point(73, 119));
        player1InitialPos.add(new Point(119, 73));
        player1InitialPos.add(new Point(165, 119));
        player1InitialPos.add(new Point(119, 165));

        //for player 2 add four pice position
        player2InitialPos.add(new Point(489, 119));
        player2InitialPos.add(new Point(535, 73));
        player2InitialPos.add(new Point(581, 119));
        player2InitialPos.add(new Point(535, 165));

        //for player 3 add four pice position
        player3InitialPos.add(new Point(489, 535));
        player3InitialPos.add(new Point(535, 489));
        player3InitialPos.add(new Point(581, 535));
        player3InitialPos.add(new Point(535, 581));

        //for player 4 add four pice position
        player4InitialPos.add(new Point(73, 535));
        player4InitialPos.add(new Point(119, 489));
        player4InitialPos.add(new Point(165, 535));
        player4InitialPos.add(new Point(119, 581));

        //positions where no piece will cut
        nonRemovalPos.add(new Point(51, 281));
        nonRemovalPos.add(new Point(281, 97));
        nonRemovalPos.add(new Point(373, 51));
        nonRemovalPos.add(new Point(557, 281));
        nonRemovalPos.add(new Point(603, 373));
        nonRemovalPos.add(new Point(373, 557));
        nonRemovalPos.add(new Point(281, 603));
        nonRemovalPos.add(new Point(97, 373));

    }
    
    
    public static boolean isNonRemoval(Point point){
        for(int i = 0; i < nonRemovalPos.size(); i++){
            if(nonRemovalPos.get(i).equals(point)){
                return true;
            }
        }
        
        return false;
    }

}
