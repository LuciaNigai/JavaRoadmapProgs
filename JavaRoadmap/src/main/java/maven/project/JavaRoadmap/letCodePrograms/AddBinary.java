package maven.project.JavaRoadmap.letCodePrograms;

import java.math.BigInteger;
/**
 * A utility class that returns the sum of two binary strings
 * @version 1.0
 * @since 2024-03-27
 */

public class AddBinary {

	/**
	 * Functions returns the binary string that is the sum of two given binary strings 
	 * @param a the first binary string
	 * @param b the second binary string
	 * @return returns the sum of twi binary strings
	 */
	public static String addBinary(String a, String b) {
		BigInteger num1 = new BigInteger(a,2);
		BigInteger num2 = new BigInteger(b,2);

		BigInteger sum = num1.add(num2);
		System.out.println(sum.toString(2));
        
        return sum.toString(2);
	}
	
	/**
	 * Method (from letcode) returns the binary string that is the sum of two binary strings
	 * @param a the first binary string
	 * @param b the second binary string
	 * @return returns the sum of twi binary strings
	 */
	public static String addBinaryLetCode(String a, String b) {
        // Convert binary strings to character arrays
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        
        // Iterate through the arrays from right to left
        int i = num1.length - 1;
        int j = num2.length - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1[i--] - '0' : 0;
            int digit2 = j >= 0 ? num2[j--] - '0' : 0;
            
            // Calculate the sum of the current digits and the carry
            int total = digit1 + digit2 + carry;
            
            // Append the least significant bit of the sum to the result
            sum.append(total % 2);
            
            // Update the carry for the next iteration
            carry = total / 2;
        }
        
        // Reverse the result and return as a string
        return sum.reverse().toString();
	}
}
