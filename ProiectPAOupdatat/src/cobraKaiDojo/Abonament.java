package cobraKaiDojo;

public abstract class Abonament {
    protected String tip;
    protected double cost;
    protected int durata; // Durata în luni
    protected String descriere;

    public Abonament(String tip, double cost, int durata, String descriere) {
        this.tip = tip;
        this.cost = cost;
        this.durata = durata;
        this.descriere = descriere;
    }

    // Getteri și setteri

    @Override
    public String toString() {
        return tip + " - Cost: " + cost + ", Durata: " + durata + " luni, Descriere: " + descriere;
    }
}

