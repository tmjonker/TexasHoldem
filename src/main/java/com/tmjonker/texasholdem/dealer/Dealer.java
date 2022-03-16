package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;

import java.util.List;

public class Dealer {


    private List<Player> players;
    private DealerDeck dealerDeck = new DealerDeck();

    public Dealer(List<Player> players) {
        this.players = players;
    }

    public void dealCards() {

        for (Player player : players) {
            player.setPlayerHand(dealerDeck.dealPlayerCards());
        }
    }

    public void dealFlop() {

        List<Card> flop = dealerDeck.generateFlop();

        System.out.println("flop" + " " + flop);

        for (Player player : players) {
            player.setFlop(dealerDeck.getTableCards());
        }
    }

    public void dealTurn() {

        Card turn = dealerDeck.generateTurnRiver();

        System.out.println("turn" + " " + turn);

        for (Player player : players) {
            player.addTableCard(turn);
        }
    }

    public void dealRiver() {

        Card river = dealerDeck.generateTurnRiver();

        System.out.println("river" + " " + river + "\n");

        for (Player player : players) {
            player.addTableCard(river);
        }

    }

    public DealerDeck getDealerDeck() {
        return dealerDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
