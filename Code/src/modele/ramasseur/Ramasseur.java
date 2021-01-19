package modele.ramasseur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import modele.Carte;

/**
 * Classe abstraite, mère du RamasseurSimple
 * Permt de définir les méthode a implémenter pour les classes fille
 */
public abstract class Ramasseur {
    private DoubleProperty width = new SimpleDoubleProperty();
    public double getWidth() {return width.get();}
    public DoubleProperty widthProperty() {return width;}
    public void setWidth(double width) {this.width.set(width);}

    private DoubleProperty height = new SimpleDoubleProperty();
    public double getHeight() {return height.get();}
    public DoubleProperty heightProperty() {return height;}
    public void setHeight(double height) {this.height.set(height);}

    protected Carte laCarte;

    /**
     * Instanciation du Ramasseur.
     *
     * @param laCarte la carte
     */
    public Ramasseur(Carte laCarte){
        this.laCarte = laCarte;
    }

    /**
     * Permet de savoir si une entité est présentes
     * @param x position
     * @param y position
     * @return true ou false si elle est présente ou non
     */
    public abstract boolean isPresent(double x, double y);

    /**
     * Permet de ramasser une Protection
     */
    public abstract void Ramasser();
}
