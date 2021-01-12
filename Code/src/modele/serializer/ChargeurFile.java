package modele.serializer;

import modele.score.Score;
import modele.score.TableauScore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ChargeurFile extends Chargeur {
    @Override
    public TableauScore chargerDonnee() {
        TableauScore lesScores = new TableauScore();

        try (var in = new ObjectInputStream(new FileInputStream("scores.dat"))) {
            while (true){
                if(in.readObject() == null){break;}
                lesScores.ajouterScore((Score) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lesScores;
    }
}