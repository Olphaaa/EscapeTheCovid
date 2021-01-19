package modele.score;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;

/**
 * Tableau score.
 * Permet d'avoir une liste observable de scores
 */
public class TableauScore implements Serializable{

    private ObservableList<Score> listScoreObs = FXCollections.observableArrayList();

    private transient ListProperty<Score> lesScores = new SimpleListProperty<>(listScoreObs);

    /**
     * Get les scores.
     *
     * @return la liste observable de score
     */
    public ObservableList<Score> getLesScores() {return lesScores.get();}

    /**
     * Les scores property read only list property.
     *
     * @return la readonly liste de score
     */
    public ReadOnlyListProperty<Score> lesScoresProperty() {return lesScores;}
        private void setLesScores(ObservableList<Score> lesScores) {this.lesScores.set(lesScores);}


    /**
     * Get liste de scores observables.
     *
     * @return la liste des scores
     */
    public ObservableList<Score> getListScoreObs() {return listScoreObs;}

    /**
     * Ajouter score.
     *
     * @param score le socre a ajouter
     */
    public void ajouterScore(Score score) {
        listScoreObs.add(score);
    }
}
