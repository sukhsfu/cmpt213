package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

import java.util.Random;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This graph class is responsible for printing the maze initially when the game starts and initializes cells where needed
 */

public class graph {

    static maze grid;
    int cols;
    int rows;
    Cell newCell;
    static int w = 0; //temp x value
    static int h = 0; //temp y value
    static int e = 0; //buffer for x value
    static int f = 0; //buffer for y value
    static int life = 0; //counter for the power in maze
    static int t = 0; //global x value for power while loop
    static int v = 0; //global y value for power while loop


    public graph() {
        grid = new maze();
        cols = grid.getNUM_COLS();
        rows = grid.getNUM_ROWS();
    }

    public static maze getGrid() {
        return grid;
    }

    public static int getW() {
        return w;
    }

    public static void setW(int w) {
        graph.w = w;
    }

    public static int getH() {
        return h;
    }

    public static void setH(int h) {
        graph.h = h;
    }

    public static int getE() {
        return e;
    }

    public static void setE(int e) {
        graph.e = e;
    }

    public static int getF() {
        return f;
    }

    public static void setF(int f) {
        graph.f = f;
    }

    public static int getT() {
        return t;
    }

    public static void setT(int t) {
        graph.t = t;
    }

    public static int getV() {
        return v;
    }

    public static void setV(int v) {
        graph.v = v;
    }

    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        graph.life = life;
    }

    public void newGraph(){ //default graph shown at the start of the game
        int num = 0;
        int p = 0;
        int l = 0;
        while(num != 1){
            p = generateX(rows-1);
            l = generateY(cols-1);
            boolean see = checkXY(p,l);
            if(see == false){
                num = 1;
            }
        }
        for(int x = 0; x < cols + 2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                newCell = grid.getCell(x,y);
                if((newCell.wall != true) && (x == 0) && (y == 0)){
                    System.out.print("@" + "\t");
                    newCell.hero = true;
                    w = x;
                    h = y;
                }
                else if ((x == 0)&&(y == 1))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 1)&&(y == 0))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 1)&&(y == 1))
                {
                    newCell.reveal = true;
                    if(newCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else if ((x == 0) && (y == 12)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == 17) && (y == 0)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == 17) && (y == 12)){
                    System.out.print("!" + "\t");
                    newCell.monster = true;
                }
                else if ((x == p) && (y == l) && (newCell.hero != true)){
                    if(newCell.monster == true)
                    {
                        newCell.power = true;
                        life = 1;
                    }
                    else{
                        System.out.print("$" + "\t");
                        life = 1;
                        newCell.power = true;
                    }
                }
                else
                {
                    System.out.print("." + "\t");
                    if(newCell.wall == true)
                    {
                        newCell.wall = true;
                    }
                    else
                    {
                        newCell.wall = false;
                    }
                }
            }
            System.out.print('#');
            System.out.println();
        }
        for(int x = 0; x < cols + 2; x++){
            System.out.print("#\t");
        }
        System.out.println();
    }

    public static int generateX(int a){
        Random rand = new Random();
        return rand.nextInt(a);
    }

    public static int generateY(int b){
        Random rand = new Random();
        return rand.nextInt(b);
    }

    public boolean checkXY(int a, int b){
        newCell = grid.getCell(a,b);
        if((newCell.wall == true) || (newCell.hero == true)){
            return true;
        }
        return false;
    }
}
