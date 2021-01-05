package modele.serializer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.score.Score;
import modele.score.TableauScore;

import java.io.*;
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
    public void SauvegarderDonnee(Score score) {
        try {

            FileWriter leWritter = new FileWriter(System.getProperty("user.dir")+"/src/data/scores.txt", true);


                String ligneFichier = score.toStringFile();
                leWritter.write("\n"+ligneFichier);
                leWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public TableauScore chargerDonnee() {
        TableauScore lesScores = new TableauScore();

        try {
            //String path = System.getProperty("user.dir");

            File file = new File(System.getProperty("user.dir")+"/src/data/scores.txt");
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