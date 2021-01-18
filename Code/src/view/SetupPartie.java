package view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import launch.Launch;
import java.io.IOException;



public class SetupPartie {
    private static Stage game = Launch.fenetrePrincipale;

    @FXML
    private TextField saisieSurnom;
    
    @FXML
    private ChoiceBox choiceDifficulty;

    public void initialize(){
        saisieSurnom.textProperty().bindBidirectional(PartieVue.m.pseudoProperty());
    }

    @FXML
    private void clickRetour(ActionEvent actionEvent) throws IOException {
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        Launch.fenetrePrincipale.getScene().setRoot(container);
    }

    @FXML
    private void clickStart(ActionEvent actionEvent) throws IOException {

        if (choiceDifficulty.getValue().equals("Masque + visière  (1)")){PartieVue.m.setNivDiff(1);}
        else if (choiceDifficulty.getValue().equals("Masque    (2)")){PartieVue.m.setNivDiff(2);}
        else{PartieVue.m.setNivDiff(3);}

        game.getIcons().add(new Image("images/icone.png"));
        game.setTitle("Escape the Covid");
        Launch.fenetrePrincipale.close();
        Parent container = FXMLLoader.load(getClass().getResource("/PartieVue.fxml"));
        container.getStylesheets().add("css/style.css");
        game.setScene(new Scene(container));
        game.show();
    }

}
