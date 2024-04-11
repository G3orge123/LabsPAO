package cobraKaiDojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Antrenament {
    private LocalDateTime dataOra;
    private String tip;
    private String locatie;
    private int durata; // în minute
    private String antrenor;
    private String nivel;
    private List<Membru> participanti = new ArrayList<>();
    private String descriere;

    public Antrenament(LocalDateTime dataOra, String tip, String locatie, int durata, String antrenor, String nivel, String descriere) {
        this.dataOra = dataOra;
        this.tip = tip;
        this.locatie = locatie;
        this.durata = durata;
        this.antrenor = antrenor;
        this.nivel = nivel;
        this.descriere = descriere;
    }

    public void adaugaParticipant(Membru membru) {
        participanti.add(membru);
    }

    public void eliminaParticipant(Membru membru) {
        participanti.remove(membru);
    }



    @Override
    public String toString() {
        // Folosim un StringBuilder pentru a construi eficient șirul de caractere
        StringBuilder sb = new StringBuilder();
        sb.append("Antrenament{");
        sb.append("dataOra=").append(dataOra);
        sb.append(", tip='").append(tip).append('\'');
        sb.append(", locatie='").append(locatie).append('\'');
        sb.append(", durata=").append(durata);
        sb.append(", antrenor='").append(antrenor).append('\'');
        sb.append(", nivel='").append(nivel).append('\'');

        // Adăugăm numele participanților
        sb.append(", participanti=").append(participanti.size()).append(" [");
        for (Membru membru : participanti) {
            sb.append(membru.getNume()).append(" ").append(membru.getPrenume()).append(", ");
        }
        if (!participanti.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Eliminăm ultima virgulă și spațiu
        }
        sb.append("]");

        sb.append(", descriere='").append(descriere).append('\'');
        sb.append('}');
        return sb.toString();
    }



}

