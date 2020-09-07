package ca.cmpt213.a3.shapes;
/*
Rectangle is the concrete class that provides the functionality of the checking whether the given cell is
inside the rectangle and also whether the given cell is border of the rectangle.
 */

public class Rectangle extends ShapeImpl {
    public Rectangle(int X,int Y,int width,int heigth){
        super(X,Y,width,heigth);
    }
    @Override
    boolean isBorder(int a, int b) {
        if(a==getLocationX()||a==getLocationX()+getWidth()-1){
            return true;
        }
        if(b==getLocationY()||b==getLocationY()+getHeight()-1){
            return true;
        }

        return false;
    }

    @Override
    boolean isInside(int a, int b) {
        return true;
    }
}
