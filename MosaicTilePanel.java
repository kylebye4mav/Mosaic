import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * @author  Kyle Bye
 */
@SuppressWarnings("serial")
public class MosaicTilePanel extends JPanel {

    public MosaicTilePanel() {
        
        GridLayout layout = new GridLayout(12, 12);
        setLayout(layout);

        generateTiles();
        
    }

    public void generateTiles() {

        //  Remove all MosaicTile instances of MosaicTile
        removeTiles();

        //  Add a bunch of new MosaicTile instances.
        for (int i = 0; i<144; ++i) add(MosaicTileFactory.createRandomTile(0, 0, 0, 0));

        //  Called because this instance's Components have been changed.
        revalidate();

    }

    public MosaicTile[] getTiles() {

        MosaicTile[] tiles;

        ArrayList<MosaicTile> tileList = new ArrayList<MosaicTile>();

        //  Add the reference of every instance of MosaicTile into
        //  the tileList.
        for (Component c : getComponents()) {

            if (c instanceof MosaicTile) {
                tileList.add((MosaicTile)c);
            }

        }

        //  Initialize the tile array.
        tiles = new MosaicTile[tileList.size()];

        //  Assign every index of tiles a reference of the corresponding
        //  element at that index of tileList.
        for (int i = 0; i<tiles.length; ++i) {
            tiles[i] = tileList.get(i);
        }

        return tiles;

    }

    public void addTiles(MosaicTile[] tiles) {

        //  Add every tile to this panel.
        for (MosaicTile tile : tiles) {
            add(tile);
        }

    }

    public void shuffleTiles() {

        //  Get every instance of MosaicTile
        MosaicTile[] tiles = getTiles();

        //  Remove every tile from this panel.
        removeTiles();

        //  Shuffle the tiles in the tiles array.
        MosaicUtil.randomizeArray(tiles);

        //  Add the shuffled tiles back to the panel.
        addTiles(tiles);
        
        //  Called because this instance's Components have been changed.
        revalidate();

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