package maven.project.JavaRoadmap.javaStuffOOP;


import java.util.ArrayList;
import java.util.List;


/**
 * Demonstrates the usage of lambda expressions in Java, including capturing instance variables, using local variables,
 * method references, and avoiding side effects with immutable objects.
 *
 * @version 1.0
 * @since 2024-03-24
 */
public class LambdaExpressions {

    // Capturing instance variables in lambda expressions
    private int counter = 0;

    /**
     * Performs an action using a lambda expression and captures the instance variable 'counter'.
     */
    public void performAction() {
        Runnable runnable1 = () -> {
            System.out.println("Inside lambda1 " + counter);
        };
        counter++;
        runnable1.run();
    }

    /**
     * Prints a number to demonstrate method reference.
     */
    public void printNumber() {
        int number = 10;
        System.out.println("Inside method reference " + number);
    }

    public static void main(String[] args) {

        // Using local variables in lambda expressions
        int number = 10;
        Runnable runnable = () -> {
            System.out.println("Inside lambda " + number);
        };

        // Using method reference
        LambdaExpressions lm = new LambdaExpressions();
        Runnable runnable2 = lm::printNumber;
        runnable2.run();

//        number=20;
        // Trying to modify 'number' - this would cause an error as it should be final or effectively final
        runnable.run();

        LambdaExpressions ex = new LambdaExpressions();
        ex.performAction();

        // Avoiding side effects with immutable Objects
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        names.forEach(name -> System.out.println("Hello " + name));
        names.add("Charlie");
        System.out.println(names);

        // Using functional interfaces with lambda expressions
        Calculator sum = (a, b) -> a + b;
        int res = sum.calculate(4, 4);
        System.out.println(res);

        Calculator minus = (a, b) -> a - b;
        System.out.println(minus.calculate(10, 2));

    }

    /**
     * Functional interface for performing a calculation.
     */
    @FunctionalInterface
    interface Calculator {
        /**
         * Performs a calculation with two integers.
         *
         * @param a the first integer
         * @param b the second integer
         * @return the result of the calculation
         */
        int calculate(int a, int b);
    }
}

