package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.arrayPrograms.ArrayCopy;
import maven.project.JavaRoadmap.arrayPrograms.ElementOccurance;
import maven.project.JavaRoadmap.arrayPrograms.ElementFrequency;
import maven.project.JavaRoadmap.arrayPrograms.FindMinAndMax;
import maven.project.JavaRoadmap.arrayPrograms.RemoveEvenFromArray;
import maven.project.JavaRoadmap.arrayPrograms.ReverseArray;
import maven.project.JavaRoadmap.arrayPrograms.RotateToLeft;
import maven.project.JavaRoadmap.arrayPrograms.SecondMax;

class ArrayProgramsTest {

	@Test
	void testRemoveEven() {
        int[] expected = new int[] {3, 5, 3, 7};
        int[] actual = RemoveEvenFromArray.removeEven(new int[] {3, 4, 2, 5, 4, 3, 6, 7});

        assertArrayEquals(expected, actual);
	}
	
	@Test
	void testRevesreArray() {
		int[] expected = new int[] {2,3,4,5};
		int[] actual = ReverseArray.reverseArray(new int[] {5,4,3,2});
		assertArrayEquals(expected, actual);
	}

	@Test
	void testMinMax() {
		int[] expected = new int[] {1,8};
		int[] actual = FindMinAndMax.findMinAndMax(new int[] {1,4,5,6,3,7,8,3});
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testSecondMax() {
		int expected = 9;
		int actual = SecondMax.findSecondMax(new int[] {3,6,4,5,7,8,9,15});
		assertEquals(expected, actual);
	}
	
	@Test
	void testArrayCopy() {
		int[] expected = new int[] {1,2,4,5};
		int[] actual1=ArrayCopy.copyArray(expected, expected);
		int[] actual2=ArrayCopy.copyArray(expected, expected);
		assertArrayEquals(expected, actual1);
		assertArrayEquals(expected, actual2);
		
	}
	
    @Test
    void testFrequency() {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 1};
        Map<Integer, Integer> expected = new HashMap<>();
        for (int num : arr) {
            expected.put(num, expected.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> actual = ElementFrequency.getFrequency(arr);

        assertEquals(expected, actual);
    }
    
    
    @Test
    void testTotateLeft() {
    	int[] expected = new int[] {3,5,6,7,2,4};
    	int[] actual = RotateToLeft.rotateArrayToLeft(new int[] {4,3,5,6,7,2});
    	assertArrayEquals(expected, actual);
    }
    
    @Test
    void testPrintArrayDuplicates() {
        int[] array = {1, 2, 3, 4, 2, 3, 4, 5, 5, 5};
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(2, 2);
        expected.put(3, 2);
        expected.put(4, 2);
        expected.put(5, 3);

        Map<Integer, Integer> actual = ElementOccurance.printArrayDuplicates(array);

        assertEquals(expected, actual);
    }
    

}
