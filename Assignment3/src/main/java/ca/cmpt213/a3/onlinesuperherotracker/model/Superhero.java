package ca.cmpt213.a3.onlinesuperherotracker.model;

/*
Superhero class saves the characteristics of the hero.
Each object of this class represent the individual superhero.

 */
public class Superhero {
    private long id;
    private String name;
    private String superpower;
    private double height;
    private  int numberOfCiviliansSaved;
    public Superhero(){

    }

    public Superhero(long id,String name, String superpower, double height) {
        this.id=id;
        this.name = name;
        this.superpower = superpower;
        this.height = height;
        this.numberOfCiviliansSaved=0;
    }

    public Superhero(long id, String superpower,String name,double height, int numberOfCiviliansSaved) {
        this.id=id;
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
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
