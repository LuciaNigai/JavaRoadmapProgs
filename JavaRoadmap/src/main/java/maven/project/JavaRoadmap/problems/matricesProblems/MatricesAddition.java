package maven.project.JavaRoadmap.problems.matricesProblems;

/**
 * A utility class containing a method to perform addition of two matrices.
 *
 * @version 1.0
 */
public class MatricesAddition {

    /**
     * Adds two matrices together.
     *
     * @param mc1 the first matrix
     * @param mc2 the second matrix
     * @return the result of adding the two matrices
     * @throws ArithmeticException if the matrices do not have the same dimensions
     */
    public static int[][] addMatrices(int[][] mc1, int[][] mc2) {
        // Check if the matrices have the same dimensions
        if (mc1.length != mc2.length || mc1[0].length != mc2[0].length) {
            throw new ArithmeticException("The matrices should have the same dimensions");
        }

        // Create a new matrix to store the result
        int[][] arr = new int[mc1.length][mc1[0].length];

        // Perform addition element-wise
        for (int i = 0; i < mc1.length; i++) {
            for (int j = 0; j < mc1[i].length; j++) {
                arr[i][j] = mc1[i][j] + mc2[i][j];
            }
        }

        return arr;
    }
}

