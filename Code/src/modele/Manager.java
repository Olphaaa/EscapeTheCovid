package modele;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import launch.Launch;
import modele.boucleur.Boucleur;
import modele.boucleur.BoucleurSimple;
import modele.collisionneur.Collisionneur;
import modele.collisionneur.CollisionneurIA;
import modele.collisionneur.CollisionneurSimple;
import modele.createur.CreateurEntite;
import modele.createur.CreateurSimple;
import modele.deplaceur.Deplaceur;
import modele.deplaceur.DeplaceurIA;
import modele.deplaceur.DeplaceurSimple;
import modele.entite.Entite;
import modele.entite.personnages.IA;
import modele.entite.personnages.PersoPrincipal;
import modele.ramasseur.Ramasseur;
import modele.ramasseur.RamasseurSimple;
import modele.score.Score;
import modele.serializer.SauvegarderFile;
import modele.spawner.Spawner;
import modele.spawner.SpawnerSimple;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;


/**
 * Manager.
 */
public class Manager implements InvalidationListener {
    public int nbKill;
    private int nivDiff;
    private int nbIA;
    private int nbProtection;
    private boolean up,down,left,right,space;

    private PersoPrincipal perso;

    /**
     * Get perso perso principal.
     *
     * @return the perso principal
     */
    public PersoPrincipal getPerso(){
        return perso;
    }

    private StringProperty secondes = new SimpleStringProperty();
        public String getSecondes() {return secondes.get();}
        public StringProperty secondesProperty() {return secondes;}
        public void setSecondes(String cptTemps) {this.secondes.set(cptTemps);}

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

    private StringProperty score = new SimpleStringProperty();
        public String getScore() {return score.get();}
        public StringProperty scoreProperty() {return score;}
        public void setScore(String score) {this.score.set(score);}

    private StringProperty kill = new SimpleStringProperty();
        public String getKill() {return kill.get();}
        public StringProperty killProperty() {return kill;}
        public void setKill(String kill) {this.kill.set(kill);}

    public int getNivDiff() {return nivDiff;}
    public void setNivDiff(int i) {this.nivDiff = i;}
    public CreateurEntite getLeCreateur() {return leCreateur;}

    /**
     * Get carte.
     *
     * @return la carte
     */
    public Carte getCarte() {return carte;}

    private CreateurEntite leCreateur = new CreateurSimple();
    private Carte carte = new Carte();
    private Boucleur leBoucleur = new BoucleurSimple();
    private Spawner leSpawner = new SpawnerSimple();
    private Collisionneur leCollisionneur = new CollisionneurSimple(carte,this);
    private Collisionneur leCollisionneurIA = new CollisionneurIA(carte,this);
    //private Ramasseur leRamasseur = new RamasseurSimple(carte);
    private Deplaceur leDeplaceurSim = new DeplaceurSimple(leCollisionneur);
    private Deplaceur leDeplaceurIA = new DeplaceurIA((CollisionneurIA) leCollisionneurIA,carte);
    private SauvegarderFile leSerializer = new SauvegarderFile();

    /**
     * Instanciation du Manager.
     */
    public Manager(){
    }

    /**
     * Debut de la partie
     */
    public void startPartie(){
        perso = leCreateur.creerPersoPrincipal(carte);
        temps.set(String.valueOf(0));
        vie.setValue(String.valueOf(perso.getPv()));
        secondes.set(String.valueOf(0));
        score.set(String.valueOf(0));
        kill.set(String.valueOf(0));
        startBoucleur();
        leDeplaceurSim = new DeplaceurSimple(leCollisionneur);
        leDeplaceurIA = new DeplaceurIA((CollisionneurIA) leCollisionneurIA,carte);
        //leBoucleur = new BoucleurSimple();
    }

    /**
     * Début du boucleur
     */
    public void startBoucleur(){
        leBoucleur.addListener(this);
        leBoucleur.setActif(true);
        new Thread(leBoucleur).start();
    }

    /**
     * Met fin au boucleur
     */
    public void stopBoucleur(){
        leBoucleur.setActif(false);
    }
    /**
     * variable tps pour gérer le temps
     */
    private int tps;

    /**
     * Code executé a chaque tour de boucle
     * @param observable Objet observable
     */
    @Override
    public void invalidated(Observable observable) {
        tps = Integer.parseInt(temps.get())+1;
        temps.set(String.valueOf(tps));

        if (tps%10 == 0){
            secondes.set(String.valueOf(Integer.parseInt(secondes.get())+1));
        }
        vie.set(String.valueOf(perso.getPv()));
        if((tps%30==0 && nbIA<=5+(nivDiff*3)-1)){
            leCreateur.creerIA(carte);
            //((IA)carte.getLesIA().get(0)).setInfect(true);
            nbIA++;
        }

        if ( perso.getPv()<=0){
            perso.setPv(0);
            score.set(String.valueOf(Integer.parseInt(score.get())+tps * 10+Integer.parseInt(kill.get())*6));
            try {
                partiePerdue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (perso.getPv() <= 3 && perso.isEquiped()){
            perso.desequipe();
            nbProtection = 0;
        }
        if (tps%100==0 && nbProtection<1 && !perso.isEquiped()){
            nbProtection = 1;
            leSpawner.spawnProtection((CreateurSimple) leCreateur, carte);
        }
        leDeplaceurIA.deplacerIA();
    }

    /**
     * Permet de réinitialiser une partie
     * Ne fonctionne pas
     */
    private void reinit(){
        stopBoucleur();
        carte.supprimerToutEntites();
    }

    /**
     * Affichage de la vue GameOver dès la partie terminée
     */
    @FXML
    private void partiePerdue() throws IOException {
        stopBoucleur();
        String pseudoScore;
        if(this.getPseudo() == null){
            pseudoScore = "Joueur";
        }else{
            pseudoScore = this.getPseudo();
        }
        Score sc = new Score(Integer.parseInt(this.getScore()),pseudoScore, LocalDateTime.now());
        leSerializer.SauvegarderDonnee(sc);

        Parent container = FXMLLoader.load(getClass().getResource("/GameOverView.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }

    /**
     * get La liste d'entité
     *
     * @return la liste d'entités
     */
    public ObservableList<Entite> getListeEntite() {return carte.getLesEntites();}

    /**
     * Met les valeurs de la direction en fonciton des touches relachées
     *
     * @param k l'évenement du clavier
     */
    public void testRealesed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP){up = false;}
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT){left = false;}
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN){down = false;}
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT){right = false;}
        if(k.getCode() == KeyCode.SPACE){space = false;}
        touche();
    }
    /**
     * Met les valeurs de la direction en fonciton des touches appuyées
     *
     * @param k l'évenement du clavier
     */
    public void testPressed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP){up = true;}
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT){left = true;}
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN){down = true;}
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT){right = true;}
        if(k.getCode() == KeyCode.SPACE){space = true;}
        touche();
    }
    /**
     * Execute le déplacement du Personnage Princpal une fois une touche activée
     */
    private void touche(){
        leDeplaceurSim.deplacerPersonnage(up,down,right,left,space,perso);
    }

    /**
     * Supprime une IA lors de l'attaque
     *
     * @param ia IA en question
     */

    public void supprIA(IA ia) {
        kill.set(String.valueOf(Integer.parseInt(kill.get())+1));
        carte.supprimerEntites(ia);
        nbIA--;
    }

    /**
     * get le collisionneur
     * @return le Collisionneur
     */
    public Collisionneur getLeCollisionneur() {
        return leCollisionneur;
    }

}
