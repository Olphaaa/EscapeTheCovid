package modele.score;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Score.
 * Classe qui définie ce qu'est un score
 */
public class Score implements Serializable {

    private transient IntegerProperty score = new SimpleIntegerProperty();
        public Integer getScore(){return score.get();}
        public IntegerProperty scoreProperty(){return score;}
        public void setScore(Integer score){this.score.set(score);}


    private transient StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){return pseudo.get();}
        public StringProperty pseudoProperty(){return pseudo;}
        public void setPseudo(String pseudo){this.pseudo.set(pseudo);}


    private LocalDateTime date;

    /**
     * Définition d'un socre
     * @param score
     * @param pseudo
     * @param date du jour
     */
    public Score (int score, String pseudo, LocalDateTime date){
        this.score.set(score);
        this.pseudo.set(pseudo);
        this.date = date;
    }

    @Override
    public String toString() {
        return pseudo.get() + ": " + score.get() + " fait le " + date.getDayOfMonth() + "/"+date.getMonth() + "/"+date.getYear() + "  "+date.getHour()+"h"+date.getHour();
    }

}
