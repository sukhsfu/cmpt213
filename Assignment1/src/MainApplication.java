import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
/*
This class contains the main function.
It field has List of superheros of type class superhero.
It also provide way to option class interact with list of superheroes.
*/

public class MainApplication {
    private  ArrayList<Superhero> Superheroes;

    public MainApplication() {
        Superheroes =new ArrayList<>();
    }

    public MainApplication(ArrayList<Superhero> Superheroes) {
        this.Superheroes = Superheroes;
    }

    public ArrayList<Superhero> getSuperheroes() {
        return Superheroes;
    }
    public void addSuperhero(Superhero X){
        Superheroes.add(X);
    }
    public void removeSuperhero(int index){
        Superheroes.remove(index);
    }
    public void setCivilians(int index, int number){
        Superheroes.get(index).setNumberOfCiviliansSaved(number);
    }




    public static void main(String args[])throws IOException{
        boolean execute=true;
        File file= new File("data.json");
        Gson gson=new Gson();
        MainApplication instance;
        if(file.exists()){
            if(file.length()!=0){
               JsonElement fileElement=JsonParser.parseReader(new FileReader(file));
               JsonObject  fileObject=fileElement.getAsJsonObject();
               instance=gson.fromJson(fileObject, MainApplication.class);
            }
            else{
                 instance=new MainApplication();
            }
        }
        else{
            instance=new MainApplication();
        }

        Option option=new Option(instance);
        do {
            option.menuPrint();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int choice;
            System.out.print("Enter >> ");
            choice = Integer.parseInt(br.readLine());
             execute=option.performOption(choice);
            System.out.println();
        }while(execute);
        file.createNewFile();
        FileWriter fileWriter=new FileWriter(file);
        String json=gson.toJson(instance);
        fileWriter.write(json);
        fileWriter.close();




    }




}
