import java.util.Arrays;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;/* Size of game board */
    public int r;
    public int c;
    public Mark winner;
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        for(int i =0; i < board.length;++i ) {
        	for(int j = 0; j < board[i].length;++j) {
        		board[i][j]=Mark.EMPTY;
        	}
        	
        }
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        r=row;
        c =col;
        if(isValidSquare(row,col)==true && isSquareMarked(row,col)==false) {
        	
        	if(xTurn==true) {
        		//System.out.println("cords:"+row+col);
        		board[row][col]=Mark.X;
        		isMarkWin(Mark.X);
        		getResult();
        		//System.out.println(board[row][col]);
        		xTurn=false;
        		
        	}
        	else if(xTurn==false) {
        		board[row][col]=Mark.O;
        		isMarkWin(Mark.O);
        		getResult();
        		xTurn=true;
        		
        	}
        	return true;
        }
        else {
        
        	return false;
        }// remove this line later!
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        if(row <= width && col <= width) {
        	return true;
        }
        else
        {
        	return false;
        }
        

        // remove this line later!
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        if(board[row][col] != Mark.EMPTY) {
        	return true;
        }
        else {
        	return false;
        }

       // remove this line later!
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
    	

        return board[row][col]; // remove this line later!
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
    	
        if(winner==Mark.X) {
        	return Result.X;
        }
        else if(winner== Mark.O) {
        	return Result.O;
        }
        else if(isTie()==true)
        {
        	return Result.TIE;
        }
        else {
        	return Result.NONE;
        }
        	

       // remove this line later!
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        //rows
    	int tallyRows=0;
    	int tallyCol=0;
    	int tallydiag1=0;
    	int tallydiag2=0;
    	//rows
    	for(int i=0; i < board.length;++i) {
    		for(int j=0; j < board[i].length;++j) {
    			if(board[i][j]==mark){
    				tallyRows+=1;
    				if(tallyRows==board.length) {
    					winner=mark;
    					return true;
    				}
    			}
    			
    		}
    		tallyRows=0;
    	}
    	//columns
    	for(int i=0; i < board.length;++i) {
    		for(int j=0; j < board[i].length;++j) {
    			if(board[j][i]==mark){
    				tallyCol+=1;
    				if(tallyCol==board.length) {
    					winner=mark;
    					return true;
    				}
    			}
    			
    		}
    		tallyCol=0;
    	}
    	
    	//left starting diagonal
    	
    	
    	for(int i=0; i < board.length;++i) {
    		for(int j=0; j < board[i].length;++j) {
    			if(board[i][i]==mark){
    				System.out.println(board[i][i]);
    				tallydiag1+=1;
    				System.out.println(tallydiag1);
    				if(tallydiag1==board.length) {
    					winner=mark;
    					return true;
    				}
    			}
    			
    		}
    		tallydiag1=0;
    	}
    	/*
    	//right starting diagonal
    	for(int i=0; i < board.length;++i) {
    		for(int j=0; j < board[i].length;++j) {
    			if(board[i][board.length-i-1]==mark){
    				tallydiag2+=1;
    				if(tallydiag2==board.length) {
    					winner=mark;
    					return true;
    				}
    			}
    			
    		}
    		tallydiag2=0;
    	}*/
    	
        
       
        return false;
       
        

       // remove this line later!

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE

        return false; // remove this line later!
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        for(int i =0; i < board.length;++i ) {
        	output.append("\n");
        	for(int j = 0; j < board[i].length;++j) {
        		output.append(board[i][j].toString());
        	}
        	
        }
        
        
 

   
         	
         
        return output.toString();
    	//return Arrays.toString(board);
        
    }
    
}
