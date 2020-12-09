package com.tmjonker.texasholdem.playingcards;

import java.util.*;

public class PlayerHand {

    private final int MAX_CARDS_HAND = 5;
    private final int TOTAL_CARD_HAND;

    private List<Card> totalPlayerHand;

    private Card highCard;

    private int flushSuit = 0;
    private List<Card> flushHand = new ArrayList<>();

    private List<Card> reducedHand = new ArrayList<>(totalPlayerHand);


    public PlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
        System.out.println(totalPlayerHand);
        TOTAL_CARD_HAND = totalPlayerHand.size();
    }

    public boolean checkFlush() {

        int runningTotal = 0;

        sortBySuit();

        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {
            int currentCardSuit = totalPlayerHand.get(i).getCardSuit();
            int nextCardSuit = totalPlayerHand.get(i+1).getCardSuit();

            if (currentCardSuit == nextCardSuit)
                runningTotal++;
            else
                runningTotal = 0;

            if (runningTotal == 4) {
                flushSuit = currentCardSuit;
                break;
            }
        }
        return runningTotal == 4;
    }

    public boolean checkRoyalFlush() {

        int runningTotal = 0;

        totalPlayerHand.forEach(card -> {
            if (card.getCardSuit() == flushSuit) {
                flushHand.add(card);
            }
        });

        Collections.sort(flushHand);

        for (int i = 0; i < MAX_CARDS_HAND; i++) {
            int currentCardValue = flushHand.get(i).getCardValue();
            runningTotal += currentCardValue;
        }

        Collections.sort(flushHand);
        highCard = flushHand.get(0);

        return runningTotal == 60;
    }

    public boolean checkStraight() {

        int runningTotal = 0;

        Collections.sort(totalPlayerHand);

        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue - 1)
                runningTotal++;
            else if (nextCardValue == currentCardValue) ;
            else runningTotal = 0;

            if (runningTotal == 4) break;
        }

        highCard = totalPlayerHand.get(0);
        return runningTotal == 4;
    }
    public boolean checkStraightFlush() {

        int runningTotal = 0;

        Collections.sort(flushHand);

        for (int i = 0; i < flushHand.size() - 1; i++) {
            int currentCardValue = flushHand.get(i).getCardValue();
            int nextCardValue = flushHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue - 1)
                runningTotal++;
            else if (nextCardValue == currentCardValue) ;
            else runningTotal = 0;

            if (runningTotal == 4) break;
        }

        return runningTotal == 4;
    }

    public boolean checkFourOfAKind() {

        int runningTotal = 0;

        Collections.sort(totalPlayerHand);

        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue)
                runningTotal++;
            else runningTotal = 0;

            if (runningTotal == 3) {
                highCard = totalPlayerHand.get(i);
                break;
            }
        }

        return runningTotal == 3;
    }

    public boolean checkThreeOfAKind() {

        int runningTotal = 0;

        Collections.sort(totalPlayerHand);

        for (int i = 0; i < TOTAL_CARD_HAND - 1; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue)
                runningTotal++;
            else runningTotal = 0;

            if (runningTotal == 2) {
                reducedHand.remove(i);
                reducedHand.remove(i+1);
                reducedHand.remove(i-1);
                highCard = totalPlayerHand.get(i);
                break;
            }
        }

        return runningTotal == 2;
    }

    public boolean checkTwoOfAKind() {

        int runningTotal = 0;

        Collections.sort(reducedHand);

        for (int i = 0; i < reducedHand.size() -  1; i++) {
            int currentCardValue = reducedHand.get(i).getCardValue();
            int nextCardValue = reducedHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue)
                runningTotal++;
            else runningTotal = 0;

            if (runningTotal >= 1) {
                reducedHand.remove(reducedHand.get(i));
                reducedHand.remove(reducedHand.get(i+1));
                break;
            }
        }

        return runningTotal >= 1;
    }

    private void sortBySuit() {
        totalPlayerHand.sort(Comparator.comparing(Card::getCardSuit).thenComparing(Card::getCardValue).reversed());
    }
}
