package testConsole;

import data.Stub;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;
import modele.serializer.Serializer;
import modele.serializer.SerializerFile;
import modele.serializer.SerializerJSON;

import java.time.LocalDateTime;
import java.time.Month;

public class Console {
    public static void main(String[] args) throws Exception{
        Serializer leSerializer = new SerializerFile();
        Stub leStub = new Stub();

        TableauScore scoreList;

        scoreList = leSerializer.chargerDonnee();

        for (Score sc : scoreList.getListScoreObs()) {
            System.out.println(sc.toString());
        }

        Score sc = new Score(1245,"Xavier", LocalDateTime.of(2020, 11,23,0,0));
        leSerializer.SauvegarderDonnee(sc);

        scoreList = leSerializer.chargerDonnee();
        System.out.println("---");
        for (Score sco : scoreList.getListScoreObs()) {
            System.out.println(sco.toString());
        }
    }
}
