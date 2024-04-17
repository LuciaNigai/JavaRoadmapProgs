package maven.project.JavaRoadmap.JUnitTests.DSTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.dsa.linearDS.ArrayDS;

/**
 * testing array operations methods
 * @since 2024-15-04
 */
class ArrayDSTests {

//	testing simple array operations
	@Test
	void ArrayTraversaltest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		System.out.println("Array traversal");
		ds.traverseArray(array);
	}

	@Test
	void InsertionInArrayTest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		int[] expected = new int[] {1, 2, 3, 4, 34, 8, 7, 5, 4};
		System.out.println("Array before insertion: "+Arrays.toString(array));
		System.out.println("Array after insertion: "+Arrays.toString(ds.insertElementBetter(array, 34, 4)));
		assertArrayEquals(expected, ds.insertElementBetter(array, 34, 4));
	}
	
	@Test
	void DeletionFromPositionTest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		int[] expected = new int[] {1, 2, 3, 4, 8, 5, 4};
		System.out.println("Array before deletion: "+Arrays.toString(array));
		System.out.println("Array after deletion: "+Arrays.toString(ds.deleteElementAtPosition(array, 5)));
		assertArrayEquals(expected, ds.deleteElementAtPosition(array, 5));
	}
	
	@Test
	void DeletionOfSpecifiedElemTest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		int[] expected = new int[] {1, 2, 3, 8, 7, 5, 4};
		System.out.println("Array before deletion: "+Arrays.toString(array));
		System.out.println("Array after deletion: "+Arrays.toString(ds.deleteElement(array, 4)));
		assertArrayEquals(expected, ds.deleteElement(array, 4));
	}
	
	@Test
	void UpdationOfElementTest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		int[] expected = new int[] {1, 110, 3, 4, 8, 7, 5, 4};
		System.out.println("Array before update: "+Arrays.toString(array));
		assertArrayEquals(expected, ds.update(array, 1, 110));
		System.out.println("Array after update: "+Arrays.toString(array));
	}
	
	@Test
	void SearchForElementTest() {
		int[] array = new int[] {1,2,3,4,8,7,5,4};
		ArrayDS ds = new ArrayDS();
		int expected = 4;
		assertEquals(expected, ds.searchForElement(array, 8));
	}
}
