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
import modele.serializer.ChargeurFile;

import java.io.IOException;
import java.io.Serializable;

public class TableauScores implements Serializable {
    @FXML
    private ListView listeScores;

    Stub stub = new Stub();

    private TableauScore tabScore = stub.creerTableau();

    public void initialize(){
        ChargeurFile leSerializer = new ChargeurFile();
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
