package modele.score;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;


public class Score implements java.io.Serializable{

    private IntegerProperty score = new SimpleIntegerProperty();
        public Integer getScore(){return score.get();}
        public IntegerProperty scoreProperty(){return score;}
        public void setScore(Integer score){this.score.set(score);}


    private StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){return pseudo.get();}
        public StringProperty pseudoProperty(){return pseudo;}
        public void setPseudo(String pseudo){this.pseudo.set(pseudo);}

    //comment faire une propriété sur une date ?
    private LocalDateTime date;

    public Score (int score, String pseudo, LocalDateTime date){
        this.score.set(score);
        this.pseudo.set(pseudo);
        this.date = date;
    }

    @Override
    public String toString() {
        return pseudo.get() + ": " + score.get() + " fait le " + date.getDayOfMonth() + "/"+date.getMonth() + "/"+date.getYear() + "  "+date.getHour()+":"+date.getHour();
    }

    public String toStringFile(){
        String hour;
        String minutes;

        if(this.date.getHour()<10){hour = "0"+this.date.getHour();}
        else{hour = String.valueOf(this.date.getHour());}

        if(this.date.getHour()<10){minutes = "0"+this.date.getMinute();}
        else{minutes = String.valueOf(this.date.getMinute());}

        return this.getScore() +";"+this.getPseudo()+";"+this.date.getYear()+"-"+this.date.getMonth().getValue() + "-"+this.date.getDayOfMonth()+ " "+hour+":"+minutes;
    }

    public LocalDateTime getDate() {
        return this.date;
    }
}
