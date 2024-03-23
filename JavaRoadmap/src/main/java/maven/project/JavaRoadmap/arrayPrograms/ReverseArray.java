package maven.project.JavaRoadmap.arrayPrograms;

public class ReverseArray {
	
	public static int[] reverseArray(int[] array) {
		int start = 0;
		int end =array.length-1;
		while(start<end) {
			int temp = array[start];
			array[start]=array[end];
			array[end]=temp;
			start++; 
			end--;
		}
		return array;
	}

}
