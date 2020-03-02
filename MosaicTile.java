import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import shapes.*;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicTile extends JPanel implements ActionListener{

    private final static Color[] darkColors = {
        Color.BLACK, Color.BLUE, Color.GRAY, 
        Color.DARK_GRAY, Color.RED
    };

    private Shape backgroundShape;
    private JLabel letterLabel;
    private Face face;

    //  Getters

    public Shape getBackgroundShape() {

        return backgroundShape;

    }


    public JLabel getLetterLabel() {

        return letterLabel;

    }

    public Face getFace() {

        return face;

    }

    //  Setters

    public void setBackgroundShape(Shape backgroundShapeIn) {

        backgroundShape = backgroundShapeIn;

    }

    public void setLetterLabel(JLabel letterLabelIn) {

        letterLabel = letterLabelIn;

    }

    public void setFace(Face faceIn) {

        face = faceIn;

    }

    //  Other Methods

    public void actionPerformed(ActionEvent ae) {

        if (face != null) {

            if (face.isVisible()) face.setVisible(false);
            else face.setVisible(true);

        }

    }

    //  Constructors

    public MosaicTile() {

        this(0, 0, 0, 0, Color.WHITE, new Rectangle() , 'A', new Face(0, 0, 0, 0, Color.WHITE, 0));

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn) {

        this(xIn, yIn, widthIn, heightIn, Color.WHITE, new Rectangle(), 'A', new Face(xIn, yIn, widthIn/2, heightIn/2, Color.WHITE, 0));

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

        this(xIn, yIn, widthIn, heightIn, colorIn, new Rectangle(), 'A', new Face(xIn, yIn, widthIn/2, heightIn/2, Color.WHITE, 0));

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, Shape backgroundShapeIn) {

        this(xIn, yIn, widthIn, heightIn, colorIn, backgroundShapeIn, 'A', new Face(xIn, yIn, widthIn/2, heightIn/2, Color.WHITE, 0));

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, Shape backgroundShapeIn, char letterIn) {

        this(xIn, yIn, widthIn, heightIn, colorIn, backgroundShapeIn, letterIn, new Face(xIn, yIn, widthIn/2, heightIn/2, Color.WHITE, 0));
    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, Shape backgroundShapeIn, char letterIn, Face faceIn) {

        super();
        
        setLayout(null);

        //  Add the Face to this panel but set it to not be visible.
        faceIn.setVisible(false);
        setFace(faceIn);
        add(faceIn);

        //  Establish backgroundShape to this instance along with
        //  changing backgroundShape to BorderLayout for the letterLabel.
        backgroundShapeIn.setLayout(new BorderLayout());
        setBackgroundShape(backgroundShapeIn);

        //  Create a letterLabel
        JLabel lLabel = new JLabel();
        lLabel.setHorizontalAlignment(JLabel.CENTER);
        lLabel.setText(Character.toString(letterIn));
        lLabel.setFont(new Font(Font.SERIF, Font.BOLD, 12));

        //  If this instance's background shape is going to be a dark color,
        //  then set the text of letterLabel to be white. Otherwise,
        //  keep it black.
        if (SequentialSearch.ifObjectExists(colorIn, darkColors)) {
            lLabel.setForeground(Color.WHITE);
        }
        else lLabel.setForeground(Color.BLACK);

        //  Establish letterLabel to this instance.
        setLetterLabel(lLabel);

        //  Add a reference of letterLabel to backgroundShape.
        //  Add a refernce of backgroundShape to this instance.
        backgroundShape.add(lLabel, BorderLayout.CENTER);
        add(backgroundShape);
    }    
    
}