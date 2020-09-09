package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

import java.util.Collections;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This monster class is responsible for moving the monsters psuedo randomly through the maze.
 */

public class monsters {

    Cell oldCell;
    maze oldMaze;
    int rows, cols;
    int a1, a2, b1, b2, c1, c2;
    public monsters()
    {
        oldMaze = graph.getGrid();
        cols = oldMaze.getNUM_COLS();
        rows = oldMaze.getNUM_ROWS();
    }

    public void moveMonsters() {
        int counter = 1;
        for (int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                oldCell = oldMaze.getCell(i, j);
                if((oldCell.monster == true)&&(counter == 1))
                {
                    a1 = i;
                    a2 = j;
                    counter++;
                }
                else if((oldCell.monster == true)&&(counter == 2))
                {
                    b1 = i;
                    b2 = j;
                    counter++;
                }
                else if((oldCell.monster == true)&&(counter == 3))
                {
                    c1 = i;
                    c2 = j;
                    counter = 1;
                }
            }
        }
        for(int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                oldCell = oldMaze.getCell(x, y);
                if((x == a1) && (y == a2))
                {
                    Collections.shuffle(oldCell.neighbours);
                    int len = oldCell.neighbours.size();
                    int track = 0;
                    int found = 0;
                    for(int f = 0; f < len; f++)
                    {
                        if(oldCell.neighbours.get(f).hero == true)
                        {
                            found = 1;
                            break;
                        }
                        else if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false) && (oldCell.neighbours.get(f).here == false))
                        {
                            oldCell.monster = false;
                            oldCell.here = true;
                            oldCell.neighbours.get(f).monster = true;
                            break;
                        }
                        else
                        {
                            track++;
                        }
                    }
                    if(track == len)
                    {
                        for(int f = 0; f < len; f++)
                        {
                            if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false))
                            {
                                oldCell.monster = false;
                                oldCell.here = true;
                                oldCell.neighbours.get(f).monster = true;
                                break;
                            }
                        }
                    }
                }
                else if ((x == b1) && (y == b2))
                {
                    Collections.shuffle(oldCell.neighbours);
                    int len = oldCell.neighbours.size();
                    int track = 0;
                    int found = 0;
                    for(int f = 0; f < len; f++)
                    {
                        if(oldCell.neighbours.get(f).hero == true)
                        {
                            found = 1;
                            break;
                        }
                        else if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false) && (oldCell.neighbours.get(f).here == false))
                        {
                            oldCell.monster = false;
                            oldCell.here = true;
                            oldCell.neighbours.get(f).monster = true;
                            break;
                        }
                        else
                        {
                            track++;
                        }
                    }
                    if(track == len)
                    {
                        for(int f = 0; f < len; f++)
                        {
                            if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false))
                            {
                                oldCell.monster = false;
                                oldCell.here = true;
                                oldCell.neighbours.get(f).monster = true;
                                break;
                            }
                        }
                    }
                }
                else if ((x == c1) && (y == c2))
                {
                    Collections.shuffle(oldCell.neighbours);
                    int len = oldCell.neighbours.size();
                    int track = 0;
                    int found = 0;
                    for(int f = 0; f < len; f++)
                    {
                        if(oldCell.neighbours.get(f).hero == true)
                        {
                            found = 1;
                            break;
                        }
                        else if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false) && (oldCell.neighbours.get(f).here == false))
                        {
                            oldCell.monster = false;
                            oldCell.here = true;
                            oldCell.neighbours.get(f).monster = true;
                            break;
                        }
                        else
                        {
                            track++;
                        }
                    }
                    if(track == len)
                    {
                        for(int f = 0; f < len; f++)
                        {
                            if((oldCell.neighbours.get(f).wall == false) && (oldCell.neighbours.get(f).hero == false))
                            {
                                oldCell.monster = false;
                                oldCell.here = true;
                                oldCell.neighbours.get(f).monster = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
