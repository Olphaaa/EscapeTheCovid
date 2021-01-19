package modele.serializer;

import modele.score.Score;
import modele.score.TableauScore;
import java.io.*;



public class SauvegarderFile extends Sauvegarder {

    @Override
    public void SauvegarderDonnee(Score score) {
        TableauScore lesScores = new TableauScore();

        /*try (var in = new ObjectInputStream(new FileInputStream("scores.bin"))) {
            while (in.available() > 0){
                lesScores.ajouterScore((Score) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
*/
        lesScores.ajouterScore(score);

        try (var out = new ObjectOutputStream(new FileOutputStream("scores.bin"))) {
            for (Score sc: lesScores.getLesScores()) {
                out.writeObject(sc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}