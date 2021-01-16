package testConsole;

import modele.score.Score;
import modele.score.TableauScore;
import modele.serializer.Chargeur;
import modele.serializer.ChargeurFile;
import modele.serializer.Sauvegarder;
import modele.serializer.SauvegarderFile;

import java.time.LocalDateTime;

public class Console {
    public static void main(String[] args) throws Exception{
        Chargeur leChargeur = new ChargeurFile();
        Sauvegarder leSauvegardeur = new SauvegarderFile();

        TableauScore scoreList;

        /*scoreList = leChargeur.chargerDonnee();

        for (Score sc : scoreList.getListScoreObs()) {
            System.out.println(sc.toString());
        }*/

        Score sc = new Score(1245,"Xavier", LocalDateTime.of(2020, 11,23,0,0));
        Score sc2 = new Score(1245,"Jeremy", LocalDateTime.of(2020, 11,23,0,0));

        leSauvegardeur.SauvegarderDonnee(sc);
        leSauvegardeur.SauvegarderDonnee(sc2);


        scoreList = leChargeur.chargerDonnee();
        System.out.println("---");
        for (Score sco : scoreList.getListScoreObs()) {
            System.out.println(sco.toString());
        }
    }
}
