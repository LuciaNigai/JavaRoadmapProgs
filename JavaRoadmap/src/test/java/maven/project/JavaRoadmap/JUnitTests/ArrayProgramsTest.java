package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.problems.arrayProblems.*;

class ArrayProgramsTest {
	
    /**
     * Tests the {@link RemoveEvenFromArray#removeEven(int[])} method.
     * It verifies that the method removes even numbers from the input array.
     */

	@Test
	void testRemoveEvenTest() {
        int[] expected = new int[] {3, 5, 3, 7};
        int[] actual = RemoveEvenFromArray.removeEven(new int[] {3, 4, 2, 5, 4, 3, 6, 7});

        assertArrayEquals(expected, actual);
	}
	
    /**
     * Tests the {@link ReverseArray#reverseArray(int[])} method.
     * It verifies that the method correctly reverses the elements of the input array.
     */
	@Test
	void testRevesreArrayTest() {
		int[] expected = new int[] {2,3,4,5};
		int[] actual = ReverseArray.reverseArray(new int[] {5,4,3,2});
		assertArrayEquals(expected, actual);
	}

    /**
     * Tests the {@link FindMinAndMax#findMinAndMax(int[])} method.
     * It verifies that the method correctly finds the minimum and maximum values in the input array.
     */
	@Test
	void testMinMaxTest() {
		int[] expected = new int[] {1,8};
		int[] actual = FindMinAndMax.findMinAndMax(new int[] {1,4,5,6,3,7,8,3});
		assertArrayEquals(expected, actual);
	}
	
    /**
     * Tests the {@link SecondMax#findSecondMax(int[])} method.
     * It verifies that the method correctly finds the second maximum value in the input array.
     */
	@Test
	void testSecondMaxTest() {
		int expected = 9;
		int actual = SecondMax.findSecondMax(new int[] {3,6,4,5,7,8,9,15});
		assertEquals(expected, actual);
	}
	
    /**
     * Tests the {@link ArrayCopy#copyArray(int[], int[])} method.
     * It verifies that the method correctly copies the elements from one array to another.
     */
	@Test
	void testArrayCopyTest() {
		int[] expected = new int[] {1,2,4,5};
		int[] actual1=ArrayCopy.copyArray(expected, expected);
		int[] actual2=ArrayCopy.copyArray(expected, expected);
		assertArrayEquals(expected, actual1);
		assertArrayEquals(expected, actual2);
		
	}
	
    /**
     * Tests the {@link ElementFrequency#getFrequency(int[])} method.
     * It verifies that the method correctly calculates the frequency of each element in the input array.
     */
    @Test
    void testFrequencyTest() {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 1};
        Map<Integer, Integer> expected = new HashMap<>();
        for (int num : arr) {
            expected.put(num, expected.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> actual = ElementFrequency.getFrequency(arr);

        assertEquals(expected, actual);
    }
    
    
    /**
     * Tests the {@link RotateToLeft#rotateArrayToLeft(int[])} method.
     * It verifies that the method correctly rotates the elements of the input array to the left.
     */
    @Test
    void testRotateLeftTest() {
    	int[] expected = new int[] {3,5,6,7,2,4};
    	int[] actual = RotateToLeft.rotateArrayToLeft(new int[] {4,3,5,6,7,2});
    	assertArrayEquals(expected, actual);
    }
    
    /**
     * Tests the {@link ElementOccurance#printArrayDuplicates(int[])} method.
     * It verifies that the method correctly identifies and prints duplicate elements in the input array.
     */
    @Test
    void testPrintArrayDuplicatesTest() {
        int[] array = {1, 2, 3, 4, 2, 3, 4, 5, 5, 5};
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 2);
        expected.put(3, 2);
        expected.put(4, 2);
        expected.put(5, 3);

        Map<Integer, Integer> actual = ElementOccurance.printArrayDuplicates(array);

        assertEquals(expected, actual);
    }
    
    
    /**
     * Tests the {@link MoveZerosToEnd#moveZerosEnd(int[])} method.
     * It verifies that the method correctly moves all zeros to the end of the input array while maintaining the order of non-zero elements.
     */
    @Test
    void MoveZerosToEndTest() {
    	int[] expected = new int[] {1,4,3,0,0};
    	int[] actual = MoveZerosToEnd.moveZerosEnd(new int[] {1,0,4,0,3});
    	
    	assertArrayEquals(expected, actual);
    }
    
    /**
     * Tests the {@link MissingNumber#findMissingNumber(int[])} method.
     * It verifies that the method correctly finds the missing number in the input array.
     */
    @Test
    void MissingNumberTest() {
    	int expected = 5;
    	int actual = MissingNumber.findMissingNumber(new int[] {2,4,1,8,6,3,7});
    	assertEquals(expected, actual);
    }
    
    /**
     * Tests the {@link RemoveDuplicates#removeDuplicates(int[])}, {@link RemoveDuplicates#removeDuplicatesBetter(int[])} and {@link RemoveDuplicates#removeDuplicatesArrayList(int[])} methods
     * It verifies that the methods correctly removes the duplicates from a sorted int array 
     */
    @Test
    void RemoveDuplicatesTest() {
    	int[] expected = new int[] {1,2,3,4,5};
    	int[] actual1 = RemoveDuplicates.removeDuplicates(new int[] {1,1,2,3,3,4,5,5});
    	int[] actual2 = RemoveDuplicates.removeDuplicatesBetter(new int[] {1,1,2,3,3,4,5,5});
    	int[] actual3 = RemoveDuplicates.removeDuplicatesArrayList(new int[] {1,1,2,3,3,4,5,5});
    	assertArrayEquals(expected, actual1);
    	assertArrayEquals(expected, actual2);
    	assertArrayEquals(expected, actual3);
    }

}
