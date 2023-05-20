package org.example;

import java.util.HashMap;

public class ComputerPlayer extends TicTacPlayer {
    public ComputerPlayer(String symbol){
        super(symbol);
    }

    public void putOnBoard(TicTacBoard board){
        //collect the empty spots
            //we're gonna use a hashmap of coordinates
        HashMap<Integer, Coordinate> empties = new HashMap<>();
            //we're going to label each coordinate with a number
        int counter = 0;
        String[][] grid = board.getBoard();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                if (grid[i][j] == null){
                    empties.put(counter++, new Coordinate(i, j));
                }
            }
        }
        //randomly choose one
            //we're gonna use Math.random()
        //The size of the counter tells us how many coordinates
            //valid spot #s are [0, counter - 1]
        int randomNumber = (int) (Math.random() * counter);
        Coordinate luckySpot = empties.get(randomNumber);
        //make the move
        board.makeMove(luckySpot.row, luckySpot.col, symbol);
            //At the specified spot
    }

    class Coordinate{
        int row, col;
        public Coordinate(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
