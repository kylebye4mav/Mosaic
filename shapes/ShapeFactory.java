package shapes;

import java.awt.Color;

/**
 * This class is responsible for creating and returning
 * <code>Shape</code> objects based on the parameters given.
 * 
 * @author  Kyle Bye
 * @see Shape
 * @see Oval
 * @see Rectangle
 */
public final class ShapeFactory {

    //  Immutable Properties

    public final static String[] ALL_SHAPE_TYPES = {
        "oval", "rectangle"
    };

    public final static String OVAL = "oval";
    public final static String RECTANGLE = "rectangle";

    /**
     * Create and returns a <code>Shape</code> object based on
     * the provided parameters.
     * 
     * @param   xIn x coordinate of <code>Shape</code>.
     * @param   yIn y coordinate of <code>Shape</code>.
     * @param   widthIn width of <code>Shape</code>.
     * @param   heightIn    height of <code>Shape</code>.
     * @return  a <code>Shape</code> instance.
     */
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