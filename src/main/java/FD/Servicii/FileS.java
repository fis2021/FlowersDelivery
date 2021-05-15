package FD.Servicii;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileS {
    private static final String APPLICATION_FOLDER = ".SKC";
    private static final String USER_FOLDER = System.getProperty("User.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    private static final String Produs_FOLDER = System.getProperty("Produs.home");
    public static final Path Produs_Home_Path = Paths.get(Produs_FOLDER,APPLICATION_FOLDER);
    public static Path getPathProdusToFile(String... path){return Produs_Home_Path.resolve(Paths.get(".",path));}

}