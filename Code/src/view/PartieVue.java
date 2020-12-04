package view;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.input.KeyEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import modele.Manager;



public class PartieVue {

    @FXML
    public Button startButton;
    @FXML
    public Label kill;
    @FXML
    public Label temps;
    @FXML
    public BorderPane map;

    private String pseudo;
    private int nivDifficulte;

    private final Manager m = new Manager();
    private final Scene partie = SetupPartie.game.getScene();

    public void onStart(ActionEvent actionEvent) {
        partie.addEventHandler(KeyEvent.KEY_PRESSED, m::touche);
        temps.setText("0");
        kill.setText("0");

        startButton.setVisible(false);
        m.spawnPerso();
        map.getChildren().add(m.imV);
    }

    private void addListeners() {
        partie.addEventFilter(KeyEvent.ANY, e -> {
            partie.addEventFilter(KeyEvent.KEY_PRESSED, key->{
                m.touche(key);
                startButton.setVisible(true);

            });
        });
    }

}
