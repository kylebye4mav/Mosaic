import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicShapePanel extends JPanel {

    public MosaicShapePanel() {
        
        GridLayout layout = new GridLayout(12, 12);
        setLayout(layout);

        generateTiles();
        
    }

    public void generateTiles() {

        //  Remove all MosaicTile instances out of
        removeTiles();

        //  Add a bunch of new MosaicTile instances.
        for (int i = 0; i<144; ++i) add(MosaicTileFactory.createRandomTile(0, 0, 0, 0));

        //  Called because this instance's Components have been changed.
        revalidate();
        //repaint();
    }

    private void removeTiles() {

        //  Removes every Component that is a MosiacTile
        for (Component c : getComponents()) {

            if (c instanceof MosaicTile) {
                remove(c);
            }

        }

    }
}