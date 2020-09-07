/*
Superhero class saves the characteristics of the hero.
Each object of this class represent the individual superhero.

 */
public class Superhero {
    private String name;
    private String superpower;
    private double height;
     private  int numberOfCiviliansSaved;

    public Superhero(String name, String superpower, double height) {
        this.name = name;
        this.superpower = superpower;
        this.height = height;
        this.numberOfCiviliansSaved=0;
    }

    public Superhero(String name, String superpower, double height, int numberOfCiviliansSaved) {
        this.name = name;
        this.superpower = superpower;
        this.height = height;
        this.numberOfCiviliansSaved = numberOfCiviliansSaved;
    }

    public String getName() {
        return name;
    }

    public String getSuperpower() {
        return superpower;
    }

    public double getHeight() {
        return height;
    }

    public int getNumberOfCiviliansSaved() {
        return numberOfCiviliansSaved;
    }

    public void setNumberOfCiviliansSaved(int numberOfCiviliansSaved) {
        this.numberOfCiviliansSaved = numberOfCiviliansSaved;
    }


    @Override
    public String toString() {
        return "superhero{" +
                "name='" + name + '\'' +
                ", superpower='" + superpower + '\'' +
                ", height=" + height +
                ", numberOfCiviliansSaved=" + numberOfCiviliansSaved +
                '}';
    }
}
