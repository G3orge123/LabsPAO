package animal;

public class Bird extends Animal{
    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public void sing(){
        System.out.println("I can uac");
    }
    public Bird(int noOfLegs, String name, String colour){
        super(name,noOfLegs);
        this.colour=colour;
    }
}
