package FD.Controller;

import FD.Exceptii.NumeIncorect;
import FD.Exceptii.ParolaIncorecta;
import FD.Servicii.ClientS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label Status;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button logButton;
    @FXML
    private Button regButton;



   public void inregistrare() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_inregistrare.fxml"));

   public void handleRegistrationView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));

        Stage scene= (Stage) logButton.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,725,490));
    }

    public void  handleLoginAction() throws IOException, NumeIncorect, ParolaIncorecta {
        ClientS.userExists(usernameField.getText(),passwordField.getText());
        //   logMessage.setText("Successful log in");
        if(ClientS.checkIsAdmin(usernameField.getText())==true)
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin_main_page.fxml"));
            Stage scene= (Stage) logButton.getScene().getWindow();
            scene.setTitle("Admin");
            scene.setScene(new Scene(root,720,490));
            scene.setResizable(true);
            //scene.setMinHeight(1080);
            //scene.setMinWidth(1920);
            //scene.setMaxHeight(1080);
            //scene.setMaxWidth(1920);
            //scene.setTitle("Client");
            //scene.setFullScreen(true);


        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("client_main_page.fxml"));
            Stage scene= (Stage) logButton.getScene().getWindow();
            scene.setScene(new Scene(root,720,490));
            scene.setResizable(true);
            //  scene.setMinHeight(1080);
            // scene.setMinWidth(1920);
            // scene.setMaxHeight(1080);
            //scene.setMaxWidth(1920);
            //scene.setTitle("Client");
            //scene.setFullScreen(true);

        }

    }

}
