package org.example;

import java.util.Scanner;

public class TicTacPlayer {
    //property
    protected String symbol;
    //constructor to populate property
    public TicTacPlayer(String symbol){
        this.symbol = symbol;
    }
    //methods

    Scanner scan = new Scanner(System.in);
    public void putOnBoard(TicTacBoard board){
        int row = -1 , col = -1;
        do {
            System.out.println("Enter your row: ");
            String rowResponse = scan.nextLine();

            try {
                row = Integer.parseInt(rowResponse);
            } catch (NumberFormatException e){
                System.out.println("Provide me with numerical input");
            }

            System.out.println("Enter your column: ");
            String colResponse = scan.nextLine();
            try {
                col = Integer.parseInt(colResponse);
            } catch (NumberFormatException e){
                System.out.println("Provide me with numerical input");
            }

        } while(row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize());

        //make a move, but lose a turn if the spot is taken
        try {
            board.makeMove(row, col, symbol);
        } catch (SpotsTakenException e){
            System.out.println(e.getMessage());
            System.out.println("WOMP womp, you lose a turn :(");
        }
    }
}
