package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launch extends Application{
    @Override
    public void start(Stage pS) throws Exception{
        Parent container = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        pS.setScene(new Scene(container));
        pS.setTitle("Escape the Covid");
        pS.show();
    }
}
