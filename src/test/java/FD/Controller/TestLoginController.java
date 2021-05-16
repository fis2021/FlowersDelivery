package FD.Controller;

import FD.Servicii.ClientS;
import FD.Servicii.FileS;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertTrue;

public class TestLoginController {

    private static final String test_username = "Test-username";
    private static final String test_password = "Test-password";
    private static ClientS UserSevice;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileS.APPLICATION_FOLDER= ".test_database";
        ClientS.initDatabase();
    }

    @Test
    public void testCopyDefaultUserNotExists() throws Exception{
        assertTrue(Files.exists(FileS.getPathToFile()));

    }
}
