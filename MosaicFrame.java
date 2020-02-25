import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicFrame extends JFrame {

    private MosaicShapePanel shapePanel;
    private MosaicButtonPanel buttonPanel;

    public MosaicFrame() {

        this(0, 0, 0, 0);

    }

    public MosaicFrame(int widthIn, int heightIn) {

        this(0,0, widthIn, heightIn);

    }

    public MosaicFrame(int xIn, int yIn, int widthIn, int heightIn) {

        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(xIn, yIn, widthIn, heightIn);
        setTitle("Mosaic");

        //  Instantiate and add a MosaicPanel.
        shapePanel = new MosaicShapePanel();
        add(shapePanel, BorderLayout.CENTER);

        //  Instantiate and add a MosaicButtonPanel
        //  in which a reference of shapePanel is passed.
        buttonPanel = new MosaicButtonPanel(shapePanel);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
