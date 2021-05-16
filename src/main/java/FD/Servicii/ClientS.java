package FD.Servicii;


import FD.Exceptii.*;
import FD.Utilizatori.Client;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static FD.Servicii.FileS.getPathToFile;

public class ClientS {

    public static ObjectRepository<Client> userRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Admin.db").toFile())
                .openOrCreate("admin", "admin1");

        userRepository = database.getRepository(Client.class);
    }

    public static void addUser(String username,String password,String email,String address,String phone) throws NumeUtilizatorExistent, CampuriNecompletate, NumeUtilizatorExistent, LiteraMare {
        AllFieldsCompleted(username,password,email,address,phone);
        checkUserDoesNotAlreadyExist(username);
        LiteraMareE(password);
        Client user=new Client(username, encodePassword(username, password), email, address, phone);
        //user.setisAdmin();
        userRepository.insert(user);

    }


    private static void checkUserDoesNotAlreadyExist(String username) throws NumeUtilizatorExistent {
        Cursor<Client> cursor = userRepository.find();
        for (Client user : cursor) {
//            if (Objects.equals(username, user.getUsername()))
            if (username.equals(user.getUsername()))
            {   throw new NumeUtilizatorExistent(username);

            }
        }
    }
    public static boolean checkIsAdmin(String username)  {
        Cursor<Client> cursor = userRepository.find();
        for (Client user : cursor) {
            if (username.equals(user.getUsername())) {
                if (user.isAdmin()) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean LiteraMareE(String password) throws LiteraMare
    {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if(!matchFound) throw new LiteraMare("Trebuie sa contina cel putin o litera mare!");
        else
            return true;

    }
    public static void AllFieldsCompleted(String username, String password,String email, String address, String phone) throws  CampuriNecompletate {
        Pattern pattern = Pattern.compile("[\\S+]");
        Matcher matcher1 = pattern.matcher(username);
        Matcher matcher2 = pattern.matcher(password);
        Matcher matcher3 = pattern.matcher(email);
        Matcher matcher4= pattern.matcher(address);
        Matcher matcher5=pattern.matcher(phone);

        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();
        boolean matchFound3 = matcher3.find();
        boolean matchFound4 = matcher4.find();
        boolean matchFound5 = matcher5.find();

        if(!matchFound1 ) throw new CampuriNecompletate("Trebuie completate toate campurile!");
        if(!matchFound2 ) throw new CampuriNecompletate("Trebuie completate toate campurile!");
        if(!matchFound3 ) throw new CampuriNecompletate("Trebuie completate toate campurile!");
        if(!matchFound4 ) throw new CampuriNecompletate("Trebuie completate toate campurile!");
        if(!matchFound5 ) throw new CampuriNecompletate("Trebuie completate toate campurile!");


    }


    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }
    public static boolean userExists(String username,String password) throws NumeIncorect, ParolaIncorecta {
        int ok=0,ok2=0;
        for(Client user :userRepository.find())
        {
            if (Objects.equals(username, user.getUsername()))
            {   ok=1;
                if(encodePassword(username,password).equals(user.getPassword())) {
                    ok2=1;
                }
            }
        }
        if(ok==0)
            throw new NumeIncorect("Numele introdus este incorect");
        if(ok2==0)
            throw new NumeIncorect("Numele introdus este incorect");

        return true;
    }
    public static void addAdmin(String username, String password,String email,String address,String phone) throws LiteraMare, CampuriNecompletate, LiteraMare, NumeUtilizatorExistent {
        try {
            AllFieldsCompleted(username,password,email,address,phone);
        } catch (CampuriNecompletate e) {
            e.printStackTrace();
        }
        checkUserDoesNotAlreadyExist(username);
        LiteraMareE(password);
        Client u=new Client(username,encodePassword(username,password),email,address,phone);
        u.setisAdmin();
        userRepository.insert(u);
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}