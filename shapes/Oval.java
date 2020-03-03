package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class Oval extends Shape {

    private int radiusX;
    private int radiusY;

    //  Getters

    public int getRadiusX() {
        return radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

    //  Setters

    public void setRadiusX(int radiusXIn) {

        radiusX = radiusXIn;
        super.setBounds(getX(), getY(), radiusXIn*2, getHeight());

    }

    public void setRadiusY(int radiusYIn) {

        radiusY = radiusYIn;
        super.setBounds(getX(), getY(), getWidth(), getHeight());
    }

    //  Other Methods

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(getColor());
        g.fillOval(0, 0, getWidth(), getHeight());

    }

    //  Constructors

    public Oval() {

        this(0, 0, 0, 0, Color.WHITE);
        
    }

    public Oval(int radiusXIn, int radiusYIn) {

        this(0, 0, radiusXIn, radiusYIn, Color.WHITE);

    }

    public Oval(int xIn, int yIn, int radiusXIn, int radiusYIn) {

        this(xIn, yIn, radiusXIn, radiusYIn, Color.WHITE);
    }

    public Oval(int xIn, int yIn, int radiusXIn, int radiusYIn, Color colorIn) {

        super(xIn, yIn, radiusXIn*2, radiusYIn*2, colorIn);

    }

}