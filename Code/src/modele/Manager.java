package modele;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.boucleur.Boucleur;
import modele.boucleur.BoucleurSimple;
import modele.createur.CreateurEntite;
import modele.createur.CreateurSimple;
import modele.deplaceur.Deplaceur;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;
import view.PartieVue;
import view.SetupPartie;


public class Manager implements InvalidationListener {
    public int nbKill;
    private int nivDiff;
    public PersoPrincipal perso;

    private StringProperty temps = new SimpleStringProperty();
        public String getTemps() {return temps.get();}
        public StringProperty tempsProperty() {return temps;}
        public void setTemps(String temps) {this.temps.set(temps);}

    private StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){return pseudo.get();}
        public void setPseudo(String pseudo){this.pseudo.set(pseudo);}
        public StringProperty pseudoProperty(){return pseudo;}


    public int getNivDiff() {return nivDiff;}
    public void setNivDiff(int i) {this.nivDiff = i;}

    public CreateurEntite getLeCreateur() {return leCreateur;}
    public Carte getCarte() {return carte;}

    private CreateurEntite leCreateur = new CreateurSimple();
    private Carte carte = new Carte();
    private Boucleur leBoucleur = new BoucleurSimple();
    private Spawner leSpawner = new SpawnerSimple();


    public Manager(){
        leCreateur.creerPersoPrincipal(carte);

        temps.set(String.valueOf(0));

        leBoucleur.addListener(this);
        leBoucleur.setActif(true);
        new Thread(leBoucleur).start();
    }

    public void stopBoucleur(){
        leBoucleur.setActif(false);
    }

    @Override
    public void invalidated(Observable observable) {
        int tps= Integer.parseInt(temps.get())+1;
        temps.set(String.valueOf(tps));
        leCreateur.creerIA(carte);
    }

    public ObservableList<Entite> getListeEntite() {return carte.getLesEntites();}

    // DEPLACEMENT
    private boolean up,down,left,right;
    public void touche(KeyEvent k){
        Deplaceur d = new Deplaceur();
        if (up)
        {
            d.deplacerHaut(perso);
        }
        if (down){
            d.deplacerBas(perso);
        }
        if (left){
            d.deplacerGauche(perso);
        }
        if(right){
            d.deplacerDroit(perso);
        }
    }
    public void testRealesed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP) up = false;
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT) left = false;
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN) down = false;
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT) right = false;
        touche(k);
    }
    public void testPressed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP) up = true;
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT) left = true;
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN) down = true;
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT) right = true;
        touche(k);
    }


}
