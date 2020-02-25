
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import shapes.Oval;
/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicPanel extends JPanel {

    public MosaicPanel() {
        
        GridLayout layout = new GridLayout(12, 12);
        setLayout(layout);
        
        for (int i = 0; i<144; ++i) add(new Oval(0, 0, 100, 100, Color.BLACK));
        
    }
}