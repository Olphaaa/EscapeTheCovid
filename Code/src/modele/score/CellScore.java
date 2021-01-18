package modele.score;

import javafx.scene.control.ListCell;

public class CellScore extends ListCell<Score> {
    @Override
    protected void updateItem(Score score, boolean b) {
        super.updateItem(score, b);
        if (score != null){
            textProperty().setValue(score.toString());
        }
    }
}
