package FD.Utilizatori;

import org.dizitart.no2.objects.Id;

public class Client {
    @Id
    private String nume;
    private String parola;
    private String email;
    private String adresa;
    private String nrt;
    private boolean admin=false;

    public Client() {
    }

    public Client(String username, String password, String name, String email, String address, String phone) {
        this.nume = username;
        this.parola = password;
        this.adresa = address;
        this.email=email;
        this.nrt=phone;
    }
    public void setisAdmin()
    {
        this.admin=true;
    }
    public boolean isAdmin()
    {
        return this.admin;
    }
    public String getUsername() {
        return nume;
    }

    public void setUsername(String username) {
        this.nume = username;
    }

    public String getPassword() {
        return parola;
    }

    public void setPassword(String password) {
        this.parola = password;
    }

    public String getAddress() {
        return adresa;
    }

    public void setAddress(String address) {
        this.adresa = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return nrt;
    }

    public void setPhone(String phone) {
        this.nrt = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client user = (Client) o;

        if (nume != null ? !nume.equals(user.nume) : user.nume != null) return false;
        if (nume != null ? !nume.equals(user.nume) : user.nume != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + (parola != null ? parola.hashCode() : 0);
        return result;
    }
}
