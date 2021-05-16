package FD.Utilizatori;

import FD.Utilizatori.Produs;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.ArrayList;
import java.util.Objects;
import static FD.Servicii.FileS.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class ProdusS {

    public static ObjectRepository<Produs> produsRepository;


    public static void initProdusDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Produse.db").toFile())
                .openOrCreate("admin", "admin1");

        produsRepository = database.getRepository(Produs.class);
    }

    public static void addProduse(String nume, String pret, String detalii)
    {

        Produs produs = new Produs(nume,pret,detalii);
        produsRepository.insert(produs);

    }
    public static void getProdusePreturi(ObservableList<String> produse){
        for(Produs produs: produsRepository.find()) {
            if(produs.getNume()!=null)
                produse.add(produs.getNume()+" "+produs.getPret()+" "+produs.getDetalii());
        }
    }
    public static void getProdusePiele(ObservableList<String> produse){
        for(Produs produs: produsRepository.find()) {
            if(produs.getDetalii()!=null)
                produse.add(produs.getDetalii());
        }
    }

    public static ArrayList<Produs> getProduseSelectate(String detalii){
        ArrayList<Produs> produse = new ArrayList<>();
        for(Produs produs : produsRepository.find())
            if(Objects.equals(detalii, produs.getDetalii()))
                produse.add(produs);
        return produse;
    }

    public static ArrayList<Produs> getProduse(){
        ArrayList<Produs> produse = new ArrayList<>();
        for(Produs produs : produsRepository.find())
            produse.add(produs);
        return produse;
    }

    public static void remove(Produs s)
    {
        produsRepository.remove(s);
    }
}
