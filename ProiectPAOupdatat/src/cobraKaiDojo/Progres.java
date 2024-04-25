package cobraKaiDojo;

import java.time.LocalDateTime;

public class Progres implements Comparable<Progres> {
    private String numeMembru; // Utilizează numele membrului în locul ID-ului
    private LocalDateTime data; // Actualizat pentru a folosi LocalDateTime
    private String grad;
    private int puncteProgres;
    private String observatii;

    // Constructor ajustat pentru a accepta LocalDateTime
    public Progres(String numeMembru, LocalDateTime data, String grad, int puncteProgres, String observatii) {
        this.numeMembru = numeMembru;
        this.data = data;
        this.grad = grad;
        this.puncteProgres = puncteProgres;
        this.observatii = observatii;
    }

    // Getteri și setteri ajustați pentru LocalDateTime și alte atribute
    public String getNumeMembru() {
        return numeMembru;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getGrad() {
        return grad;
    }

    public int getPuncteProgres() {
        return puncteProgres;
    }

    public String getObservatii() {
        return observatii;
    }

    // Compară după nume membru și data, dacă numele membrilor sunt identice
    @Override
    public int compareTo(Progres altProgres) {
        int compareNume = this.numeMembru.compareTo(altProgres.numeMembru);
        if (compareNume == 0) {
            return this.data.compareTo(altProgres.data);
        }
        return compareNume;
    }

    @Override
    public String toString() {
        return "Progres{" +
                "numeMembru='" + numeMembru + '\'' +
                ", data=" + data +
                ", grad='" + grad + '\'' +
                ", puncteProgres=" + puncteProgres +
                ", observatii='" + observatii + '\'' +
                '}';
    }

    public static void afiseazaEvoluția(Progres startProgres, Progres endProgres) {
        System.out.println("Evoluția membrului " + startProgres.getNumeMembru() + " de la data " + startProgres.getData() + " până la " + endProgres.getData() + ":");
        System.out.println("De la gradul " + startProgres.getGrad() + " la " + endProgres.getGrad() + ".");
        System.out.println("Puncte de progres acumulate: " + (endProgres.getPuncteProgres() - startProgres.getPuncteProgres()));
    }

    public void adaugaObiectiv(String obiectiv) {
        this.observatii = (this.observatii.isEmpty() ? "" : this.observatii + "; ") + "Obiectiv: " + obiectiv;
    }
}
