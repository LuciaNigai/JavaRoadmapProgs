package maven.project.JavaRoadmap.arrayPrograms;

public class FindMinAndMax {

	public static int[] findMinAndMax(int[] array) {
		int[] minMax = new int[2];
		int min=array[0];
		int max=array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i]<min)
				min=array[i];
			if(array[i]>max) {
				max=array[i];
			}
		}
		minMax[0]=min;
		minMax[1]=max;
		return minMax;
	}
}
