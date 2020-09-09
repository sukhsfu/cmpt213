package ca.cmpt213.a2.model;
import java.util.ArrayList;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: Cell class stores the information about the particular cell on the board.
 */

public class Cell {
    public boolean visited;
    public int i;
    public int j;
    public boolean wall;
    public boolean reveal;
    public boolean power ;
    public boolean monster;
    public boolean hero;
    public int tracker;
    public boolean here;
    public ArrayList<Cell> neighbours;

    public Cell(int i,int j){
        this.i=i;
        this.j=j;
        this.here = false;
        this.visited=false;
        this.wall = true;
        this.hero = false;
        this.reveal = false;
        this.power = false;
        this.monster = false;
        tracker=-1;
        neighbours=new ArrayList<Cell>();
    }
}