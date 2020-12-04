package view;

import data.Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Launch;
import modele.tableauScore.Score;
import modele.tableauScore.TableauScore;

import  javafx.scene.control.ListView;
import java.io.IOException;

public class TableauScores {
    @FXML
    private ListView listeScores;

    Stub stub = new Stub();

    private TableauScore tabScore = stub.creerTableau();

    public void initialize(){
        listeScores.itemsProperty().bind(tabScore.lesScoresProperty());
    }

    @FXML
    public void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }



}
