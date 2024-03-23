package maven.project.JavaRoadmap.Matrices;

public class LowerUpperTriangularMatrix {

	public static void main(String[] args) {

		displayLowerTriangular(new int[][] { { 1, 3, 4 }, { 1, 4, 8 }, { 1, 9, 5 } });
	}
	
	private static void displayLowerTriangular(int[][] mx) {
		if (mx.length != mx[0].length) {
			throw new IllegalArgumentException("The matrix should be square");
		}
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(mx[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[0].length; j++) {
				if (i > j) {
					System.out.print("  ");
				} else
					System.out.print(mx[i][j] + " ");
			}
			System.out.println();
		}
	}

}
