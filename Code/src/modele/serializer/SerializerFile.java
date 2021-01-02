package modele.serializer;

import javafx.collections.ObservableList;
import modele.score.Score;

import java.io.File;

public class SerializerFile extends Serializer{
    @Override
    public void SauvegarderDonnee(ObservableList<Score> score) {
        super.SauvegarderDonnee(score);
    }

    @Override
    public ObservableList<Score> chargerDonnee() {
        File file = new File("../data/scores.txt");
    }
}
