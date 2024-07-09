package maven.project.JavaRoadmap;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[] array = { 666, 42, 2, 4, 6, 888, 23, 24, 55, 644 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		String[] strings = { "hey", "hello", "blueberry", "strawberry", "beauty" };
		threeSttrings(strings);
		
	}

//	MERGE SORT
	public static void mergeSort(int[] inputArray) {
		int inputLength = inputArray.length;

		if (inputLength < 2) {
			return;
		}
		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}

		mergeSort(leftHalf);
		mergeSort(rightHalf);

		// Merge
		merge(inputArray, leftHalf, rightHalf);
	}

	public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
	}

//	QUICK SORT

//	3 longest strings
	public static void threeSttrings(String[] array) {
		String max1 = "", max2 = "", max3 = "";
		for (String s : array) {
			if (s.length() > max1.length()) {
				max3 = max2;
				max2 = max1;
				max1 = s;
			} else if (s.length() > max2.length()) {
				max3 = max2;
				max2 = s;
			} else if (s.length() > max3.length()) {
				max3 = s;
			}
		}
		System.out.println("max1= "+max1+" ,max2= "+ max2 + " max3 ="+max3);
	}
}
