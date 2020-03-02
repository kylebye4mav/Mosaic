
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author  Kyle Bye
 * @see JButton
 * @see JPanel
 */
@SuppressWarnings("serial")
public class MosaicButtonPanel extends JPanel implements ActionListener {

    private MosaicTilePanel tilePanel;
    private JButton randomizeButton;

    public MosaicButtonPanel(MosaicTilePanel tilePanelIn) {
        super();

        tilePanel = tilePanelIn;

        randomizeButton = new JButton();
        randomizeButton.setText("Randomize");
        randomizeButton.addActionListener(this);
        add(randomizeButton);
        

    }

    public void actionPerformed(ActionEvent ae) {

        tilePanel.shuffleTiles();

        System.out.println("Randomize Action Performed...");

    }

}
