package cobraKaiDojo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class DojoManagement {
    private List<Membru>membri;
    private List<Antrenament> antrenamente;
    private List<Echipament> echipamente;

    public DojoManagement() {
        this.membri = new ArrayList<>();
        this.antrenamente = new ArrayList<>(); // Inițializează lista de antrenamente
        this.echipamente = new ArrayList<>();
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
    public void anuleazaAntrenament(int idAntrenament) {
        antrenamente.removeIf(antrenament -> antrenament.getId() == idAntrenament);
    }

    public void reprogrameazaAntrenament(int idAntrenament, LocalDateTime nouaDataOra) {
        for (Antrenament antrenament : antrenamente) {
            if (antrenament.getId() == idAntrenament) {
                antrenament.setDataOra(nouaDataOra);
                break;
            }
        }
    }

    public void adaugaEchipament(String nume, int cantitate) {
        Echipament echipament = new Echipament(nume, cantitate);
        echipamente.add(echipament);
    }

    public void afiseazaEchipamente() {
        if (echipamente.isEmpty()) {
            System.out.println("Nu există echipamente înregistrate.");
        } else {
            for (Echipament echipament : echipamente) {
                System.out.println(echipament);
            }
        }
    }
    public Membru cautaMembru(String numePrenume) {
        for (Membru membru : membri) {
            if ((membru.getNume() + " " + membru.getPrenume()).equalsIgnoreCase(numePrenume)) {
                return membru;
            }
        }
        return null;  // Returnează null dacă membrul nu este găsit
    }





}
