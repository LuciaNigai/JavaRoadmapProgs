package maven.project.JavaRoadmap.Matrices;

import java.util.HashMap;
import java.util.Map;

public class RowColSum {
	
	public static  Map<String, Map<Integer, Integer>> calculateSums(int[][] mx) {
	    Map<Integer, Integer> rows = new HashMap<>();
	    Map<Integer, Integer> cols = new HashMap<>();
	    Map<String, Map<Integer, Integer>> map = new HashMap<>();
	    
	    for (int i = 0; i < mx.length; i++) {
	        int rowSum = 0;
	        int colSum = 0;
	        
	        for (int j = 0; j < mx[i].length; j++) {
	            rowSum += mx[i][j];
	            colSum += mx[j][i]; // Summing up the column elements correctly
	        }
	        
	        rows.put(i, rowSum);
	        cols.put(i, colSum);
	        
	        System.out.println("Row " + i + " sum = " + rowSum);
	        System.out.println("Col " + i + " sum = " + colSum);
	    }
	    
	    map.put("Row", rows);
	    map.put("Col", cols);
	    
	    return map;
	}


}
