package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import launch.Launch;
import modele.Manager;
import modele.entite.Rocher;

import java.util.Timer;
import java.util.TimerTask;


public class PartieVue{

    @FXML
    public Button startButton;
    @FXML
    public Label kill;
    @FXML
    public Label temps;
    @FXML
    public BorderPane map;
    private Integer i=0;


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

        tps.scheduleAtFixedRate(task,1000,1000);

    }

    Timer tps = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            i++;
            System.out.println("second="+i);
        }
    };

    private void changeTemps() {
        temps.setText(i.toString());
    }

}
