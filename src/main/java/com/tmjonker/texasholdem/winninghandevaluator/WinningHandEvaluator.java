package com.tmjonker.texasholdem.winninghandevaluator;

import com.tmjonker.texasholdem.player.Player;

import java.util.Comparator;
import java.util.List;

public class WinningHandEvaluator {

    private List<Player> players;

    public WinningHandEvaluator(List<Player> players) {
        this.players = players;
    }

    // Determines which player has the winning hand in the simulated game.
    public Player determineWinningHand() {

        players.forEach(p -> {
                    System.out.print(p.getName() + " ");
                    HandEvaluator handEvaluator = new HandEvaluator(p);
                    handEvaluator.determineHandResult();
                    p.setPairValue(handEvaluator.getPairValue());

                    p.getTotalPlayerHand().forEach(card -> {
                        System.out.print(card + " ");
                    });

                    System.out.println(p.getFinalResultHand() + "        " + "highest deal: " + p.getHighestPlayerDealtCard() +
                            "      " + "lowest deal: " + p.getLowestPlayerDealtCard());
                });

        List<Player> playersClone = players;
        playersClone.sort(Comparator.comparing(Player::getFinalResultHandValue).reversed()
                .thenComparing(Player::getHighCard));

        int winningHandValue = playersClone.get(0).getFinalResultHandValue();
        playersClone.removeIf(player -> (player.getFinalResultHandValue() != winningHandValue));

        /* Filters out losers in the event of a tie involving multiple players having the same winning hand.
         It first evaluates all tied players high cards, then if theres still a tie, it checks the highest card dealt
         to a player, if there's still a tie, then it checks the lowest card dealt to each player.  It also checks the
         value of pairs if there's a tie between multiple players who have a full house or two pair.
         */
        if (playersClone.size() > 1) {
            checkHighCard(playersClone);
        }
        if (playersClone.size() > 1) {
            checkHighestPlayerDealtCard(playersClone);
        }
        if (playersClone.size() > 1) {
            checkLowestPlayerDealtCard(playersClone);
        }
        if (playersClone.size() > 1) {
            if (winningHandValue == 5 || winningHandValue == 2) {
                checkPairValue(playersClone);
            }
        }

        if (playersClone.size() > 1)
            return new Player("\ntie");
        else
            return playersClone.get(0);
    }

    // Evaluates high card in each player's total deck.
    private void checkHighCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getHighCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getHighCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                } else {
                    playersClone.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    // Evaluates highest card of the two that were dealt to each individual player.
    private void checkHighestPlayerDealtCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getHighestPlayerDealtCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getHighestPlayerDealtCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                } else {
                    playersClone.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    //Evaluates the lower of the two cards that was dealt to each individual player.
    private void checkLowestPlayerDealtCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getLowestPlayerDealtCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getLowestPlayerDealtCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                } else {
                    playersClone.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    //Evaluates the pair value if there is a tie between multiple players with a full house or two pair.
    private void checkPairValue(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {

            int tempHighest = playersClone.get(i).getPairValue();
            if (playersClone.size() > i + 1) {
                if (playersClone.get(i+1).getPairValue() < tempHighest) {
                    playersClone.remove(i+1);
                } else {
                    playersClone.remove(i);
                }
                i--;
            }
        }
    }
}

