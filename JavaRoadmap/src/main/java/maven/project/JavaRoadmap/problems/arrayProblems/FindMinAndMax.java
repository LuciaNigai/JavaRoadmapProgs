package maven.project.JavaRoadmap.problems.arrayProblems;

/**
 * The FindMinAndMax class provides a method to find the minimum and maximum elements in an array.
 */
public class FindMinAndMax {
    
    /**
     * Finds the minimum and maximum elements in the given array.
     *
     * @param array The input array.
     * @return An array containing the minimum element at index 0 and the maximum element at index 1.
     */
    public static int[] findMinAndMax(int[] array) {
        int[] minMax = new int[2];
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max) {
                max = array[i];
            }
        }
        minMax[0] = min;
        minMax[1] = max;
        return minMax;
    }
}

