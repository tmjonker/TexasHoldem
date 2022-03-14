package com.tmjonker.texasholdem.dealer;

import com.tmjonker.texasholdem.playingcards.Card;

import java.util.*;

public class DealerDeck {
    
    private final int STARTING_CARD = 2;
    private final int TOTAL_CARDS_SUIT = 13;
    private final int TOTAL_SUITS = 4;

    private Random random = new Random();
    private List<Card> dealtCards = new ArrayList<>();
    private List<Card> tableCards = new ArrayList<>();

    public DealerDeck() {

    }

    public List<Card> generateFlop() {

        Random random = new Random();
        dealtCards = new ArrayList<>();
        tableCards = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + STARTING_CARD;

            Card tableCard = new Card(suit, value);

            if (dealtCards.contains(tableCard))
                i--;
            else {
                dealtCards.add(tableCard);
                tableCards.add(tableCard);
            }
        }

        return tableCards;
    }

    public Card generateTurnRiver() {

        Card dealtCard = new Card();

        for (int i = 0; i < 1; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + STARTING_CARD;

            dealtCard = new Card(suit, value);

            if (dealtCards.contains(dealtCard))
                i--;
            else {
                dealtCards.add(dealtCard);
                tableCards.add(dealtCard);
            }
        }
        return dealtCard;
    }

    public List<Card> dealPlayerCards() {

        List<Card> playerDealtCards = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + 2;

            Card playerCard = new Card(suit, value);

            if (dealtCards.contains(playerCard))
                i--;
            else {
                dealtCards.add(playerCard);
                playerDealtCards.add(playerCard);
            }
        }
        return playerDealtCards;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }
}
