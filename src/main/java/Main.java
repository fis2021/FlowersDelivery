
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("pagina_login.fxml")));

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(root, 725, 490));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
