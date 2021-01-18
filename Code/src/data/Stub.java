package data;

import modele.score.Score;
import modele.score.TableauScore;
import java.time.LocalDateTime;
import java.time.Month;

public class Stub {
    public TableauScore creerTableau(){
        TableauScore retour = new TableauScore();
            retour.ajouterScore(new Score(1245,"Xavier", LocalDateTime.of(2020,Month.APRIL,23,15,30)));
            retour.ajouterScore(new Score(1245,"Xavier",LocalDateTime.of(2020,Month.APRIL,23,0,0)));
            retour.ajouterScore(new Score(1245,"Patrick",LocalDateTime.of(2019,Month.SEPTEMBER,17,0,0)));
            retour.ajouterScore(new Score(1245,"Paul",LocalDateTime.of(2020,Month.AUGUST,04,0,0)));
            retour.ajouterScore(new Score(1245,"Michel",LocalDateTime.of(2019,11,30,0,0)));
        return retour;
    }
}
