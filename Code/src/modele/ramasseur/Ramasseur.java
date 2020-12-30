package modele.ramasseur;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import modele.Carte;

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

    public Ramasseur(Carte laCarte){
        this.laCarte = laCarte;
    }
    public abstract boolean isPresent(double x, double y);

    public abstract void Ramasser();
}
