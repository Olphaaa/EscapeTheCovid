package testConsole;

import data.Stub;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;
import modele.serializer.Serializer;
import modele.serializer.SerializerJSON;

public class Console {
    public static void main(String[] args) throws Exception{
        Serializer leSerializer = new SerializerJSON();
        Stub leStub = new Stub();
        TableauScore ts = leStub.creerTableau();
        ObservableList<Score> scoreList = ts.getListScoreObs();

        for(Score sc: scoreList) {
            System.out.println(sc.toString());
        }

        leSerializer.SauvegarderDonnee(scoreList);
    }
}
