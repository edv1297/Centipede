package Project2Centipede;


import java.awt.*;
import objectdraw.*;

public class Missile extends ActiveObject {
    

    private VisibleImage shot;
    private DrawingCanvas canvas;
    private static final int STEP_SIZE = -6;
    private static final int PAUSE_TIME = 30;
    
    public Missile(Image laser, double x, double y, DrawingCanvas aCanvas) {
        canvas = aCanvas;
        shot = new VisibleImage (laser,x,y, canvas);
        
        this.start();
    }
    //this makes the missile move upwards until it reaches the top of the canvas then it is removed
    public void run() {
        
        while (shot.getY() >0) {
        shot.move(0,STEP_SIZE);
        pause(PAUSE_TIME);
        
        }
        shot.removeFromCanvas();
    }
    
    // checks if the missile hits a centipede segment
    public boolean centipedeHit(VisibleImage segment){
    return shot.overlaps(segment);
    
    }
    
    // checks if the missile hits a mushroom
    public boolean mushroomHit(VisibleImage shroom){
    return shot.overlaps(shroom);
    
    }
    
}
