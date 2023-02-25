import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;
import com.tmjonker.texasholdem.winninghandevaluator.HandEvaluator;
import com.tmjonker.texasholdem.winninghandevaluator.WinningHandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TieTests {

    @Test
    public void TestShouldResultInTie() {

        List<Card> testList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(0);
            testList.add(card);
        }

        testList.get(0).setCardSuit(1);
        testList.get(1).setCardSuit(1);
        testList.get(2).setCardSuit(2);
        testList.get(3).setCardSuit(2);
        testList.get(4).setCardSuit(1);

        testList.get(0).setCardValue(10);
        testList.get(1).setCardValue(10);
        testList.get(2).setCardValue(14);
        testList.get(3).setCardValue(2);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

        Player player = new Player(testList);
        player.setName("p1");

        List<Card> testList2 = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Card card = new Card();
            card.setCardSuit(0);
            testList2.add(card);
        }

        testList2.get(0).setCardSuit(1);
        testList2.get(1).setCardSuit(1);
        testList2.get(2).setCardSuit(2);
        testList2.get(3).setCardSuit(2);
        testList2.get(4).setCardSuit(1);

        testList2.get(0).setCardValue(10);
        testList2.get(1).setCardValue(10);
        testList2.get(2).setCardValue(14);
        testList2.get(3).setCardValue(2);
        testList2.get(4).setCardValue(13);
        testList2.get(5).setCardValue(2);
        testList2.get(6).setCardValue(12);

        Player player2 = new Player(testList2);
        player2.setName("p2");

        List<Player> playerList = new ArrayList<Player>();
        playerList.add(player);
        playerList.add(player2);

        playerList.forEach(p -> {
            p.setPlayerHand(testList2);
            HandEvaluator handEvaluator = new HandEvaluator(p);
            handEvaluator.determineHandResult();
        });

        WinningHandEvaluator winningHandEvaluator = new WinningHandEvaluator(playerList);
        Player winningPlayer = winningHandEvaluator.determineWinningHand();

        assertEquals("tie", winningPlayer.getName());
    }
}
