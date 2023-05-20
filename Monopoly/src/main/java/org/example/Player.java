package org.example;

public class Player {
    enum Piece {
        CAR,
        BATTLESHIP,
        MONEYBAGS,
        SHOE,
        THIMBLE,
        HORSE,
        TRAIN;

        double weight;
    }
    private String name;
    private int balance, position;
    private boolean hasLost;
    private Piece piece;

    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
        balance = 1000;
        position = 0;
        hasLost = false;
    }

    public boolean canBuyProperty(Property prop){
        if (prop.isOwned()){
            return false;
        }
        return balance >= prop.getCost();
    }

    public boolean equals(Object other){
        //reflexivity test (am I you?)
        if (this == other){
            return true;
        }

        //non-nullity test (are you null?)
        if (other == null){
            return false;
        }

        //type test(are you actually a player?)
        if (! (other instanceof Player)){
            return false;
        }

        //type-cast to remove the object jacket
        Player otherPlayer = (Player) other;

        //logical equality test
        return this.name.equals(otherPlayer.name) &&
                this.piece == otherPlayer.piece;

    }

    public void payRentTo(Player other, int amt){
        //my money goes down
        //other's money goes up
        //if I don't have enough money-> i lose
        if (balance < amt){
            hasLost = true;
            other.balance += balance;
            balance = 0;
        } else if (balance == amt){
            System.out.println(name + " is in the danger zone! Quick someone wave a dollar in their face!");
        } else {
            //I have enough money
            other.balance += amt;
            this.balance -= amt;
        }
    }

    public int rollDice(){
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        return die1 + die2;
    }

    public void passGo(){
        //access the Bank
        //distribute 200 dollars
        Bank b = Bank.getInstance();
        b.distributeFunds(200, this);
    }

    public boolean makePurchase(int amt){
        if (balance >= amt){
            balance-=amt;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isHasLost() {
        return hasLost;
    }

    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
