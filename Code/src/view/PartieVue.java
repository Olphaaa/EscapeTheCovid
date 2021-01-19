package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modele.Manager;
import modele.createur.CreateurSimple;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;

import java.util.Iterator;


/**
 * Partie vue.
 */
public class PartieVue implements InvalidationListener{

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
    @FXML
    private Label vie;


    /**
     * The constant m.
     */
    public static Manager m = new Manager();

    /**
     * Initialize.
     */
    public void initialize(){
        kill.textProperty().bind(m.killProperty());
        pseud.setText(m.getPseudo());
        temps.textProperty().bind(m.secondesProperty());
        vie.textProperty().bind(m.vieProperty());

        Spawner spw = new SpawnerSimple();
        spw.spawnRocher((CreateurSimple) m.getLeCreateur(),m.getCarte(),m.getNivDiff());

        /*
        for (Entite entite : m.getListeEntite()) {
            update(entite);
        }
        */

        m.getListeEntite().addListener((ListChangeListener.Change<? extends Entite> change) -> {
           change.next();
            for (Entite e : change.getAddedSubList()) {
                update(e);
            }

            for (Entite e : change.getRemoved()) {
                Iterator<Node> unIterateur = map.getChildren().iterator();
                while (unIterateur.hasNext()) {
                    Node leNode = unIterateur.next();
                    if (leNode.getUserData() == e) {
                            unIterateur.remove();
                        }
                    }
                }
            }
        );

        m.getLeCollisionneur().widthProperty().bind(map.widthProperty());
        m.getLeCollisionneur().heightProperty().bind(map.heightProperty());
    }

    /**
     * On start.
     *
     * @param actionEvent the action event
     */
    public void onStart(ActionEvent actionEvent) {
        for (Entite entite : m.getListeEntite()) {
            update(entite);
        }


        startButton.setVisible(false);
        ((Button)actionEvent.getSource()).getScene().setOnKeyPressed(m::testPressed);
        ((Button)actionEvent.getSource()).getScene().setOnKeyReleased(m::testRealesed);
        m.startPartie();

        PersoPrincipal pp = m.getPerso();
        pp.addListener(this);
    }
    /**
     * invalidated, ce qui est executé a chaque beep du boucleur
     *
     * @param observable Objet observable
     */
    public void invalidated(Observable observable) {
        update(m.getPerso());
        m.getListeEntite().addListener((ListChangeListener.Change<? extends Entite> change) -> {
                    change.next();
                    for (Entite e : change.getAddedSubList()) {
                        update(e);
                    }


                    for (Entite e : change.getRemoved()) {
                        Iterator<Node> unIterateur = map.getChildren().iterator();
                        while (unIterateur.hasNext()) {
                            Node leNode = unIterateur.next();
                            if (leNode.getUserData() == e) {
                                unIterateur.remove();
                            }
                        }
                    }
                }
        );
    }

    /**
     * update.
     * Permet de mettre a jour l'affichage d'une entite
     *
     * @param e Entite en question
     */
    private void update(Entite e){
        ImageView entiteAffichee = new ImageView();
        entiteAffichee.setUserData(e);
        entiteAffichee.setImage(new Image(getClass().getResource(e.getImage()).toExternalForm()));
        entiteAffichee.layoutXProperty().bind(e.xProperty());
        entiteAffichee.layoutYProperty().bind(e.yProperty());
        entiteAffichee.setFitHeight(e.getMaxHeight());
        entiteAffichee.setFitWidth(e.getMaxWidth());
        map.getChildren().add(entiteAffichee);
    }
}
