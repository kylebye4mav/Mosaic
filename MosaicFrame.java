import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicFrame extends JFrame {

    private MosaicTilePanel tilePanel;
    private MosaicButtonPanel buttonPanel;

    //  Getters

    public MosaicTilePanel getTilePanel() {

        return tilePanel;

    }

    public MosaicButtonPanel getButtonPanel() {

        return buttonPanel;

    }

    //  Setters

    public void setTilePanel(MosaicTilePanel tilePanelIn) {

        tilePanel = tilePanelIn;

    }

    public void setButtonPanel(MosaicButtonPanel buttonPanelIn) {

        buttonPanel = buttonPanelIn;

    }

    //  Constructors

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
        tilePanel = new MosaicTilePanel();
        add(tilePanel, BorderLayout.CENTER);

        //  Instantiate and add a MosaicButtonPanel
        //  in which a reference of TilePanel is passed.
        buttonPanel = new MosaicButtonPanel(tilePanel);
        add(buttonPanel, BorderLayout.SOUTH);

    }

}
