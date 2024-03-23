package maven.project.JavaRoadmap.Matrices;

public class MatricesAddition {

    public static int[][] addMatrices(int[][] mc1, int[][] mc2) {
        if (mc1.length != mc2.length || mc1[0].length != mc2[0].length) {
            throw new ArithmeticException("The matrices should have the same dimensions");
        }
        int[][] arr = new int[mc1.length][mc1[0].length];
        for (int i = 0; i < mc1.length; i++) {
            for (int j = 0; j < mc1[i].length; j++) {
                arr[i][j] = mc1[i][j] + mc2[i][j];
            }
        }

        return arr;
    }
}
