package shapes;

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

    }

    public void setRadiusY(int radiusYIn) {

        radiusY = radiusYIn;

    }

    //  Other Methods

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(getColor());
        g.fillOval(0, 0, getWidth(), getHeight());

    }

    //  Constructors

    public Oval() {

    }

}