package com.tmjonker.texasholdem.winninghandevaluator;

import com.tmjonker.texasholdem.player.Player;

import java.util.Comparator;
import java.util.List;

public class WinningHandEvaluator {

    private List<Player> players;

    public WinningHandEvaluator(List<Player> players) {
        this.players = players;
    }

    public Player determineWinningHand() {

        for (Player p : players) {
            System.out.print(p.getName() + " ");
            HandEvaluator handEvaluator = new HandEvaluator(p);
            handEvaluator.determineHandResult();
            p.setPairValue(handEvaluator.getPairValue());

            p.getTotalPlayerHand().forEach(card -> {
                System.out.print(card + " ");
            });
            System.out.println(p.getFinalResultHand() + "        " + "highest deal: " + p.getHighestPlayerDealtCard() +
                    "      " + "lowest deal: " + p.getLowestPlayerDealtCard());
        }

        List<Player> playersClone = players;
        playersClone.sort(Comparator.comparing(Player::getFinalResultHandValue).reversed()
                .thenComparing(Player::getHighCard));

        int winningHandValue = playersClone.get(0).getFinalResultHandValue();
        playersClone.removeIf(player -> (player.getFinalResultHandValue() != winningHandValue));

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
        System.out.println("\n" + playersClone);

        if (playersClone.size() > 1)
            return new Player("\ntie");
        else
            System.out.print("\nWinning Player: ");
        return playersClone.get(0);
    }

    private void checkHighCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getHighCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getHighCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                }
            }
        }
    }

    private void checkHighestPlayerDealtCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getHighestPlayerDealtCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getHighestPlayerDealtCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                }
            }
        }
    }

    private void checkLowestPlayerDealtCard(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {
            int tempHighest = playersClone.get(i).getLowestPlayerDealtCard().getCardValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getLowestPlayerDealtCard().getCardValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                }
            }
        }
    }

    private void checkPairValue(List<Player> playersClone) {
        for (int i = 0; i < playersClone.size(); i++) {

            int tempHighest = playersClone.get(i).getPairValue();
            for (int j = 1; j < playersClone.size(); j++) {
                if (playersClone.get(j).getPairValue() < tempHighest) {
                    playersClone.remove(j);
                    i--;
                    break;
                }
            }
        }
    }
}

