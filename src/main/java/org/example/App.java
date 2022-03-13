package org.example;

public class App {

  public static void main(String[] args) {
    Player lisa = new Player("Lisa");
    Player matt = new Player("Matt");
    TennisScorebord scorebord = new TennisScorebord(lisa,matt);


    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);   //1-0

    scorebord.addPoint(matt);
    scorebord.addPoint(lisa); //15-15
    scorebord.addPoint(matt);
    scorebord.addPoint(lisa); //30-30
    scorebord.addPoint(lisa);
    scorebord.addPoint(matt); //40-40
    scorebord.addPoint(matt); // Matt ADV
    scorebord.addPoint(lisa); // no advantage
    scorebord.addPoint(lisa); // Lisa ADV
    scorebord.addPoint(lisa); // 2-0

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);  //3-0

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);  //4-0

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);  //5-0

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //5-1

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //5-2

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //5-3

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //5-4

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //5-5

    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);
    scorebord.addPoint(matt);  //6-5

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);   //6-6

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);

    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);
    scorebord.addPoint(lisa);   //8-6   ==>  set 1-0









    scorebord.returnScore();
  }
}