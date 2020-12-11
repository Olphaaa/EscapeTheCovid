package view;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import launch.Launch;
import modele.Manager;
import modele.entite.Rocher;

import javax.swing.*;
import java.awt.event.KeyListener;


public class PartieVue{

    @FXML
    public Button startButton;
    @FXML
    public Label kill;
    @FXML
    public Label temps;
    @FXML
    public BorderPane map;

    private String pseudo;
    private int nivDifficulte = 3; //todo a changer une fois le niveau de diff importé

    private final Manager m = new Manager();
    private final Scene partie = Launch.fenetrePrincipale.getScene();

    public PartieVue(){

    }

    public void onStart(ActionEvent actionEvent) {
        ((Button)actionEvent.getSource()).getScene().setOnKeyPressed(e->{
            m.touche(e);
        });

        temps.setText("0");
        kill.setText("0");

        startButton.setVisible(false);
        m.spawnPerso();
        m.spawnRocher(nivDifficulte*10);
/*
        for (ImageView imageView: m.imVRocherList) {
            map.getChildren().add(imageView);
        }*/

        for(Rocher r : m.listRocher){
            map.getChildren().add(r.getImView());
        }
        //map.getChildren().add(m.imVPerso);
        map.getChildren().add(m.perso.getImView());
    }


}
