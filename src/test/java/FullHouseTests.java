import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseTests {

    @Test
    public void handShouldBeFullHouse1() {

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

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(10);
        testList.get(2).setCardValue(8);
        testList.get(3).setCardValue(11);
        testList.get(4).setCardValue(10);
        testList.get(5).setCardValue(11);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        assertEquals(Hand.FULL_HOUSE, player1.determineHandResult());
    }

    @Test
    public void handShouldBeFullHouse2() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            testList.add(card);
        }

        testList.get(0).setCardValue(14);
        testList.get(1).setCardValue(10);
        testList.get(2).setCardValue(14);
        testList.get(3).setCardValue(2);
        testList.get(4).setCardValue(2);
        testList.get(5).setCardValue(11);
        testList.get(6).setCardValue(2);

        Player player2 = new Player(testList);
        assertEquals(Hand.FULL_HOUSE, player2.determineHandResult());
    }
}
