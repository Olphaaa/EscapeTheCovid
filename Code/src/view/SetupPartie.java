package view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launch.Launch;

import java.io.IOException;

public class SetupPartie {
    public static Stage game = Launch.fenetrePrincipale;

    @FXML
    private static ChoiceBox<String> choiceDifficulty;
    @FXML
    public javafx.scene.control.TextField saisieSurnom;

    @FXML
    public void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.getScene().setRoot(container);
    }

    @FXML
    public void clickStart(ActionEvent actionEvent) throws IOException {
        game.getIcons().add(new Image("images/icone.png"));
        game.setTitle("Escape the Covid");
        Launch.fenetrePrincipale.close();
        //System.out.println(choiceDifficulty.getValue());
        Parent container = FXMLLoader.load(getClass().getResource("/PartieVue.fxml"));
        container.getStylesheets().add("css/style.css");
        game.setScene(new Scene(container));
        game.show();
    }
}
