package maven.project.JavaRoadmap.problems.matricesProblems;

import java.util.HashMap;
import java.util.Map;


/**
 * A utility class for calculating row and column sums of a matrix.
 *
 * @version 1.0
 */
public class RowColSum {

    /**
     * Calculates the sum of rows and columns of the given matrix.
     *
     * @param mx the input matrix
     * @return a map containing the sums of rows and columns
     */
    public static Map<String, Map<Integer, Integer>> calculateSums(int[][] mx) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < mx.length; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < mx[i].length; j++) {
                rowSum += mx[i][j];
                colSum += mx[j][i]; 
            }

            rows.put(i, rowSum);
            cols.put(i, colSum);

            System.out.println("Row " + i + " sum = " + rowSum);
            System.out.println("Col " + i + " sum = " + colSum);
        }

        map.put("Row", rows);
        map.put("Col", cols);

        return map;
    }
}

