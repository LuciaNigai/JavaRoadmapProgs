package maven.project.JavaRoadmap.arrayPrograms;

public class RemoveEvenFromArray {
	/*
	 * removing even numbers
	 */
	 public static int[] removeEven(int[] arr) {
		int oddCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2!=0) {
				oddCount++;
			}
		}
		int[] result = new int[oddCount];
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2!=0) {
				result[idx]=arr[i];
				idx++;
			}
		}
		return result;
	}

}
