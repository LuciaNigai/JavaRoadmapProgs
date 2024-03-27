package maven.project.JavaRoadmap.problems.arrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A utility class for removing duplicates from a sorted integer array.
 *
 * @version 1.0
 * @since 2024-03-27
 */
public class RemoveDuplicates {

    /**
     * Removes duplicates from the given sorted integer array.
     *
     * @param arr the sorted integer array
     * @return the array without duplicates
     */
    public static int[] removeDuplicates(int[] arr) {
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                len++;
            }
        }
        int[] array = new int[len];
        array[0] = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                array[count] = arr[i];
                count++;
            }
        }
        return array;
    }
    
    /**
     * Removes duplicates from the given sorted integer array. (using just one loop)
     *
     * @param arr the sorted integer array
     * @return the array without duplicates
     */
    public static int[] removeDuplicatesBetter(int[] arr) {
    	int n= arr.length;
    	if(n==0 || n==1) {
    		return arr;
    	}
    	int[] result = new int[n];
    	int j=0;
    	for(int i=0; i<n-1; i++) {
    		if(arr[i]!=arr[i+1]) {
    			result[j++]=arr[i];
    		}
    	}
    	result[j++]=arr[n-1]; //add the last elemnt as it's unique
    	int[] finalResult = Arrays.copyOf(result, j); //copy only the valid elements
    	return finalResult;
    	
    }
    
    /**
     * Removes the duplicates from the given sorted integer array using ArrayList
     * 
     * @param arr the sorted integer array
     * @reutrn the array wihtiut duplicates
     */
    public static int[] removeDuplicatesArrayList(int[] arr) {
    	List<Integer> resultList = new ArrayList<>();
//    	traversing the array and 
//    	checking if the elemtns is the first in an array or is not equal to the previous element
//    	if true adding it to the resultList
    	for(int i=0; i<arr.length; i++) {
    		if(i==0 || arr[i]!=arr[i-1]) {
    			resultList.add(arr[i]);
    		}
    	}
//    	converting the list to an array
    	int[] result = new int[resultList.size()];
    	for(int i=0; i<resultList.size(); i++) {
    		result[i]=resultList.get(i);
    	}
    	return result;
    	
    }
    
    
}
