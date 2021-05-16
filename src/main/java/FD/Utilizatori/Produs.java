package FD.Utilizatori;

import java.util.Objects;

public class Produs {

    private String nume;
    private String pret;
    private String detalii;

    public Produs(){}

    public Produs(String nume, String pret, String detalii) {
        this.nume = nume;
        this.pret = pret;
        this.detalii = detalii;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String det) {
        this.detalii = det;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", tippiele='" + detalii + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return pret == produs.pret && nume.equals(produs.nume) && detalii.equals(produs.detalii);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, pret, detalii);
    }
}