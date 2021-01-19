package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import modele.Manager;
import view.PartieVue;


/**
 * Classe principale du jeu en effet c'est de la qu'est lancé l'application
 * Elle initilise nos premiers composants et notre première scène.
 */

public class Launch extends Application{
    public static Stage fenetrePrincipale;

    @Override
    public void start(Stage pS) throws Exception{
        fenetrePrincipale = pS;
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        Scene scene = new Scene(container);
        container.getStylesheets().add("css/style.css");
        pS.getIcons().add(new Image("images/icone.png"));
        pS.setScene(scene);
        pS.setTitle("Escape the Covid");
        pS.show();
    }

    @Override
    public void stop() throws Exception {
        PartieVue.m.stopBoucleur();
        super.stop();
    }
}
