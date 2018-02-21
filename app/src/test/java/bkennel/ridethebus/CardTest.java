package bkennel.ridethebus;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by bjtke_000 on 1/31/2018.
 */

public class CardTest {
    public static Card card;

    @BeforeClass
    public static void setUp(){
        card=new Card(1,"SPADES");
    }

    @Test
    public void testGetValue(){
        assertEquals(1, card.getValue());
    }

    @Test
    public void testGetSuit(){
        assertEquals("SPADES", card.getSuit());
    }

}
