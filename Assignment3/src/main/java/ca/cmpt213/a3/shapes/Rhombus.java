package ca.cmpt213.a3.shapes;
/*
Rhombus class is the  concrete class which implements the ShameImp and provides the functionality of whether the
given cell is inside the rhombus and also whether the given cell is border of the rhombus.
 */
public class Rhombus extends ShapeImpl {
    int length;
    public Rhombus(int X, int Y, int length) {
        super(X, Y, 2*length-1,2* length-1);
        this.length=length;

    }

    @Override
    boolean isBorder(int a, int b) {
        if(b<getLocationY()+length){
            int l=b-getLocationY();
            if(a==(getLocationX()+length-l-1)){
                return true;
            }
            if(a==(getLocationX()+length+l-1)){
                return true;
            }
        }
        else{
            int l=b-getLocationY();
            if(a==(getLocationX()+l-length+1)){
                return true;
            }
            if(a==(getLocationX()+3*length-l-3)){
                return true;
            }
        }


        return false;
    }

    @Override
    boolean isInside(int a, int b) {
        if(b<getLocationY()+length){
            int l=b-getLocationY()+1;
            if(a>=getLocationX()+length-l&&a<getLocationX()+length+l-1){
                return  true;
            }
        }
        else{
            int l=b-getLocationY();
            if(a>getLocationX()+(l-length)&&a<getLocationX()+2*length-(l-length)-2){
                return  true;
            }
        }

        return false;
    }
}
