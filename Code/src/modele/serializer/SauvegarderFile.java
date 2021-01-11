package modele.serializer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;

import java.io.*;


public class SauvegarderFile extends Sauvegarder {
    @Override
    public void SauvegarderDonnee(Score score) {
        TableauScore lesScores = new TableauScore();

        try (var in = new ObjectInputStream(new FileInputStream("scores.dat"))) {
            while (true){
                if(in.readObject() == null){break;}
                lesScores.ajouterScore((Score) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        lesScores.ajouterScore(score);

        try (var out = new ObjectOutputStream(new FileOutputStream("scores.dat"))) {
            for (Score sc: lesScores.getLesScores()) {
                out.writeObject(sc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}