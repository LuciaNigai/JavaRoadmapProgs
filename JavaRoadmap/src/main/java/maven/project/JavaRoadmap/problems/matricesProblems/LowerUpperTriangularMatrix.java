package maven.project.JavaRoadmap.problems.matricesProblems;

/**
 * A utility class containing methods to display the lower triangular part of a square matrix.
 *
 * @version 1.0
 */
public class LowerUpperTriangularMatrix {

    /**
     * Displays the lower triangular part of the given square matrix.
     *
     * @param mx the square matrix to display
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static void displayLowerTriangular(int[][] mx) {
        if (mx.length != mx[0].length) {
            throw new IllegalArgumentException("The matrix should be square");
        }

        // Displaying the lower triangular part
        System.out.println("Lower Triangular Matrix:");
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(mx[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Displaying the upper triangular part (with zeros below the diagonal)
        System.out.println("Upper Triangular Matrix:");
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[0].length; j++) {
                if (i > j) {
                    System.out.print("  "); // Print two spaces for better alignment
                } else {
                    System.out.print(mx[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Main method to demonstrate displaying lower triangular matrices.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Example usage
        displayLowerTriangular(new int[][]{{1, 3, 4}, {1, 4, 8}, {1, 9, 5}});
    }
}

