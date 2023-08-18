import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Principal extends Application {
	@Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/visao/TelaPrincipal.fxml"));
            Scene scene = new Scene(root);                       
            stage.setScene(scene); 
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}