package modele.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class NiveauDifficulte {
    private final IntegerProperty nivDifficulte = new SimpleIntegerProperty();
    public Integer getDifficulteProperty(){return nivDifficulte.get();}
    public IntegerProperty NiveauDifficulteProperty(){return nivDifficulte;}
    public void setDifficulteProperty(Integer nivDiff){this.nivDifficulte.set(nivDiff);}

    public NiveauDifficulte(int niv){
        this.nivDifficulte.set(niv);
    }
}
