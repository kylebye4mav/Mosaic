package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class Rectangle extends Shape {

    //  Other Methods

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(getColor());
        g.fillRect(0, 0, getWidth(), getHeight());

    }

    @Override
    public String toString() {
        
        String returnString = new String();
        String formatter = "%s::Rectangle[]";

        returnString = String.format(formatter, super.toString());

        return returnString;

    }

    //  Constructors

    public Rectangle() {

        this(0, 0, 0, 0, Color.WHITE);

    }

    public Rectangle(int widthIn, int heightIn) {

        this(0, 0, widthIn, heightIn, Color.WHITE);

    }

    public Rectangle(int xIn, int yIn, int widthIn, int heightIn) {

        this(xIn, yIn, widthIn, heightIn, Color.WHITE);

    }

    public Rectangle(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

        super(xIn, yIn, widthIn, heightIn, colorIn);

    }

}