
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

    private MosaicShapePanel shapePanel;
    private JButton randomizeButton;

    public MosaicButtonPanel(MosaicShapePanel shapePanelIn) {
        super();

        shapePanel = shapePanelIn;

        randomizeButton = new JButton();
        randomizeButton.setText("Randomize");
        randomizeButton.addActionListener(this);
        add(randomizeButton);
        

    }

    public void actionPerformed(ActionEvent ae) {

        shapePanel.generateTiles();

        System.out.println("Randomize Action Performed...");

    }

}
