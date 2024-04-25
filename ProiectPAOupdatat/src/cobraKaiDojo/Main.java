package cobraKaiDojo;

import java.util.Set;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DojoManagement management = new DojoManagement();

        while (true) {
            System.out.println("Alegeti o optiune:");
            System.out.println("1. Adauga membru");
            System.out.println("2. Adauga abonament");
            System.out.println("3. Adauga antrenament");
            System.out.println("4. Adauga competitie");
            System.out.println("5. Afiseaza membrii");
            System.out.println("6. Afiseaza antrenamente");
            System.out.println("7. Afiseaza competitiile unui membru");
            System.out.println("8. Iesire");

            System.out.print("Introduceti optiunea: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();  // Consuma newline-ul ramas dupa nextInt()

            switch (optiune) {
                case 1:
                    // Logica pentru adaugarea unui membru
                    System.out.println("Introduceti numele: ");
                    String nume = scanner.nextLine();
                    System.out.println("Introduceti prenumele: ");
                    String prenume = scanner.nextLine();
                    System.out.println("Introduceti varsta: ");
                    int varsta = scanner.nextInt();
                    scanner.nextLine(); // Consuma newline-ul ramas
                    System.out.println("Introduceti gradul: ");
                    String grad = scanner.nextLine();
                    System.out.println("Introduceti emailul: ");
                    String email = scanner.nextLine();
                    System.out.println("Introduceti telefonul: ");
                    String telefon = scanner.nextLine();
                    System.out.println("Introduceti adresa: ");
                    String adresa = scanner.nextLine();

                    Membru membru = new Membru(nume, prenume, varsta, grad, email, telefon, adresa);
                    management.adaugaMembru(membru);
                    break;
                case 2:
                    // Logica pentru adaugarea unui abonament
                    System.out.println("Introduceti numele complet al membrului pentru abonament:");
                    String numeComplet = scanner.nextLine();
                    Membru membruAles = null;

                    // Căutăm membrul în lista de membri
                    for (Membru m : management.getMembri()) {
                        if ((m.getNume() + " " + m.getPrenume()).equalsIgnoreCase(numeComplet)) {
                            membruAles = m;
                            break;
                        }
                    }

                    if (membruAles == null) {
                        System.out.println("Membru nu a fost gasit. Verificati numele introdus si reincercati.");
                    } else {
                        System.out.println("Selectati tipul de abonament ('Standard' sau 'Premium'):");
                        String tip = scanner.nextLine();
                        if (tip.equalsIgnoreCase("Standard")) {
                            membruAles.setAbonament(new AbonamentStandard());
                            System.out.println("Abonament standard aplicat pentru " + numeComplet);
                        } else if (tip.equalsIgnoreCase("Premium")) {
                            membruAles.setAbonament(new AbonamentPremium());
                            System.out.println("Abonament premium aplicat pentru " + numeComplet);
                        } else {
                            System.out.println("Tip de abonament necunoscut.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Introduceti data si ora antrenamentului (format YYYY-MM-DDTHH:MM, ex: 2024-03-25T18:00):");
                    String dataOra = scanner.nextLine();
                    LocalDateTime data = LocalDateTime.parse(dataOra);  // Acesta parsează conform formatului ISO_LOCAL_DATE_TIME

                    System.out.println("Introduceti tipul antrenamentului:");
                    String tipAntrenament = scanner.nextLine();

                    System.out.println("Introduceti locatia antrenamentului:");
                    String locatie = scanner.nextLine();

                    System.out.println("Introduceti durata antrenamentului (în minute):");
                    int durata = scanner.nextInt();
                    scanner.nextLine(); // curăță buffer-ul după citirea unui int

                    System.out.println("Introduceti numele senseiului:");
                    String sensei = scanner.nextLine();

                    System.out.println("Introduceti nivelul antrenamentului (ex: incepator, intermediar, avansat):");
                    String nivel = scanner.nextLine();

                    System.out.println("Introduceti o descriere scurtă a antrenamentului:");
                    String descriere = scanner.nextLine();

                    Antrenament antrenament = new Antrenament(data, tipAntrenament, locatie, durata, sensei, nivel, descriere);
                    management.adaugaAntrenament(antrenament);
                    System.out.println("Antrenament adaugat cu succes!");
                    break;

                case 4:
                    // Logica pentru adaugarea unei competitii
                    System.out.println("Introduceti numele competitiei:");
                    String numeCompetitie = scanner.nextLine();
                    System.out.println("Introduceti data competitiei (format YYYY-MM-DD):");
                    String dataCompetitie = scanner.nextLine();

                    Competitie competitie = new Competitie(numeCompetitie, dataCompetitie);

                    // Alegerea membrilor care vor participa la competitie
                    System.out.println("Introduceti numele complet al membrilor care vor participa la competitie, separati prin virgula:");
                    String numeMembri = scanner.nextLine();
                    String[] numeMembriArray = numeMembri.split(",");

                    int numarMembriAdaugati = 0;
                    Membru membruAles1 = null;  // Declară variabila aici, înaintea buclei for
                    for (String numeMembru : numeMembriArray) {
                        numeMembru = numeMembru.trim(); // Curăță spațiile

                        boolean found = false;
                        for (Membru m : management.getMembri()) {
                            if ((m.getNume() + " " + m.getPrenume()).equalsIgnoreCase(numeMembru)) {
                                membruAles1 = m;
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            membruAles1.adaugaCompetitie(competitie);
                            numarMembriAdaugati++;
                        } else {
                            System.out.println("Membru '" + numeMembru + "' nu a fost gasit.");
                        }
                    }

                    if (numarMembriAdaugati > 0) {
                        System.out.println(numarMembriAdaugati + " membri au fost inscrisi la competitia '" + numeCompetitie + "'.");
                    } else {
                        System.out.println("Niciun membru inscris la competitie.");
                    }
                    break;

                case 5:
                    // Afișează toți membrii
                    management.afiseazaMembru();
                    break;
                case 6:
                    // Afișează toate antrenamentele
                    management.afiseazaAntrenamente();
                    break;
                case 7:
                    // Afișează competițiile unui membru
                    System.out.println("Introduceți numele complet al membrului pentru care doriți să vedeți competițiile (nume prenume):");
                    String numeCompletMembru = scanner.nextLine();

                    Membru membruSelectat = null;
                    for (Membru membru1 : management.getMembri()) {
                        if ((membru1.getNume() + " " + membru1.getPrenume()).equalsIgnoreCase(numeCompletMembru)) {
                            membruSelectat = membru1;
                            break;
                        }
                    }

                    if (membruSelectat != null) {
                        Set<Competitie>competitiile = membruSelectat.getIstoricCompetitii();
                        if (competitiile == null || competitiile.isEmpty()) {
                            System.out.println("Membrul nu este înscris la nicio competiție.");
                        } else {
                            for (Competitie competitie1 : competitiile) {
                                System.out.println(competitie1.toString());
                            }
                        }
                    } else {
                        System.out.println("Nu s-a găsit un membru cu numele: " + numeCompletMembru);
                    }
                    break;
                case 8:
                    // Iesire din program
                    System.out.println("Iesire din program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Optiune invalida, incercati din nou.");
                    break;
            }
            }
    }
}
