package FD.Controller;

import FD.Servicii.ProdusS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdaugaController {
    @FXML
    public TextField numeprodus;

    @FXML
    private TextField pretprodus;
    @FXML
    private TextField detalii;
    @FXML
    private Button BAdauga;

    public void AdaugaP(ActionEvent actionEvent) throws IOException {
        ProdusS.addProduse(numeprodus.getText(),pretprodus.getText(),detalii.getText());
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_admin.fxml"));
        Stage scene= (Stage) BAdauga.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,770,540));

    }
}
