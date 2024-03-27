package maven.project.JavaRoadmap.problems.matricesProblems;

/**
 * A utility class containing a method to check if a given square matrix is a sparse matrix.
 *
 * @version 1.0
 */
public class GivenSparseMatrix {

    /**
     * Checks whether the given square matrix is a sparse matrix.
     * In a sparse matrix, all diagonal elements are non-zero, and all non-diagonal elements are zero.
     *
     * @param mx the given square matrix to be checked
     * @return true if the matrix is a sparse matrix, false otherwise
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static boolean checkSparse(int[][] mx) {
        if (mx.length != mx[0].length) {
            throw new IllegalArgumentException("The matrix should be square");
        }

        for (int i = 0; i < mx.length; i++) {
            if (mx[i][i] == 0) {
                return false;
            }
            for (int j = 0; j < mx[0].length; j++) {
                if (i != j && mx[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
