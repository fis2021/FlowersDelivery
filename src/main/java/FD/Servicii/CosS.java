package FD.Servicii;

import FD.Utilizatori.Produs;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.ArrayList;

import static FD.Servicii.FileS.getPathToFile;

public class CosS {

    public static ObjectRepository<Produs> CosRepository;


    public static void initProdusDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Cart.db").toFile())
                .openOrCreate("admin", "admin1");

        CosRepository = database.getRepository(Produs.class);

    }

    public static void add(Produs produs)
    {

        CosRepository.insert(produs);
    }

    public static ArrayList<Produs> getProduse()
    {
        ArrayList<Produs> produse = new ArrayList<>();
        for(Produs produs : CosRepository.find()) {
            produse.add(produs);
        }
        return produse;
    }
}
