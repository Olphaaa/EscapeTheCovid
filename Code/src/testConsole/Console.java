package testConsole;

import data.Stub;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;
import modele.serializer.Serializer;
import modele.serializer.SerializerFile;
import modele.serializer.SerializerJSON;

public class Console {
    public static void main(String[] args) throws Exception{
        Serializer leSerializer = new SerializerFile();
        Stub leStub = new Stub();

        TableauScore scoreList;

        scoreList = leSerializer.chargerDonnee();

        for (Score sc : scoreList.getListScoreObs()) {
            System.out.println(sc.toString());
        }
    }
}
