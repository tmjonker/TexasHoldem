package com.tmjonker.texasholdem.gamecontroller;

import com.tmjonker.texasholdem.dealer.Dealer;
import com.tmjonker.texasholdem.player.Player;
import com.tmjonker.texasholdem.winninghandevaluator.HandEvaluator;
import com.tmjonker.texasholdem.winninghandevaluator.WinningHandEvaluator;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final int NUMBER_PLAYERS = 8;

    private List<Player> players = new ArrayList<>();

    public GameController() {

    }

    public void generatePlayers() {

        for (int i=0; i < NUMBER_PLAYERS; i++) {
            Player player = new Player("p"+i);
            players.add(player);
        }
    }

    public void startGame() {

        generatePlayers();

        Dealer dealer = new Dealer(players);
        dealer.dealCards();
        dealer.dealFlop();
        dealer.dealTurn();
        dealer.dealRiver();

        HandEvaluator handEvaluator;
        for (Player p : players) {
            handEvaluator = new HandEvaluator(p);
            handEvaluator.determineHandResult();
        }

        WinningHandEvaluator winningHandEvaluator = new WinningHandEvaluator(players);

        Player winningPlayer = winningHandEvaluator.determineWinningHand();

        System.out.print("\nWinning Player: ");
        System.out.println(winningPlayer.getName());
        System.exit(0);
    }
}
