package maven.project.JavaRoadmap.Matrices;

import java.util.HashMap;
import java.util.Map;

public class OddEvenElements {
	public static Map<String,Integer> getOddEvenFrequency(int[][] mx) {
		Map<String, Integer> nums = new HashMap<String, Integer>();
		int odd = 0, even = 0;

		for (int i = 0; i < mx.length; i++) {
			for (int j = 0; j < mx[i].length; j++) {
				if (mx[i][j] % 2 == 0) {
					even++;
				} else {
					odd++;
				}
			}
		}
		nums.put("Even", even);
		nums.put("Odd", odd);
		
		return nums;
	}

}
