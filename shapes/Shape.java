package shapes;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * This class represents a shape is a JPanel.
 * 
 * Uses Absolute (null) layout.
 * 
 * @see Color
 * @see JPanel
 */
@SuppressWarnings("serial")
public abstract class Shape extends JPanel {

    private Color color;

    //  Getters

    public Color getColor() {

        return color;

    }

    //  Setters
    
    public void setColor(Color colorIn) {

        color = colorIn;

    }

    //  Other Methods

    @Override
    public String toString() {

        String returnString = new String();
        String formatter = "Shape: [x:{%d}, y:{%d}, width:{%d}, height:{%d}, color:{%s}]";

        returnString = String.format(
            formatter, getX(), getY(), getWidth(), getHeight(), getColor().toString()
            );

        return returnString;

    }

    //  Constructors

    public Shape() {

        this(0, 0, 0, 0, Color.WHITE);

    }

    public Shape(int widthIn, int heightIn) {

        this(0, 0, widthIn, heightIn, Color.WHITE);

    }

    public Shape(int xIn, int yIn, int widthIn, int heightIn) {

        this(xIn, yIn, widthIn, heightIn, Color.WHITE);

    }

    public Shape(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

        setLayout(null);
        setBounds(xIn, yIn, widthIn, heightIn);
        setBackground(new Color(0,0,0,0));
        setOpaque(true);
        setColor(colorIn);

    }

}