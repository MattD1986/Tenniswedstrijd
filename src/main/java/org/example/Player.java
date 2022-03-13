package org.example;

public class Player {

    public String naam;
    public int gewonnenSet;
    public int gewonnenGame;
    public int gamePuntenTelling;

    public Player(String naam) {
        this.naam = naam;
        this.gewonnenSet = 0;
        this.gewonnenGame = 0;
        this.gamePuntenTelling = 0;
    }

    public String getNaam() {
        return naam;
    }

    public int getGewonnenSet() {
        return gewonnenSet;
    }

    public int getGewonnenGame() {
        return gewonnenGame;
    }

    public int getGamePuntenTelling() {
        return gamePuntenTelling;
    }


    public void increaseSet(){
        gewonnenSet++;
    }

    public void setGewonnenGame(int gewonnenGame) {
        this.gewonnenGame = gewonnenGame;
    }

    public void setGamePuntenTelling(int gamePuntenTelling) {
        this.gamePuntenTelling = gamePuntenTelling;
    }

    public void increaseGame(){
        gewonnenGame++;
    }


    public void increaseMatch(){
        gamePuntenTelling++;
    }

    @Override
    public String toString() {
        return naam;
    }
}
