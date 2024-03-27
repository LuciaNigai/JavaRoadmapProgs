package maven.project.JavaRoadmap.problems.arrayProblems;


/**
 * The RotateToLeft class provides a method to rotate an array of integers to the left by one position.
 */
public class RotateToLeft {
    
    /**
     * Rotates the elements of the given array to the left by one position.
     *
     * @param array The input array of integers.
     * @return The array after rotating its elements to the left by one position.
     */
    public static int[] rotateArrayToLeft(int[] array) {
        // Store the first element
        int firstElement = array[0];
        // Shift elements to the left by one position
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        // Place the first element at the end of the array
        array[array.length - 1] = firstElement;
        return array;
    }
}
