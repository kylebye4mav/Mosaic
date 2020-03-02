package shapes;

import java.awt.Color;
import java.util.Random;
/**
 * @author  Kyle Bye
 */
public class FaceFactory {

    private final static Random random = new Random();

    public final static Color[] colorPallete = new Color[] {
        Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN, 
        Color.DARK_GRAY, Color.GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    public Face generateRandomFace(int xIn, int yIn, int widthIn, int heightIn) {

        Face returnFace;

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];
        int faceState = random.nextInt(3);

        returnFace = new Face(xIn, yIn, widthIn, heightIn, faceColor, faceState);

        return returnFace;

    }


}