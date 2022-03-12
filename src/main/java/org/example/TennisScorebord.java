package org.example;

public class TennisScorebord {

    private String player1;
    private String player2;
    private int wonSetPlayer1;
    private int wonSetPlayer2;
    private int wonGamePlayer1;
    private int wonGamePlayer2;
    private int tiebreakPlayer1;
    private int tiebreakPlayer2;
    private String currentGamePlayer1;
    private String currentGamePlayer2;
    private String setStand;

    /**
     * Constructor voor objects van class Scorebord
     */
    public TennisScorebord(String player1, String player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        currentGamePlayer1 ="0";
        currentGamePlayer2 ="0";
        setStand="0-0";
    }

    public void addPoint(String naamSpeler)
    {
        //controle op Tiebreak
        if(wonGamePlayer1 ==6&& wonGamePlayer2 ==6){
            if(naamSpeler.equals(player1)){
                if(tiebreakPlayer1 >=6&&(tiebreakPlayer2 <=(tiebreakPlayer1 -2))){   //indien 2 punten verschil
                    wonSetPlayer1++; //setwinst
                    currentGamePlayer1 ="0"; //reset van de spellen
                    currentGamePlayer2 ="0";
                    wonGamePlayer1 =0;
                    wonGamePlayer2 =0;
                    tiebreakPlayer1 =0;
                    tiebreakPlayer2 =0;
                }else{
                    tiebreakPlayer1++;                        //anders TBpunt+1
                }
            }else if(tiebreakPlayer2 >=6&&(tiebreakPlayer1 <=(tiebreakPlayer2 -1))){
                wonSetPlayer2++;    //setwinst
                currentGamePlayer1 ="0"; //reset van de spellen
                currentGamePlayer2 ="0";
                wonGamePlayer1 =0;
                wonGamePlayer2 =0;
                tiebreakPlayer1 =0;
                tiebreakPlayer2 =0;
            }else{
                tiebreakPlayer2++;
            }

            //puntentelling bij spelletje - gebruik van string om "advantage" te verwerken
            //speler1
        }else if(naamSpeler.equals(player1)){
            if(currentGamePlayer1.equals("0")){
                currentGamePlayer1 ="15";
            }else if(currentGamePlayer1.equals("15")){
                currentGamePlayer1 ="30";
            }else if(currentGamePlayer1.equals("30")){
                currentGamePlayer1 ="40";
            }else if(currentGamePlayer1.equals("adv")){
                wonGamePlayer1++;
                currentGamePlayer1 ="0"; //reset van de spellen
                currentGamePlayer2 ="0";
            }else if(currentGamePlayer2.equals("40")){
                currentGamePlayer1 ="adv"; //deuce!! : punt speler 1
            }else if(currentGamePlayer2.equals("adv")){
                currentGamePlayer2 ="40"; //deuce!! : speler 1 neemt voordeel weg van speler 1 (opnieuw Deuce)
            }else if(currentGamePlayer1.equals("40")){
                wonGamePlayer1++;
                currentGamePlayer1 ="0";
                currentGamePlayer2 ="0";
            }
            //speler2
        }else if(currentGamePlayer2.equals("0")){
            currentGamePlayer2 ="15";
        }else if(currentGamePlayer2.equals("15")){
            currentGamePlayer2 ="30";
        }else if(currentGamePlayer2.equals("30")){
            currentGamePlayer2 ="40";
        }else if(currentGamePlayer2.equals("adv")){
            wonGamePlayer2++;
            currentGamePlayer1 ="0"; //reset van de spellen
            currentGamePlayer2 ="0";
        }else if(currentGamePlayer1.equals("40")){
            currentGamePlayer2 ="adv"; //deuce!! : punt speler 2
        }else if(currentGamePlayer1.equals("adv")){
            currentGamePlayer1 ="40"; //deuce!! : speler 2 neemt voordeel weg van speler 1 (opnieuw Deuce)
        }else if(currentGamePlayer2.equals("40")){
            wonGamePlayer2++;
            currentGamePlayer1 ="0";
            currentGamePlayer2 ="0";
        }

        //winst set
        if(wonGamePlayer1 >=6&& wonGamePlayer2 <=(wonGamePlayer1 -2)){
            wonSetPlayer1++;
            wonGamePlayer1 =0;
            wonGamePlayer2 =0;
        }else if(wonGamePlayer2 >=6&& wonGamePlayer1 <=(wonGamePlayer2 -2)){
            wonSetPlayer2++;
            wonGamePlayer1 =0;
            wonGamePlayer2 =0;
        }
        updateSetstand();
    }

    public void updateSetstand()
    {
        setStand = wonSetPlayer1 + "-" + wonSetPlayer2;
    }



    public void displayScore()
    {
        System.out.println("De eindstand is " + wonSetPlayer1 + "-" + wonSetPlayer2 +
                "(" + wonGamePlayer1 + "-" + wonSetPlayer2 + ")" );
    }
}

