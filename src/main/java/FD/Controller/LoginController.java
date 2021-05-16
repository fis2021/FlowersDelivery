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
        Stage scene= (Stage) regButton.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,725,490));
    }

    public void  handleLoginAction() throws IOException, NumeIncorect, ParolaIncorecta {
        try
        {
            ClientS.userExists(usernameField.getText(),passwordField.getText());
            //   logMessage.setText("Successful log in");
            if(ClientS.checkIsAdmin(usernameField.getText())==true)
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_admin.fxml"));
                Stage scene= (Stage) logButton.getScene().getWindow();
                scene.setTitle("Admin");
                scene.setScene(new Scene(root,800,550));
                scene.setResizable(true);


            }
            else
            {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_client.fxml"));
                Stage scene= (Stage) logButton.getScene().getWindow();
                scene.setScene(new Scene(root,780,510));
                scene.setResizable(true);


            }


        }
        catch(NumeIncorect e)
        {
             Status.setText("Numele si parola nu corespund!");

        }catch(ParolaIncorecta e)
        {
            Status.setText("Numele si parola nu corespund!");
        }
    }

}
