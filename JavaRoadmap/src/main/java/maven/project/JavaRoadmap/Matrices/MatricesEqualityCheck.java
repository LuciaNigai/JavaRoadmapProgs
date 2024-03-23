package maven.project.JavaRoadmap.Matrices;

public class MatricesEqualityCheck {
	
	public static boolean checkMatricesEquality(int[][] mc1, int[][] mc2) {
		if ((mc1.length != mc2.length || mc1[0].length != mc2[0].length)
				|| (mc1.length != mc2.length && mc1[0].length != mc2[0].length)) {
			throw new ArithmeticException("The matrix should have the same dimensions");
		}
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
