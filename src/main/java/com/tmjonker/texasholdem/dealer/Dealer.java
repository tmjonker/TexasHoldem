package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.Card;

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
            Player player = new Player("p"+i);
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
            System.out.print(p.getName() + " ");
            p.setTableCards(dealerDeck.getTableCards());
            p.setFinalResultHand(p.determineHandResult());

            p.getTotalPlayerHand().forEach(card -> {
                System.out.print(card + " ");
            });
            System.out.println(p.getFinalResultHand() + " ");
        }

        List<Player> playersClone = players;
        playersClone.sort(Comparator.comparing(Player::getFinalResultHandValue).reversed()
                .thenComparing(Player::getHighCard));

        int winningHandValue = playersClone.get(0).getFinalResultHandValue();
        playersClone.removeIf(player -> (player.getFinalResultHandValue() != winningHandValue));

        if (playersClone.size() > 1) {
            for (int i = 0; i < playersClone.size() - 1; i++) {
                if (playersClone.get(i).getHighCard().getCardValue()
                        > playersClone.get(i+1).getHighCard().getCardValue()) {
                    playersClone.remove(i+1);
                    i--;
                }
            }
            for (int i = 0; i < playersClone.size() - 1; i++) {
                System.out.println(playersClone.get(i).getHighestPlayerDealtCard());
                if (playersClone.get(i).getHighestPlayerDealtCard().getCardValue()
                        > playersClone.get(i+1).getHighestPlayerDealtCard().getCardValue()) {
                    playersClone.remove(i+1);
                    i--;
                }
            }
        }

        winningPlayer = playersClone.get(0);
        return winningPlayer;
    }
}
