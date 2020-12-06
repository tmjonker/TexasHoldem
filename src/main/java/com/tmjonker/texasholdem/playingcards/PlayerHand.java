package com.tmjonker.texasholdem.playingcards;

import java.util.*;

public class PlayerHand {

    private final int MAX_CARDS_HAND = 5;
    private final int TOTAL_CARD_HAND;

    private List<Card> totalPlayerHand;


    public PlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
        sortBySuit();
        System.out.println(totalPlayerHand);
        TOTAL_CARD_HAND = totalPlayerHand.size();
    }

    public boolean checkFlush() {

        int runningTotal = 0;
        int flushSuit = 0;

        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {
            int currentCardSuit = totalPlayerHand.get(i).getCardSuit();
            int nextCardSuit = totalPlayerHand.get(i+1).getCardSuit();

            if (currentCardSuit == nextCardSuit)
                runningTotal++;
            else
                runningTotal = 0;

            if (runningTotal >= 4) {
                flushSuit = currentCardSuit;
                break;
            }
        }
        return runningTotal >= 4;
    }

    public boolean checkRoyalFlush(int flushSuit) {

        int runningTotal = 0;

        sortBySuit();

        List<Card> flushHand = new ArrayList<>();

        totalPlayerHand.forEach(card -> {
            if (card.getCardSuit() == flushSuit) {
                flushHand.add(card);
            }
        });

        for (int i = 0; i < TOTAL_CARD_HAND; i++) {
            int currentCardValue = flushHand.get(i).getCardValue();
            runningTotal += currentCardValue;
        }

        return runningTotal == 60;
    }

    public boolean checkStraight() {

        int runningTotal = 0;

        Collections.sort(this.totalPlayerHand);

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
