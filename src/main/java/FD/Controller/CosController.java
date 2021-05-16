package FD.Controller;

import FD.Servicii.CosS;
import FD.Utilizatori.Produs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CosController {
    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> detalii;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnFinal;
    @FXML
    private Button btnLogout;
    @FXML
    private Label SL;

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        detalii.setCellValueFactory(new PropertyValueFactory<>("detalii"));
        tabelproduse.setItems(produse);
    }

    ObservableList<Produs> produse = FXCollections.observableArrayList(CosS.getProduse());


    public void ButonInapoi() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_client.fxml"));
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void ButonCumpara(ActionEvent actionEvent) throws IOException {
        SL.setText("Comanda a fost trimisa!");

    }

    public void ButonLogout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_login.fxml"));
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
