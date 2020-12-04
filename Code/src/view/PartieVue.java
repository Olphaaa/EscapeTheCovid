package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launch.Launch;
import modele.Deplaceur;
import modele.Manager;
import modele.Position;
import modele.entite.personnages.PersoPrincipal;

import javafx.scene.input.KeyEvent;

public class PartieVue {

    @FXML
    public Button startButton;

    private String pseudo;
    private int nivDifficulte;

    Manager m = new Manager();
    Scene partie = SetupPartie.game.getScene();

    public void onStart(ActionEvent actionEvent) {
        startButton.setVisible(false);
        Manager.nvllePartie();
    }


    public void onAppuie(KeyEvent keyEvent){
        partie.addEventFilter(KeyEvent.KEY_PRESSED, key->{
            m.touche(key);
            startButton.setVisible(true);
        });
    }


}
