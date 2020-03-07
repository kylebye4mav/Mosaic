package shapes;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Kyle Bye
 * @see Shape
 * @see JPanel
 */
@SuppressWarnings("serial")
public class SemiOval extends Shape {

    //  Static Properties that determine which
    //  direction the flat side of this SemiOval
    //  instance is facing.
    public static final int DIRECTION_UP = 0;
    public static final int DIRECTION_DOWN = 1;

    //  Properties
    private int direction;
    private int radiusX;
    private int radiusY;

    //  Getters
    public int getDirection() { return direction; }
    public int getRadiusX() { return radiusX; }
    public int getRadiusY() { return radiusY; }

    //  Setters
    public void setDirection(int directionIn) {

        if (directionIn >= 0 && directionIn < 2) {
            direction = directionIn;
        }

    }

    public void setRadiusX(int radiusXIn) { 

        if (radiusXIn >= 0) radiusX = radiusXIn;

    }

    public void setRadiusY(int radiusYIn) {

        if (radiusYIn >= 0) radiusY = radiusYIn;

    }

    //   Other Methods
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //  This SemiOval is drawn by shifting half
        //  an oval beyond this instance's bound so 
        //  only half of an Oval paints.
        int yOffset = -1;

        if (direction == DIRECTION_UP) {

            //  Shift the SemiOval up by half of its 
            //  vertical diameter.
            yOffset = -1*getHeight()/2;
        }
        else if (direction == DIRECTION_DOWN) {

            //  Shift the SemiOval down by half of its
            //  vertical diameter.
            yOffset = getHeight()/2;
        }

        g.setColor(getColor());
        g.fillOval(0, yOffset, getWidth(), getHeight());

    }

    @Override
    public String toString() {

        String returnString = new String();
        String formatter = "%s::SemiOval[direction:{%d}, radiusX:{%d}, radiusY:{%d}]";

        returnString = String.format(
            formatter, super.toString(), direction, radiusX, radiusY
            );

        return returnString;

    }

    //   Constructors

    public SemiOval() {

        this(0, 0, 0, 0, Color.WHITE);

    }
    
    public SemiOval(int radiusXIn, int radiusYIn) {

        this(0, 0, radiusXIn, radiusYIn, Color.WHITE);

    }

    public SemiOval(int xIn, int yIn, int radiusXIn, int radiusYIn) {

        this(xIn, yIn, radiusXIn, radiusYIn, Color.WHITE);

    }

    public SemiOval(int xIn, int yIn, int radiusXIn, int radiusYIn, Color colorIn) {

        this(xIn, yIn, radiusXIn, radiusYIn, colorIn, DIRECTION_UP);

    }

    public SemiOval(int xIn, int yIn, int radiusXIn, int radiusYIn, Color colorIn, int directionIn) {

        //  Initialize the SemiOval's parent: Shape.
        super(xIn, yIn, radiusXIn*2, radiusYIn*2, colorIn); 

        //  Initialize the direction of where the flat side of the semioval is facing.
        //      -   DIRECTION_UP or 0 means that the flat side is facing up.
        //      -   DIRECTION_DOWN or 1 means that the flat side is facing down.
        setDirection(directionIn);

        //  Initialize the radiuses of this instance.
        setRadiusX(radiusXIn);
        setRadiusY(radiusYIn);  
    }

}