package modele;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modele.boucleur.Boucleur;
import modele.boucleur.BoucleurIA;
import modele.boucleur.BoucleurSimple;
import modele.collisionneur.Collisionneur;
import modele.collisionneur.CollisionneurSimple;
import modele.createur.CreateurEntite;
import modele.createur.CreateurSimple;
import modele.deplaceur.Deplaceur;
import modele.deplaceur.DeplaceurSimple;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;


public class Manager implements InvalidationListener {
    public int nbKill;
    private int nivDiff;
    private int nbIA;
    private int nbProtection = 0;
    public PersoPrincipal perso;

    private StringProperty temps = new SimpleStringProperty();
        public String getTemps() {return temps.get();}
        public StringProperty tempsProperty() {return temps;}
        public void setTemps(String temps) {this.temps.set(temps);}

    private StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){return pseudo.get();}
        public void setPseudo(String pseudo){this.pseudo.set(pseudo);}
        public StringProperty pseudoProperty(){return pseudo;}

    private StringProperty vie = new SimpleStringProperty();
        public String getVie(){return vie.get();}
        public void setVie(String vie){this.vie.set(vie);}
        public StringProperty vieProperty(){return vie;}


    public int getNivDiff() {return nivDiff;}
    public void setNivDiff(int i) {this.nivDiff = i;}

    public CreateurEntite getLeCreateur() {return leCreateur;}
    public Carte getCarte() {return carte;}

    private CreateurEntite leCreateur = new CreateurSimple();
    private Carte carte = new Carte();
    private Boucleur leBoucleur = new BoucleurSimple();
    private Spawner leSpawner = new SpawnerSimple();
    private Collisionneur leCollisionneur = new CollisionneurSimple(carte,this);
    private Ramasseur leRamasseur = new RamasseurSimple(carte);
    private Deplaceur leDeplaceur = new DeplaceurSimple(leCollisionneur, leRamasseur);
    private Deplaceur leDeplaceurIA = new DeplaceurIA(leCollisionneur, leRamasseur);// todo voir s'il faut bien le ramasseur
    public Manager(){
        perso = leCreateur.creerPersoPrincipal(carte);
        temps.set(String.valueOf(0));
        vie.setValue(String.valueOf(perso.getPv()));
    }

    public void startBoucleur(){
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
        vie.set(String.valueOf(perso.getPv()));
        if((tps%1==0 && nbIA<=5+(nivDiff*3)-1) && nbIA <1){
            leCreateur.creerIA(carte);
            nbIA++;
        }
        if (perso.getPv()==0){
            //todo faire en sorte d'afficher la page game over une fois la partie terminée
            stopBoucleur();
        }
    }

    public ObservableList<Entite> getListeEntite() {return carte.getLesEntites();}


    private boolean up,down,left,right;

    public void touche(){
        if (up)
        {
            leDeplaceur.deplacerHaut(perso);
        }
        if (down){
            leDeplaceur.deplacerBas(perso);
        }
        if (left){
            leDeplaceur.deplacerGauche(perso);
        }
        if(right){
            leDeplaceur.deplacerDroit(perso);
        }
    }
    public void testRealesed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP) up = false;
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT) left = false;
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN) down = false;
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT) right = false;
        touche();
    }
    public void testPressed(KeyEvent k){

        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP) up = true;
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT) left = true;
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN) down = true;
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT) right = true;
        touche();
    }

    public Collisionneur getLeCollisionneur() {
        return leCollisionneur;
    }


}
