package FD.Controller;

import FD.Exceptii.CampuriNecompletate;
import FD.Exceptii.LiteraMare;
import FD.Exceptii.NumeIncorect;
import FD.Servicii.ClientS;
import FD.Utilizatori.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InregistrareController{

    @FXML
    private Label registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private Button logButton;

    public void handleRegisterAction() {

        try{
            ClientS.addUser(usernameField.getText(), passwordField.getText(),emailField.getText(),addressField.getText(),phoneField.getText());
            registrationMessage.setText("Cont creat cu Succes!");
            handleLogAction();
        }catch(CampuriNecompletate e){
            registrationMessage.setText(e.getMessage());
        }catch(NumeIncorect ee)
        {
            registrationMessage.setText(ee.getMessage());
        }catch(LiteraMare eee)
        {
            registrationMessage.setText(eee.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void handleLogAction() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_login.fxml"));
        Stage scene= (Stage) logButton.getScene().getWindow();
        scene.setScene(new Scene(root,720,490));
        scene.setFullScreen(false);
    }
}

