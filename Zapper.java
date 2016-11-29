package Project2Centipede;

import objectdraw.*;
import java.awt.*;

public class Zapper extends ActiveObject {
    private static final int DIMENSIONS = 15;
    private VisibleImage zapper;
    private static final int X_STEP = 6;
    private static final int Y_STEP = 0; 
    private DrawingCanvas canvas;
     
    public Zapper(Image zapImg, double x, double y, DrawingCanvas aCanvas){
        canvas = aCanvas;
        zapper = new VisibleImage (zapImg, x, y, canvas);      

    }

    public void moveLeft(){
        zapper.move(-X_STEP, Y_STEP);
    }

    public void moveRight(){
        zapper.move(X_STEP, Y_STEP);
    }

    public double getX(){
        return zapper.getX();
    }

    public double getY(){
        return zapper.getY();
    }

    public double getWidth(){
        return zapper.getWidth()+8;
    }

}
