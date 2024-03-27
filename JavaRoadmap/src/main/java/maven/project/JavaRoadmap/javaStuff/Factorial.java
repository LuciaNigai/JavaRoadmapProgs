package maven.project.JavaRoadmap.javaStuff;

/**
 * The Factorial class provides methods to calculate factorial of a number with and without recursion.
 * Factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
 */
public class Factorial {

    /**
     * Main method to demonstrate calculating factorial.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
        System.out.println(getFactorialWithoutRecursion(5));
    }

    /**
     * Calculates the factorial of a given number using recursion.
     * 
     * @param n The number for which factorial needs to be calculated.
     * @return The factorial of the given number.
     * @throws IllegalArgumentException if the input number is negative.
     */
    public static int getFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Can't calculate factorial of a negative number");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }

    /**
     * Calculates the factorial of a given number without using recursion.
     * 
     * @param n The number for which factorial needs to be calculated.
     * @return The factorial of the given number.
     * @throws IllegalArgumentException if the input number is negative.
     */
    public static int getFactorialWithoutRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Can't calculate factorial of a negative number");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
