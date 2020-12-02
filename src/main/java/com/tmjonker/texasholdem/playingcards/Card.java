package com.tmjonker.texasholdem.playingcards;

import javafx.scene.image.Image;

public class Card implements Comparable<Card> {

    private Image cardImage;
    private int cardSuit;
    private int cardValue;

    public Card() {}

    public Card (int cardSuit, int cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public int getCardSuit() {
        return cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardSuit == card.cardSuit &&
                cardValue == card.cardValue;
    }

    @Override
    public String toString() {

        String suit = "";
        String value = Integer.toString(cardValue);

        if (cardSuit == 0)
            suit = "spades";
         else if (cardSuit == 1)
            suit = "clubs";
         else if (cardSuit == 2)
            suit = "diamonds";
         else if (cardSuit == 3)
            suit = "hearts";

        if (cardValue > 10) {
            if (cardValue == 11)
                value = "jack";
            else if (cardValue == 12)
                value = "queen";
            else if (cardValue == 13)
                value = "king";
            else if (cardValue == 14)
                value = "ace";
        }

        return value + ":" + suit;
    }

    @Override
    public int compareTo(Card o) {

        if (o.cardSuit == this.cardSuit)
            return 0;
        else if (o.cardSuit > this.cardSuit)
            return 1;
        else return -1;
    }
}
