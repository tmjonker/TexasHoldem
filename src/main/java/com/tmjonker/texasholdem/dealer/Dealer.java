package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.DealerDeck;
import com.tmjonker.texasholdem.playingcards.Hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealer {

    private final int NUMBER_PLAYERS = 8;
    private List<Player> players = new ArrayList<>();
    private DealerDeck dealerDeck = new DealerDeck();

    public Dealer() {

    }

    public void dealCards() {

        for (int i=0; i < NUMBER_PLAYERS; i++) {
            Player player = new Player();
            player.setPlayerHand(dealerDeck.dealPlayerCards());
            players.add(player);
        }
    }

    public void dealFlop() {

        List<Card> flop = dealerDeck.generateFlop();
    }

    public void dealTurn() {

        Card card = dealerDeck.generateTurnRiver();
    }

    public void dealRiver() {

        Card card = dealerDeck.generateTurnRiver();
    }

    public Player determineWinningHand() {

        Player winningPlayer = null;

        for (Player p : players) {
            p.setTableCards(dealerDeck.getTableCards());
            p.setFinalResultHand(p.determineHandResult());
            System.out.println(p.getFinalResultHand());
        }

        List<Player> playersClone = players;

        playersClone.sort(Comparator.comparing(Player::getFinalResultHandValue).thenComparing(Player::getHighCard).reversed());

        int winningHandValue = playersClone.get(0).getFinalResultHandValue();

        playersClone.removeIf(player -> (player.getFinalResultHandValue() != winningHandValue));

        winningPlayer = playersClone.get(0);
        return winningPlayer;
    }
}
