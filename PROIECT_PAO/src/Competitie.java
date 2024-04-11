package cobraKaiDojo;

public class Competitie implements Comparable<Competitie> {
    private String nume;
    private String data; // Format: "YYYY-MM-DD"
    // Alte atribute și metode

    public Competitie(String nume, String data) {
        this.nume = nume;
        this.data = data;
    }

    public String getNume() {
        return nume;
    }

    public String getData() {
        return data;
    }

    @Override
    public int compareTo(Competitie o) {
        return this.nume.compareTo(o.nume);
    }

    @Override
    public String toString() {
        return "Competitie{" +
                "nume='" + nume + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
