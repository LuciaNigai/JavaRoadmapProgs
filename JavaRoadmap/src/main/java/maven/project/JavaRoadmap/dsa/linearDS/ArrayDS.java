package maven.project.JavaRoadmap.dsa.linearDS;

import java.util.Arrays;

/**
 * Class demonstrates basic operations in the array 
 * @version 1.0
 * @since 2024-04-15
 */
public class ArrayDS {
	
//	array traversal
	/**
	 * Method demonstrates different ways of array traversal
	 * @param array the array to be traversed
	 */
	public void traverseArray(int[] array) {
//		using for loop
		for(int i=0; i<array.length; i++) {
			System.out.print("array ["+i+"] = "+array[i]+" \n");
		}
//		using while loop
		int j=0;
		while(j<array.length) {
			System.out.print("array ["+j+"] = "+array[j]+" \n");
			j++;
		}
//		using foreach
		for(int i : array) {
			System.out.print("array[i]= "+i+" \n");
		}
	}
	
//	array insertion
	public int[] insertElement(int[] array, int n, int index) {
		int[] arr = Arrays.copyOf(array, array.length+1);
		System.out.println(Arrays.toString(arr));
		for(int i=arr.length-1; i>index; i--) {
			int temp= arr[i];
			arr[i]=arr[i-1];
			arr[i-1]=temp;
		}
		arr[index]=n;
		return arr;
	}
	
//	insertion 2 (better)
	/**
	 * Method inserts the element into array at the specified position
	 * @param array  the erray where the element will be inserted
	 * @param n element to be inserted
	 * @param index position where to insert the specified element
	 * @return returns new array with together with inserted element
	 */
	public int[] insertElementBetter(int[] array, int n, int index) {
		if(index<0 || index>array.length-1) {
			throw new IllegalArgumentException("Invalid element position");
		}
		int[] arr= new int[array.length+1];
		for(int i=0; i<index;i++) {
			arr[i]=array[i];
		}
		arr[index]=n;
		for(int i=index; i<array.length; i++) {
			arr[i+1]=array[i];
		}
		return arr;
	}
	
//	deletion of the element from an array from position
	/**
	 * Method deletes the element from the specified position on an array
	 * @param array array from which the element will be deleted
	 * @param position the position form which to delete the element
	 * @return returns the new array without the deleted element
	 */
	public int[] deleteElementAtPosition(int[] array, int position) {
		if(position<0 || position>array.length-1) {
			throw new IllegalArgumentException("Invalid element position");
		}
		int[] arr = new int[array.length-1];
		for(int i=0; i<position; i++) {
			arr[i]=array[i];
		}
		for(int i=position; i<array.length-1; i++) {
			arr[i]=array[i+1];
		}
		return arr;
	}
//	deletion of the elment from an array that equals to
	/**
	 * deletes the first found element from an array and returns array without that element
	 * @param array from where to delete the element
	 * @param elem the element to delete
	 * @return int[] array without the element that you want to delete 
	 */
	public int[] deleteElement(int[] array, int elem) {
		int position =-1;
		for(int i=0; i<array.length; i++) {
			if(array[i]==elem) {
				position=i;
				break;
			}
		}
		if (position!=-1) {
			int[] arr = deleteElementAtPosition(array, position);
			return arr;
		}
		else {
			throw new IllegalArgumentException("The element that you are trying to delete does not exist");
		}

	}
	
//	updatign element at specified position
	/**
	 * Method updates the eelement at a specified position
	 * @param array the array in which update will happen
	 * @param position the position of the element to update
	 * @param val the new value of the element
	 */
	public int[] update(int[] array, int position, int val) {
		if(position<0 || position>array.length-1) {
			throw new IllegalArgumentException("Invalid element position");
		}
		array[position]=val;
		return array;
	}
	
//	searching for specified element
	/**
	 * Method searches for the specified element in an array
	 * @param array the array in which the search is performed
	 * @param elem the element that is searched for
	 */
	public int searchForElement(int[] array, int elem) {
		int position =-1;
		for(int i=0; i<array.length; i++) {
			if(array[i]==elem) {
				position=i;
				break;
			}
		}
		if (position!=-1) {
			System.out.println("Element "+elem+" first occurs at index "+position);
			return position;
		}
		else {
			System.out.println("The element is not found.");
			return -1;
		}
	}

//	sorting an array using..

}
