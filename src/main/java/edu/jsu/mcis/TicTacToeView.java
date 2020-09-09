

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    TicTacToeModel marking = new TicTacToeModel();
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        Scanner rowInput = new Scanner(System.in);
        Scanner colInput = new Scanner(System.in);
        
        System.out.println("Enter the row you'd like to move to:");
        int row=rowInput.nextInt();
        System.out.println("Enter the column you'd like to move to:");
        int col = colInput.nextInt();
        
        
        
       
        //return TicTacToeMove(row,col); // remove this line later!
        return new TicTacToeMove(row,col);

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
