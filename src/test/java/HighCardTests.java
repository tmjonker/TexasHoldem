import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HighCardTests {

    @Test
    public void highCardShouldBeFour() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(0);
        testList.get(2).setCardSuit(3);
        testList.get(3).setCardSuit(2);
        testList.get(4).setCardSuit(2);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(4);
        testList.get(3).setCardValue(4);
        testList.get(4).setCardValue(4);
        testList.get(5).setCardValue(8);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(4, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeTwelve() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(1);
        testList.get(2).setCardSuit(1);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(1);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(11);
        testList.get(3).setCardValue(4);
        testList.get(4).setCardValue(14);
        testList.get(5).setCardValue(8);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(12, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeTen() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(0);
        testList.get(2).setCardSuit(3);
        testList.get(3).setCardSuit(2);
        testList.get(4).setCardSuit(2);
        testList.get(5).setCardSuit(1);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(7);
        testList.get(3).setCardValue(8);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(6);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(10, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeThirteen() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(7);
        testList.get(3).setCardValue(4);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(13, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeSix() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(2);
        testList.get(2).setCardSuit(3);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(2);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(6);
        testList.get(1).setCardValue(6);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(7);
        testList.get(4).setCardValue(2);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(6, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeSeven() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(2);
        testList.get(2).setCardSuit(3);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(2);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(6);
        testList.get(1).setCardValue(7);
        testList.get(2).setCardValue(9);
        testList.get(3).setCardValue(7);
        testList.get(4).setCardValue(7);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(7, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeTwo() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(2);
        testList.get(2).setCardSuit(3);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(2);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(6);
        testList.get(1).setCardValue(5);
        testList.get(2).setCardValue(2);
        testList.get(3).setCardValue(7);
        testList.get(4).setCardValue(7);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(2);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(2, player1.getHighCard().getCardValue());
    }

    @Test
    public void highCardShouldBeEight() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(1);
        testList.get(2).setCardSuit(1);
        testList.get(3).setCardSuit(1);
        testList.get(4).setCardSuit(0);
        testList.get(5).setCardSuit(2);
        testList.get(6).setCardSuit(1);

        testList.get(0).setCardValue(6);
        testList.get(1).setCardValue(5);
        testList.get(2).setCardValue(2);
        testList.get(3).setCardValue(8);
        testList.get(4).setCardValue(7);
        testList.get(5).setCardValue(13);
        testList.get(6).setCardValue(3);

        Player player1 = new Player(testList);
        player1.determineHandResult();
        assertEquals(8, player1.getHighCard().getCardValue());
    }
}

