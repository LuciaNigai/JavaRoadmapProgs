package maven.project.JavaRoadmap.javaStuff;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(getFractorial(5));
		System.out.println(getFactorialWithoutRecursion(5));
	}
	
	public static int getFractorial(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Can't count a factorial of a negative number");
		}
		
		if(n==1 || n==0) {
			return 1;
		}
		return n*getFractorial(n-1);
	}

	
	public static int getFactorialWithoutRecursion(int n) {
		if(n<0) {
			throw new IllegalArgumentException("Can't count a factorial of a negative number");
		}
		if(n==0 || n==1) {
			return 1;
		}
		int fact=1;
		for(int i=1; i<=n; i++) {
			fact=fact*i;
		}
		return fact;
	}
}