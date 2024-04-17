package maven.project.JavaRoadmap;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello" + 5 + 6);
		System.out.println("Hello" + (5 + 6));

		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = a;
		b[0] = 0;
		System.out.println(Arrays.toString(a));
		b = a.clone();
		b[0] = 100;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(sumOddN(4));
		System.out.println(sumSquare(3));
		System.out.println(numberVowels("Hello my friend"));
		System.out.println("Hello! How are you?".replaceAll("[\\p{Punct}]", ""));
		System.out.println(correctArithmeticFormula(3, 5, 8));
		System.out.println(PairIsEven(new int[] {1,2,5,7,9}));
		System.out.println(distrinctFloat(new float[] {1.0f,2.0f,3.0f,4.0f,2.0f}));
		
		String string = "Hello friend";
		System.out.println(string.substring(4, 8));
		

	}

	public static int sumOddN(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n % 2 == 0) {
			// If n is even, skip it and recursively call sumN with n-1
			return sumOddN(n - 1);
		} else {
			// If n is odd, add n and recursively call sumN with n-2
			return n + sumOddN(n - 2);
		}
	}

	public static int sumSquare(int n) {
		if (n <= 0)
			return 0;
		return n * n + sumSquare(n - 1);
	}

	public static int numberVowels(String s) {
		s = s.toLowerCase();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u')
				count++;
		}
		return count;
	}

	public static boolean correctArithmeticFormula(int a, int b, int c) {
		if((a+b==c) || (b-c==a) || (a*b==c)) {
			return true;
		}
		else return false;
	}
	
	public static boolean PairIsEven(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]%2==0 || arr[j]%2==0)
					return true;
			}
		}
		return false;
	}
	
	public static boolean distrinctFloat(float[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j])
					return false;
			}
		}
		return true;
	}


}
