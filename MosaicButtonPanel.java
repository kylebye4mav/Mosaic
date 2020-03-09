
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * 
 * @author  Kyle Bye
 * @see JButton
 * @see JPanel
 * @see MosaicTilePanel
 */
@SuppressWarnings("serial")
public class MosaicButtonPanel extends JPanel implements ActionListener {

    //  Properties
    
    private MosaicTilePanel tilePanel;
    private JButton randomizeButton;

    //  Getters

    public JButton getJButton() {

        return randomizeButton;

    }

    public MosaicTilePanel getTilePanel() {

        return tilePanel;

    }

    //  Setters

    public void setRandomizeButton(JButton randomizeButtonIn) {

        randomizeButton = randomizeButtonIn;

    }

    public void setTilePanel(MosaicTilePanel tilePanelIn) {

        tilePanel = tilePanelIn;

    }

    //  Constructors

    public MosaicButtonPanel(MosaicTilePanel tilePanelIn) {

        super();

        setTilePanel(tilePanelIn);

        //  Initialize Randomize Button.
        setRandomizeButton(new JButton());
        randomizeButton.setText("Randomize");
        randomizeButton.addActionListener(this);
        add(randomizeButton);

    }

    /**
     * Calls <code>shuffleTiles()</code> within the tilePanel.
     * 
     * @param   ae  ActionEvent
     * @see MosaicTilePanel#shuffleTiles()
     */
    public void actionPerformed(ActionEvent ae) {

        tilePanel.shuffleTiles();

        System.out.println("Randomize Action Performed...");

    }

}
