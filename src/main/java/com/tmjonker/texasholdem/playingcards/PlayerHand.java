package com.tmjonker.texasholdem.playingcards;

import java.util.*;

public class PlayerHand {

    private final int MAX_CARDS_HAND = 5;
    private final int TOTAL_CARD_HAND;

    private List<Card> totalPlayerHand;


    public PlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
        Collections.sort(this.totalPlayerHand);
        TOTAL_CARD_HAND = totalPlayerHand.size();
    }

    public boolean checkFlush() {

        int runningTotal = 0;

        for (int i = 0; i < TOTAL_CARD_HAND; i++) {
            for (int j = i + 1; i < TOTAL_CARD_HAND; i++) {
                int currentCardSuit = totalPlayerHand.get(i).getCardSuit();
                int nextCardSuit = totalPlayerHand.get(j).getCardSuit();

                if (currentCardSuit == nextCardSuit)
                    runningTotal++;
            }
            if (runningTotal >= 5)
                break;
        }
        return runningTotal >= 5;
    }

    public boolean checkRoyalFlush() {

        int runningTotal = 0;

        for (int i = 0; i < MAX_CARDS_HAND; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            runningTotal += currentCardValue;
        }

        return runningTotal == 60;
    }

    public boolean checkStraight() {

        int runningTotal = 0;
        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {

            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue - 1)
                runningTotal++;
            else if (nextCardValue == currentCardValue) ;
            else
                runningTotal = 0;

            if (runningTotal >= 4)
                break;
        }

        return runningTotal >= 4;
    }

    private void sortBySuit() {
        totalPlayerHand.sort(Comparator.comparing(Card::getCardSuit).thenComparing(Card::getCardValue).reversed());
    }
}
