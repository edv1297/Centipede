package Project2Centipede;

import objectdraw.*;
import java.awt.*;

public class Segment {

    // width of segment image
    private static final int SEGMENT_WIDTH = 16;  

    // number of pixels a segment should travel in the X direction 
    private static final int SEGMENT_STEP_X = SEGMENT_WIDTH / 5;

    // number of pixels a segment should travel in the Y direction
    private static final int SEGMENT_STEP_Y = 16;

    private VisibleImage segment;
    private boolean movingRight;
    private Field shrooms;

    public Segment(Image segImg, int x, int y, DrawingCanvas aCanvas, Field mushroomField, Zapper zap1){
        DrawingCanvas canvas = aCanvas;
        shrooms = mushroomField;
        segment = new VisibleImage(segImg, x, y, canvas, shrooms);
        movingRight = true;

    }

    public double getX(){
        return segment.getX();
    }

    public boolean isAlive(){
    
    
    }
    public void kill(){
        segment.hide();
    }
    public double getY(){
        return segment.getY();
    }

    public void step(){
        if(movingRight){
            segment.move (SEGMENT_STEP_X,0);
            if(segment.getX() == canvas.getWidth() || (segment.getX() == field.getColumn(segment.getX())) &&
            segment.getY() == field.getRow(segment.getY())){
            segment.move()
            
            }
            
        }
        else if(segment.getX()>= canvas.getWidth()){
            segment.move (-SEGMENT_STEP_X,0);
        }
    }

    public void shiftDown(){
        segment.move(0,SEGMENT_STEP_Y);
    }

    public void removeFromCanvas(){
        segment.removeFromCanvas();
    }

    public Location getLocation(){
        return segment.getLocation();
    }

}