import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
/*
Option class has set of option to provide text based interaction.
Each object of this class represent set of options. calling default constructor set hardcoded options.

 */

public class Option {
    private String menuTitle;
    private ArrayList<String> menuOptions;
    private MainApplication instance;

    public Option(MainApplication instance) {
        this.menuTitle = "SuperHero Tracker" ;
        menuOptions=new ArrayList<>();
        menuOptions.add("List all superheroes");
        menuOptions.add("Add a new superhero");
        menuOptions.add("Remove a superhero");
        menuOptions.add("Update number of civilians saved by a superhero");
        menuOptions.add("List Top 3 superheroes");
        menuOptions.add("Debug Dump (toString)");
        menuOptions.add("Exit");
        this.instance=instance;

    }


    private void ListAllSuperheros(){
        if(instance.getSuperheroes().isEmpty()) {
            System.out.println("No heroes present in the list. Add more..");
        }
        else{
            int cnt=0;
            for(Superhero X:instance.getSuperheroes()){
                System.out.println(++cnt+".Hero name: "+X.getName()+", height: "+X.getHeight()+" cm, superpower:"+X.getSuperpower()+" ,saved "+X.getNumberOfCiviliansSaved()+" civilians");
            }
        }

    }
    private void AddSuperhero() throws IOException {
        String name,superpower;
        double height;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Hero's name: ");
        name=br.readLine();
        System.out.print("Enter Hero's height in cm: ");
        height=Integer.parseInt(br.readLine());
        System.out.print("Enter Hero's Superpower: ");
        superpower=br.readLine();
        if(height>=0){
        instance.addSuperhero(new Superhero(name,superpower,height));
        System.out.println(name+" has been added to the list of superheroes");}
        else{
            System.out.println("Height of the superHero should be non-negative");
        }
    }
    private void removeSuperhero() throws IOException {
        this.ListAllSuperheros();
        int index;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter Hero number to be removed or Enter 0 to cancel");
            System.out.print("Enter>> ");
            index = Integer.parseInt(br.readLine());
            if(index<0||index>instance.getSuperheroes().size()){
                System.out.println("Invalid number! Try again");
            }
        }while(index<0||index>instance.getSuperheroes().size());
        if(index==0){
            System.out.println("Removing Cancelled");
        }
        else{
            index--;
            String name=instance.getSuperheroes().get(index).getName();
            instance.removeSuperhero(index);
            System.out.println(name+" has been removed from the list of superheroes.");
        }

    }
    private void UpdateNumberOfCivilians() throws IOException {
        this.ListAllSuperheros();
        int index;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Enter Hero number to update number of civilians saved or Enter 0 to cancel");
            System.out.print("Enter>> ");
            index = Integer.parseInt(br.readLine());
            if(index<0||index>instance.getSuperheroes().size()){
                System.out.println("Invalid number! Try again");
            }
        }while(index<0||index>instance.getSuperheroes().size());
        if(index==0){
            System.out.println("Updating Cancelled");
        }
        else{
            index--;
            String name=instance.getSuperheroes().get(index).getName();
            int numberOfCivilians=instance.getSuperheroes().get(index).getNumberOfCiviliansSaved();
            System.out.print("Enter new civilians save count: ");
            int newNumberOfCivilians=Integer.parseInt(br.readLine());
            instance.setCivilians(index,newNumberOfCivilians);
            System.out.println("Number of civilians saved by "+name+" has been updated from "+numberOfCivilians+" to "+newNumberOfCivilians);
        }

    }
    private void ListTop3SuperHeroes(){
        ArrayList<Superhero> temporaryList=instance.getSuperheroes();
        Comparator<Superhero> civiliansNumberDesc=new Comparator<Superhero>() {
            @Override
            public int compare(Superhero o1, Superhero o2) {
                return o2.getNumberOfCiviliansSaved()-o1.getNumberOfCiviliansSaved();
            }
        };
        temporaryList.sort(civiliansNumberDesc);
        if(temporaryList.size()<3){
            System.out.println("There is not enough superheros in the list. Please add more");
        }
        else {
            int j;
            for( j=0;j<temporaryList.size();j++){
                if(temporaryList.get(j).getNumberOfCiviliansSaved()==0){
                    break;
                }
            }
            if(j<3){
                System.out.println("The Superheros have not saved enough civilians");
            }
            else {
                for (int i = 0; i < 3; i++) {
                    System.out.println(temporaryList.get(i).getName() + " has saved " + temporaryList.get(i).getNumberOfCiviliansSaved() + " civilians");
                }
            }
        }
    }
    private void debugDump(){
        for(Superhero X:instance.getSuperheroes()){
            System.out.println(X.toString());
        }
    }
    public boolean performOption(int choice)throws IOException{
        switch (choice) {
            case 1:
                ListAllSuperheros();
                break;
            case 2:
                AddSuperhero();
                break;
            case 3:
                removeSuperhero();
                break;
            case 4:
                UpdateNumberOfCivilians();
                break;
            case 5:
                ListTop3SuperHeroes();
                break;
            case 6:
                debugDump();
                break;
            case 7:
                System.out.println("Thank you for using system");
                return false;
            default:
                System.out.println("Wrong Choice! Try Again");
        }
        return true;

    }


    public Option(String menuTitle, ArrayList<String> menuOptions, MainApplication instance) {
        this.menuTitle = menuTitle;
        this.menuOptions = menuOptions;
        this.instance=instance;
    }
    public void  menuPrint(){
        int titleLength=menuTitle.length();
        for(int i=0;i<=titleLength;i++){
            System.out.print('*');
        }
        System.out.println();
        System.out.println(menuTitle);
        for(int i=0;i<=titleLength;i++){
            System.out.print('*');
        }
        System.out.println("\n");
        int num=0;
        for(String a:menuOptions){
            System.out.println(++num+":"+a);
        }
    }
}
