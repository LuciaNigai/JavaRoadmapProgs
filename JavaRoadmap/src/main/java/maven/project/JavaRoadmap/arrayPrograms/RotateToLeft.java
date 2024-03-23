package maven.project.JavaRoadmap.arrayPrograms;


public class RotateToLeft {
	public static int[] rotateArrayToLeft(int[] array) {
		int a=array[0];
		for(int i=0; i<array.length-1; i++) {
			array[i]=array[i+1];
		}
		array[array.length-1]=a;
		return array;
	}

}
