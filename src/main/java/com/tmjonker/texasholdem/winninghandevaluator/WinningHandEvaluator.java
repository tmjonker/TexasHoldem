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
                if (playersClone.get(i).getHighestPlayerDealtCard().getCardValue()
                        > playersClone.get(i+1).getHighestPlayerDealtCard().getCardValue()) {
                    playersClone.remove(i+1);
                    i--;
                }
            }

            for (int i = 0; i < playersClone.size() - 1; i++) {
                if (winningHandValue == 5 || winningHandValue == 2) {
                    if (playersClone.get(i).getPairValue()
                            > playersClone.get(i+1).getPairValue()) {
                        playersClone.remove(i+1);
                        i--;
                    }
                }
            }
        }

        if (playersClone.size() > 1)
            return new Player("Tie");
        else {
            winningPlayer = playersClone.get(0);
            return winningPlayer;
        }
    }
}
