/**
 * This class is responsible for instantiating
 * a Mosaic object. Program execution begins in
 * the <code>main()</code> method.
 * @author  Kyle Bye
 */
public class Mosaic {

    /**
     * Program execution begins here. Launches an
     * instance of <code>MosaicFrame</code>
     * @param   args    Program Arguments
     */
    public static void main(String[] args) {

        MosaicFrame mosaicFrame = new MosaicFrame(0, 0, 600, 600);
        mosaicFrame.setVisible(true);

    }

}