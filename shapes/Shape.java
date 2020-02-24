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

    public Shape() {

    }

}