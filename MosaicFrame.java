import javax.swing.JFrame;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicFrame extends JFrame {

    public MosaicFrame() {

        this(0, 0, 0, 0);

    }

    public MosaicFrame(int widthIn, int heightIn) {

        this(0,0, widthIn, heightIn);

    }

    public MosaicFrame(int xIn, int yIn, int widthIn, int heightIn) {

        setBounds(xIn, yIn, widthIn, heightIn);

        //  Instantiate and add a MosaicPanel.
        MosaicPanel mosaicPanel = new MosaicPanel();
        add(mosaicPanel);

    }

}
