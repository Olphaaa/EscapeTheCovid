package modele.serializer;


import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;

public class SerializerJSON extends Serializer {
    @Override
    public TableauScore chargerDonnee() {
        //JSONObject jsonObject = new JSONOject();
        return  super.chargerDonnee();
    }

    @Override
    public void SauvegarderDonnee(Score score) {
        super.SauvegarderDonnee(score);
    }
}
