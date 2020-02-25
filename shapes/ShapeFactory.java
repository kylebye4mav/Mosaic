package shapes;

import java.awt.Color;

/**
 * @author  Kyle Bye
 * @see Shape
 * @see Oval
 * @see Rectangle
 */
public final class ShapeFactory {
    
    public final static String[] ALL_SHAPE_TYPES = {
        "oval", "rectangle"
    };

    public final static String OVAL = "oval";
    public final static String RECTANGLE = "rectangle";

    public final static Shape createShape(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, String shapeType) {

        Shape returnShape = null;

        shapeType = shapeType.toLowerCase().trim();

        if (shapeType.equals(OVAL)) {

            returnShape = new Oval(xIn, yIn, widthIn/2, heightIn/2, colorIn);

        }
        else if (shapeType.equals(RECTANGLE)) {

            returnShape = new Rectangle(xIn, yIn, widthIn, heightIn, colorIn);

        }

        return returnShape;

    }
}