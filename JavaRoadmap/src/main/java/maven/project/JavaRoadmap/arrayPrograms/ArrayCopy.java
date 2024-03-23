package maven.project.JavaRoadmap.arrayPrograms;

import java.util.Arrays;

public class ArrayCopy {

	public static int[] copyArray(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	public static int[] copyArray2(int[] arr1, int[] arr2) {
		arr2 = Arrays.copyOf(arr1, arr2.length);
		return arr2;
	}
}
