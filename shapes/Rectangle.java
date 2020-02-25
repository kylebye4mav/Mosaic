package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class Rectangle extends Shape {

    //  Other Methods

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(getColor());
        g.fillRect(0, 0, getWidth(), getHeight());

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