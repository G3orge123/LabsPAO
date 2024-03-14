package animal;

public class Duck extends Bird{
    private int length;

    public int getLength() {
        return length;
    }
    public Duck(int noOfLegs , String name, String colour,int length){
        super(noOfLegs,name,colour);
        this.length = length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean equals(Object o) {
        // Verifică dacă obiectul este comparat cu el însuși
        if (this == o) return true;
        // Verifică dacă obiectul primit este null sau dacă clasele sunt diferite
        if (o == null || getClass() != o.getClass()) return false;
        // Cast la tipul Duck pentru a putea accesa câmpurile specifice
        Duck duck = (Duck) o;
        // Compară lungimea și apelează `equals` din clasa părinte pentru celelalte câmpuri
        return this.length == duck.length && super.equals(o);
    }

}
