package modele.serializer;

import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;

public abstract class Serializer {

    public TableauScore chargerDonnee() {return null;}

    public void SauvegarderDonnee(ObservableList<Score> score){}

}
