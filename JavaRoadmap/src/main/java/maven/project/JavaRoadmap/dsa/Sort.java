package maven.project.JavaRoadmap.dsa;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] array = new int[] { 77, 44, 55, 33, 22, 555, 23, 1, 8, 43 };
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		int[] array2 = new int[] { 77, 44, 55, 33, 22, 555, 23, 1, 8, 43 };
		insertionSort(array2);
		int[] array3 = new int[] { 77, 44, 55, 33, 22, 555, 23, 1, 8, 43 };
		quickSort(array3);
		System.out.println(Arrays.toString(array3));
		System.out.println(Arrays.toString(array2));
		int[] array4 = new int[] { 77, 44, 55, 33, 22, 555, 23, 1, 8, 43 };
		selectionSort(array4);
		System.out.println(Arrays.toString(array4));
		int[] array5 = new int[] { 77, 44, 55, 33, 22, 555, 23, 1, 8, 43 };
		mergeSort(array5);
		System.out.println(Arrays.toString(array5));
	}

	/**
	 * Implementation of bubble sort algorithm.
	 * 
	 * @param array The array to be sorted.
	 */
	public static void bubbleSort(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * Implementation of insertion sort algorithm.
	 * 
	 * @param array Th array to be sorted.
	 */
	public static void insertionSort(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j] < array[j - 1]) {
				// Swap array[j] and array[j - 1]
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
	}

	/**
	 * Method implements selection sort algorithm
	 * @param array The array to be sorted.
	 */
	public static void selectionSort(int[] array) {
		int j = 0;
		while (j < array.length - 1) {
			int min = j;
			for (int i = j+1; i < array.length; i++) {
				if (array[min] > array[i]) {
					min = i;
				}
			}
			int temp =array[j];
			array[j]=array[min];
			array[min]=temp;
			j++;
		}

	}
	
//					MERGE SORT
	/**
	 * Method implements merge sort algorithm.
	 * @param array The array to be sorted.
	 */
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return; // Base case: array is already sorted
        }
        
        // Split the array into two halves
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
        
        // Populate left and right arrays
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            rightArray[i - mid] = array[i];
        }
        
        // Recursively sort each half
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        // Merge the sorted halves
        merge(array, leftArray, rightArray);
    }
    
    /**
     * Helper method for merge sort algorithm. Merges two arrays.
     * @param array The initial array. 
     * @param leftArray Left array.
     * @param rightArray Right array.
     */
    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        
        // Merge left and right arrays into the result array
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[resultIndex++] = leftArray[leftIndex++];
            } else {
                array[resultIndex++] = rightArray[rightIndex++];
            }
        }
        
        // Copy remaining elements of left array
        while (leftIndex < leftArray.length) {
            array[resultIndex++] = leftArray[leftIndex++];
        }
        
        // Copy remaining elements of right array
        while (rightIndex < rightArray.length) {
            array[resultIndex++] = rightArray[rightIndex++];
        }
    }
    
    
//  					QUICK SORT
    
    /**
     * Method implements quick sort algorithm.
     * @param array The array to be sorted.
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }
    
    /**
     * Helper method for quick sort algorithm. 
     * @param array The initial array to be sorted.
     * @param low The lower element.
     * @param high The higher element;
     */
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    
    /**
     * Helper method for quick sort.
     * @param array The array to be sorted.
     * @param low The lower index.
     * @param high The higher index.
     * @return The partition index.
     */
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
