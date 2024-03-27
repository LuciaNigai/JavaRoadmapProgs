package maven.project.JavaRoadmap.problems.arrayProblems;

/**
 * The SecondMax class provides a method to find the second maximum element in an array of integers.
 */
public class SecondMax {
    
    /**
     * Finds the second maximum element in the given array of integers.
     *
     * @param array The input array of integers.
     * @return The second maximum element in the array.
     */
    public static int findSecondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                // Update secondMax to previous max value
                secondMax = max;
                // Update max to current array element
                max = array[i];
            } else if (array[i] > secondMax && array[i] != max) {
                // Update secondMax if the array element is greater than the current secondMax
                secondMax = array[i];
            }
        }
        return secondMax;
    }
}
