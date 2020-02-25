/**
 * This class contains methods that deal withing finding
 * whether if a certain type of object exists in certain types
 * of arrays and finding the index of a certain type of Object 
 * in a certain type of an array.
 * 
 * Uses Sequential Search Algorithm.
 * 
 * @author Kyle Bye
 */
public class SequentialSearch {

    /**
     * Returns True if the parameter Object, o, exists
     * in the parameter Object Array arr. Otherwise,
     * false is returned.
     * 
     * @param   o   Object to find.
     * @param   arr Array to search through.
     * @return  True if o exists in arr. Otherwise, returns false.
     */
    public static boolean ifObjectExists(Object o, Object[] arr) {

        for (Object oA : arr) {

            if (o.equals(oA)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Returns the index of the parameter Object, o, from the 
     * parameter Object Array arr if it exists in arr. Otherwise,
     * a -1 is returned.
     * 
     * @param   o   Object to find.
     * @param   arr Array to search through.
     * @return  Index of o if it exists in arr. Otherwise, returns -1.
     */
    public static int findIndexOf(Object o, Object[] arr) {

        for (int i = 0; i<arr.length; ++i) {

            if (o.equals(arr[i])) {

                return i;

            }
            
        }

        return -1;
    }

}