package modele.serializer;

import javafx.collections.ObservableList;
import modele.score.Score;

public abstract class Serializer {

    public ObservableList<Score> chargerDonnee() {return null;}

    public void SauvegarderDonnee(ObservableList<Score> score){}

}
