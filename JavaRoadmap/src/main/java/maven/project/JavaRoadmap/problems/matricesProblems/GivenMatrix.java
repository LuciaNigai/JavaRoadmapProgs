package maven.project.JavaRoadmap.problems.matricesProblems;



/**
 * A utility class containing a method to check if a given matrix is a special type of matrix where all diagonal elements are 1 and all non-diagonal elements are 0.
 *
 * @version 1.0
 */
public class GivenMatrix {

    /**
     * Checks whether the given matrix is a special type of matrix.
     * In this special type, all diagonal elements are 1, and all non-diagonal elements are 0.
     *
     * @param mx the given matrix to be checked
     * @return true if the matrix is of the special type, false otherwise
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static boolean checkGivenMatrix(int[][] mx) {
        if (mx.length != mx[0].length) {
            throw new IllegalArgumentException("The matrix should be square");
        }

        for (int i = 0; i < mx.length; i++) {
            if (mx[i][i] != 1) {
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
