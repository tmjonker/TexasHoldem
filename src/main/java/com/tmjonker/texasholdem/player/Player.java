package com.tmjonker.texasholdem.player;

import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;
import com.tmjonker.texasholdem.playingcards.PlayerHand;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> playerDealtCards;
    private List<Card> tableCards;
    private List<Card> totalPlayerHand = new ArrayList<>();
    private boolean bigBlind;
    private boolean smallBlind;
    private PlayerHand playerHand;
    private Hand finalResultHand;
    private int finalResultHandValue;

    public Player() {}

    public Player(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
    }

    public void placeBet() {

    }

    public void check() {

    }

    public void fold() {

    }

    public void setPlayerHand(List<Card> playerDealtCards) {
        this.playerDealtCards = playerDealtCards;
    }

    public void setTableCards(List<Card> tableCards) {
        this.tableCards = tableCards;
        createTotalPlayerHand();
    }

    public void createTotalPlayerHand() {

        totalPlayerHand.addAll(tableCards);
        totalPlayerHand.addAll(playerDealtCards);
    }

    public Hand determineHandResult() {

        playerHand = new PlayerHand(totalPlayerHand);

        if (playerHand.checkFlush()) {
            if (playerHand.checkRoyalFlush())
                return Hand.ROYAL_FLUSH;
            else if (playerHand.checkStraightFlush())
                return Hand.STRAIGHT_FLUSH;
            else
                return Hand.FLUSH;
        } else if (playerHand.checkFourOfAKind())
            return Hand.FOUR_OF_A_KIND;
        else if (playerHand.checkStraight())
            return Hand.STRAIGHT;
        else if (playerHand.checkThreeOfAKind()) {
            if (playerHand.checkTwoOfAKind())
                return Hand.FULL_HOUSE;
            else
                return Hand.THREE_OF_A_KIND;
        } else if (playerHand.checkTwoOfAKind()) {
            if (playerHand.checkTwoOfAKind())
                return Hand.TWO_PAIR;
            else
                return Hand.PAIR;
        } else
            return Hand.HIGH_CARD;
    }

    public Card getHighCard() {
        return playerHand.getHighCard();
    }

    public void setFinalResultHand(Hand handResult) {
        finalResultHand = handResult;

        switch (handResult) {
            case ROYAL_FLUSH:
                    finalResultHandValue = 9;
                    break;
            case STRAIGHT_FLUSH:
                    finalResultHandValue = 8;
                    break;
            case FOUR_OF_A_KIND:
                    finalResultHandValue = 7;
                    break;
            case FULL_HOUSE:
                    finalResultHandValue = 6;
                    break;
            case FLUSH:
                    finalResultHandValue = 5;
                    break;
            case STRAIGHT:
                    finalResultHandValue = 4;
                    break;
            case THREE_OF_A_KIND:
                    finalResultHandValue = 3;
                    break;
            case TWO_PAIR:
                    finalResultHandValue = 2;
                    break;
            case PAIR:
                    finalResultHandValue = 1;
                    break;
            case HIGH_CARD:
                    finalResultHandValue = 0;
                    break;
        }
    }

    public Hand getFinalResultHand() {
        return finalResultHand;
    }

    public int getFinalResultHandValue() {
        return finalResultHandValue;
    }

    public List<Card> getTotalPlayerHand() {
        return totalPlayerHand;
    }

    public void setTotalPlayerHand(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
    }
}
