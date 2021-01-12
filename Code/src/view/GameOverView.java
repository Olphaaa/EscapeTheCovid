package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launch.Launch;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverView {

    @FXML
    public javafx.scene.control.Label score;



    public void initialize(){
        //score.setText(PartieVue.);
        score.textProperty().bind(PartieVue.m.scoreProperty());
    }

    public void onRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.setScene(new Scene(container));
    }


}
