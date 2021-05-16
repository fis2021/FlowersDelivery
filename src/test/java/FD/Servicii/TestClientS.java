package FD.Servicii;

import FD.Exceptii.CampuriNecompletate;
import FD.Exceptii.LiteraMare;
import FD.Exceptii.NumeUtilizatorExistent;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClientS {

    private ClientS UserSevice;

    @Test
    public void testCopyDefaultUserNotExists() throws Exception{
        UserSevice.initDatabase();
        assertTrue(Files.exists(FileS.getPathToFile()));
    }

    @Test
    public void addOneUser() throws NumeUtilizatorExistent, LiteraMare, CampuriNecompletate {
        int i = ClientS.getAllUsers().size();
        ClientS.addUser("test","Test","test","test","test");
        assertEquals(i+1,ClientS.getAllUsers().size());


    }

}
