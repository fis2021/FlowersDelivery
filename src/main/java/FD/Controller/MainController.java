package FD.Controller;

import FD.Servicii.ProdusS;
import FD.Utilizatori.Produs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class MainController {
    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> detalii;
    @FXML
    private Button backButton;
    @FXML
    private Button btnAdauga;
    @FXML
    private Button btnComenzi;
    @FXML
    private Button btnStergere;
    @FXML
    private Label LProd;

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        detalii.setCellValueFactory(new PropertyValueFactory<>("detalii"));
        tabelproduse.setItems(produse);
    }


    ObservableList<Produs> produse = FXCollections.observableArrayList(ProdusS.getProduse());

    public void backLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_login.fxml"));
        Stage scene= (Stage) backButton.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,725,490));
    }

    public void AdaugaP() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_adauga.fxml"));
        Stage scene= (Stage) btnAdauga.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,466,399));
    }

    public void LComenzi() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_comenzi.fxml"));
        Stage scene= (Stage) btnComenzi.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,700,500));
    }

    public void StergeB() throws  Exception{
        /*btnStergere.setOnAction(e -> {
            Produs selectedItem = tabelproduse.getSelectionModel().getSelectedItem();
            tabelproduse.getItems().remove(selectedItem);
        });*/
        try{ObservableList<Produs> allProduct, SingleProduct;
            allProduct=tabelproduse.getItems();
            SingleProduct=tabelproduse.getSelectionModel().getSelectedItems();
            SingleProduct.forEach(allProduct::remove);}
        catch (Exception e){
            LProd.setText("Ati sters toate elementele din tabel!");
        }

    }

    public void OnEditChange(TableColumn.CellEditEvent<Produs, String> produsStringCellEditEvent) {
        Produs prod = tabelproduse.getSelectionModel().getSelectedItem();
        prod.setNume(produsStringCellEditEvent.getNewValue());
    }
}


