package FD.Controller;

import FD.Servicii.CosS;
import FD.Servicii.ProdusS;
import FD.Utilizatori.Produs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class ClientController {

    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> detalii;
    @FXML
    private Button btnCumpara;
    @FXML
    private Button btnCos;
    @FXML
    private Button btnLogout;

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        detalii.setCellValueFactory(new PropertyValueFactory<>("detalii"));
        tabelproduse.setItems(produse);
    }

    ObservableList<Produs> produse = FXCollections.observableArrayList(ProdusS.getProduse());

    public void ButonLogout() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_login.fxml"));
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void ButonCos() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_cos.fxml"));
        Stage stage = (Stage) btnCos.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void ButonCumpara() throws Exception {
        ObservableList<Produs> typesSelected;
        typesSelected = tabelproduse.getSelectionModel().getSelectedItems();
        for(Produs pr: typesSelected)
        {
            CosS.add(pr);
        }
    }
}

