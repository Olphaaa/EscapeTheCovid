package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Launch;
import java.io.IOException;

/**
 * The type Game over view.
 */
public class GameOverView {

    /**
     * Affichage du score.
     */
    @FXML
    public javafx.scene.control.Label score;


    /**
     * Initialize.
     */
    public void initialize(){ score.textProperty().bind(PartieVue.m.scoreProperty());
    }

    /**
     * Affichage de la vue MainWindow au click du bouton
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void onRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }


}
