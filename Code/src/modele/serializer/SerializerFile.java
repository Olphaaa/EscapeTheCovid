package modele.serializer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class SerializerFile extends Serializer {
    @Override
    public void SauvegarderDonnee(ObservableList<Score> score) {
        super.SauvegarderDonnee(score);
    }

    @Override
    public TableauScore chargerDonnee() {
        TableauScore lesScores = new TableauScore();

        try {
            String path = System.getProperty("user.dir");

            File file = new File(path+"/src/data/scores.txt");
            Scanner leScanner = new Scanner(file);
            while (leScanner.hasNextLine()) {
                String data = leScanner.nextLine();
                String[] tabScoreSplit = data.split(";");
                
                int scoreFichier = Integer.parseInt(tabScoreSplit[0]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateFichier = LocalDateTime.parse(tabScoreSplit[2], formatter);


                Score score = new Score(scoreFichier,tabScoreSplit[1], dateFichier);
                lesScores.ajouterScore(score);
            }
            leScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lesScores;
    }
}