import javax.swing.JPanel;
import javax.swing.JLabel;
import shapes.*;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicTile extends JPanel {

    private Shape backgroundShape;
    private char letter;
    private JLabel letterLabel;

    //  Getters

    public Shape getBackgroundShape() {

        return backgroundShape;

    }

    public char getLetter() {

        return letter;

    }

    public JLabel getLetterLabel() {

        return letterLabel;

    }

    //  Setters

    public void setBackgroundShape(Shape backgroundShapeIn) {

        backgroundShape = backgroundShapeIn;

    }

    public void setLetter(char letterIn) {

        letter = letterIn;

    }

    public void setLetterLabel(JLabel letterLabelIn) {

        letterLabel = letterLabelIn;

    }

    //  Constructors

    public MosaicTile() {

    }
    
}