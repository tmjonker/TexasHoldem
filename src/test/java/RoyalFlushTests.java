import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoyalFlushTests {

    @Test
    public void handShouldBeRoyalFlush() {
        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(0);
            testList.add(card);
        }

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(7);
        testList.get(3).setCardValue(14);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(11);
        testList.get(6).setCardValue(12);

        Player player1 = new Player(testList);
        assertEquals(Hand.ROYAL_FLUSH, player1.determineHandResult());

        for (Card c : testList)
            c.setCardSuit(1);

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(9);
        testList.get(2).setCardValue(7);
        testList.get(3).setCardValue(14);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(11);
        testList.get(6).setCardValue(12);

        Player player2 = new Player(testList);
        assertEquals(Hand.ROYAL_FLUSH, player2.determineHandResult());
    }
}
