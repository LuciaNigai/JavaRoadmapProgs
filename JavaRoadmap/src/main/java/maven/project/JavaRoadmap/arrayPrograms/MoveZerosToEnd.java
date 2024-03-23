package maven.project.JavaRoadmap.arrayPrograms;

import java.util.Arrays;

/*
 * algorithm visualization link
 * https://www.notion.so/Move-Zeros-to-end-b8e2e31217ed4853b07a1ee7fdd976ab
 */

public class MoveZerosToEnd {
	
	public static void main(String...args) {
		System.out.println(Arrays.toString(moveZerosEnd(new int[] {2,4,0,5,0,6,7})));;
	}
	

	public static int[] moveZerosEnd(int[] arr) {
		int j=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0 && arr[j]==0) {
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			if(arr[j]!=0) {
				j++;
			}
		}
		return arr;
	}

}
