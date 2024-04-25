package cobraKaiDojo;

import java.util.ArrayList;
import java.util.List;

public class DojoManagement {
    private List<Membru>membri;
    private List<Antrenament> antrenamente;

    public DojoManagement() {
        this.membri = new ArrayList<>();
        this.antrenamente = new ArrayList<>(); // Inițializează lista de antrenamente
    }
    public void adaugaMembru(Membru membru){
        this.membri.add(membru);
    }
    public List<Membru>getMembri(){
        return membri;
    }
    public void afiseazaMembru() {
        if (membri.isEmpty()) {
            System.out.println("Nu există membri înregistrați în dojo.");
        } else {
            System.out.println("Membrii înregistrați în dojo:");
            for (Membru membru : membri) {
                System.out.println(membru);
            }
        }
    }
    // Metodă pentru adăugarea unui antrenament în listă
    public void adaugaAntrenament(Antrenament antrenament) {
        this.antrenamente.add(antrenament);
    }

    public void asignareAntrenamentLaMembru(Membru membru, Antrenament antrenament) {
        if (this.membri.contains(membru) && this.antrenamente.contains(antrenament)) {
            antrenament.adaugaParticipant(membru);
        } else {
            System.out.println("Membru sau antrenamentul nu există în lista dojo-ului.");
        }
    }

    public void afiseazaAntrenamente() {
        if (antrenamente.isEmpty()) {
            System.out.println("Nu există antrenamente înregistrate în dojo.");
        } else {
            System.out.println("Antrenamente înregistrate în dojo:");
            for (Antrenament antrenament : antrenamente) {
                System.out.println(antrenament);
            }
        }
    }




}
