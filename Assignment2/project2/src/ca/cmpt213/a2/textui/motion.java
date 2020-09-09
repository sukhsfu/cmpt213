package ca.cmpt213.a2.textui;

import ca.cmpt213.a2.model.Cell;
import ca.cmpt213.a2.model.maze;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This motion class is responsible for the movement of the hero and reaction to certain conditions like when the hero is killed or the hero grabs a power
 */

public class motion {
    maze myGraph;
    checkGraph check = new checkGraph();
    Cell tempCell;
    int cols, rows;
    int x1, x2, y1, y2, num, tempE, tempF;
    monsters chime;
    public motion()
    {
        myGraph = graph.getGrid();
        cols = myGraph.getNUM_COLS();
        rows = myGraph.getNUM_ROWS();
        chime = new monsters();
    }

    public int movement(int j){
        int counter = 0;
        if(j == 1)
        {
            x1 = graph.getW();
            x2 = graph.getH();
            int k = 0;
            if(x1 == 0)
            {
                return 1;
            }
            else
            {
                k = x1-1;
            }
            tempCell = myGraph.getCell(k,x2);
            if(tempCell.wall == true)
            {
                return 1;
            }
            else if ((tempCell.monster == true) && (tempCell.power == true))
            {
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                graph.setT(y1);
                graph.setV(y2);
                counter = 0;
                graph.setE(k);
                graph.setF(x2);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 4;
            }
            else if((tempCell.monster == true))
            {
                int verify = 0;
                tempCell.hero = true;
                graph.setE(k);
                graph.setF(x2);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 2;
            }
            else if(tempCell.power == true)
            {
                tempCell.power = false;
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                graph.setT(y1);
                graph.setV(y2);
                counter = 0;
                graph.setE(k);
                graph.setF(x2);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 3;
            }
            else
            {
                tempCell.hero = true;
                graph.setE(k);
                graph.setF(x2);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 0;
            }
        }
        else if(j == 2)
        {
            x1 = graph.getW();
            x2 = graph.getH();
            int k = 0;
            if(x2 == 0)
            {
                return 1;
            }
            else
            {
                k = x2 - 1;
            }
            tempCell = myGraph.getCell(x1,k);
            if(tempCell.wall == true)
            {
                return 1;
            }
            else if ((tempCell.monster == true) && (tempCell.power == true))
            {
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(x1);
                graph.setF(k);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 4;
            }
            else if(tempCell.monster == true)
            {
                tempCell.hero = true;
                graph.setE(x1);
                graph.setF(k);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 2;
            }
            else if(tempCell.power == true)
            {
                tempCell.power = false;
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(x1);
                graph.setF(k);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 3;
            }
            else
            {
                tempCell.hero = true;
                graph.setE(x1);
                graph.setF(k);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 0;
            }
        }
        else if (j == 3)
        {
            x1 = graph.getW();
            x2 = graph.getH();
            int k = 0;
            if(x1 == 17)
            {
                return 1;
            }
            else
            {
                k = x1 + 1;
            }
            tempCell = myGraph.getCell(k,x2);
            if(tempCell.wall == true)
            {
                return 1;
            }
            else if ((tempCell.monster == true) && (tempCell.power == true))
            {
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(k);
                graph.setF(x2);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 4;

            }
            else if(tempCell.monster == true)
            {
                tempCell.hero = true;
                graph.setE(k);
                graph.setF(x2);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 2;
            }
            else if(tempCell.power == true)
            {
                tempCell.power = false;
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(k);
                graph.setF(x2);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 3;
            }
            else
            {
                tempCell.hero = true;
                graph.setE(k);
                graph.setF(x2);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 0;
            }
        }
        else if (j == 4)
        {
            x1 = graph.getW();
            x2 = graph.getH();
            int k = 0;
            if(x2 == 12)
            {
                return 1;
            }
            else
            {
                k = x2 + 1;
            }
            tempCell = myGraph.getCell(x1,k);
            if(tempCell.wall == true)
            {
                return 1;
            }
            else if ((tempCell.monster == true) && (tempCell.power == true))
            {
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(x1);
                graph.setF(k);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 4;
            }
            else if(tempCell.monster == true)
            {
                tempCell.hero = true;
                graph.setE(x1);
                graph.setF(k);
                tempCell.monster = false;
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                check.checkGraph();
                return 2;
            }
            else if(tempCell.power == true)
            {
                tempCell.power = false;
                tempCell.hero = true;
                graph.setLife(0);
                while(counter != 1){
                    y1 = graph.generateX(rows-1);
                    y2 = graph.generateY(cols-1);
                    boolean see = modifyXY(y1,y2);
                    if(see == false){
                        counter = 1;
                    }
                }
                counter = 0;
                graph.setE(x1);
                graph.setF(k);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 3;
            }
            else
            {
                tempCell.hero = true;
                graph.setE(x1);
                graph.setF(k);
                tempCell = myGraph.getCell(x1,x2);
                tempCell.hero = false;
                tempE = graph.getE();
                tempF = graph.getF();
                graph.setW(tempE);
                graph.setH(tempF);
                chime.moveMonsters();
                check.checkGraph();
                return 0;
            }
        }
        return 0;
    }

    public boolean modifyXY(int a, int b){
        tempCell = myGraph.getCell(a,b);
        if((tempCell.wall == true) || (tempCell.hero == true)){
            return true;
        }
        return false;
    }
}
