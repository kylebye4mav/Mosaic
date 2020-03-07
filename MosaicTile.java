import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import shapes.*;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicTile extends JPanel implements MouseListener{

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

    public Face getFace() {

        return face;

    }

    public JLabel getLetterLabel() {

        return letterLabel;

    }

    //  Setters

    public void setBackgroundShape(Shape backgroundShapeIn) {

        backgroundShape = backgroundShapeIn;

    }

    public void setFace(Face faceIn) {

        face = faceIn;

    }

    public void setLetterLabel(JLabel letterLabelIn) {

        letterLabel = letterLabelIn;

    }

    //  Other Methods

    public void changeState() {

        if (face != null && backgroundShape != null) {

            if (face.isVisible()) hideFace();
            else showFace();

        }

    }

    public void hideFace() {

        face.setVisible(false);
        backgroundShape.setVisible(true);

    }

    public void showFace() {

        backgroundShape.setVisible(false);
        face.setVisible(true);

    }

    //  Mouse Event Handlers

    public void mouseClicked(MouseEvent me) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {

        changeState();

    }

    public void mouseReleased(MouseEvent e) {}

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        System.out.println(toString());
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        System.out.println(toString());

    } 

    @Override
    public String toString() {

        String returnString = new String();
        String formatter = "MosaicTile[backgroundShape:{%s}, face:{%s}, letterLabel:{%s}]";

        returnString = String.format(
            formatter, backgroundShape.toString(), face.toString(), letterLabel.getText()
            );

        return returnString;
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

        //  Done to avoid graphical artifacts with other LayoutManagers.
        setOpaque(false);

        //  OverlayLayout allows components to be place ontop another.
        setLayout(new OverlayLayout(this));

        addMouseListener(this);

        //  Add the Face to this panel but set it to not be visible
        //  because by default, the backgroundShape is visible while
        //  face is not.
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