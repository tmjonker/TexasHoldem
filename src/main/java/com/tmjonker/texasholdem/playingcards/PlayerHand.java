package com.tmjonker.texasholdem.playingcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerHand {

    public boolean checkFlush(List<Card> totalPlayerHand) {

        int numSameSuit = 0;
        List<Card> discarded = new ArrayList<>();

        for (int i = 0; i < totalPlayerHand.size(); i++) {
            for (int j = i+1; i < totalPlayerHand.size(); i++) {
                if (totalPlayerHand.get(i).getCardSuit() == totalPlayerHand.get(j).getCardSuit()) {
                    numSameSuit++;
                }
            }
            if (numSameSuit >= 5) {
                break;
            } else if (i < totalPlayerHand.size()){
                discarded.add(totalPlayerHand.get(i));
                totalPlayerHand.remove(i);
            }
        }
        return numSameSuit >= 5;
    }
}
