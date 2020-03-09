import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 * This class is responsible for holding a 12 by 12 grid
 * of <code>MosaicTile</code> instances.
 * 
 * Uses <code>GridLayout</code>.
 * 
 * @author  Kyle Bye
 * @see GridLayout
 * @see JPanel
 * @see MosaicTileFactory
 */
@SuppressWarnings("serial")
public class MosaicTilePanel extends JPanel {

    //  Other Methods

    /**
     * Removes all the already existing <code>MosaicTile</code>
     * instances if any already exists and adds a 144 new instances
     * randomly generated from <code>MosaicTileFactory</code>
     * 
     * @see MosaicTileFactory#createRandomTile(int, int, int, int)
     */
    public void generateTiles() {

        //  Remove all MosaicTile instances of MosaicTile
        //  if any already exists.
        removeTiles();

        //  Add a bunch of new MosaicTile instances.
        for (int i = 0; i<144; ++i) add(MosaicTileFactory.createRandomTile(0, 0, 0, 0));

        //  Called because this instance's Components have been changed.
        revalidate();

    }

    /**
     * Returns every instance of <code>MosaicTile</code> within this instance's
     * component array.
     * 
     * @return  an array of <code>MosaicTile</code> instances.
     */
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

    /**
     * Takes an array of <code>MosaicTile</code> instances and adds
     * them to this instance.
     * 
     * @param tiles <code>MosaicTile</code> instances.
     */
    public void addTiles(MosaicTile[] tiles) {

        //  Add every tile to this panel.
        for (MosaicTile tile : tiles) {
            add(tile);
        }

    }

    /**
     * Using methods from <code>MosaicUtil</code>, this method takes
     * every instance of <code>MosaicTile</code> and randomizes the 
     * positions of them in the grid.
     * 
     * @see MosaicUtil#randomizeArray(Object[])
     */
    public void shuffleTiles() {

        //  Get every instance of MosaicTile
        MosaicTile[] tiles = getTiles();

        //  Reset every tile to default state (Face hidden).
        for (MosaicTile tile : tiles) tile.hideFace();

        //  Remove every tile from this panel.
        removeTiles();

        //  Shuffle the tiles in the tiles array.
        MosaicUtil.randomizeArray(tiles);

        //  Add the shuffled tiles back to the panel.
        addTiles(tiles);
        
        //  Called because this instance's Components have been changed.
        revalidate();

    }

    /**
     * Removes every instance of <code>MosaicTile</code> from this instance.
     */
    private void removeTiles() {

        //  Removes every Component that is a MosiacTile
        for (Component c : getComponents()) {

            if (c instanceof MosaicTile) {
                remove(c);
            }

        }

    }

    //  Constructors

    public MosaicTilePanel() {
        
        GridLayout layout = new GridLayout(12, 12);
        setLayout(layout);

        generateTiles();
        
    }
    
}