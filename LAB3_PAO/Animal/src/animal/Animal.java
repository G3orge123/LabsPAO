package animal;

public class Animal {
    private String name;
    private int noOfLegs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }
    public Animal(String name,int noOfLegs){
        this.name=name;
        this.noOfLegs=noOfLegs;
    }
    public Animal(){}
    public void move(){
        System.out.println("aichenmuv!");

    }
    public void eat(){
        System.out.println("ineedsomethingtoeat");
    }

    public void eat(String food){
        System.out.println("ineedsomethingtoeat");

    }


}

