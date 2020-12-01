package com.tmjonker.texasholdem.playingcards;

import java.util.*;

public class DealerDeck {

    private final int STARTING_CARD = 2;
    private final int TOTAL_CARDS_SUIT = 13;
    private final int TOTAL_SUITS = 4;

    private Random random = new Random();
    private Map<Integer, Card> dealtCards;
    private List<Card> tableCards;

    public DealerDeck() {

    }

    public List<Card> generateFlop() {

        Random random = new Random();
        dealtCards = new HashMap<>();
        tableCards = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + STARTING_CARD;

            Card tableCard = new Card(suit, value);

            if (dealtCards.containsValue(tableCard))
                i--;
            else {
                dealtCards.put(i, tableCard);
                tableCards.add(tableCard);
            }
        }
        System.out.println("The flop is: ");
        dealtCards.forEach((cardNumber, card) -> {
            System.out.print(card.toString() + " ");
        });
        return tableCards;
    }

    public Card generateTurnRiver() {

        Card dealtCard = new Card();

        for (int i = 0; i < 1; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + STARTING_CARD;

            dealtCard = new Card(suit, value);

            if (dealtCards.containsValue(dealtCard))
                i--;
            else {
                dealtCards.put(i, dealtCard);
                tableCards.add(dealtCard);
                System.out.print(dealtCard.toString() + " ");
            }
        }
        return dealtCard;
    }

    public PlayerHand dealPlayerCards() {

        PlayerHand playerHand = new PlayerHand();

        for (int i = 0; i < 2; i++) {
            int suit = random.nextInt(TOTAL_SUITS);
            int value = random.nextInt(TOTAL_CARDS_SUIT) + 2;

            Card tableCard = new Card(suit, value);

            if (dealtCards.containsValue(tableCard) && i > 0)
                i--;
            else {
                dealtCards.put(i, tableCard);
                playerHand.updateHand(tableCard);
            }
        }
        return playerHand;
    }
}
