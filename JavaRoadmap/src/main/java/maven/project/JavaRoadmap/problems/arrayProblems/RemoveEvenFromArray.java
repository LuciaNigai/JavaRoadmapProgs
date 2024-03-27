package maven.project.JavaRoadmap.problems.arrayProblems;

/**
 * The RemoveEvenFromArray class provides a method to remove all even numbers from an array.
 */
public class RemoveEvenFromArray {
    
    /**
     * Removes all even numbers from the given array and returns an array containing only the odd numbers.
     *
     * @param arr The input array of integers.
     * @return An array containing only the odd numbers from the input array.
     */
    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        // Count the number of odd elements in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        // Create a new array to store the odd numbers
        int[] result = new int[oddCount];
        int idx = 0;
        // Copy odd numbers to the result array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }
}

