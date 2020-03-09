package shapes;

import java.awt.Color;
import java.util.Random;
/**
 * This class is responsible for creating and returning
 * <code>Face</code> objects based on the parameters given.
 * Includes methods that create random faces.
 * 
 * @author  Kyle Bye
 * @see Color
 * @see Face
 * @see javax.swing.JPanel
 * @see Random
 */
public class FaceFactory {

    //  Public Immutable Properties

    public final static Random random = new Random();

    public final static Color[] colorPallete = new Color[] {
        Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN, 
        Color.DARK_GRAY, Color.GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.YELLOW,
    };

    public final static Color[] darkColors = {
        Color.BLACK, Color.BLUE, Color.GRAY, 
        Color.DARK_GRAY, Color.RED
    };

    //  Factory Methods

    /**
     * Create and returns a <code>Face</code> object with
     * a random face, random color, and zeroed out bounds.
     * 
     * @return  a completely randomized <code>Face</code>
     *          instance that has zeroed out bounds.
     */
    public static Face generateRandomFace() {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];
        int faceState = random.nextInt(3);

        return generateFace(0, 0, 0, 0, faceColor, faceState);
    }

    /**
     * Create and returns a <code>Face</code> object with
     * a random face state and color.
     * 
     * @param   xIn x coordinate of <code>Face</code>.
     * @param   yIn y coordinate of <code>Face</code>.
     * @param   widthIn width of <code>Face</code>.
     * @param   heightIn    height of <code>Face</code>.
     * @return  a <code>Face</code> instance with a random face
     *          state and color.
     */
    public static Face generateRandomFace(int xIn, int yIn, int widthIn, int heightIn) {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];
        int faceState = random.nextInt(3);
        
        return generateFace(xIn, yIn, widthIn, heightIn, faceColor, faceState);

    }

    /**
     * Create and returns a <code>Face</code> object with
     * a random face state and a color provided by the parameter.
     * 
     * @param   xIn x coordinate of <code>Face</code>.
     * @param   yIn y coordinate of <code>Face</code>.
     * @param   widthIn width of <code>Face</code>.
     * @param   heightIn    height of <code>Face</code>.
     * @param   colorIn <code>Color</code> of <code>Face</code>.
     * @return  a <code>Face</code> instance with a random face state
     *          and a color that was provided.
     */
    public static Face generateRandomFace(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

        int faceState = random.nextInt(3);

        return generateFace(xIn, yIn, widthIn, heightIn, colorIn, faceState);
    }

    /**
     * Creates and returns a <code>Face</code> object
     * with a random face state, zeroed out bounds, and
     * a color provided by the parameter.
     * 
     * @param   colorIn <code>Color</code> of <code>Face</code>.
     * @return  a <code>Face</code> instance with
     *          zeroed out bounds, random face state,
     *          and a color that was provided.
     */
    public static Face generateRandomFace(Color colorIn) {

        int faceState = random.nextInt(3);

        return generateFace(0, 0, 0, 0, colorIn, faceState);

    }

    /**
     * Creates and returns a Face object with a random 
     * <code>Color</code>, all its bounds being set
     * to zero, and the face state indicated via the
     * parameter.
     * 
     * @param   faceStateIn integer representing the emotion of the
     *                      <code>Face</code>. The following are acceptable
     *                      types: <code>Face.SAD_STATE</code>,
     *                      <code>Face.NEUTRAL_STATE</code>, and
     *                      <code>Face.HAPPY_STATE</code>.
     * @return  a <code>Face</code> instance with a random
     *          <code>Color</code> and zeroed out bounds.
     */
    public static Face generateRandomFace(int faceStateIn) {

        Color faceColor = colorPallete[random.nextInt(colorPallete.length)];

        return generateFace(0, 0, 0, 0, faceColor, faceStateIn);

    }

    /**
     * Creates and returns a Face object based on the given parameters.
     * 
     * @param   xIn x coordinate of <code>Face</code>.
     * @param   yIn y coordinate of <code>Face</code>.
     * @param   widthIn width of <code>Face</code>.
     * @param   heightIn    height of <code>Face</code>.
     * @param   colorIn <code>Color</code> of <code>Face</code>.
     * @param   faceStateIn integer representing the emotion of the
     *                      <code>Face</code>. The following are acceptable
     *                      types: <code>Face.SAD_STATE</code>,
     *                      <code>Face.NEUTRAL_STATE</code>, and
     *                      <code>Face.HAPPY_STATE</code>.
     * @return  a <code>Face</code> instance.
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

    //  Other Methods

    /**
     * Returns true if and only if colorIn is considered
     * a dark color. Otherwise, false is returned.
     * 
     * Uses Sequential Search algorithm.
     * 
     * @param   colorIn <code>Color</code> being tested if it's dark.
     * @return  true if parameter is dark color. false if parameter
     *          is not.
     */
    private static boolean isDarkColor(Color colorIn) {

        for (Color c : darkColors) {
            if (colorIn.equals(c)) return true;
        }

        return false;

    }


}