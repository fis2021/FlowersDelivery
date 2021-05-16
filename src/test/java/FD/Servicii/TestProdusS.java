package FD.Servicii;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProdusS {

    @Test
    public void testCopyDefaultUserNotExists() throws Exception{
        ProdusS.initProdusDatabase();
        assertTrue(Files.exists(FileS.getPathToFile()));
    }

    public void addProdus()
    {
        int i = ProdusS.getAllProdus().size();
        ProdusS.addProduse("test","test","test");
        assertEquals(i+1,ClientS.getAllUsers().size());
    }

}
