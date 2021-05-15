package FD.Exceptii;

public class NumeIncorect extends Exception{
    private String username;

    public NumeIncorect(String username) {
        super(String.format("Numele de utilizator nu este corect", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
