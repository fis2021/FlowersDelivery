package FD.Servicii;

import FD.Utilizatori.Produs;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCosS {

    @Test
    public void testCopyDefaultUserNotExists() throws Exception{
        ProdusS.initProdusDatabase();
        assertTrue(Files.exists(FileS.getPathToFile()));
    }

    public void addCart()
    {
        int i = CosS.getAllProdus().size();
        CosS.add(new Produs("test","test","test"));
        assertEquals(i+1,ClientS.getAllUsers().size());
    }

}
