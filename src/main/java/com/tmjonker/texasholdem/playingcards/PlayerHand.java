package com.tmjonker.texasholdem.playingcards;

import java.util.ArrayList;
import java.util.List;

public class PlayerHand {

    List<Card> playerHand = new ArrayList<>();

    public void updateHand(Card card) {

        playerHand.add(card);
    }
}
