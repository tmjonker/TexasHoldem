package main;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bridge extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        Random random = new Random();

        Map<Integer, Card> deck = new HashMap<>();

        for (int i = 0; i < 3; i++) {

            int suit = random.nextInt(4);
            int value = random.nextInt(13) + 2;

            Card tableCard = new Card(suit, value);

            if (deck.containsValue(tableCard)) {
                i--;
            } else {
                deck.put(i, tableCard);
            }
        }

        System.out.println("The flop is: ");

        deck.forEach((cardNumber, card) -> {
            System.out.print(card.toString() + " ");
        });

        System.out.println("");

        System.out.println("Your cards: ");
    }
}
