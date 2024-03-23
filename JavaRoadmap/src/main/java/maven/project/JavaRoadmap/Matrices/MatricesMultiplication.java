package maven.project.JavaRoadmap.Matrices;

public class MatricesMultiplication {
	
	public static int[][] multiplyMatrices(int[][] mc1, int[][] mc2) {
		// Check if matrices can be multiplied
		if (mc1[0].length != mc2.length) {
			throw new ArithmeticException("Matrices of those sizes cannot be multiplied");
		}

		// Create a new matrix to store the result
		int[][] result = new int[mc1.length][mc2[0].length];

		// Perform matrix multiplication
		for (int i = 0; i < mc1.length; i++) {
			for (int j = 0; j < mc2[0].length; j++) {
				for (int k = 0; k < mc1[0].length; k++) {
					result[i][j] += mc1[i][k] * mc2[k][j];
				}
			}
		}

		return result;
	}

}
