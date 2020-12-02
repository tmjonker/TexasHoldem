package com.tmjonker.texasholdem.gamecontroller;

import com.tmjonker.texasholdem.dealer.Dealer;
import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.playingcards.DealerDeck;

public class GameController {

    public GameController() {

    }

    public void startGame() {

        Player player1 = new Player();

        Dealer dealer = new Dealer();
        dealer.dealCards();
        dealer.dealFlop();
        dealer.dealTurn();
        dealer.dealRiver();
        dealer.determineWinner();
    }
}
