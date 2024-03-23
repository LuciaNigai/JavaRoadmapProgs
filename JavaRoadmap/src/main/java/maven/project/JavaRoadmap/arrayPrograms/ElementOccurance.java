package maven.project.JavaRoadmap.arrayPrograms;

import java.util.HashMap;
import java.util.Map;

public class ElementOccurance {
	public static Map<Integer,Integer> printArrayDuplicates(int[] array) {
		boolean[] checked = new boolean[array.length];
		Map<Integer, Integer> occurance = new HashMap<Integer, Integer>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};
		for(int i=0; i<array.length; i++) {
			if(checked[i]==true) {
				continue;
			}
			int count=1;
			checked[i]=true;
			for(int j=i+1; j<array.length; j++) {
				if(array[i]==array[j]) {
					checked[j]=true;
					count++;
				}
			}
			if(count>1) {
				occurance.put(array[i], count);
			}
		}
		return occurance;
	}
	

}
