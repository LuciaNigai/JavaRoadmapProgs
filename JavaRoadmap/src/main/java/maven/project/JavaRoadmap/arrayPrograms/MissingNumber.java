package maven.project.JavaRoadmap.arrayPrograms;

public class MissingNumber {

	public static int findMissingNumber(int[] arr) {
		int n = arr.length;
		int sum = n * (n + 1) / 2;
		for (int i : arr) {
			sum = sum - i;

		}
		return sum;
	}

}
