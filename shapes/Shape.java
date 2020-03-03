package shapes;

import javax.swing.JPanel;
import java.awt.Color;

/**
 * 
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