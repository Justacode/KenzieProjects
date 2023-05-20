package org.example;

import java.util.List;

public class MonopolyGame {
    private List<Player> players;
    private int currPlayerIndex;

    //TODO: Make constructor
    public void takeATurn(){
        //Become the active player
        Player activePlayer = players.get(currPlayerIndex);
        //RollDice()
        int result = activePlayer.rollDice();
        //UpdatePosition()
        int newPos = activePlayer.getPosition() + result;
        int numOfProperties = Bank.getInstance().getNumProperties();
        while (newPos >= numOfProperties){
            //we gotta wrap around
            activePlayer.passGo();
            newPos -= numOfProperties;
        }
        activePlayer.setPosition(newPos);
        //see where we landed
        Property landed = Bank.getInstance().getProperty(newPos);
        //ASK: is it owned?
        if (landed.isOwned()){
            //Yes-> payRent
            activePlayer.payRentTo(landed.getOwner(), landed.calcRent());
        } else {
            //Buy it
            //TODO: Code BUY Properites from bank
        }

        currPlayerIndex++;
    }
}
