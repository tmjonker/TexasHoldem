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

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(1);
        testList.get(2).setCardSuit(1);
        testList.get(3).setCardSuit(2);
        testList.get(4).setCardSuit(2);
        testList.get(5).setCardSuit(2);
        testList.get(6).setCardSuit(2);

        PlayerHand playerHand5 = new PlayerHand(testList);
        assertFalse(playerHand5.checkFlush());
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
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkRoyalFlush());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(12);
        testList.get(2).setCardValue(11);
        testList.get(3).setCardValue(10);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkRoyalFlush());

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(13);
        testList.get(4).setCardValue(11);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkRoyalFlush());
    }

    @Test
    public void fourOfAKindShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();
        int flushSuit = 0;

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList.add(card);
        }

        testList.get(0).setCardValue(9);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(14);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertFalse(playerHand1.checkFourOfAKind());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(12);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(12);
        testList.get(4).setCardValue(12);
        testList.get(5).setCardValue(0);
        testList.get(6).setCardValue(0);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertTrue(playerHand2.checkFourOfAKind());

        testList.get(0).setCardValue(13);
        testList.get(1).setCardValue(12);
        testList.get(2).setCardValue(11);
        testList.get(3).setCardValue(10);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(10);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkFourOfAKind());

        testList.get(0).setCardValue(9);
        testList.get(1).setCardValue(12);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(9);
        testList.get(5).setCardValue(10);
        testList.get(6).setCardValue(9);

        PlayerHand playerHand4 = new PlayerHand(testList);
        assertTrue(playerHand4.checkFourOfAKind());
    }

    @Test
    public void fiveCardsWithSameSuitAndConsecutiveValuesShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();
        int flushSuit = 0;

        for (int i = 0; i < 5; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList.add(card);
        }

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(13);
        testList.get(2).setCardValue(12);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkStraightFlush());

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(10);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(6);
        testList.get(4).setCardValue(4);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkStraightFlush());

        testList.get(0).setCardValue(6);
        testList.get(1).setCardValue(7);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(8);
        testList.get(4).setCardValue(10);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkStraightFlush());
    }

    @Test
    public void threeOfAKindShouldEqualTrue() {

        List<Card> testList = new ArrayList<>();
        int flushSuit = 0;

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList.add(card);
        }

        testList.get(0).setCardValue(9);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(14);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(9);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand1 = new PlayerHand(testList);
        assertTrue(playerHand1.checkThreeOfAKind());

        testList.get(0).setCardValue(9);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(14);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(8);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand2 = new PlayerHand(testList);
        assertFalse(playerHand2.checkThreeOfAKind());

        testList.get(0).setCardValue(9);
        testList.get(1).setCardValue(14);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(2);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(2);

        PlayerHand playerHand3 = new PlayerHand(testList);
        assertTrue(playerHand3.checkThreeOfAKind());
    }

    @Test
    public void twoOfAKindShouldEqualTrue() {

        List<Card> testList1 = new ArrayList<>();
        int flushSuit = 0;

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList1.add(card);
        }

        List<Card> testList2 = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Card card = new Card();
            card.setCardSuit(flushSuit);
            testList2.add(card);
        }

        testList1.get(0).setCardValue(9);
        testList1.get(1).setCardValue(14);
        testList1.get(2).setCardValue(10);
        testList1.get(3).setCardValue(14);
        testList1.get(4).setCardValue(10);
        testList1.get(5).setCardValue(9);
        testList1.get(6).setCardValue(2);

        PlayerHand playerHand1 = new PlayerHand(testList1);
        assertTrue(playerHand1.checkTwoOfAKind());

        testList1.get(0).setCardValue(10);
        testList1.get(1).setCardValue(5);
        testList1.get(2).setCardValue(10);
        testList1.get(3).setCardValue(14);
        testList1.get(4).setCardValue(7);
        testList1.get(5).setCardValue(9);
        testList1.get(6).setCardValue(2);

        PlayerHand playerHand2 = new PlayerHand(testList1);
        assertTrue(playerHand2.checkTwoOfAKind());

        testList1.get(0).setCardValue(7);
        testList1.get(1).setCardValue(10);
        testList1.get(2).setCardValue(8);
        testList1.get(3).setCardValue(14);
        testList1.get(4).setCardValue(2);
        testList1.get(5).setCardValue(2);
        testList1.get(6).setCardValue(1);

        PlayerHand playerHand3 = new PlayerHand(testList1);
        assertTrue(playerHand3.checkTwoOfAKind());

        testList2.get(0).setCardValue(7);
        testList2.get(1).setCardValue(10);
        testList2.get(2).setCardValue(8);
        testList2.get(3).setCardValue(7);

        PlayerHand playerHand4 = new PlayerHand(testList2);
        assertTrue(playerHand4.checkTwoOfAKind());

        testList2.get(0).setCardValue(7);
        testList2.get(1).setCardValue(10);
        testList2.get(2).setCardValue(8);
        testList2.get(3).setCardValue(7);

        PlayerHand playerHand5 = new PlayerHand(testList2);
        assertTrue(playerHand5.checkTwoOfAKind());

        testList2.get(0).setCardValue(6);
        testList2.get(1).setCardValue(10);
        testList2.get(2).setCardValue(8);
        testList2.get(3).setCardValue(7);

        PlayerHand playerHand6 = new PlayerHand(testList2);
        assertFalse(playerHand6.checkTwoOfAKind());

        testList1.get(0).setCardValue(7);
        testList1.get(1).setCardValue(10);
        testList1.get(2).setCardValue(8);
        testList1.get(3).setCardValue(14);
        testList1.get(4).setCardValue(9);
        testList1.get(5).setCardValue(2);
        testList1.get(6).setCardValue(1);

        PlayerHand playerHand7 = new PlayerHand(testList1);
        assertFalse(playerHand7.checkTwoOfAKind());
    }
}
