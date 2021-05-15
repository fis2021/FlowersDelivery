package FD.Exceptii;

public class NumeUtilizatorExistent extends Exception {

    private String username;

    public NumeUtilizatorExistent(String username) {
        super(String.format("An account with the username %s already exists!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
