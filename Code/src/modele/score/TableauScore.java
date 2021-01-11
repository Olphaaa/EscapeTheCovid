package modele.score;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class TableauScore implements Serializable{

    //private ObservableList<Score> listeScore; // new ?
    private ObservableList<Score> listScoreObs = FXCollections.observableArrayList();

    private transient ListProperty<Score> lesScores = new SimpleListProperty<>(listScoreObs);
        public ObservableList<Score> getLesScores() {return lesScores.get();}
        public ReadOnlyListProperty<Score> lesScoresProperty() {return lesScores;}
        private void setLesScores(ObservableList<Score> lesScores) {this.lesScores.set(lesScores);}


    public ObservableList<Score> getListScoreObs() {return listScoreObs;}

    public void ajouterScore(Score score) {
        listScoreObs.add(score);
    }
}
