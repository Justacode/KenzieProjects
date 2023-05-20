package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    //private static instance
    //private constructor
    //public getter method (for the instance)
    private static Bank instance;
    private List<Property> properties;
    private int numHouses, numHotels, availableMoney;

    private Bank(){
        properties = new ArrayList<>();
        //TODO: Actually put properties in there
        numHouses = 25;
        numHotels = 10;
        availableMoney = 12000;
    }

    public static Bank getInstance(){
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }

    public int getNumProperties(){
        return properties.size();
    }

    public Property getProperty(int index){
        return properties.get(index);
    }

    //GOAL: The number of UNOwned properties
    public int getnumUnOwned(){
        int counter = 0;
        for (Property prop : properties){
            if (!prop.isOwned()){
                counter++;
            }
        }
        return counter;
    }

    //Given an owner (Player), return all of their properties in an arrayList
    //in an arraylist
    //counter (arraylist)
    //loop
        //get the owner
        //if the player owns it
            //add (the player) the property to the basket
    //return the counter
    public ArrayList<Property> getPropsForOwner(Player owner){
        ArrayList<Property> counter = new ArrayList<>();
        for (Property prop : properties){
            Player propOwner = prop.getOwner();
            if (owner.equals(propOwner)){
                counter.add(prop);
            }
        }
        return counter;
    }

    public void distributeFunds(int amt, Player p){
        //What I want VS What the Bank Has VS What I get
        // 200               12000               200
        // 200                150                150

        //Math.max(a, b) returns the larger
        //Math.min(a, b) returns the smaller

        int amtToTransfer = Math.min(amt, availableMoney);
        p.setBalance(p.getBalance() + amtToTransfer);
        availableMoney -= amtToTransfer;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public int getNumHotels() {
        return numHotels;
    }

    public int getAvailableMoney() {
        return availableMoney;
    }
}
