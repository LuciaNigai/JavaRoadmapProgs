package maven.project.JavaRoadmap.letCodePrograms;

import java.util.Stack;

/**
 * A class containing methods to check the validity of parentheses in a given string.
 *
 * @version 1.0
 * @since 2024-03-24
 */
public class ValidParentheses {

    /**
     * Checks whether the parentheses in the given string are valid.
     *
     * @param s the input string containing parentheses
     * @return true if the parentheses are valid, false otherwise
     */
    public static boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the current character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the stack is empty or the current closing bracket does not match
                // the top of the stack, the string is invalid
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
                    return false;
                }
                // Pop the matching opening bracket from the stack
                stack.pop();
            }
        }

        // If the stack is empty, all opening brackets were properly closed
        return stack.isEmpty();
    }

    /**
     * Checks whether the given characters form a matching pair of parentheses.
     *
     * @param open  the opening bracket
     * @param close the closing bracket
     * @return true if the characters form a matching pair, false otherwise
     */
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    /**
     * Alternative method to check whether the parentheses in the given string are valid.
     * This method uses a character array to store closing brackets and compares them directly.
     *
     * @param s the input string containing parentheses
     * @return true if the parentheses are valid, false otherwise
     */
    public static boolean isValid2(String s) {
        char[] charArr = new char[s.length()];

        int i = -1;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                charArr[++i] = ')';
            } else if (c == '[') {
                charArr[++i] = ']';
            } else if (c == '{') {
                charArr[++i] = '}';
            } else if (i != -1 && ((c == ')' && charArr[i] == c)
                    || (c == ']' && charArr[i] == c)
                    || (c == '}' && charArr[i] == c))) {
                i--;
            } else {
                return false;
            }
        }

        return i == -1;
    }
}
