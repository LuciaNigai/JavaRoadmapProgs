package maven.project.JavaRoadmap.problems.stringProblems;

import java.util.Stack;

/**
 * The Reverse class provides methods to reverse a string.
 */
public class Reverse {

    /**
     * Reverses the input string using StringBuilder's reverse method.
     *
     * @param s The input string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Reverses the input string using a loop and concatenation.
     *
     * @param s The input string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString1(String s) {
        String s2 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s2 += s.charAt(i);
        }
        return s2;
    }

    /**
     * Reverses the input string using a stack.
     *
     * @param s The input string to be reversed.
     * @return The reversed string.
     */
    public static String revserseStringUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        return s;
    }
}

