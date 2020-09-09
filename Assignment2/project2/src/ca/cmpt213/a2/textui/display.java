package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE:
DESCRIPTION: This display graph class is responsible for displaying the full maze with walls and spaces either when the game ends or the m key is pressed
 */

public class display {
    maze fullGraph;
    int cols;
    int rows;
    Cell myCell;

    public display()
    {
        fullGraph = graph.getGrid();
        cols = fullGraph.getNUM_COLS();
        rows = fullGraph.getNUM_ROWS();
    }

    public void displayGraph()
    {
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                myCell = fullGraph.getCell(x,y);
                if(myCell.wall == true)
                {
                    System.out.print("#" + "\t");
                }
                else if (myCell.hero == true)
                {
                    System.out.print("@" + "\t");
                }
                else if (myCell.monster == true)
                {
                    System.out.print("!" + "\t");
                }
                else if (myCell.power == true)
                {
                    if(myCell.monster != true)
                    {
                        System.out.print("$" + "\t");
                    }
                }
                else
                {
                    System.out.print(" " + "\t");
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
}
