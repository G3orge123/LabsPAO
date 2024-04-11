package cobraKaiDojo;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DojoManagement management = new DojoManagement();
        Membru membru1 = new Membru("Miguel", "Diaz", 17, "neagra", "miguel.diaz@email.com", "0722334455", "Strada Libertatii, Nr. 10");
        Membru membru2 = new Membru("Eli", "Maschovitz", 17, "neagra", "eli.maschov@email.com", "0722334325", "Strada Libertatii, Nr. 2");

        management.adaugaMembru(membru1);
        management.adaugaMembru(membru2);

        Competitie competitie1 = new Competitie("Kumite National Championship", "2024-05-15");
        Competitie competitie2 = new Competitie("All Valley Karate Tournament", "2024-07-20");

        // Adăugarea competițiilor membrilor
        membru1.adaugaCompetitie(competitie1);
        membru1.adaugaCompetitie(competitie2); // Să presupunem că Miguel participă la ambele competiții
        membru2.adaugaCompetitie(competitie2); // Eli participă doar la a doua competiție

        // Afișarea membrilor dojo-ului și a abonamentelor acestora
        management.afiseazaMembru();

        membru1.setAbonament(new AbonamentPremium());
        membru2.setAbonament(new AbonamentStandard());

        Antrenament antrenament1 = new Antrenament(LocalDateTime.of(2024, 3, 25, 18, 0), "Kata", "Dojo Cobra Kai", 60, "Sensei Lawrence", "Toate nivelele", "Antrenament intensiv de kata.");
        Antrenament antrenament2 = new Antrenament(LocalDateTime.of(2024, 3, 26, 18, 0), "Kumite", "Dojo Cobra Kai", 60, "Sensei Lawrence", "Intermediar", "Tehnici avansate de luptă.");

        management.adaugaAntrenament(antrenament1);
        management.adaugaAntrenament(antrenament2);

        // Asignarea membrilor la antrenamente
        management.asignareAntrenamentLaMembru(membru1, antrenament1);
        management.asignareAntrenamentLaMembru(membru2, antrenament2);

        // Afișarea antrenamentelor și participanților
        management.afiseazaAntrenamente();

        // Afișarea competițiilor la care participă fiecare membru
        System.out.println("Competiții Miguel Diaz:");
        membru1.afiseazaIstoricCompetitii();

        System.out.println("Competiții Eli Maschovitz:");
        membru2.afiseazaIstoricCompetitii();

        Progres progresStartMiguel = new Progres("Miguel Diaz", LocalDateTime.of(2024, 3, 25, 18, 0), "Galben", 10, "Stăpânește bazele karate-ului.");
        Progres progresEndMiguel = new Progres("Miguel Diaz", LocalDateTime.of(2025, 1, 12, 8, 30), "Portocaliu", 50, "Îmbunătățiri semnificative în tehnici de apărare.");

        Progres progresStartEli = new Progres("Eli Maschovitz", LocalDateTime.of(2024, 9, 15, 8, 30), "Galben", 10, "Începător entuziast.");
        Progres progresEndEli = new Progres("Eli Maschovitz", LocalDateTime.of(2025, 2, 15, 8, 30), "Verde", 60, "Progresează rapid, interes mare în competiții.");


        // Adăugarea obiectivelor
        progresEndMiguel.adaugaObiectiv("Participă la turneul regional.");
        progresEndEli.adaugaObiectiv("Învață și perfecționează lovitura de crane.");

    // Afișarea evoluției
        Progres.afiseazaEvoluția(progresStartMiguel, progresEndMiguel);
        System.out.println(progresEndMiguel.getObservatii());

        Progres.afiseazaEvoluția(progresStartEli, progresEndEli);
        System.out.println(progresEndEli.getObservatii());
        }

}
