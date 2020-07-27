package mainPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GamePlay{
    class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private final static int WINPOINT = 100;
    private static Map<Integer,Integer> snake;
    private static Map<Integer,Integer> ladder;
    private static Map<Integer, Node> playerImagePos;

    public GamePlay(){
        snake = new HashMap<>();
        ladder = new HashMap<>();
        playerImagePos = new HashMap<>();
        
        //make snake-------------------------------------------------------------------------------
        snake.put(99,41);
	snake.put(90,52);
	snake.put(74,46);
	snake.put(56,37);
	snake.put(47,29);
        snake.put(27,15);
        snake.put(21,2);
	
        //make ladder------------------------------------------------------------------------------
	ladder.put(75,96);
	ladder.put(65,84);
	ladder.put(61,79);
	ladder.put(32,51);
	ladder.put(23,42);
        
        //position for board value-----------------------------------------------------------------
        int position = 100;
        for(int y = 0; y < 10; y++){
            if(y%2==0){
                for(int x = 0; x <= 9; x++){
                    playerImagePos.put(position, new Node(x*60, y*60));
                    position--;
                }
            }
            else{
                for(int x = 9; x >= 0; x--){
                    playerImagePos.put(position, new Node(x*60, y*60));
                    position--;
                }
            }
        }
    }
	
	
    public int rollDice()
    {
	Random rand = new Random();
	int n = rand.nextInt(7);
        
	return (n==0) ? 1 : n;
    }
	
    public int[] getplayerImagePos(int pos){
        Node node = playerImagePos.get(pos);
        
        return new int[]{node.x, node.y};
    }
    
    public int SnakeSwallow(int pos){
        if(snake.containsKey(pos)){
            return snake.get(pos);
        }
        
        return 0;
    }
    
    public int LadderClimb(int pos){
        if(ladder.containsKey(pos)){
            return ladder.get(pos);
        }
        
        return 0;
    }

    public boolean isWin(int player)
    {
	return WINPOINT == player;
    }
    
}

