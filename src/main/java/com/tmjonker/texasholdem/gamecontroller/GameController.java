package com.tmjonker.texasholdem.gamecontroller;

import com.tmjonker.texasholdem.playingcards.DealerDeck;

public class GameController {

    public GameController() {

    }

    public void dealFlop() {

        DealerDeck dealerDeck = new DealerDeck();
        dealerDeck.generateFlop();
        dealerDeck.generateTurnRiver();
        dealerDeck.generateTurnRiver();
    }
}
