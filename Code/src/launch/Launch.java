package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Launch extends Application{
    public static Stage fenetrePrincipale;

    @Override
    public void start(Stage pS) throws Exception{
        fenetrePrincipale = pS;
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        container.getStylesheets().add("css/style.css");
        pS.getIcons().add(new Image("ressource/images/icone.png"));
        pS.setScene(new Scene(container));
        pS.setTitle("Escape the Covid");
        pS.show();
    }
}
