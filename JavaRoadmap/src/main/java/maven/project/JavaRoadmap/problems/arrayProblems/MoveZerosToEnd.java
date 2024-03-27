package maven.project.JavaRoadmap.problems.arrayProblems;


/*
 * algorithm visualization link
 * https://www.notion.so/Move-Zeros-to-end-b8e2e31217ed4853b07a1ee7fdd976ab
 */

/**
 * The MoveZerosToEnd class provides a method to move all zeros in an array to the end while maintaining the order of non-zero elements.
 */
public class MoveZerosToEnd {
    
    /**
     * Moves all zeros in the given array to the end while maintaining the order of non-zero elements.
     *
     * @param arr The input array of integers.
     * @return The modified array with zeros moved to the end.
     */
    public static int[] moveZerosEnd(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
        return arr;
    }

}
