package ca.cmpt213.a2.textui;

import java.util.Scanner;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE:
DESCRIPTION: This options class is responsible for the menu options and header titles displayed on the game screen.
 */

public class options {

    private String title;
    private String[] legend;

    options(String title, String[] legend)
    {
        this.title = title;
        this.legend = legend;
    }

    public String[] getLegend(){
        return this.legend;
    }

    private void printBarrier(int x){
        int j = x + 2;
        for(int i = 0; i < j; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void displayTitle(int counter){
        int titleLen = title.length();
        printBarrier(titleLen);
        System.out.println(counter + ")" + " " + title + " ");
        printBarrier(titleLen);
    }

    public void displayMainMenu(){
        System.out.println("DIRECTIONS: ");
        System.out.println("\t" + "\t" + "Kill 3 Monsters!");
        System.out.println("LEGEND: ");
        for(int j = 0; j < legend.length; j++){
            System.out.println("\t" + "\t" + legend[j]);
        }
        System.out.println("MOVES: ");
        System.out.println("\t" + "\t" + "Use W (up), A (left), S(down) and D (right) to move. Use Q to quit.");
        System.out.println("\t" + "\t" + "(You must press enter after each move).");
    }

    public void displayOptions(int monsters, int powers, int alive){
        System.out.println("Total number of monsters to be killed: " + monsters);
        System.out.println("Number of powers currently in possesion: " + powers);
        System.out.println("Number of Monsters alive: " + alive);
    }

    public String getUserInput(){
        Scanner enter = new Scanner(System.in);
        System.out.print("Enter your move [WASD?]: ");
        return enter.nextLine().toLowerCase();
    }

}
