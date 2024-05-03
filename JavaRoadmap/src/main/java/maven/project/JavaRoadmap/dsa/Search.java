package maven.project.JavaRoadmap.dsa;

/**
 * Class implements search algorithms
 * 
 * @version 1.0
 * @since 2024-04-28
 */
public class Search {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(searchLinear(array, 7));
		System.out.println(binarySearch(array, 0, array.length - 1, 5));
		System.out.println(interpolationSearch(array, 0, array.length-1, 6));
		System.out.println(jumpSearch(array, 7));
	}

	/**
	 * Performs a linear search algorithm.
	 * 
	 * @param array Array in which the search is performed.
	 * @param num   Number to search for.
	 * @return True if element is found, false otherwise.
	 */
	public static boolean searchLinear(int[] array, int num) {
		for (int i : array) {
			if (i == num) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Performs a binary search algorithm.
	 * 
	 * @param array The array in which the search is performed.
	 * @param begin The start index.
	 * @param end   The end index.
	 * @param num   The number to be searched for.
	 * @return True if element is found, false otherwise.
	 */
	public static boolean binarySearch(int[] array, int begin, int end, int num) {
		int mid;
		if (end >= begin) {
			mid = (begin + end) / 2;
			if (array[mid] == num)
				return true;
			if (num > array[mid]) {
				return binarySearch(array, mid + 1, end, num);
			}
			if (num < array[mid]) {
				return binarySearch(array, begin, mid - 1, num);
			}
		}
		return false;
	}

	/**
	 * Method performs interpolation search. (works better with uniformly distributed elements)
	 * For uniformly distributed O(log log n), but if not can be O(n).
	 * @param array Array in which the search is performed.
	 * @param begin The begin position of array.
	 * @param end The end position of array.
	 * @param num The number to search for.
	 * @return True if element is found, false otherwise.
	 */
	public static boolean interpolationSearch(int[] array, int begin, int end, int num) {
	    if (end >= begin) {
	        int mid = begin + ((end - begin) * (num - array[begin])) / (array[end] - array[begin]);

	        if (array[mid] == num) {
	            return true;
	        }
	        if (num > array[mid]) {
	            return interpolationSearch(array, mid + 1, end, num);
	        }
	        if (num < array[mid]) {
	            return interpolationSearch(array, begin, mid - 1, num);
	        }
	    }
	    return false;
	}

	/**
	 * Method performs jump search algorithm. 
	 * Time complexity O(√n), and space complexity is O(1);
	 * @param array The array in which the search is prtformed.
	 * @param num The number to search for.
	 * @return True if element is found, false otherwise.
	 */
	public static boolean jumpSearch(int[] array, int num) {
	    int blockSize = (int) Math.sqrt(array.length);
	    int start = 0;
	    int end = blockSize;

	    // Find the block where the target element might exist
	    while (end < array.length && array[end - 1] < num) {
	        start = end; // Move to the next block
	        end = Math.min(end + blockSize, array.length);
	    }

	    // Perform linear search within the identified block
	    for (int i = start; i < end; i++) {
	        if (array[i] == num) {
	            return true; // Element found
	        }
	    }

	    return false; // Element not found
	}


	/**
	 * Method perfroms exponential search. Time complexity O(log n). (Writen not by me)
	 * @param array The array in which the search is performed.
	 * @param num The number to be searched for.
	 * @return True if element is found, false otherwise.
	 */
    public static boolean exponentialSearch(int[] array, int num) {
        if (array[0] == num) {
            return true; // Element found at index 0
        }

        // Find the range for binary search
        int i = 1;
        while (i < array.length && array[i] <= num) {
            i *= 2;
        }

        // Perform binary search in the identified range
        int left = i / 2;
        int right = Math.min(i, array.length - 1);
        return binarySearch(array, num, left, right);
    }
    
}
