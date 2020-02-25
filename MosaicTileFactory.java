import java.awt.Color;
import java.util.Random;
import shapes.*;

/**
 * @author  Kyle Bye
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

    public final static MosaicTile createRandomTile(int xIn, int yIn, int widthIn, int heightIn) {

        MosaicTile tile;

        Color color = colors[random.nextInt(colors.length)];
        String shapeType = ShapeFactory.ALL_SHAPE_TYPES[random.nextInt(ShapeFactory.ALL_SHAPE_TYPES.length)];
        char letter = letters[random.nextInt(letters.length)];
        Shape backgroundShape = ShapeFactory.createShape(0, 0, widthIn, heightIn, color, shapeType);

        tile = new MosaicTile(xIn, yIn, widthIn, heightIn, color, backgroundShape, letter);

        return tile;
    }
}