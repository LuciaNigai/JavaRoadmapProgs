package maven.project.JavaRoadmap.problems.arrayProblems;

/**
 * The ReverseArray class provides a method to reverse an array of integers.
 */
public class ReverseArray {
    
    /**
     * Reverses the order of elements in the given array.
     *
     * @param array The input array of integers.
     * @return The reversed array.
     */
    public static int[] reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        // Swap elements from start and end until they meet in the middle
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}

