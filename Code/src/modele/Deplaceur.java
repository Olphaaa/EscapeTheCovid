package modele;

import javafx.scene.image.ImageView;
import modele.entite.Entite;
import modele.entite.personnages.PersoPrincipal;


public class Deplaceur {
    public Position futurHaut(Entite e){
        return new Position(e.getpositionX()+3,e.getpositionY());
    }

    public Position futurBas(Entite e){
        return new Position(e.getpositionX()-3,e.getpositionY());
    }

    public Position futurGauche(Entite e){
        return new Position(e.getpositionX(),e.getpositionY()-3);
    }

    public Position futurDroit(Entite e){
        return new Position(e.getpositionX(),e.getpositionY()+3);
    }

    public void deplacerHaut(Entite e){ e.setPPerso(new Position(e.getpositionX(), e.getpositionY()-7)); }

    public void deplacerBas(Entite e){
        e.setPPerso(new Position(e.getpositionX(), e.getpositionY()+7));
    }

    public void deplacerGauche(Entite e){
        e.setPPerso(new Position(e.getpositionX()-7, e.getpositionY()));
    }

    public void deplacerDroit(Entite e){
        e.setPPerso(new Position(e.getpositionX()+7, e.getpositionY()));
    }
}
