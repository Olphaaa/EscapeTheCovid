package view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launch.Launch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SetupPartie {
    public static Stage game = Launch.fenetrePrincipale;

    @FXML
    private static ChoiceBox<String> choiceDifficulty;
    @FXML
    private static TextField surnomField;

    @FXML
    public void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }

    public void clickStart(ActionEvent actionEvent) throws IOException {
        game.getIcons().add(new Image("images/icone.png"));
        game.setTitle("Escape the Covid");
        Launch.fenetrePrincipale.close();

        Parent container = FXMLLoader.load(getClass().getResource("/PartieVue.fxml"));
        container.getStylesheets().add("css/style.css");
        game.setScene(new Scene(container));
        game.show();
    }
}
