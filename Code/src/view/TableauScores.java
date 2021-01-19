package view;

import data.Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import launch.Launch;
import modele.score.CellScore;
import modele.score.Score;
import modele.score.TableauScore;

import  javafx.scene.control.ListView;
import modele.serializer.ChargeurFile;

import java.io.IOException;
import java.io.Serializable;

/**
 * The type Tableau scores.
 */
public class TableauScores implements Serializable {
    @FXML
    private ListView listeScores;

    private Stub stub = new Stub();

    private TableauScore tabScore = stub.creerTableau();

    /**
     * Initialisation.
     */
    public void initialize(){
        ChargeurFile leSerializer = new ChargeurFile();
        TableauScore scoreList;
        //scoreList = leSerializer.chargerDonnee();
        //listeScores.itemsProperty().bind(scoreList.lesScoresProperty());

        listeScores.itemsProperty().bind(tabScore.lesScoresProperty());
        listeScores.setCellFactory((param)->new CellScore());
//// equivalent
//        listeScores.setCellFactory(new Callback<ListView, ListCell>() {
//            @Override
//            public ListCell call(ListView listView) {
//                return new ListCell();
//            }
//        });

    }

    @FXML
    private void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }
}
