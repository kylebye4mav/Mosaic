import java.util.Random;
import java.util.ArrayList;

/**
 * @author  Kyle Bye
 * 
 */
public class MosaicUtil {

    private final static Random random = new Random();

    public static void randomizeArray(Object[] arr) {

        //  Create a temporary new Object Array
        Object[] temp = new Object[arr.length];

        //  Make an indices integer array
        //  and randomize it.
        int[] indices = new int[arr.length];
        for (int i = 0; i<arr.length; ++i) indices[i] = i;
        randomizeIndices(indices);

        //  Assign each temp randomized index a value
        //  from the original. The temp array is now
        //  different from arr at this point.
        for (int i = 0; i<arr.length; ++i) {
            temp[indices[i]] = arr[i];
        }

        //  Assign each index of arr to point at the 
        //  corresponding index of temp. arr is now
        //  randomized at this point/
        for (int i = 0; i<arr.length; ++i) arr[i] = temp[i];

    }

    public static void randomizeIndices(int[] arr) {

        int[] temp = new int[arr.length];

        for (int i = 0; i<temp.length; ++i) temp[i] = -1;

        ArrayList<Integer> indices = new ArrayList<Integer>();
        for (int i : arr) indices.add(i);

        while(!indices.isEmpty()) {

            int randomIndex = random.nextInt(arr.length);
            
            if (temp[randomIndex] == -1) { 
                temp[randomIndex] = indices.remove(0);
            }

        }

        for (int i = 0; i<arr.length; ++i) arr[i] = temp[i];

    }

}