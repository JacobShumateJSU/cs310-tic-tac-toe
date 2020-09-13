package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class TicTacToeController implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }


    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton buttonClicked = (JButton) event.getSource();
        String name = buttonClicked.getName();
        int row= Character.getNumericValue(name.charAt(6));
        int col= Character.getNumericValue(name.charAt(7));
        model.makeMark(row,col);
        view.updateSquares();
        
        if(model.isGameover()){
        	view.disableSquares();
        	view.showResult(model.getResult().toString());
        }
        
    }

}