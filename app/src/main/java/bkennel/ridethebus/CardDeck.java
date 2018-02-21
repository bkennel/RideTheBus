package bkennel.ridethebus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by bjtke_000 on 1/17/2018.
 */

public class CardDeck {
    private Queue<Card> deck;

    public CardDeck(){
        deck=new LinkedList<>();
        for(int i=1;i<=13;i++){
            deck.add(new Card(i,"HEARTS"));
            deck.add(new Card(i,"DIAMONDS"));
            deck.add(new Card(i,"CLUBS"));
            deck.add(new Card(i,"SPADES"));
        }
    }

    public int getCount(){return deck.size();}

    public Card draw(){
        return deck.remove();
    }

    public Card drawN(int n){
        //Get list of n removed cards
        return deck.remove();
    }

    public Card top() {return deck.peek();}

    public void shuffle(){
        //Knuth shuffle or sort by assigned random number
        Card[] tempdeck=new Card[52];
        for(int i=0;i<tempdeck.length;i++){
            tempdeck[i]=this.draw();
        }
        Random random=new Random();
        for(int i=tempdeck.length-1;i>0;i--){
            int r=random.nextInt(i); //change to within range, not 0-52 every time
            //swap(tempdeck[i],tempdeck[r]);
            Card temp=tempdeck[i];
            tempdeck[i]=tempdeck[r];
            tempdeck[r]=temp;
        }
        for(int i=0;i<tempdeck.length;i++){
            deck.add(tempdeck[i]);
        }

    }

    private void swap(Card a, Card b){
        Card temp=b;
        b=a;
        a=temp;
    }
}
