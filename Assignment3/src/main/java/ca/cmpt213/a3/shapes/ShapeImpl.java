package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;
/*
Abstract class contains all the attributes and methods which are shared by Rectangle and Rhombus.
 */

import java.awt.*;

abstract class ShapeImpl implements Shape {
    private int LocationX;
    private int LocationY;
    private char BorderChar;
    private Color color;
    private int width;
    private int height;
    ShapeImpl(int X, int Y, int width, int height){
        LocationX=X;
        LocationY=Y;
        this.width=width;
        this.height=height;
    }
    public int getLocationX(){
        return LocationX;
    }
    public int getLocationY(){
        return LocationY;
    }
    public void setBorderChar(char BorderChar){
        this.BorderChar=BorderChar;
    }
    public char getBorderChar(){
        return BorderChar;
    }
    public void setColor(Color color){
        this.color=color;
    }
    public Color getColor(){
        return color;
    }
    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
    abstract boolean isBorder(int a,int b);
    abstract boolean isInside(int a,int b);

    public void draw(Canvas canvas){
        for (int yPos=LocationY;yPos<LocationY+height;yPos++){
            for(int xPos=LocationX;xPos<LocationX+width;xPos++){
                if(isBorder(xPos,yPos)){
                    canvas.setCellText(xPos,yPos,BorderChar);

                }
                if(isInside(xPos,yPos)){
                    if(canvas.getCellText(xPos,yPos)!=BorderChar){
                        canvas.setCellText(xPos,yPos,' ');
                    }
                    canvas.setCellColor(xPos,yPos,color);
                }
            }
        }
    }



}

