package maven.project.JavaRoadmap.javaStuff;

public class ArmstrongNumber {

	public static void main(String[] args) {
		checkArmstrongNumber(155);
	}
	
	private static void checkArmstrongNumber(int n) {
		//check the number of digits in number
		int len = String.valueOf(n).length();
		int num=n, res=0;;
		//count the sum of pows of digits
		while(num>0) {
			res+=Math.pow(num%10, len);
			num/=10;
		}
		//compare the result with the initial number
		if(res==n) System.out.println(n +" is armstrong number");
		else System.out.println(n + " is not an armstrong number");
	}

}