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

        Player winningPlayer = null;

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

            for (int i = 0; i < playersClone.size(); i++) {
                if (winningHandValue == 5 || winningHandValue == 2) {
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

        System.out.println(playersClone);

        if (playersClone.size() > 1)
            return new Player("tie");
        else
            System.out.print("\nWinning Player: ");
            return winningPlayer = playersClone.get(0);
    }
}
