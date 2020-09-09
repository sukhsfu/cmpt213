package ca.cmpt213.a2.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: Creates the maze using the rescursive backtracking. Remove 2*2 open and locked cells and then make all the
        cells that are not wall accessible.
 */


public class Explorer {

    Stack path=new Stack();
    Cell current;
    private Cell cells[][];


    public Explorer(Cell current,Cell[][] cells) {
        this.current = current;
        this.cells=cells;
        pathexplorer();

        CornerCleaner();

        removeLockedCells();
        removeOpenCells();
        CornerCleaner();
        openPath();
    }

    private void pathexplorer(){
        current.visited=true;
        path.push(current);
        while(!path.empty()){
            current = (Cell) path.pop();
            Collections.shuffle(current.neighbours);
            for(Cell neighbour:current.neighbours){
                if(!neighbour.visited) {
                    path.push(current);

                    current.wall=false;
                    neighbour.visited=true;
                    path.push(neighbour);


                }
            }
        }
    }
    private void removeOpenCells(){
        for(int i=0;i<18;i++){
            for(int j=0;j<13;j++){
                if(!cells[i][j].wall){
                    boolean neighbourWall=false;
                    int cnt=0;
                    if(i>0){
                        if(cells[i-1][j].wall){
                            cnt++;
                        }
                    }
                    if(j>0){
                        if(cells[i][j-1].wall){
                            cnt++;
                        }
                    }
                    if(i>0&&j>0){
                        if(cells[i-1][j-1].wall){
                            cnt++;
                        }
                    }
                    if(j<12){
                        if(cells[i][j+1].wall){
                            neighbourWall=true;
                        }
                    }
                    if(i<17){
                        if(cells[i+1][j].wall){
                            neighbourWall=true;
                        }
                    }
                    if(i<17&&j<12){
                        if(cells[i+1][j+1].wall){
                            neighbourWall=true;
                        }
                    }
                    if (!neighbourWall){
                        if(cnt!=3) {
                            cells[i][j].wall = true;
                        }
                        if(cnt==3&&i<17){
                            cells[i+1][j].wall = true;
                        }
                    }
                }
            }
        }
    }

    private void removeLockedCells() {
        for(int i=0;i<18;i++){
            for(int j=0;j<13;j++){
                if(cells[i][j].wall){
                    boolean neighbourWall=true;
                    if(j<12){
                        if(!cells[i][j+1].wall){
                            neighbourWall=false;
                        }
                    }
                    if(i<17){
                        if(!cells[i+1][j].wall){
                            neighbourWall=false;
                        }
                    }
                    if(i<17&&j<12){
                        if(!cells[i+1][j+1].wall){
                            neighbourWall=false;
                        }
                    }
                    if (neighbourWall){
                        cells[i][j].wall=false;
                    }
                }
            }
        }

    }
    private void CornerCleaner(){
        cells[0][0].wall=false;
        cells[0][12].wall=false;
        cells[17][0].wall=false;
        cells[17][12].wall=false;
    }
    private void trackingCells() {
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 13; j++) {
                if(!cells[i][j].wall){
                    cells[i][j].tracker=0;
                }
            }

        }
    }
    private void bfs(Cell start){
        Queue<Cell> path=new LinkedList<>();
        path.add(start);
        while(!path.isEmpty()){
            Cell blockcurrent=path.remove();
            blockcurrent.tracker=1;
            for(Cell neighbor:blockcurrent.neighbours){
                if(neighbor.tracker==0){
                    path.add(neighbor);
                }
            }
        }
    }

    private void openPath(){
        trackingCells();
        bfs(cells[0][0]);
        boolean repeat;
        do {
            repeat=false;
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 13; j++) {
                    Cell newCurrent = cells[i][j];
                    if (newCurrent.tracker == 0) {

                        for (Cell neighbour : newCurrent.neighbours) {
                            if (neighbour.wall&&!checkOpenBlock(neighbour) ) {
                                neighbour.wall = false;
                                bfs(newCurrent);
                                break;
                            }
                        }
                    }

                }
            }
            trackingCells();
            bfs(cells[0][0]);
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 13; j++) {
                    if(cells[i][j].tracker==0)
                        repeat=true;

                }
            }



        }while(repeat);


        CornerCleaner();
    }
    private boolean checkOpenBlock(Cell current){
        int i,j;
        i=current.i;
        j=current.j;
        boolean check=true;
        if(i>0&&j>0){
            if(cells[i-1][j-1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(i>0){
            if(cells[i-1][j].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(j>0){
            if(cells[i][j-1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(check)
            return true;

        if(i>0&&j<12){
            if(cells[i-1][j+1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(i>0){
            if(cells[i-1][j].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(j<12){
            if(cells[i][j+1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(check)
            return true;

        if(i<17&&j>0){
            if(cells[i+1][j-1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(i<17){
            if(cells[i+1][j].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(j>0){
            if(cells[i][j-1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(check)
            return true;

        if(i<17&&j<12){
            if(cells[i+1][j+1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(i<17){
            if(cells[i+1][j].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(j<12){
            if(cells[i][j+1].wall)
                check=false;
        }
        else{
            check=false;
        }
        if(check)
            return true;


        return false;

    }
}