package maven.project.JavaRoadmap.Matrices;

public class GivenSparseMatrix {
	
	public static boolean checkSparse(int[][] mx) {
	    if (mx.length != mx[0].length) {
	        throw new IllegalArgumentException("The matrix should be square");
	    }
	    
	    for (int i = 0; i < mx.length; i++) {
	        if (mx[i][i] ==0) {
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
