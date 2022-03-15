package com.tmjonker.texasholdem.winninghandevaluator;

import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.player.PlayerHand;
import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class HandEvaluator {

    private final int MAX_CARDS_HAND = 5;

    private Player player;
    private List<Card> totalPlayerHand;
    private Card highCard;
    private List<Card> flushHand = new ArrayList<>();
    private final List<Card> reducedHand;
    private int pairCounter = 0;
    private int pairValue = 0;
    private boolean threeOfAKind = false;

    public HandEvaluator(Player player) {
        this.player = player;
        totalPlayerHand = player.getTotalPlayerHand();
        Collections.sort(totalPlayerHand);
        reducedHand = new ArrayList<>(totalPlayerHand);
    }

    public Card determineHighestPlayerDealtCard(List<Card> dealtCards) {
        Collections.sort(dealtCards);
        return dealtCards.get(0);
    }

    public void determineHighCard() {
        Collections.sort(totalPlayerHand);
        highCard = totalPlayerHand.get(0);
    }

    public boolean checkFlush() {

        int runningTotal = 0;

        sortBySuit();

        for (int i = 0; i < totalPlayerHand.size() - 1; i++) {
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

        System.out.println(highCard);
        highCard = flushHand.get(0);

        return runningTotal == 60;
    }

    public boolean checkStraight() {

        int runningTotal = 0;

        for (int i = 0; i < totalPlayerHand.size() - 1; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue - 1)
                runningTotal++;
            else if (nextCardValue == currentCardValue) ;
            else {
                runningTotal = 0;
            }
            if (runningTotal == 4) {
                highCard = totalPlayerHand.get(i-3);
                break;
            }
        }

        return runningTotal == 4;
    }

    public boolean checkFourOfAKind() {

        int runningTotal = 0;

        Collections.sort(totalPlayerHand);

        for (int i = 0; i < totalPlayerHand.size() - 1; i++) {
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

        for (int i = 0; i < totalPlayerHand.size() - 1; i++) {
            int currentCardValue = totalPlayerHand.get(i).getCardValue();
            int nextCardValue = totalPlayerHand.get(i + 1).getCardValue();

            if (nextCardValue == currentCardValue)
                runningTotal++;
            else runningTotal = 0;

            if (runningTotal == 2) {
                threeOfAKind = true;
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
                if (!threeOfAKind && pairCounter == 0)
                    highCard = reducedHand.get(i);
                else
                    pairValue = currentCardValue * 2;
                reducedHand.removeIf(card -> card.getCardValue() == currentCardValue);
                break;
            }
        }

        pairCounter++;

        return runningTotal == 1;
    }

    public void determineHandResult() {

        if (checkFlush()) {
            if (checkRoyalFlush())
                player.setFinalResultHand(Hand.ROYAL_FLUSH);
            else if (checkStraight())
                player.setFinalResultHand(Hand.STRAIGHT_FLUSH);
            else
                player.setFinalResultHand(Hand.FLUSH);
        } else if (checkFourOfAKind())
            player.setFinalResultHand(Hand.FOUR_OF_A_KIND);
        else if (checkStraight())
            player.setFinalResultHand(Hand.STRAIGHT);
        else if (checkThreeOfAKind()) {
            if (checkTwoOfAKind())
                player.setFinalResultHand(Hand.FULL_HOUSE);
            else
                player.setFinalResultHand(Hand.THREE_OF_A_KIND);
        } else if (checkTwoOfAKind()) {
            if (checkTwoOfAKind())
                player.setFinalResultHand(Hand.TWO_PAIR);
            else
                player.setFinalResultHand(Hand.PAIR);
        } else {
            determineHighCard();
            player.setFinalResultHand(Hand.HIGH_CARD);
        }
        player.setHighCard(highCard);
    }

    public void setFlushHand(List<Card> flushHand) {
        this.flushHand = flushHand;
    }

    private void sortBySuit() {
        totalPlayerHand.sort(Comparator.comparing(Card::getCardSuit).thenComparing(Card::getCardValue).reversed());
    }

    public Card getHighCard() {
        return highCard;
    }

    public int getPairValue() {
        return pairValue;
    }

    public Player getPlayer() {
        return player;
    }
}
