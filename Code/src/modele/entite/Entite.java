package modele.entite;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Position;

import java.awt.*;

public abstract class Entite {
    private Position p;
    private String image;
    private ImageView imView;

    public ImageView getImView() {
        return imView;
    }

    public void setImView(ImageView imView) {
        this.imView = imView;
    }

    public float getpositionX() {
        return this.p.getX();
    }

    public float getpositionY() {
        return this.p.getY();
    }

    public Position getPosition(){
        return this.p;
    }

    public void setPPerso(Position p) { //todo voir si on peux faire une méthode setP differente pour le Personnage et le Rocher
        this.p = p;
        this.imView.setX(p.getX());
        this.imView.setY(p.getY());
    }
    public void setP(Position p){
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
