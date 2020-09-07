package ca.cmpt213.a3.shapes;
/*
TextBox is the concrete class which extends the rectangle class and
provide the functionality of displaying the message inside the rectangle.
 */
import ca.cmpt213.a3.UI.Canvas;



public class TextBox extends Rectangle {
    String message;

    public TextBox(int X, int Y, int width, int heigth,String message) {
        super(X, Y, width, heigth);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);



        int cnt=0;
        boolean firstChar=true;
        for (int yPos = getLocationY(); yPos < getLocationY() + getHeight(); yPos++) {

            for (int xPos = getLocationX(); xPos < getLocationX() + getWidth(); xPos++) {
                if(!isBorder(xPos,yPos)){
                    if(firstChar&&message.charAt(cnt)!=' '){
                        firstChar=false;
                    }
                    canvas.setCellText(xPos,yPos,message.charAt(cnt++));
                }
                if(cnt==message.length()){
                    break;
                }
            }
            while(cnt<message.length()&&message.charAt(cnt)==' '&&!firstChar){
                cnt++;
            }
        }

    }
}
