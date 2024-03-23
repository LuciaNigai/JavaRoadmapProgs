package maven.project.JavaRoadmap.Matrices;

public class TransposeMatrix {

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
