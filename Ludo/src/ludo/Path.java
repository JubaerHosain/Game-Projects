package ludo;

import java.util.HashMap;

/**
 * This class contains path for the player pieces
 *
 * @author jubaer
 */
public class Path {

    public static HashMap<Integer, Point> player1Path = new HashMap<>();
    public static HashMap<Integer, Point> player2Path = new HashMap<>();
    public static HashMap<Integer, Point> player3Path = new HashMap<>();
    public static HashMap<Integer, Point> player4Path = new HashMap<>();

    public Path() {
        //======================================================================
        //This is for player 1
        //x is difference by 46 (move right) Start from here
        player1Path.put(1, new Point(51, 281));
        player1Path.put(2, new Point(97, 281));
        player1Path.put(3, new Point(143, 281));
        player1Path.put(4, new Point(189, 281));
        player1Path.put(5, new Point(235, 281));

        //y is difference by 46 (move up)
        player1Path.put(6, new Point(281, 235));
        player1Path.put(7, new Point(281, 189));
        player1Path.put(8, new Point(281, 143));
        player1Path.put(9, new Point(281, 97));
        player1Path.put(10, new Point(281, 51));
        player1Path.put(11, new Point(281, 5));

        //x is difference by 46 (move right)
        player1Path.put(12, new Point(327, 5));

        //y is difference by 46 (move down)
        player1Path.put(13, new Point(373, 5));
        player1Path.put(14, new Point(373, 51));
        player1Path.put(15, new Point(373, 97));
        player1Path.put(16, new Point(373, 143));
        player1Path.put(17, new Point(373, 189));
        player1Path.put(18, new Point(373, 235));

        //x is difference by 46 (move right)
        player1Path.put(19, new Point(419, 281));
        player1Path.put(20, new Point(465, 281));
        player1Path.put(21, new Point(511, 281));
        player1Path.put(22, new Point(557, 281));
        player1Path.put(23, new Point(603, 281));
        player1Path.put(24, new Point(649, 281));

        //y is difference by 46 (move down)
        player1Path.put(25, new Point(649, 327));
        player1Path.put(26, new Point(649, 373));

        //x is difference by 46 (move left)
        player1Path.put(27, new Point(603, 373));
        player1Path.put(28, new Point(557, 373));
        player1Path.put(29, new Point(511, 373));
        player1Path.put(30, new Point(465, 373));
        player1Path.put(31, new Point(419, 373));

        //y is difference by 46 (move down)
        player1Path.put(32, new Point(373, 419));
        player1Path.put(33, new Point(373, 465));
        player1Path.put(34, new Point(373, 511));
        player1Path.put(35, new Point(373, 557));
        player1Path.put(36, new Point(373, 603));
        player1Path.put(37, new Point(373, 649));

        //x is difference by 46 (move left)
        player1Path.put(38, new Point(327, 649));
        player1Path.put(39, new Point(281, 649));

        //y is difference by 46 (move up)
        player1Path.put(40, new Point(281, 603));
        player1Path.put(41, new Point(281, 557));
        player1Path.put(42, new Point(281, 511));
        player1Path.put(43, new Point(281, 465));
        player1Path.put(44, new Point(281, 419));

        //x is difference by 46 (move left)
        player1Path.put(45, new Point(235, 373));
        player1Path.put(46, new Point(189, 373));
        player1Path.put(47, new Point(143, 373));
        player1Path.put(48, new Point(97, 373));
        player1Path.put(49, new Point(51, 373));
        player1Path.put(50, new Point(5, 373));

        //x is difference by 46 (move up)
        player1Path.put(51, new Point(5, 327));

        //x is difference by 46 (move inside)
        player1Path.put(52, new Point(51, 327));
        player1Path.put(53, new Point(97, 327));
        player1Path.put(54, new Point(143, 327));
        player1Path.put(55, new Point(189, 327));
        player1Path.put(56, new Point(235, 327));
        player1Path.put(57, new Point(281, 327));

        //======================================================================
        //This is for player 2
        //y is difference by 46 (move down) Start from  here
        player2Path.put(1, new Point(373, 51));
        player2Path.put(2, new Point(373, 97));
        player2Path.put(3, new Point(373, 143));
        player2Path.put(4, new Point(373, 189));
        player2Path.put(5, new Point(373, 235));

        //x is difference by 46 (move right)
        player2Path.put(6, new Point(419, 281));
        player2Path.put(7, new Point(465, 281));
        player2Path.put(8, new Point(511, 281));
        player2Path.put(9, new Point(557, 281));
        player2Path.put(10, new Point(603, 281));
        player2Path.put(11, new Point(649, 281));

        //y is difference by 46 (move down)
        player2Path.put(12, new Point(649, 327));
        player2Path.put(13, new Point(649, 373));

        //x is difference by 46 (move left)
        player2Path.put(14, new Point(603, 373));
        player2Path.put(15, new Point(557, 373));
        player2Path.put(16, new Point(511, 373));
        player2Path.put(17, new Point(465, 373));
        player2Path.put(18, new Point(419, 373));

        //y is difference by 46 (move down)
        player2Path.put(19, new Point(373, 419));
        player2Path.put(20, new Point(373, 465));
        player2Path.put(21, new Point(373, 511));
        player2Path.put(22, new Point(373, 557));
        player2Path.put(23, new Point(373, 603));
        player2Path.put(24, new Point(373, 649));

        //x is difference by 46 (move left)
        player2Path.put(25, new Point(327, 649));
        player2Path.put(26, new Point(281, 649));

        //y is difference by 46 (move up)
        player2Path.put(27, new Point(281, 603));
        player2Path.put(28, new Point(281, 557));
        player2Path.put(29, new Point(281, 511));
        player2Path.put(30, new Point(281, 465));
        player2Path.put(31, new Point(281, 419));

        //x is difference by 46 (move left)
        player2Path.put(32, new Point(235, 373));
        player2Path.put(33, new Point(189, 373));
        player2Path.put(34, new Point(143, 373));
        player2Path.put(35, new Point(97, 373));
        player2Path.put(36, new Point(51, 373));
        player2Path.put(37, new Point(5, 373));

        //y is difference by 46 (move up)
        player2Path.put(38, new Point(5, 327));
        player2Path.put(39, new Point(5, 281));

        //x is difference by 46 (move right) 
        player2Path.put(40, new Point(51, 281));
        player2Path.put(41, new Point(97, 281));
        player2Path.put(42, new Point(143, 281));
        player2Path.put(43, new Point(189, 281));
        player2Path.put(44, new Point(235, 281));

        //y is difference by 46 (move up)
        player2Path.put(45, new Point(281, 235));
        player2Path.put(46, new Point(281, 189));
        player2Path.put(47, new Point(281, 143));
        player2Path.put(48, new Point(281, 97));
        player2Path.put(49, new Point(281, 51));
        player2Path.put(50, new Point(281, 5));

        //x is difference by 46 (move right)
        player2Path.put(51, new Point(327, 5));

        //y is difference by 46 (move inside)
        player2Path.put(52, new Point(327, 51));
        player2Path.put(53, new Point(327, 97));
        player2Path.put(54, new Point(327, 143));
        player2Path.put(55, new Point(327, 189));
        player2Path.put(56, new Point(327, 235));
        player2Path.put(57, new Point(327, 281));

        //======================================================================
        //This is for player 3
        //x is difference by 46 (move left) Start from here
        player3Path.put(1, new Point(603, 373));
        player3Path.put(2, new Point(557, 373));
        player3Path.put(3, new Point(511, 373));
        player3Path.put(4, new Point(465, 373));
        player3Path.put(5, new Point(419, 373));

        //y is difference by 46 (move down)
        player3Path.put(6, new Point(373, 419));
        player3Path.put(7, new Point(373, 465));
        player3Path.put(8, new Point(373, 511));
        player3Path.put(9, new Point(373, 557));
        player3Path.put(10, new Point(373, 603));
        player3Path.put(11, new Point(373, 649));

        //x is difference by 46 (move left)
        player3Path.put(12, new Point(327, 649));
        player3Path.put(13, new Point(281, 649));

        //y is difference by 46 (move up)
        player3Path.put(14, new Point(281, 603));
        player3Path.put(15, new Point(281, 557));
        player3Path.put(16, new Point(281, 511));
        player3Path.put(17, new Point(281, 465));
        player3Path.put(18, new Point(281, 419));

        //x is difference by 46 (move left)
        player3Path.put(19, new Point(235, 373));
        player3Path.put(20, new Point(189, 373));
        player3Path.put(21, new Point(143, 373));
        player3Path.put(22, new Point(97, 373));
        player3Path.put(23, new Point(51, 373));
        player3Path.put(24, new Point(5, 373));

        //y is difference by 46 (move up)
        player3Path.put(25, new Point(5, 327));
        player3Path.put(26, new Point(5, 281));

        //x is difference by 46 (move right) 
        player3Path.put(27, new Point(51, 281));
        player3Path.put(28, new Point(97, 281));
        player3Path.put(29, new Point(143, 281));
        player3Path.put(30, new Point(189, 281));
        player3Path.put(31, new Point(235, 281));

        //y is difference by 46 (move up)
        player3Path.put(32, new Point(281, 235));
        player3Path.put(33, new Point(281, 189));
        player3Path.put(34, new Point(281, 143));
        player3Path.put(35, new Point(281, 97));
        player3Path.put(36, new Point(281, 51));
        player3Path.put(37, new Point(281, 5));

        //x is difference by 46 (move right)
        player3Path.put(38, new Point(327, 5));
        player3Path.put(39, new Point(373, 5));

        //y is difference by 46 (move down) 
        player3Path.put(40, new Point(373, 51));
        player3Path.put(41, new Point(373, 97));
        player3Path.put(42, new Point(373, 143));
        player3Path.put(43, new Point(373, 189));
        player3Path.put(44, new Point(373, 235));

        //x is difference by 46 (move right)
        player3Path.put(45, new Point(419, 281));
        player3Path.put(46, new Point(465, 281));
        player3Path.put(47, new Point(511, 281));
        player3Path.put(48, new Point(557, 281));
        player3Path.put(49, new Point(603, 281));
        player3Path.put(50, new Point(649, 281));

        //y is difference by 46 (move down)
        player3Path.put(51, new Point(649, 327));

        //x is difference by 46 (move inside) 
        player3Path.put(52, new Point(603, 327));
        player3Path.put(53, new Point(557, 327));
        player3Path.put(54, new Point(511, 327));
        player3Path.put(55, new Point(465, 327));
        player3Path.put(56, new Point(419, 327));
        player3Path.put(57, new Point(373, 327));

        //======================================================================
        //This is for player 4
        //y is difference by 46 (move up) Start from here
        player4Path.put(1, new Point(281, 603));
        player4Path.put(2, new Point(281, 557));
        player4Path.put(3, new Point(281, 511));
        player4Path.put(4, new Point(281, 465));
        player4Path.put(5, new Point(281, 419));

        //x is difference by 46 (move left)
        player4Path.put(6, new Point(235, 373));
        player4Path.put(7, new Point(189, 373));
        player4Path.put(8, new Point(143, 373));
        player4Path.put(9, new Point(97, 373));
        player4Path.put(10, new Point(51, 373));
        player4Path.put(11, new Point(5, 373));

        //y is difference by 46 (move up)
        player4Path.put(12, new Point(5, 327));
        player4Path.put(13, new Point(5, 281));

        //x is difference by 46 (move right) 
        player4Path.put(14, new Point(51, 281));
        player4Path.put(15, new Point(97, 281));
        player4Path.put(16, new Point(143, 281));
        player4Path.put(17, new Point(189, 281));
        player4Path.put(18, new Point(235, 281));

        //y is difference by 46 (move up)
        player4Path.put(19, new Point(281, 235));
        player4Path.put(20, new Point(281, 189));
        player4Path.put(21, new Point(281, 143));
        player4Path.put(22, new Point(281, 97));
        player4Path.put(23, new Point(281, 51));
        player4Path.put(24, new Point(281, 5));

        //x is difference by 46 (move right)
        player4Path.put(25, new Point(327, 5));
        player4Path.put(26, new Point(373, 5));

        //y is difference by 46 (move down) 
        player4Path.put(27, new Point(373, 51));
        player4Path.put(28, new Point(373, 97));
        player4Path.put(29, new Point(373, 143));
        player4Path.put(30, new Point(373, 189));
        player4Path.put(31, new Point(373, 235));

        //x is difference by 46 (move right)
        player4Path.put(32, new Point(419, 281));
        player4Path.put(33, new Point(465, 281));
        player4Path.put(34, new Point(511, 281));
        player4Path.put(35, new Point(557, 281));
        player4Path.put(36, new Point(603, 281));
        player4Path.put(37, new Point(649, 281));

        //y is difference by 46 (move down)
        player4Path.put(38, new Point(649, 327));
        player4Path.put(39, new Point(649, 373));

        //x is difference by 46 (move left) 
        player4Path.put(40, new Point(603, 373));
        player4Path.put(41, new Point(557, 373));
        player4Path.put(42, new Point(511, 373));
        player4Path.put(43, new Point(465, 373));
        player4Path.put(44, new Point(419, 373));

        //y is difference by 46 (move down)
        player4Path.put(45, new Point(373, 419));
        player4Path.put(46, new Point(373, 465));
        player4Path.put(47, new Point(373, 511));
        player4Path.put(48, new Point(373, 557));
        player4Path.put(49, new Point(373, 603));
        player4Path.put(50, new Point(373, 649));

        //x is difference by 46 (move left)
        player4Path.put(51, new Point(327, 649));

        //y is difference by 46 (move down)
        player4Path.put(52, new Point(327, 603));
        player4Path.put(53, new Point(327, 557));
        player4Path.put(54, new Point(327, 511));
        player4Path.put(55, new Point(327, 465));
        player4Path.put(56, new Point(327, 419));
        player4Path.put(57, new Point(327, 373));
    }

    public static HashMap<Integer, Point> getPath(int id) {
        switch (id) {
            case 1:
                return player1Path;
                
            case 2:
                return player2Path;
                
            case 3:
                return player3Path;
                
            default:
                return player4Path;
        }
    }
}
