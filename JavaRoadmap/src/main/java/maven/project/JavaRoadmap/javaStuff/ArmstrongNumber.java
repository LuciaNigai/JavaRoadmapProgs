package maven.project.JavaRoadmap.javaStuff;

/**
 * The ArmstrongNumber class provides a method to check if a given number is an Armstrong number.
 * An Armstrong number (also known as narcissistic number) is a number that is equal to the sum of its own digits raised to the power of the number of digits.
 */
public class ArmstrongNumber {

    /**
     * Main method to demonstrate checking for Armstrong number.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        checkArmstrongNumber(155);
    }

    /**
     * Checks if the given number is an Armstrong number.
     * 
     * @param n The number to be checked.
     */
    private static void checkArmstrongNumber(int n) {
        // Check the number of digits in the number
        int len = String.valueOf(n).length();
        int num = n, res = 0;

        // Count the sum of powers of digits
        while (num > 0) {
            res += Math.pow(num % 10, len);
            num /= 10;
        }

        // Compare the result with the initial number
        if (res == n)
            System.out.println(n + " is an Armstrong number");
        else
            System.out.println(n + " is not an Armstrong number");
    }
}
