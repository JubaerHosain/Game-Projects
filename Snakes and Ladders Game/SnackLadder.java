import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jubaer
 */
public class SnackLadder {
    private static final int WINPOINT = 100;
    private HashMap<Integer, Integer> snake, ladder;
    
    public SnackLadder(){
        snake = new HashMap<>();
        ladder = new HashMap<>();
        CreateSnckeAndLadder();
    }
    
    private void CreateSnckeAndLadder(){
        //Create Snack
        snake.put(97,54);
	snake.put(70,55);
	snake.put(52,42);
	snake.put(25,2);
	snake.put(95,72);
	
        //Create Ladder
	ladder.put(6,25);
	ladder.put(11,40);
	ladder.put(60,85);
	ladder.put(46,90);
	ladder.put(17,69);
    }
    
    private int RollDice(){
        Random rand = new Random();
        int number = rand.nextInt(7);
        
        return (number == 0? 1 : number);
    }
    
    private int CalculatePlayerPosition(int player, int diceValue){
        player += diceValue;
        
        //Remain same point if exceed winpoint
        if(player > WINPOINT){
            System.out.println("Remains same position");
            player -= diceValue;
            return player;
        }
        
        //If player on the mouth of snack
        if(snake.get(player) != null){
            System.out.println("swallowed by snake");
	    player= snake.get(player);
        }
        
        //If player on the start of ladder
        if(ladder.get(player) != null){
            System.out.println("climb up the ladder");
            player= ladder.get(player);
        }
        
        return player;
    }
    
    private boolean isWin(int player){
        return WINPOINT == player;
    }
    
    public void StartGame(){
        int player1 = 0, player2 = 0, currentPlayer = -1, diceValue = 0;
        String string;
        Scanner scan = new Scanner(System.in);
        
        do{
            System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER":"\n\nSECOND PLAYER");
            System.out.print("Enter R/r to roll Dice: ");
            string = scan.next();
            diceValue = RollDice();
            System.out.println("Dice value: " + diceValue);
            
            if(currentPlayer == -1){
                player1 = CalculatePlayerPosition(player1, diceValue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
		System.out.println("------------------");
                
                if(isWin(player1)){
                    System.out.println("First player wins");
		    return;
                }
            }
            else{
                player2 = CalculatePlayerPosition(player2, diceValue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
		System.out.println("------------------");
                
                if(isWin(player2)){
                    System.out.println("Second player wins");
		    return;
                }
            }
            
            currentPlayer = -currentPlayer;
        }while(string.equals("r") || string.equals("R"));
    }
    
    public static void main(String[] args){
        SnackLadder game = new SnackLadder();
        game.StartGame();
    }
}
