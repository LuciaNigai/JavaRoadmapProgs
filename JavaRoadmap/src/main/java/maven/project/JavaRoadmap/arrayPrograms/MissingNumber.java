package maven.project.JavaRoadmap.arrayPrograms;

public class MissingNumber {

	public static int findMissingNumber(int[] arr) {
	    int n = arr.length + 1;
	    // Calculate the sum of all numbers from 1 to n
	    int expectedSum = n * (n + 1) / 2;
	    
	    // Calculate the actual sum of elements in the array
	    int actualSum = 0;
	    for (int num : arr) {
	        actualSum += num;
	    }
	    
	    // The missing number is the difference between the expected sum and the actual sum
	    return expectedSum - actualSum;
	}


}
