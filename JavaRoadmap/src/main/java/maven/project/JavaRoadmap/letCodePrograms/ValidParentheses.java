package maven.project.JavaRoadmap.letCodePrograms;

import java.util.Stack;

public class ValidParentheses {
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
    
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
    
    public static boolean isValid2(String s) {
        char[] charArr = new char[s.length()];

        int i = -1;

        for(char c : s.toCharArray()) {
            if(c == '(') {
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
