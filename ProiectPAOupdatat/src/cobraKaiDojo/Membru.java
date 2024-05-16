package cobraKaiDojo;
import java.util.*;

    public class Membru{
        private String nume;
        private String prenume;
        private Integer varsta;
        private String grad;
        private String email;
        private String telefon;
        private String adresa;
        private List<Progres> progres;
        private Abonament abonament;
        private List<Antrenament> antrenamente = new ArrayList<>();
        private Set<Competitie> istoricCompetitii = new TreeSet<>();

        public Membru() {
        }

        public Membru(String nume, String prenume, Integer varsta, String grad, String email, String telefon, String adresa) {
            this.nume = nume;
            this.prenume = prenume;
            this.varsta = varsta;
            this.grad = grad;
            this.email = email;
            this.telefon = telefon;
            this.adresa = adresa;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getPrenume() {
            return prenume;
        }

        public void setPrenume(String prenume) {
            this.prenume = prenume;
        }

        public Integer getVarsta() {
            return varsta;
        }

        public void setVarsta(Integer varsta) {
            this.varsta = varsta;
        }

        public String getGrad() {
            return grad;
        }

        public void setGrad(String grad) {
            this.grad = grad;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        public String getAdresa() {
            return adresa;
        }

        public void setAdresa(String adresa) {
            this.adresa = adresa;
        }



        public void adaugaCompetitie(Competitie competitie) {
            istoricCompetitii.add(competitie);
        }

        public Set<Competitie> getIstoricCompetitii() {
            return istoricCompetitii;
        }

        // Metoda pentru afișarea competițiilor
        public void afiseazaIstoricCompetitii() {
            for (Competitie competitie : istoricCompetitii) {
                System.out.println(competitie);
            }
        }

        public List<Progres> getProgres() {
            return progres;
        }
        public void setAbonament(Abonament abonament){
            this.abonament=abonament;
        }
        public Abonament getAbonament(){
            return abonament;
        }
        public void setProgres(List<Progres> progres) {
            this.progres = progres;
        }
        @Override
        public String toString() {
            return "Nume: " + nume + " " + prenume +
                    ", Varsta: " + varsta +
                    ", Grad: " + grad +
                    ", Email: " + email +
                    ", Telefon: " + telefon +
                    ", Adresa: " + adresa;
        }
        public void adaugaAntrenament(Antrenament antrenament) {
            this.antrenamente.add(antrenament);
        }
        public String afiseazaProgres() {
            // Exemplu simplificat; adaptează în funcție de atributele și logica specifică
            StringBuilder sb = new StringBuilder();
            sb.append("Progresul lui ").append(nume).append(" ").append(prenume).append(":\n");
            sb.append("Nivelul actual: ").append(grad).append("\n");
            sb.append("Număr antrenamente participat: ").append(antrenamente.size()).append("\n");
            return sb.toString();
        }
    }