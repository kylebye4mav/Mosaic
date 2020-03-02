package shapes;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * This class represents a face with a 2 length array of eyes that are Oval
 * instances along with a mouth that is a Shape of some kind.
 * 
 * @author Kyle Bye
 * @see Oval
 * @see SemiOval
 * @see JPanel
 */
@SuppressWarnings("serial")
public final class Face extends Oval {

    // Static Properties that affect
    // the motuh shape.
    public final static int SAD_STATE = 0;
    public final static int NEUTRAL_STATE = 1;
    public final static int HAPPY_STATE = 2;

    // Properties
    private int faceState;
    private GridBagLayout layout;
    private Oval[] eyes;
    private Shape mouth;

    // Getters
    public Oval[] getEyes() {

        return eyes;

    }

    public int getFaceState() {

        return faceState;

    }

    public Shape getMouth() {

        return mouth;

    }

    // Setters
    public void setEyes(Oval[] eyesIn) {

        if (eyesIn.length != 2 || eyesIn == null) {

            return;

        }

        // If the eyes already exist, remove them.
        if (eyes != null) {

            for (Component c : getComponents()) {
                if (c instanceof Oval)
                    remove(c);
            }

        }

        eyes = eyesIn;

        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.BOTH;
        g.weighty = 0.5;

        // Left Eye
        g.gridx = 0;
        g.gridy = 0;
        add(eyes[0], g);

        //  Right Eye
        g.gridx = 3; g.gridy = 1;
        add(eyes[1], g);

    }
    public void setFaceState(int faceStateIn) {

        if (faceState >= 0 && faceState <= 2) {
            faceState = faceStateIn;
        }

    }

    public void setMouth(Shape mouthIn) {

        mouth = mouthIn;

    }

    //   Other Methods
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        System.out.println(toString());

    }

    public String toString() {

        return String.format(
            "%sFace(\n\t(faceState: %d); \n\t(eyes[0]: %s); \n\t(eyes[1]: %s); \n\t(mouth: %s); \n\t);\n", 
            super.toString(), faceState, eyes[0].toString(), eyes[1].toString(),
            mouth.toString()
        );

    }

    //   Constructors
    public Face() {

        this(0, 0, 0, 0, Color.WHITE, NEUTRAL_STATE);

    }

    public Face(int radiusXIn, int radiusYIn) {

        this(0, 0, radiusXIn, radiusYIn, Color.WHITE, NEUTRAL_STATE);

    }

    public Face(int xIn, int yIn, int radiusXIn, int radiusYIn) {

        this(xIn, yIn, radiusXIn, radiusYIn, Color.WHITE, NEUTRAL_STATE);

    }
    
    public Face(int xIn, int yIn, int radiusXIn, int radiusYIn, Color colorIn) {

        this(xIn, yIn, radiusXIn, radiusYIn, colorIn, NEUTRAL_STATE);

    }

    public Face(int xIn, int yIn, int radiusXIn, int radiusYIn, Color colorIn, int faceStateIn) {

        //  Initialize the Face's parent Oval.
        super(xIn, yIn, radiusXIn, radiusYIn, colorIn);

        //  Initialize layout manager
        layout = new GridBagLayout();
        setLayout(layout);

        //  Diameter is twice the radius in both the x and y.
        int diameterX = getWidth();
        int diameterY = getHeight();

        //  Initialize the emotion or faceState of this Face instance.
        setFaceState(faceStateIn);

        //  Initialize the eyes of the Face that are Oval objects.
        Oval leftEye = new Oval(diameterX/4, diameterY/4, radiusXIn/4, radiusYIn/4, Color.WHITE);
        Oval rightEye = new Oval(diameterX - 2*(diameterX/4), diameterY/4, radiusXIn/4, radiusYIn/4, Color.WHITE);
        setEyes( new Oval[] {leftEye, rightEye} );

        //  Initialize the mouth shape of the Face.
        if (faceStateIn == Face.NEUTRAL_STATE) {

            //   A neutral state contructs a straight mouth in the form of a rectangle: (o_o) 
            Rectangle straightMouth = new Rectangle(
                diameterX/4, diameterY - (diameterY/3), diameterX/2, diameterY/12, Color.WHITE
                );
            setMouth(straightMouth);

        }
        else {

            //  Since the face state is a happy state of a sad state,
            //  the mouth will be a semi oval drawn like a smile or a frown.
            SemiOval mouthOval;


            if (faceStateIn == Face.SAD_STATE) {

                //  Set the mouthOval to a SemiOval instance with its flat side facing down.
                mouthOval = new SemiOval(
                    diameterX/4, diameterY/3, radiusXIn/2, radiusYIn/2, Color.WHITE, SemiOval.DIRECTION_DOWN
                    );

            }
            else {

                //  Set the mouthOval to a SemiOval instance with tis flat side facing up.
                mouthOval = new SemiOval(
                    diameterX/4, diameterY - (diameterY/3), radiusXIn/2, radiusYIn/2, Color.WHITE, SemiOval.DIRECTION_UP
                    );   

            }

            setMouth(mouthOval);
                
        }

        //  Add the eyes and the mouth to this Face component.
        //for (Oval eye : eyes) add(eye);
        add(mouth);

    }

}