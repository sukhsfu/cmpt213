package ca.cmpt213.a3.shapes;
/*
Interface which defines all the methods which a given shape should have.
 */

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

public interface Shape {
    int getLocationX();
    int getLocationY();
    void setBorderChar(char c);
    char getBorderChar();
    void setColor(Color color);
    Color getColor();
    void draw(Canvas canvas);
}
