package data;

import modele.tableauScore.Score;
import modele.tableauScore.TableauScore;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class Stub {
    public TableauScore creerTableau(){
        TableauScore retour = new TableauScore();
            retour.ajouterScore(new Score(1245,"Xavier",LocalDateTime.of(2020,Month.MAY,24,0,0)));
            retour.ajouterScore(new Score(1245,"Xavier",LocalDateTime.of(2020,Month.APRIL,23,0,0)));
            retour.ajouterScore(new Score(1245,"Patrick",LocalDateTime.of(2019,Month.SEPTEMBER,17,0,0)));
            retour.ajouterScore(new Score(1245,"Paul",LocalDateTime.of(2020,Month.AUGUST,04,0,0)));
            retour.ajouterScore(new Score(1245,"Michel",LocalDateTime.of(2019,Month.NOVEMBER,30,0,0)));
        return retour;
    }
}
