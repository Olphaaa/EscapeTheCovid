package modele.entite;
import javafx.scene.image.Image;
import modele.Position;

import java.awt.*;

public abstract class Entite {
    private Position p;
    private Image image;

    public float getpositionX() {
        return this.p.getX();
    }

    public float getpositionY() {
        return this.p.getY();
    }

    public void setP(Position p) {
        this.p = p;
    }

    public void setImage(String path){
        if ("perso".equals(path)) {
            this.image = new Image("/images/perso/ppRien.png");
        }
        this.image = new Image("images/perso/iaMalade.png");

    }
}
