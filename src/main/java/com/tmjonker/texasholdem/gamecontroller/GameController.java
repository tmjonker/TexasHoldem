package com.tmjonker.texasholdem.gamecontroller;

import com.tmjonker.texasholdem.dealer.Dealer;
import com.tmjonker.texasholdem.player.Player;

public class GameController {

    public GameController() {

    }

    public void startGame() {

        Dealer dealer = new Dealer();
        dealer.dealCards();
        dealer.dealFlop();
        dealer.dealTurn();
        dealer.dealRiver();
        Player winningPlayer = dealer.determineWinningHand();

        System.out.println(winningPlayer.getFinalResultHand()
                + " "
                + winningPlayer.getHighCard() + " "
                + winningPlayer.getName());
        System.exit(0);
    }
}
