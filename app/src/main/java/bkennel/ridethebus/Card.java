package bkennel.ridethebus;

/**
 * Created by bjtke_000 on 1/17/2018.
 */

public class Card {
    private int value;
    private String suit;

    public Card(int v, String s){
        value=v;
        suit=s;
    }

    public int getValue(){
        return this.value;
    }

    public String getSuit(){
        return this.suit;
    }
}
