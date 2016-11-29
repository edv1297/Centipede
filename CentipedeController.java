package Project2Centipede;


import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CentipedeController extends WindowController implements KeyListener {

    // The height of the menu bar at the top of the window plus the height
    // of a JLabel put in the south of the content pane.  You can use this
    // constant to make a window big enough to hold a canvas of the desired
    // size and the menu and JLabel.  This constant was created to work
    // for our solution on Steve's Mac laptop --- you may wish to adjust 
    // it if you are on a PC or decide to lay out the window differently.
    private static final int MENU_AND_HEIGHT = 100;

    private Zapper zapper1;

    private Image zapImg, shroomImg, laserImg, segImg;
    private Field mushroomField;
    private Missile shot; 
    private Centipede crawlly;

    private int start_x = Field.CANVAS_WIDTH/2 - 20;
    private int start_y = Field.CANVAS_HEIGHT;

    public void begin() {
        // Make window large enough to hold canvas of desired size, the menu, and
        //  a JLabel
        this.setSize(Field.CANVAS_WIDTH, Field.CANVAS_HEIGHT + MENU_AND_HEIGHT);

        // Create the background for the game

        new FilledRect(0, 0, Field.CANVAS_WIDTH, Field.CANVAS_HEIGHT, canvas);

        shroomImg = getImage("shroom1.gif");
        mushroomField = new Field(shroomImg, 0,0, canvas);

        segImg = getImage("Segment1.gif");
        laserImg = getImage("LaserShot.png");
        zapImg = getImage ("Zapper1.png");
        zapper1 = new Zapper (zapImg, start_x , start_y, canvas);
        crawlly = new Centipede (10,segImg, canvas, mushroomField, zapper1);

       

        Container container = getContentPane();
        // create game here ...

        // set up key events.
        canvas.addKeyListener(this);
        container.addKeyListener(this);
        container.requestFocus();
        container.validate();
    }

    // Fill in this method as necessary.
    public void keyPressed(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_LEFT && zapper1.getX()>10) {     
            zapper1.moveLeft();
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT && zapper1.getX()<canvas.getWidth() - zapper1.getWidth()) {
            zapper1.moveRight();
        } else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            Missile shot = new Missile (laserImg, zapper1.getX() + zapper1.getWidth()/2-11, zapper1.getY()-32, canvas);
            
            //if the centipede is hit then we would remove from canvas. We are defining a new method to get a segment out of the
            //segment array in centipede.
          
            //if(shot.centipedeHit(crawlly.getSegmentAt()))
        }
    }

    // Part of KeyListener, but we don't need 
    // to do anything here
    public void keyTyped(KeyEvent evt) {  }

    // Part of KeyListener, but we don't need 
    // to do anything here
    public void keyReleased(KeyEvent evt) {  }

}
