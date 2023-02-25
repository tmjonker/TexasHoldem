package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;

import java.util.List;

public class Dealer {


    private List<Player> players;
    private DealerAction dealerAction = new DealerAction();

    public Dealer(List<Player> players) {
        this.players = players;
    }

    public void dealCards() {

        for (Player player : players) {
            player.setPlayerHand(dealerAction.dealPlayerCards());
        }
    }

    public void dealFlop() {

        List<Card> flop = dealerAction.generateFlop();

        System.out.println("flop" + " " + flop);

        for (Player player : players) {
            player.setFlop(dealerAction.getTableCards());
        }
    }

    public void dealTurn() {

        Card turn = dealerAction.generateTurnRiver();

        System.out.println("turn" + " " + turn);

        for (Player player : players) {
            player.addTableCard(turn);
        }
    }

    public void dealRiver() {

        Card river = dealerAction.generateTurnRiver();

        System.out.println("river" + " " + river + "\n");

        for (Player player : players) {
            player.addTableCard(river);
        }

    }
}
