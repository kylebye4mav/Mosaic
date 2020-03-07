package shapes;

import java.awt.Color;
import java.util.Random;
/**
 * This class is responsible for creating and returning
 * Face objects based on the parameters given. Includes
 * methods that create random faces.
 * 
 * @author  Kyle Bye
 * @see Color
 * @see Random
 */
public class FaceFactory {

    private final static Random random = new Random();

    public final static Color[] colorPallete = new Color[] {
        Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN, 
        Color.DARK_GRAY, Color.GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.YELLOW,
    };

    private final static Color[] darkColors = {
        Color.BLACK, Color.BLUE, Color.GRAY, 
        Color.DARK_GRAY, Color.RED
    };

    public static Face generateRandomFace() {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];
        int faceState = random.nextInt(3);

        return generateFace(0, 0, 0, 0, faceColor, faceState);
    }

    public static Face generateRandomFace(int xIn, int yIn, int widthIn, int heightIn) {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];
        int faceState = random.nextInt(3);
        
        return generateFace(xIn, yIn, widthIn, heightIn, faceColor, faceState);

    }

    public static Face generateRandomFace(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

        int faceState = random.nextInt(3);

        return generateFace(xIn, yIn, widthIn, heightIn, colorIn, faceState);
    }

    public static Face generateRandomFace(Color colorIn) {

        int faceState = random.nextInt(3);

        return generateFace(0, 0, 0, 0, colorIn, faceState);

    }

    public static Face generateRandomFace(int faceStateIn) {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];

        return generateFace(0, 0, 0, 0, faceColor, faceStateIn);

    }

    /**
     * 
     * @param   xIn
     * @param   yIn
     * @param   widthIn
     * @param   heightIn
     * @param   colorIn
     * @param   faceStateIn
     * @return
     */
    public static Face generateFace(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, int faceStateIn) {

        Face returnFace;

        returnFace = new Face(xIn, yIn, widthIn, heightIn, colorIn, faceStateIn);

        if (!isDarkColor(colorIn)) {
            returnFace.getMouth().setColor(Color.BLACK);
            returnFace.getEyes()[0].setColor(Color.BLACK);
            returnFace.getEyes()[1].setColor(Color.BLACK);
        }   

        return returnFace;

    }

    /**
     * Returns true if and only if colorIn is considered
     * a dark color. Otherwise, false is returned.
     * @param   colorIn Color being tested if it's dark.
     * @return  true/false
     */
    private static boolean isDarkColor(Color colorIn) {

        for (Color c : darkColors) {
            if (colorIn.equals(c)) return true;
        }

        return false;

    }


}