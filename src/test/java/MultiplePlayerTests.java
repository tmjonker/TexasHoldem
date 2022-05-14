import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;
import com.tmjonker.texasholdem.winninghandevaluator.HandEvaluator;
import com.tmjonker.texasholdem.winninghandevaluator.WinningHandEvaluator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplePlayerTests {

    @Test
    public void WinningHandShouldBeThree10sAndTwo4s() {

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
        testList.get(2).setCardValue(10);
        testList.get(3).setCardValue(2);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

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
        testList2.get(2).setCardValue(10);
        testList2.get(3).setCardValue(4);
        testList2.get(4).setCardValue(13);
        testList2.get(5).setCardValue(4);
        testList2.get(6).setCardValue(12);

        Player player = new Player(testList);
        Player player2 = new Player(testList2);

        HandEvaluator handEvaluator = new HandEvaluator(player);
        handEvaluator.determineHandResult();

        HandEvaluator handEvaluator2 = new HandEvaluator(player2);
        handEvaluator2.determineHandResult();

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player2);

        WinningHandEvaluator winningHandEvaluator = new WinningHandEvaluator(playerList);

        assertEquals(player2, winningHandEvaluator.determineWinningHand(), "player2 should win with three 10's and two 4's");
    }

    @Test
    public void WinningHandShouldBeTwo10sAndTwo3s() {

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
        testList.get(1).setCardValue(3);
        testList.get(2).setCardValue(10);
        testList.get(3).setCardValue(2);
        testList.get(4).setCardValue(13);
        testList.get(5).setCardValue(2);
        testList.get(6).setCardValue(12);

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
        testList2.get(2).setCardValue(9);
        testList2.get(3).setCardValue(3);
        testList2.get(4).setCardValue(13);
        testList2.get(5).setCardValue(3);
        testList2.get(6).setCardValue(12);

        Player player = new Player(testList);
        Player player2 = new Player(testList2);

        HandEvaluator handEvaluator = new HandEvaluator(player);
        handEvaluator.determineHandResult();

        HandEvaluator handEvaluator2 = new HandEvaluator(player2);
        handEvaluator2.determineHandResult();

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player2);

        WinningHandEvaluator winningHandEvaluator = new WinningHandEvaluator(playerList);

        assertEquals(player2, winningHandEvaluator.determineWinningHand(), "player2 should win with two 10's and two 3's");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Completed");
    }
}
