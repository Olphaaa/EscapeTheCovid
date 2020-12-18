package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import launch.Launch;
import modele.createur.CreateurSimple;
import modele.deplaceur.Deplaceur;
import modele.Manager;
import modele.entite.Entite;
import modele.entite.Rocher;
import modele.entite.personnages.IA;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;


import java.util.Timer;




public class PartieVue extends Launch {

    @FXML
    private Button startButton;
    @FXML
    private Label kill;
    @FXML
    private Label pseud;
    @FXML
    private Label temps;
    @FXML
    private Pane map;


    public static final Manager m = new Manager();

    public void initialize(){

        kill.setText("0");
        pseud.setText(m.getPseudo());
        temps.textProperty().bind(m.tempsProperty());
        Spawner spw = new SpawnerSimple();

        spw.spanwRocher((CreateurSimple) m.getLeCreateur(),m.getCarte(),m.getNivDiff());

        /*m.getListeEntite().addListener(new ListChangeListener<Entite>() {
            @Override
            public void onChanged(Change<? extends Entite> change) {
                change.getAddedSubList();
                change.next();
                change.getAddedSubList().
            }
        });*/

        for (Entite entite : m.getListeEntite()) {
            ImageView entiteAAfficher = new ImageView();
            entiteAAfficher.setImage(new Image(getClass().getResource(entite.getImage()).toExternalForm()));
            entiteAAfficher.layoutXProperty().bind(entite.xProperty());
            entiteAAfficher.layoutYProperty().bind(entite.yProperty());
            entiteAAfficher.setFitHeight(entite.getMaxHeight());
            entiteAAfficher.setFitWidth(entite.getMaxWidth());
            //System.out.println(entite.xProperty()+", "+entite.yProperty());
            map.getChildren().add(entiteAAfficher);
        }

        m.getListeEntite().addListener((ListChangeListener.Change<? extends Entite> change) -> {
            change.next();
            for (Entite e : change.getAddedSubList()) {
                ImageView entiteAAfficher = new ImageView();
                entiteAAfficher.setImage(new Image(getClass().getResource(e.getImage()).toExternalForm()));
                entiteAAfficher.layoutXProperty().bind(e.xProperty());
                entiteAAfficher.layoutYProperty().bind(e.yProperty());
                entiteAAfficher.setFitHeight(e.getMaxHeight());
                entiteAAfficher.setFitWidth(e.getMaxWidth());
                map.getChildren().add(entiteAAfficher);
            }
        }
        );
    }

    public void onStart(ActionEvent actionEvent) {
        ((Button)actionEvent.getSource()).getScene().setOnKeyPressed(m::testPressed);
        ((Button)actionEvent.getSource()).getScene().setOnKeyReleased(m::testRealesed);
    }
    @Override //todo ne fonctionne pas (il servirait a arreter le boucleur)
    public void stop() throws Exception {
        m.stopBoucleur();
        super.stop();
    }

/*
    private void deplacementIA(){
        Deplaceur d = new Deplaceur();
        Timeline depIA = new Timeline( new KeyFrame( Duration.seconds(0.1), ev -> {
            for (Entite ia: m.getListeEntite()) {
                if(ia.getX() < 45 ){d.deplacerDroit(ia);}
                else if(ia.getX() > 900 ){d.deplacerBas(ia);}

                else{d.deplacerHaut(ia);}

            }
        }));
        depIA.setCycleCount(Animation.INDEFINITE);
        depIA.play();
    }
*/
}
