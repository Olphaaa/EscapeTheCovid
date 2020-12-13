package view;


import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launch.Launch;
import modele.partie.Partie;

import java.io.IOException;

public class SetupPartie {
    public static Stage game = Launch.fenetrePrincipale;

    //@FXML
    //public static ChoiceBox<String> choiceDifficulty;
    @FXML
    public TextField saisieSurnom;

    public ChoiceBox choiceDifficulty;

    public void initialize(){
        saisieSurnom.textProperty().bindBidirectional(PartieVue.m.pseudoProperty());
        //choiceDifficulty.itemsProperty().bind(PartieVue.m.niveauDiffProperty());
    }

    @FXML
    public void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.getScene().setRoot(container);
    }

    @FXML
    public void clickStart(ActionEvent actionEvent) throws IOException {
        System.out.println(choiceDifficulty.getValue());
        //PartieVue.m.nivDifficulte = getChoice(choiceDifficulty);

        if (choiceDifficulty.getValue().equals("Masque + visière  (1)"))
            PartieVue.m.setNivDiff(1);
        else if (choiceDifficulty.getValue().equals("Masque    (2)"))
            PartieVue.m.setNivDiff(2);
        else
            PartieVue.m.setNivDiff(3);

        game.getIcons().add(new Image("images/icone.png"));
        game.setTitle("Escape the Covid");
        Launch.fenetrePrincipale.close();
        Parent container = FXMLLoader.load(getClass().getResource("/PartieVue.fxml"));
        container.getStylesheets().add("css/style.css");
        game.setScene(new Scene(container));

        game.show();
    }

}
