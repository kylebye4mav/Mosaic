import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import shapes.*;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicTile extends JPanel {

    private final static Color[] darkColors = {
        Color.BLACK, Color.BLUE, Color.GRAY, 
        Color.DARK_GRAY, Color.RED
    };

    private Shape backgroundShape;
    private JLabel letterLabel;

    //  Getters

    public Shape getBackgroundShape() {

        return backgroundShape;

    }


    public JLabel getLetterLabel() {

        return letterLabel;

    }

    //  Setters

    public void setBackgroundShape(Shape backgroundShapeIn) {

        backgroundShape = backgroundShapeIn;

    }

    public void setLetterLabel(JLabel letterLabelIn) {

        letterLabel = letterLabelIn;

    }

    //  Constructors

    public MosaicTile() {

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn) {

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, Shape backgroundShapeIn) {

    }

    public MosaicTile(int xIn, int yIn, int widthIn, int heightIn, Color colorIn, Shape backgroundShapeIn, char letterIn) {

        super();
        
        setLayout(new BorderLayout());

        backgroundShapeIn.setLayout(new BorderLayout());
        setBackgroundShape(backgroundShapeIn);

        JLabel lLabel = new JLabel();
        lLabel.setHorizontalAlignment(JLabel.CENTER);
        lLabel.setText(Character.toString(letterIn));
        lLabel.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        if (SequentialSearch.ifObjectExists(colorIn, darkColors)) {
            lLabel.setForeground(Color.WHITE);
        }
        else lLabel.setForeground(Color.BLACK);
        setLetterLabel(lLabel);

        backgroundShape.add(lLabel, BorderLayout.CENTER);
        add(backgroundShape);
        //add(letterLabel);
    }

    
    
}