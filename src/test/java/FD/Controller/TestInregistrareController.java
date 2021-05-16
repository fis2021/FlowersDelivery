package FD.Controller;

import FD.Exceptii.CampuriNecompletate;
import FD.Exceptii.LiteraMare;
import FD.Exceptii.NumeUtilizatorExistent;
import FD.Servicii.ClientS;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInregistrareController {

    private static final String test_username = "Test-username";
    private static final String test_password = "Test-password";
    private static final String email = "Test-email";
    private static final String phone = "Test-Phone";
    private static final String address = "Test-adress";
    private static int contor;
    private static ClientS UserSevice;

    @BeforeClass
    public static void setUp() throws Exception{
        UserSevice.initDatabase();
        contor = ClientS.getAllUsers().size();
    }

    @Test
    public void testHandleAddUser() throws NumeUtilizatorExistent, LiteraMare, CampuriNecompletate {
        UserSevice.addUser(test_username,test_password,email,address,phone);
        assertEquals(contor+1,UserSevice.getAllUsers().size());

    }

}
