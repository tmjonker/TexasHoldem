package com.tmjonker.texasholdem.player;

import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.Hand;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> playerDealtCards;
    private List<Card> tableCards;
    private List<Card> totalPlayerHand = new ArrayList<>();
    private boolean bigBlind;
    private boolean smallBlind;
    private PlayerHand playerHand;
    private Hand finalResultHand;
    private int finalResultHandValue;

    public Player(String name) {
        setName(name);
    }

    public Player(List<Card> totalPlayerHand) {
        this.totalPlayerHand = totalPlayerHand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Card> getPlayerDealtCards(){
        return playerDealtCards;
    }

    public void setTableCards(List<Card> tableCards) {
        this.tableCards = tableCards;
        createTotalPlayerHand();
    }

    public void createTotalPlayerHand() {

        totalPlayerHand.addAll(tableCards);
        totalPlayerHand.addAll(playerDealtCards);
    }

    public Card getHighCard() {
        return playerHand.getHighCard();
    }

    public Card getHighestPlayerDealtCard() { return playerHand.determineHighestPlayerDealtCard(playerDealtCards);}

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

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }
}
