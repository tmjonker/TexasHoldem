import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.PlayerHand;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HandTests {

    @Test
    public void fiveConsecutiveCardsShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(8);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkStraight());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(14);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(8);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkStraight());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(8);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkStraight());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(5);

        PlayerHand playerHand4 = new PlayerHand(testList);
        assertFalse(playerHand4.checkStraight());

        testList.get(0).setCardValue(13);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(5);

        PlayerHand playerHand5 = new PlayerHand(testList);
        assertTrue(playerHand5.checkStraight());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(13);
        testList.get(3).setCardValue(12);
        testList.get(4).setCardValue(11);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(9);

        PlayerHand playerHand6 = new PlayerHand(testList);
        assertTrue(playerHand6.checkStraight());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(13);
        testList.get(3).setCardValue(12);
        testList.get(4).setCardValue(11);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(8);

        PlayerHand playerHand7 = new PlayerHand(testList);
        assertTrue(playerHand7.checkStraight());
    }

    @Test
    public void fiveCardsWithSameSuitShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(0);
        testList.get(1).setCardSuit(0);
        testList.get(2).setCardSuit(0);
        testList.get(3).setCardSuit(0);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(0);
        testList.get(6).setCardSuit(0);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkFlush());

        testList.get(0).setCardSuit(0);
        testList.get(1).setCardSuit(1);
        testList.get(2).setCardSuit(0);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(0);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkFlush());

        testList.get(0).setCardSuit(0);
        testList.get(1).setCardSuit(0);
        testList.get(2).setCardSuit(0);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(0);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkFlush());

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(0);
        testList.get(2).setCardSuit(2);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(2);

        PlayerHand playerHand4 = new PlayerHand(testList);
        assertFalse(playerHand4.checkFlush());
    }

    @Test
    public void aceThroughTenShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();
        int flushSuit = 0;

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList.add(card);
        }

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(0);
        testList.get(6).setCardValue(0);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkRoyalFlush(0));

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(12);
        testList.get(2).setCardValue(11);
        testList.get(3).setCardValue(10);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(0);
        testList.get(6).setCardValue(0);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkRoyalFlush(0));
    }
}
