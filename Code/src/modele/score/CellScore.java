package modele.score;

import javafx.scene.control.ListCell;

/**
 * Redefinition de ce qu'est une Cellule en héritant de ListCelle<Score>
 */
public class CellScore extends ListCell<Score> {
    /**
     * Permet de update une cellule en mettant le texte de celle-ci par le toString() d'un score
     * @param score
     * @param b boolean
     */
    @Override
    protected void updateItem(Score score, boolean b) {
        super.updateItem(score, b);
        if (score != null){
            textProperty().setValue(score.toString());
        }
    }
}
