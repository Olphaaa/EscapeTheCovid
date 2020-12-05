package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class Launch extends Application{
    public static Stage fenetrePrincipale;

    @Override
    public void start(Stage pS) throws Exception{
        fenetrePrincipale = pS;
        Parent container = FXMLLoader.load(getClass().getResource("/SetupPartie.fxml"));
        Scene scene = new Scene(container);
        container.getStylesheets().add("css/style.css");
        pS.getIcons().add(new Image("images/icone.png"));
        pS.setScene(scene);
        pS.setTitle("Escape the Covid");
        pS.show();

    }
}
