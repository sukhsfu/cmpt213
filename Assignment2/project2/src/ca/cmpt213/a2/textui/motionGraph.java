package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This graph class is responsible for printing out the resulting graph when the user has made a movement. i.e. WASD
 */

public class motionGraph {

    Cell moveCell;
    maze moveGraph;
    int cols;
    int rows;

    public motionGraph()
    {
        moveGraph = graph.getGrid();
        cols = moveGraph.getNUM_COLS();
        rows = moveGraph.getNUM_ROWS();
    }



    public void moveGraph(){ //graph shown when the hero is moved in the game
        int a = graph.getT();
        int b = graph.getV();
        int c = graph.getLife();
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();
        for(int x = 0; x < rows; x++){
            System.out.print("#\t");
            for(int y = 0; y < cols; y++){
                moveCell = moveGraph.getCell(x,y);
                if ((x == a) && (y == b) && (moveCell.hero != true) && (c == 0)){
                    if(moveCell.monster == true)
                    {
                        moveCell.power = true;
                        graph.setLife(1);
                        System.out.print("!" + "\t");
                    }
                    else{
                        System.out.print("$" + "\t");
                        graph.setLife(1);
                        moveCell.power = true;
                    }
                }
                else if(moveCell.hero == true)
                {
                    System.out.print("@" + "\t");
                }
                else if(moveCell.monster == true)
                {
                    System.out.print("!" + "\t");
                }
                else if(moveCell.power == true)
                {
                    System.out.print("$" + "\t");
                    graph.setLife(1);
                }
                else if (moveCell.reveal == true)
                {
                    if(moveCell.wall == true)
                    {
                        System.out.print("#" + "\t");
                    }
                    else
                    {
                        System.out.print(" " + "\t");
                    }
                }
                else
                {
                    System.out.print("." + "\t");
                }
            }
            System.out.print('#');
            System.out.println();
        }
        for(int x = 0; x < cols+2; x++){
            System.out.print("#\t");
        }
        System.out.println();
    }
}
