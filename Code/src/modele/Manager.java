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


public class Manager implements InvalidationListener {
    public int nbKill;
    private int nivDiff;
    private int nbIA=1;
    private int nbProtection;
    private boolean up,down,left,right,space;

    private PersoPrincipal perso;
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
    public Carte getCarte() {return carte;}

    private CreateurEntite leCreateur = new CreateurSimple();
    private Carte carte = new Carte();
    private Boucleur leBoucleur = new BoucleurSimple();
    private Spawner leSpawner = new SpawnerSimple();
    private Collisionneur leCollisionneur = new CollisionneurSimple(carte,this);
    private Collisionneur leCollisionneurIA = new CollisionneurIA(carte,this);
    private Ramasseur leRamasseur = new RamasseurSimple(carte);
    private Deplaceur leDeplaceurSim = new DeplaceurSimple(leCollisionneur);
    private Deplaceur leDeplaceurIA = new DeplaceurIA((CollisionneurIA) leCollisionneurIA,carte);// todo voir s'il faut bien le ramasseur
    private SauvegarderFile leSerializer = new SauvegarderFile();

    public Manager(){
    }

    public void startPartie(){
        perso = leCreateur.creerPersoPrincipal(carte);
        temps.set(String.valueOf(0));
        vie.setValue(String.valueOf(perso.getPv()));
        secondes.set(String.valueOf(0));
        score.set(String.valueOf(0));
        kill.set(String.valueOf(0));
        startBoucleur();
    }

    public void startBoucleur(){
        leBoucleur.addListener(this);
        leBoucleur.setActif(true);
        new Thread(leBoucleur).start();
    }

    public void stopBoucleur(){
        leBoucleur.setActif(false);
    }

    private int tps;//todo mettre ici pour éviter de déclarer un int a chaque boucle (a voir)
    @Override
    public void invalidated(Observable observable) {
        tps = Integer.parseInt(temps.get())+1;
        temps.set(String.valueOf(tps));

        if (tps%10 == 0){
            secondes.set(String.valueOf(Integer.parseInt(secondes.get())+1));
        }
        vie.set(String.valueOf(perso.getPv()));
        if((tps%50==0 && nbIA<=5+(nivDiff*3)-1)){
            leCreateur.creerIA(carte);
            ((IA)carte.getLesIA().get(0)).setInfect(true);
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
        if (tps%20==0 && nbProtection<1 && !perso.isEquiped()){
            nbProtection = 1;
            leSpawner.spawnProtection((CreateurSimple) leCreateur, carte);
        }
        leDeplaceurIA.deplacerIA();
    }
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

    public ObservableList<Entite> getListeEntite() {return carte.getLesEntites();}

    public void testRealesed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP){up = false;}
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT){left = false;}
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN){down = false;}
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT){right = false;}
        if(k.getCode() == KeyCode.SPACE){space = false;}
        touche();
    }
    public void testPressed(KeyEvent k){
        if(k.getCode() == KeyCode.Z || k.getCode() == KeyCode.UP){up = true;}
        if(k.getCode() == KeyCode.Q || k.getCode() == KeyCode.LEFT){left = true;}
        if(k.getCode() == KeyCode.S || k.getCode() == KeyCode.DOWN){down = true;}
        if(k.getCode() == KeyCode.D || k.getCode() == KeyCode.RIGHT){right = true;}
        if(k.getCode() == KeyCode.SPACE){space = true;}
        touche();
    }
    private void touche(){
        leDeplaceurSim.deplacerPersonnage(up,down,right,left,space,perso);
    }

    public void supprIA(IA ia) {
        kill.set(String.valueOf(Integer.parseInt(kill.get())+1));
        carte.supprimerEntites(ia);
        nbIA--;
    }

    public Collisionneur getLeCollisionneur() {
        return leCollisionneur;
    }

}
