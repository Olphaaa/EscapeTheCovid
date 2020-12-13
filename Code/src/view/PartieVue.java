package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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




public class PartieVue{

    @FXML
    public Button startButton;
    @FXML
    public Label kill;
    @FXML
    public Label pseud;
    @FXML
    public Label temps;
    @FXML
    public BorderPane map;
    private Integer sec=0;


    private String pseudo;
    private int nivDifficulte = 3; //todo a changer une fois le niveau de diff importé

    public static final Manager m = new Manager();
    private final Scene partie = Launch.fenetrePrincipale.getScene();

    public PartieVue(){

    }


    public void onStart(ActionEvent actionEvent) {
        ((Button)actionEvent.getSource()).getScene().setOnKeyPressed(m::testPressed);
        ((Button)actionEvent.getSource()).getScene().setOnKeyReleased(m::testRealesed);
        temps.setText("0");
        kill.setText("0");
        pseud.setText(m.getPseudo());


        startButton.setVisible(false);
        m.spawnPerso();
        m.spawnRocher();


        for(Rocher r : m.listRocher){
            map.getChildren().add(r.getImView());
        }
        map.getChildren().add(m.perso.getImView());


        setTimer();
        spawnIA();
    }

    private void spawnIA() {
        Timeline tl = new Timeline( new KeyFrame( Duration.seconds(1), ev -> {
            if (sec%3 == 0){
                m.spawnIA();
                map.getChildren().add(m.ia.getImView());
            }
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }

    private void setTimer(){
        Timer tps = new Timer();
        Timeline tl = new Timeline( new KeyFrame( Duration.seconds(1), ev -> {
            sec ++;
            temps.setText(sec.toString());
            if (sec == 2){
                m.spawnProtection();
                map.getChildren().add(m.protection.getImView());
            }
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();


        /*
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sec++;
                //changeTemps(i);
                //m.spawnEquipement();
                if (sec == 2)
                {
                    try{
                        truc();
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(sec);
                }
            }
        };
        tps.scheduleAtFixedRate(task,1000,1000);*/
    }


}
