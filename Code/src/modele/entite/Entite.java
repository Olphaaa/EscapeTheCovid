package modele.entite;
import javafx.scene.image.Image;
import modele.Position;

import java.awt.*;

public abstract class Entite {
    private Position p;
    private String image;

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
            this.image = "/images/perso/ppRien.png";
        }else if ("rocher1".equals(path)){
            this.image="/images/rocher/rock1.png";
        }else if ("rocher2".equals(path)){
            this.image="/images/rocher/rock2.png";
        }else if ("rocher3".equals(path)){
            this.image= "/images/rocher/rock3.png";
        }else if ("rocher4".equals((path))){
            this.image = "/images/rocher/rock4.png";
        }
    }

    public String getImage() {
        return image;
    }

}
