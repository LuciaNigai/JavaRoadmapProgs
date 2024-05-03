package maven.project.JavaRoadmap.javaStuff;


/**
 * Class demostrates a recursve dynamic method that returns specified number from fibonachi seqeunce.
 */
public class FibonachiDynamic {

	public static void main(String[] args) {
		System.out.println(returnFibonachi(50));
	}

	public static long returnFibonachi(int n) {
	    if(n < 0) {
	        throw new IllegalArgumentException("n must be a non-negative integer.");
	    }
	    long[] array = new long[n+1];
	    array[0] = 0;
	    if(n > 0) {
	        array[1] = 1;
	        for(int i = 2; i <= n; i++) {
	            array[i] = array[i-1] + array[i-2];
	        }
	    }
	    return array[n];
	}
}
