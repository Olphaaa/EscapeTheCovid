package modele.serializer;


import javafx.collections.ObservableList;
import modele.score.Score;

public class SerializerJSON extends Serializer {
    @Override
    public ObservableList<Score> chargerDonnee() {
        //JSONObject jsonObject = new JSONOject();
        return  super.chargerDonnee();
    }

    @Override
    public void SauvegarderDonnee(ObservableList<Score> score) {
        super.SauvegarderDonnee(score);
    }
}
