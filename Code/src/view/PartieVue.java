package view;

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
import modele.entite.personnages.IA;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;

import java.util.Iterator;


public class PartieVue{

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


    public static final Manager m = new Manager();

    public void initialize(){

        kill.setText("0");
        pseud.setText(m.getPseudo());
        temps.textProperty().bind(m.secondesProperty());
        vie.textProperty().bind(m.vieProperty());

        Spawner spw = new SpawnerSimple();
        spw.spawnRocher((CreateurSimple) m.getLeCreateur(),m.getCarte(),m.getNivDiff());


        for (Entite entite : m.getListeEntite()) {
            update(entite);
        }

        m.getListeEntite().addListener((ListChangeListener.Change<? extends Entite> change) -> {
           change.next();
            for (Entite e : change.getAddedSubList()) {
                System.out.println("je fait spawn : "+e.getClass());
                update(e);
            }
            for (Entite e : change.getList()){
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

        /*m.getListeIA().addListener((ListChangeListener.Change<? extends IA> change) -> {
                    change.next();
                    for (Entite e : change.getAddedSubList()) {
                        if (e instanceof IA) {
                            System.out.println("je fait spawn une IA");
                        }
                        update(e);
                    }

                    for (Entite e : change.getList()){
                        update(e);
                    }

                    for (Entite e : change.getRemoved()) {
                        map.getChildren().removeIf(leNode -> leNode.getUserData() == e);
                    }
                }
        );*/

        m.getLeCollisionneur().widthProperty().bind(map.widthProperty());
        m.getLeCollisionneur().heightProperty().bind(map.heightProperty());
    }

    public void onStart(ActionEvent actionEvent) {
        startButton.setVisible(false);
        ((Button)actionEvent.getSource()).getScene().setOnKeyPressed(m::testPressed);
        ((Button)actionEvent.getSource()).getScene().setOnKeyReleased(m::testRealesed);
        m.startPartie();
    }

    public void update(Entite e){
        ImageView entiteAAfficher = new ImageView();
        entiteAAfficher.setUserData(e);
        entiteAAfficher.setImage(new Image(getClass().getResource(e.getImage()).toExternalForm()));
        entiteAAfficher.layoutXProperty().bind(e.xProperty());
        entiteAAfficher.layoutYProperty().bind(e.yProperty());
        entiteAAfficher.setFitHeight(e.getMaxHeight());
        entiteAAfficher.setFitWidth(e.getMaxWidth());
        map.getChildren().add(entiteAAfficher);
    }
}
