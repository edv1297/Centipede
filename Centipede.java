package Project2Centipede;

import java.awt.*;
import objectdraw.*;

public class Centipede extends ActiveObject {

    // offset between segments when they are created
    private static final int SEGMENT_OFFSET_X = 12;

    // pause time between moving all of the segments
    private static final int CENTIPEDE_PAUSE = 30;

    private int segmentCount=0;
    private int steps=0;
    private DrawingCanvas canvas;
    private Image segPic;
    private Segment[] centiSeg;
    private int directionMod;

    public Centipede(int maxSize, Image segPic, DrawingCanvas aCanvas, Field mushroomField, Zapper zap1 ) {
        canvas = aCanvas;
        centiSeg = new Segment [maxSize];
        Field field = mushroomField;
        Zapper zap = zap1;
        for (int a = 0; a < maxSize-1; a++){
            Segment segment = new Segment(segPic, a*SEGMENT_OFFSET_X, 0, canvas, field, zap1);
            centiSeg[a] = segment;

        } 

        this.start(); // starts the centipede 

    }

    // what happens when the centipede is started
    public void run() {
        int h = 0;
        boolean gameOver = false;
        while (!gameOver){


            for(int i= 0; i < centiSeg.length-1; i++){

                    centiSeg[i].step();
                    pause(CENTIPEDE_PAUSE);
                }
            }
            for(int i = 0; i <centiSeg.length-1; i++){

                centiSeg[i].shiftDown();
                pause(CENTIPEDE_PAUSE);

            }h++;


        }
    }
}