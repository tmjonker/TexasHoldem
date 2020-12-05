package com.tmjonker.texasholdem.player;

import com.tmjonker.texasholdem.playingcards.Card;
import com.tmjonker.texasholdem.playingcards.PlayerHand;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> playerDealtCards;
    private List<Card> tableCards;
    private List<Card> totalPlayerHand = new ArrayList<>();
    private boolean bigBlind;
    private boolean smallBlind;

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
    }

    public void determineHandResult() {

        totalPlayerHand.addAll(tableCards);
        totalPlayerHand.addAll(playerDealtCards);

        PlayerHand playerHand = new PlayerHand(totalPlayerHand);

        System.out.println(playerHand.checkStraight());
    }

    public List<Card> getTotalPlayerHand() {
        return totalPlayerHand;
    }
}
