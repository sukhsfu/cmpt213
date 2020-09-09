package ca.cmpt213.a2.model;
import java.util.Random;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: Creates the double dimension array of cells for the board. Assign neighbours to the cells.
 */

public class maze {

    private int NUM_ROWS;
    private int NUM_COLS;
    private Cell cell[][];



    public maze() {
        this.NUM_ROWS = 18;
        this.NUM_COLS = 13;
        cell = new Cell[NUM_ROWS][NUM_COLS];

        for(int i=0;i<NUM_ROWS;i++) {
            for (int j = 0; j <NUM_COLS; j++) {
                cell[i][j]= new Cell(i,j);
            }
        }
        for(int i=0;i<NUM_ROWS;i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if(i!=0){//UP
                    cell[i][j].neighbours.add(cell[i-1][j]);
                }
                if(j!=0){//left
                    cell[i][j].neighbours.add(cell[i][j-1]);
                }
                if(j!=NUM_COLS-1){//right
                    cell[i][j].neighbours.add(cell[i][j+1]);
                }
                if(i!=NUM_ROWS-1){//down
                    cell[i][j].neighbours.add(cell[i+1][j]);
                }
            }
        }

        Random rand =new Random();
        int row=rand.nextInt(18);
        int column=rand.nextInt(13);
        Explorer explorer = new Explorer(cell[row][column],cell);

    }

    public int getNUM_ROWS() {
        return NUM_ROWS;
    }

    public int getNUM_COLS() {
        return NUM_COLS;
    }

    public Cell getCell(int i, int j){
        return cell[i][j];
    }

}
