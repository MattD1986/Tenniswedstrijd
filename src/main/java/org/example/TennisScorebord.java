package org.example;

import java.util.Optional;

public class TennisScorebord {

    private Player player1;
    private Player player2;
    private Optional<Player> spelerMetVoordeel;

    public TennisScorebord(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.spelerMetVoordeel = Optional.empty();
    }


    public void addPoint(Player player){
        if (applyAdvantage()){
            performAdvantageRules(player);
        } else {
            player.increaseMatch();
            performScoreUpdateChecks(player);
        }
    }

    private void performScoreUpdateChecks(Player player) {
        if (checkMatchWin(player)) {
            player.increaseGame();
            resetMatchValues();
        }

        if (checkSetWin(player)) {
            player.increaseSet();
            resetGameValues();
        }
    }

    private boolean checkSetWin(Player player) {
        return player.getGewonnenGame() >= 6 &&
                (player1.getGewonnenGame() - player2.getGewonnenGame() >= 2 || player2.getGewonnenGame() - player1.getGewonnenGame() >= 2);
    }

    private boolean checkMatchWin(Player player) {
        return player.getGamePuntenTelling() == 4;
    }

    private void resetMatchValues(){
        player1.setGamePuntenTelling(0);
        player2.setGamePuntenTelling(0);
    }

    private void resetGameValues(){
        player1.setGewonnenGame(0);
        player2.setGewonnenGame(0);
    }

    private boolean applyAdvantage(){
        return player1.getGamePuntenTelling() == 3 && player2.getGamePuntenTelling() == 3;
    }

    private void performAdvantageRules(Player player){
        if (spelerMetVoordeel.isEmpty()){
            spelerMetVoordeel = Optional.ofNullable(player);
        } else if (checkAdvantagePlayerEquality(player)) {
            player.increaseMatch();
            performScoreUpdateChecks(player);
            removeSpelerMetVoordeel();
        } else {
            removeSpelerMetVoordeel();
        }
    }

    private boolean checkAdvantagePlayerEquality(Player player){
        Optional<Player> input = Optional.ofNullable(player);
        return spelerMetVoordeel.equals(input);
    }

    private void removeSpelerMetVoordeel(){
        this.spelerMetVoordeel = Optional.empty();
    }

    public void returnScore(){
        System.out.println(player1.getNaam() + " - " + player2.getNaam() + ": " +
                player1.getGewonnenSet() + "(" + player1.getGewonnenGame() + ") - " +
                player2.getGewonnenSet() + "(" + player2.getGewonnenGame() + ")");
    }
}

