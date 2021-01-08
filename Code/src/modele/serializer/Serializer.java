package modele.serializer;

import modele.score.Score;
import modele.score.TableauScore;

public abstract class Serializer {

    public TableauScore chargerDonnee() {return null;}

    public void SauvegarderDonnee(Score score){}

}
