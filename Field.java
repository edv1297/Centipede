package Project2Centipede;

import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Field {

    // The following two constants are declared to be "public"
    // so that other classes can refer to them.  We did this here
    // because the size of the canvas, the motion of the segments,
    // and other aspects of the grame are all dependent on how
    // wide and tall the mushrooms are.  See CentipedeController
    // for an example of how to refer to public static constants
    // in other classes.

    // dimensions of the canvas
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 512;

    // size of mushroom pictures
    private static final int SHROOM_SIZE = 16;  

    // dimensions of the mushroom array
    private static final int NUM_ROWS = CANVAS_HEIGHT / SHROOM_SIZE;
    private static final int NUM_COLS = CANVAS_WIDTH / SHROOM_SIZE;

    private DrawingCanvas canvas;
    private VisibleImage shroom;
    //private VisibleImage shroom;
    private VisibleImage [][] mushroomGarden;

    private RandomIntGenerator shroomGen = new RandomIntGenerator(0,15);
    ////// Helper methods to convert between (x,y) coordinates 
    ////// on the canvas and row and columns in the mushroom 
    ////// 2D array.

    public Field(Image shroomImg, int xLoc, int yLoc, DrawingCanvas aCanvas) { 
        canvas = aCanvas;

        mushroomGarden = new VisibleImage[NUM_ROWS][NUM_COLS];
        for(int numRows = 4; numRows < NUM_ROWS-3; numRows++){
            for(int numCols = 0; numCols < NUM_COLS; numCols++){
                double y = SHROOM_SIZE * numRows;
                double x = SHROOM_SIZE* numCols;
                VisibleImage shroom = new VisibleImage(shroomImg, x ,y ,canvas);
                int shroomLoc = shroomGen.nextValue();
                if (shroomLoc!=1){
                    shroom.hide();
                }   
            }
        }

    }

    public boolean overlapsShroom (Location point){

        int x = this.getRow(point.getX());
        int y = this.getColumn(point.getY());
        if(!mushroomGarden [x][y].isHidden()){

            return true;
        }else{
            return false;
        }
    }

    public void showShroom(double x, double y){
        shroom = mushroomGarden [this.getColumn(shroom.getX())][this.getRow(shroom.getY())];
        if(shroom.isHidden()){
            shroom.show();
        }

    }

    public void hideShroom(double x, double y){
        int x = this.getRow(shroom.getY());
        int y = this.getColumn(shroom.getX());
        if(!mushroomGarden [x][y].isHidden()){
            mushroomGarden[x][y].hide();

        }
    }

    // Convert a y coordinate in pixels to the corresponding
    //   row in the mushroom array
    private int getRow(double y) {
        return (int)(y / SHROOM_SIZE);
    }

    // Convert a x coordinate in pixels to the corresponding
    //   column in the mushroom array
    private int getColumn(double x) {
        return (int)(x / SHROOM_SIZE);
    }

}
