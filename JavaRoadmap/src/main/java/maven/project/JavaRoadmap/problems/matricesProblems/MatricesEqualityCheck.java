package maven.project.JavaRoadmap.problems.matricesProblems;

/**
 * A utility class containing a method to check equality of two matrices.
 *
 * @version 1.0
 */
public class MatricesEqualityCheck {

    /**
     * Checks if two matrices are equal.
     *
     * @param mc1 the first matrix
     * @param mc2 the second matrix
     * @return {@code true} if the matrices are equal, {@code false} otherwise
     * @throws ArithmeticException if the matrices do not have the same dimensions
     */
    public static boolean checkMatricesEquality(int[][] mc1, int[][] mc2) {
        // Check if the matrices have the same dimensions
        if (mc1.length != mc2.length || mc1[0].length != mc2[0].length) {
            throw new ArithmeticException("The matrices should have the same dimensions");
        }

        // Check each element for equality
        for (int i = 0; i < mc1.length; i++) {
            for (int j = 0; j < mc1[i].length; j++) {
                if (mc1[i][j] != mc2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

