package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Launch;

import java.io.IOException;

/**
 * Main window.
 */
public class MainWindow {
    /**
     * Affichage de la vue Information au click du bouton
     *
     * @param actionEvent the action event
     */
    @FXML
    private void onInformations(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/Informations.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }
    /**
     * Affichage de la vue Tableau Score au click du bouton
     *
     * @param actionEvent the action event
     */
    @FXML
    private void onTabScore(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/TableauScores.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }
    /**
     * Affichage de la vue Setup Partie au click du bouton
     *
     * @param actionEvent the action event
     */
    @FXML
    private void onNewGame(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/SetupPartie.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }
}
