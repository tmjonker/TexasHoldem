package com.tmjonker.texasholdem.playingcards;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerHand {

    private final int MAX_CARDS_HAND = 5;
    private final int TOTAL_CARD_HAND;

    private List<Card> totalPlayerHand;

    private Card highCard;

    private List<Card> flushHand = new ArrayList<>();

    private List<Card> reducedHand;


    public PlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
        TOTAL_CARD_HAND = totalPlayerHand.size();
        reducedHand = new ArrayList<>(totalPlayerHand);
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
                flushHand = totalPlayerHand
                        .stream()
                        .filter(card -> card.getCardSuit()==currentCardSuit)
                        .collect(Collectors.toList());
                break;
            }
        }

        return runningTotal == 4;
    }

    public boolean checkRoyalFlush() {

        int runningTotal = 0;

        Collections.sort(flushHand);

        for (int i = 0; i < MAX_CARDS_HAND; i++) {
            int currentCardValue = flushHand.get(i).getCardValue();
            runningTotal += currentCardValue;
        }

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
                reducedHand.removeIf(card -> card.getCardValue() == currentCardValue);
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

            if (nextCardValue == currentCardValue) {
                runningTotal++;

            } else runningTotal = 0;

            if (runningTotal == 1) {
                reducedHand.removeIf(card -> card.getCardValue() == currentCardValue);
                break;
            }
        }

        return runningTotal == 1;
    }

    private void sortBySuit() {
        totalPlayerHand.sort(Comparator.comparing(Card::getCardSuit).thenComparing(Card::getCardValue).reversed());
    }
}
