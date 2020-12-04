package com.tmjonker.texasholdem.playingcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PlayerHand {

    private final int MAX_CARDS_HAND = 5;
    private final int TOTAL_CARD_HAND;

    private List<Card> totalPlayerHand;


    public PlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
        Collections.sort(this.totalPlayerHand);
        TOTAL_CARD_HAND = totalPlayerHand.size();
    }

    public boolean checkHand(List<Card> totalPlayerHand) {

        int runningTotal = 0;

        for (int i = 0; i < TOTAL_CARD_HAND; i++) {
            for (int j = i + 1; i < TOTAL_CARD_HAND; i++) {
                int currentCardSuit = totalPlayerHand.get(i).getCardSuit();
                int nextCardSuit = totalPlayerHand.get(j).getCardSuit();

                if (currentCardSuit == nextCardSuit)
                    runningTotal++;
            }
            if (runningTotal >= MAX_CARDS_HAND)
                break;
        }
        checkRoyalFlush();
        return runningTotal >= 5;
    }

    private boolean checkRoyalFlush() {

        int runningTotal = 0;

        for (int i = 0; i < MAX_CARDS_HAND; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            runningTotal += currentCardValue;
        }

        return runningTotal == 55;
    }

    private boolean checkStraight() {

        int runningTotal = 0;
        for (int i = 0; i < TOTAL_CARD_HAND; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            if (i != TOTAL_CARD_HAND - 1) {
                int nextCardValue = totalPlayerHand.get(i+1).getCardValue();
                if (nextCardValue == currentCardValue - 1)
                    runningTotal += 1;
                else break;
            }
        }
        return runningTotal >= 5;
    }
}
