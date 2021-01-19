package modele.serializer;

import modele.score.Score;
import modele.score.TableauScore;
import java.io.*;
/**
 * Classe fille de Chargeur
 * Elle permet de charger un tableau de score à partir d'un fichier binaire.
 */
public class ChargeurFile extends Chargeur {



    @Override
    public TableauScore chargerDonnee(){
        TableauScore lesScores = new TableauScore();

        try{
            File test=new File("scores.bin");
            if (test.createNewFile()) {
                System.out.println("fichier crée");
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try (var in = new ObjectInputStream(new FileInputStream("scores.bin"))) {
            while(in.available() > 0){
                var sc = (Score) in.readObject();
                lesScores.ajouterScore(sc);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lesScores;
    }
}