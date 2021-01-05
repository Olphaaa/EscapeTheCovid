package view;

import data.Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Launch;
import modele.score.TableauScore;

import  javafx.scene.control.ListView;
import modele.serializer.Serializer;
import modele.serializer.SerializerFile;

import java.io.IOException;

public class TableauScores {
    @FXML
    private ListView listeScores;

    Stub stub = new Stub();

    private TableauScore tabScore = stub.creerTableau();

    public void initialize(){
        Serializer leSerializer = new SerializerFile();
        TableauScore scoreList;
        scoreList = leSerializer.chargerDonnee();
        listeScores.itemsProperty().bind(scoreList.lesScoresProperty());
    }

    @FXML
    public void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }
}
