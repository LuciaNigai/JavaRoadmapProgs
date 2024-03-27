package maven.project.JavaRoadmap.problems.matricesProblems;

/**
 * A utility class for finding the transpose of a matrix.
 *
 * @version 1.0
 */
public class TransposeMatrix {

    /**
     * Finds the transpose of the given matrix.
     *
     * @param mx the input matrix
     * @return the transpose of the input matrix
     */
    public static int[][] findTranspose(int[][] mx) {
        for (int i = 0; i < mx.length; i++) {
            for (int j = i + 1; j < mx[i].length; j++) { // Start from i + 1
                int temp = mx[i][j];
                mx[i][j] = mx[j][i];
                mx[j][i] = temp;
            }
        }
        return mx;
    }
}

