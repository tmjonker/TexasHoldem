package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;

import java.util.ArrayList;
import java.util.Comparator;
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

        for (Player player : players) {
            player.setTableCards(dealerDeck.getTableCards());
        }
    }

    public void dealTurn() {

        Card turn = dealerDeck.generateTurnRiver();

        for (Player player : players) {
            player.setTableCards(dealerDeck.getTableCards());
        }
    }

    public void dealRiver() {

        Card river = dealerDeck.generateTurnRiver();

        for (Player player : players) {
            player.setTableCards(dealerDeck.getTableCards());
        }

    }

    public DealerDeck getDealerDeck() {
        return dealerDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
