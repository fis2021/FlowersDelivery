package FD.Controller;

import FD.Servicii.CosS;
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

public class ComenziController {
    @FXML
    private TableView<Produs> tabelproduse;
    @FXML
    private TableColumn<Produs, String> nume;
    @FXML
    private TableColumn<Produs, String> pret;
    @FXML
    private TableColumn<Produs, String> detalii;
    @FXML
    private Button BInapoi;
    @FXML
    private Button BAccept;
    @FXML
    private Label Stat;

    public void initialize() {
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        detalii.setCellValueFactory(new PropertyValueFactory<>("detalii"));
        tabelproduse.setItems(produse);
    }

    ObservableList<Produs> produse = FXCollections.observableArrayList(CosS.getProduse());




    public void BInapoi() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("pagina_admin.fxml"));
        Stage scene= (Stage) BInapoi.getScene().getWindow();
        scene.setTitle("GIFTINO");
        scene.setScene(new Scene(root,770,540));

    }

    public void BAccept() throws Exception
    {try {Stat.setText("COMANDA A FOST ACCEPTATA!");
        ObservableList<Produs> allProduct, SingleProduct;
        allProduct=tabelproduse.getItems();
        SingleProduct=tabelproduse.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);}
    catch (Exception e){
        Stat.setText("Nu mai sunt comenzi!");
    }
    }
}
