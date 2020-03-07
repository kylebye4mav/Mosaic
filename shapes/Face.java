package shapes;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
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
    // the mouth shape.
    public final static int SAD_STATE = 0;
    public final static int NEUTRAL_STATE = 1;
    public final static int HAPPY_STATE = 2;

    // Properties
    private int faceState;
    private JPanel[][] gridPanels;
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

        //  Set Left Eye to the grid.
        gridPanels[1][1] = eyes[0];

        //  Set Right Eye to the grid.
        gridPanels[1][3] = eyes[1];

    }

    public void setFaceState(int faceStateIn) {

        if (faceState >= 0 && faceState <= 2) {
            faceState = faceStateIn;
        }

    }

    public void setMouth(Shape mouthIn) {

        mouth = mouthIn;

        gridPanels[3][1] = mouth;

    }

    //   Other Methods
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        System.out.println(toString());

    }

    @Override
    public String toString() {

        String returnString = new String();
        String formatter = "%s::Face[faceState:{%d}, eyes[0]:{%s}, eyes[1]:{%s}, mouth:{%s}]";

        returnString = String.format(
            formatter, super.toString(), faceState, eyes[0].toString(), eyes[1].toString(),
            mouth.toString()
            );

        return returnString;

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
        setLayout(new GridBagLayout());

        //  Fill Grid Panels
        gridPanels = new JPanel[5][5];
        JPanel emptyPanel;
        for (int i = 0; i<5; ++i) {
            for (int j = 0; j<5; ++j) {
                emptyPanel = new JPanel();
                emptyPanel.setBackground(new Color(0,0,0,0));
                gridPanels[i][j] = emptyPanel;
                add(gridPanels[i][j]);
            }
        }

        //  Initialize the emotion or faceState of this Face instance.
        setFaceState(faceStateIn);

        //  Initialize the eyes of the Face that are Oval objects.
        Oval leftEye = new Oval();
        Oval rightEye = new Oval();
        setEyes( new Oval[] {leftEye, rightEye} );

        //  Initialize the mouth shape of the Face.
        if (faceStateIn == Face.NEUTRAL_STATE) {

            //   A neutral state contructs a straight mouth in the form of a rectangle: (o_o) 
            Rectangle straightMouth = new Rectangle(
                0, 0, 0,0, Color.WHITE
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
                    0, 0, 0, 0, Color.WHITE, SemiOval.DIRECTION_DOWN
                    );

            }
            else {

                //  Set the mouthOval to a SemiOval instance with tis flat side facing up.
                mouthOval = new SemiOval(
                    0, 0 , 0, 0, Color.WHITE, SemiOval.DIRECTION_UP
                    );   

            }

            setMouth(mouthOval);
                
        }

        for (int i = 0; i<5; ++i) {
            for (int j = 0; j<5; ++j) {
                GridBagConstraints g = new GridBagConstraints();
                g.weightx = 0.1;
                g.weighty = 0.1;
                g.fill = GridBagConstraints.BOTH;
                g.gridx = j;
                g.gridy = i;

                if (i == 3) {
                    if (j == 1) {
                        g.gridwidth = 3; g. gridheight = 1;
                        add(gridPanels[i][j], g);
                        continue;
                    }
                    else if (j == 2 || j == 3) continue;
                }
                add(gridPanels[i][j], g);
            }
        }

    }

}