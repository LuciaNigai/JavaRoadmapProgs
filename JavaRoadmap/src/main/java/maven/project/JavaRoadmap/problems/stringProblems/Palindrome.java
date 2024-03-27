package maven.project.JavaRoadmap.problems.stringProblems;

/**
 * The Palindrome class provides methods to check whether a given string is a palindrome or not.
 */
public class Palindrome {

    /**
     * Checks if the given string is a palindrome using StringBuilder.
     *
     * @param s The input string to check.
     * @return True if the string is a palindrome, otherwise false.
     */
    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.equals(null)) {
            System.out.println("String is empty");
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (sb.toString().equals(s)) {
            return true;
        } else
            return false;
    }

    /**
     * Checks if the given string is a palindrome using character comparison.
     *
     * @param s The input string to check.
     * @return True if the string is a palindrome, otherwise false.
     */
    public static boolean isPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("String is empty");
            return false;
        }
        s = s.toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

