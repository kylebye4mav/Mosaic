import java.awt.Color;
import java.util.Random;
import shapes.*;

/**
 * This class has methods for creating MosaicTile instances 
 * based on the parameters given. Includes a method for creating
 * a random MosaicTile instance.
 * 
 * @author  Kyle Bye
 * @see Color
 * @see Face
 * @see MosaicTile
 * @see Random
 * @see Shape
 */
public final class MosaicTileFactory {

    private final static Random random = new Random(); 

    private final static Color[] colors = {
        Color.BLACK, Color.BLUE, Color.GRAY, 
        Color.DARK_GRAY, Color.RED, Color.WHITE, 
        Color.GREEN, Color.YELLOW, Color.CYAN, 
        Color.ORANGE
    };

    private final static char[] letters = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z'
    };

    /**
     * Creates and returns an instance of <code>MosaicTile</code> that has 
     * a randomly generated color, type of background <code>Shape</code>, 
     * letter, and a <code>Face</code<. Bounds are provided as parameters and
     * <code>createTile()</code> is responsible for actually instantiating the object.
     * 
     * @param   xIn   x coordinate of <code>MosaicTile</code>.
     * @param   yIn   y coordinate of <code>MosaicTile</code>.
     * @param   widthIn   width of <code>MosaicTile</code>.
     * @param   heightIn    height of <code>MosaicTile</code>.
     * @return  a randomly generated <code>MosaicTile</code> instance.
     * @see MosaicTileFactory#createTile(int, int, int, int, Color, String, char, Shape, Face)
     */
    public final static MosaicTile createRandomTile(int xIn, int yIn, int widthIn, int heightIn) {

        Color color = colors[random.nextInt(colors.length)];
        String shapeType = ShapeFactory.ALL_SHAPE_TYPES[random.nextInt(ShapeFactory.ALL_SHAPE_TYPES.length)];
        char letter = letters[random.nextInt(letters.length)];
        Shape backgroundShape = ShapeFactory.createShape(0, 0, widthIn, heightIn, color, shapeType);
        Face face = FaceFactory.generateRandomFace(color);

        return createTile(xIn, yIn, widthIn, heightIn, color, letter, backgroundShape, face);

    }

    /**
     * Creates and returns a instance of MosaicTile based on
     * all the parameters given.
     * 
     * @param   xIn x coordinate of <code>MosaicTile</code>.
     * @param   yIn y coordinate of <code>MosaicTile</code>.
     * @param   widthIn width of <code>MosaicTile</code>.
     * @param   heightIn    height of <code>MosaicTile</code>.
     * @param   colorIn tile's background shape <code>Color</code>
     *                  of <code>MosaicTile</code>.
     * @param   letterIn    letter to be centered in background shape.
     * @param   backgroundShapeIn   provided background <code>Shape</code> 
     *                              of tile.
     * @param   faceIn  provided <code>Face</code> of tile
     * @return  a <code>MosaicTile</code> object.
     */
    public final static MosaicTile createTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, 
    char letterIn, Shape backgroundShapeIn, Face faceIn) {

        MosaicTile tile;

        tile = new MosaicTile(xIn, yIn, widthIn, heightIn, colorIn, backgroundShapeIn, letterIn, faceIn);

        return tile;
    }
    
}