package modele;

import modele.entite.Entite;

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

    public void deplacerHaut(Entite e){
        e.setP(futurHaut(e));
    }

    public void deplacerBas(Entite e){
        e.setP(futurBas(e));
    }

    public void deplacerGauche(Entite e){
        e.setP(futurGauche(e));
    }

    public void deplacerDroit(Entite e){
        e.setP(futurDroit(e));
    }
}
