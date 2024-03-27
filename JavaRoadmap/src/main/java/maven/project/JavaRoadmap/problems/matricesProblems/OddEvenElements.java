package maven.project.JavaRoadmap.problems.matricesProblems;

import java.util.HashMap;
import java.util.Map;


/**
 * A utility class for calculating the frequency of odd and even elements in a matrix.
 *
 * @version 1.0
 */
public class OddEvenElements {

    /**
     * Calculates the frequency of odd and even elements in a given matrix.
     *
     * @param mx the input matrix
     * @return a map containing the frequencies of odd and even elements
     */
    public static Map<String, Integer> getOddEvenFrequency(int[][] mx) {
        Map<String, Integer> nums = new HashMap<>();
        int odd = 0, even = 0;

        for (int[] row : mx) {
            for (int num : row) {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        nums.put("Even", even);
        nums.put("Odd", odd);

        return nums;
    }
}
