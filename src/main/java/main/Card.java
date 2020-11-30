package main;

import javafx.scene.image.Image;

import java.util.Objects;

public class Card {

    private Image cardImage;
    private int cardSuit;
    private int cardValue;

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
            suit = "Spade";
         else if (cardSuit == 1)
            suit = "Club";
         else if (cardSuit == 2)
            suit = "Diamond";
         else if (cardSuit == 3)
            suit = "Heart";

        if (cardValue > 10) {
            if (cardValue == 11)
                value = "Jack";
            else if (cardValue == 12)
                value = "Queen";
            else if (cardValue == 13)
                value = "King";
            else if (cardValue == 14)
                value = "Ace";
        }

        return value + ":" + suit;
    }
}
