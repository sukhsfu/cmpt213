package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This checkGraph class reveals all the 8 cells surrounding the hero cell when the hero moves through the game.
 */

public class checkGraph {
    Cell thisCell;
    maze gridGraph;
    int cols;
    int rows;
    public checkGraph()
    {
        gridGraph = graph.getGrid();
        cols = gridGraph.getNUM_COLS();
        rows = gridGraph.getNUM_ROWS();
    }

    public void checkGraph(){ //checks all 8 neighbouring cell to the hero cell
        int a = graph.getE();
        int b = graph.getF();
        for(int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                thisCell = gridGraph.getCell(x, y);
                if ((x == a - 1) && (y == b)) {
                    thisCell.reveal = true;
                } else if ((x == a + 1) && (y == b)) {
                    thisCell.reveal = true;
                } else if ((x == a - 1) && (y == b + 1)) {
                    thisCell.reveal = true;
                } else if ((x == a) && (y == b + 1)) {
                    thisCell.reveal = true;
                } else if ((x == a + 1) && (y == b + 1)) {
                    thisCell.reveal = true;
                } else if ((x == a - 1) && (y == b - 1) ) {
                    thisCell.reveal = true;
                } else if ((x == a) && (y == b - 1)) {
                    thisCell.reveal = true;
                } else if ((x == a + 1) && (y == b - 1)) {
                    thisCell.reveal = true;
                }
            }
        }
    }
}
