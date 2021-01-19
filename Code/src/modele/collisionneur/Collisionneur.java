package modele.collisionneur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import modele.Carte;
import modele.Manager;
import modele.entite.personnages.IA;

public abstract class Collisionneur {

    /**
     * Classe mère du Collisionneur:
     * Elle permet de savoir lorsque l'on rentre en contact avec un rocher, une IA ou une Protection
     * Elle à deux propriété qui sont la hauteur et la largeur qui permette de connaître la taille de la fenêtre.
     */

    private DoubleProperty width = new SimpleDoubleProperty();
        public double getWidth() {return width.get();}
        public DoubleProperty widthProperty() {return width;}
        public void setWidth(double width) {this.width.set(width);}

    private DoubleProperty height = new SimpleDoubleProperty();
        public double getHeight() {return height.get();}
        public DoubleProperty heightProperty() {return height;}
        public void setHeight(double height) {this.height.set(height);}

    protected Carte laCarte;
    protected Manager leManager;


    public Collisionneur(Carte laCarte, Manager m){
        this.laCarte = laCarte;
        this.leManager = m;
    }

    //Est-ce que l'on peut avancer dans la direction souhaitée ? Cette fonction répond à la question
    public abstract boolean canMove(double x, double y);

    //Cette fonction permet de savoir si nous somme en collision avec une IA ou une Protection
    public abstract boolean isPresent(double x, double y);

    //Cette fonction permet de savoir si une IA se situe dans le rayon d'attaque du personnage.
    public abstract IA isPresentAttaq(double x, double y);
}
