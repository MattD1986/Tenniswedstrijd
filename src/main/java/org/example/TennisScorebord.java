package org.example;

public class TennisScorebord {

    private String sp1;
    private String sp2;
    private int setSp1;
    private int setSp2;
    private int gameSp1;
    private int gameSp2;
    private int TbSp1;
    private int TbSp2;
    private String spelSp1;
    private String spelSp2;
    private String setStand;

    /**
     * Constructor voor objects van class Scorebord
     */
    public TennisScorebord(String speler1, String speler2)
    {
        sp1 = speler1;
        sp2 = speler2;
        spelSp1="0";
        spelSp2="0";
        setStand="0-0";

    }

    public void puntToevoegen(String naamSpeler)
    {
        //controle op Tiebreak
        if(gameSp1==6&&gameSp2==6){
            if(naamSpeler.equals(sp1)){
                if(TbSp1>=6&&(TbSp2<=(TbSp1-2))){   //indien 2 punten verschil
                    setSp1++; //setwinst
                    spelSp1="0"; //reset van de spellen
                    spelSp2="0";
                    gameSp1=0;
                    gameSp2=0;
                    TbSp1=0;
                    TbSp2=0;
                }else{
                    TbSp1++;                        //anders TBpunt+1
                }
            }else if(TbSp2>=6&&(TbSp1<=(TbSp2-1))){
                setSp2++;    //setwinst
                spelSp1="0"; //reset van de spellen
                spelSp2="0";
                gameSp1=0;
                gameSp2=0;
                TbSp1=0;
                TbSp2=0;
            }else{
                TbSp2++;
            }

            //puntentelling bij spelletje - gebruik van string om "advantage" te verwerken
            //speler1
        }else if(naamSpeler.equals(sp1)){
            if(spelSp1.equals("0")){spelSp1="15";
            }else if(spelSp1.equals("15")){
                spelSp1="30";
            }else if(spelSp1.equals("30")){
                spelSp1="40";
            }else if(spelSp1.equals("adv")){
                gameSp1++;
                spelSp1="0"; //reset van de spellen
                spelSp2="0";
            }else if(spelSp2.equals("40")){
                spelSp1="adv"; //deuce!! : punt speler 1
            }else if(spelSp2.equals("adv")){
                spelSp2="40"; //deuce!! : speler 1 neemt voordeel weg van speler 1 (opnieuw Deuce)
            }else if(spelSp1.equals("40")){
                gameSp1++;
                spelSp1="0";
                spelSp2="0";
            }
            //speler2
        }else if(spelSp2.equals("0")){
            spelSp2="15";
        }else if(spelSp2.equals("15")){
            spelSp2="30";
        }else if(spelSp2.equals("30")){
            spelSp2="40";
        }else if(spelSp2.equals("adv")){
            gameSp2++;
            spelSp1="0"; //reset van de spellen
            spelSp2="0";
        }else if(spelSp1.equals("40")){
            spelSp2="adv"; //deuce!! : punt speler 2
        }else if(spelSp1.equals("adv")){
            spelSp1="40"; //deuce!! : speler 2 neemt voordeel weg van speler 1 (opnieuw Deuce)
        }else if(spelSp2.equals("40")){
            gameSp2++;
            spelSp1="0";
            spelSp2="0";
        }

        //winst set
        if(gameSp1>=6&&gameSp2<=(gameSp1-2)){
            setSp1++;
            gameSp1=0;
            gameSp2=0;
        }else if(gameSp2>=6&&gameSp1<=(gameSp2-2)){
            setSp2++;
            gameSp1=0;
            gameSp2=0;
        }
        updateSetstand();
    }

    public void updateSetstand()
    {
        setStand = setSp1 + "-" + setSp2;
    }

    public void eindScore()
    {
        System.out.println("De eindstand is " +setSp1+ "-" +setSp2);
    }
}

