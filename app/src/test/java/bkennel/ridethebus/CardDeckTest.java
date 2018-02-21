package bkennel.ridethebus;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bjtke_000 on 1/31/2018.
 */

public class CardDeckTest{
    public static CardDeck cd;

    @BeforeClass
    public static void setUp(){
        cd=new CardDeck();
    }

    @Test
    public void testDraw(){
        Card card=cd.draw();
        System.out.println(card.getSuit());
        System.out.println(card.getValue());
        assertNotNull(card);
    }

    @Test
    public void testShuffle(){
        Card c1=cd.top();
        cd.shuffle();
        Card c2=cd.draw();
        assertNotEquals(c1, c2);
    }

}
