package maven.project.JavaRoadmap.problems.stringProblems;

/**
 * Utility class to count the number of characters in a string.
 */
public class CharactersNumber {

    /**
     * Counts the number of characters in the given string, excluding whitespace.
     *
     * @param s The input string.
     * @return The number of characters in the string, excluding whitespace.
     * @throws IllegalArgumentException if the input string is empty or {@code null}.
     */
    public static int getCharactNumb(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of characters in the given string, excluding whitespace using streams.
     *
     * @param s The input string.
     * @return The number of characters in the string, excluding whitespace.
     * @throws IllegalArgumentException if the input string is empty or {@code null}.
     */
    public static int getCharactNumb2(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        return (int) s.chars().filter(ch -> ch != ' ').count();
    }

    /**
     * Counts the number of characters in the given string, excluding whitespace using streams.
     *
     * @param s The input string.
     * @return The number of characters in the string, excluding whitespace.
     * @throws IllegalArgumentException if the input string is empty or {@code null}.
     */
    public static int getCharactNumb3(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        return (int) s.chars().filter(ch -> !Character.isWhitespace(ch)).count();
    }

    /**
     * Counts the number of characters in the given string, excluding whitespace using regular expression.
     *
     * @param s The input string.
     * @return The number of characters in the string, excluding whitespace.
     * @throws IllegalArgumentException if the input string is empty or {@code null}.
     */
    public static int getCharactNumb4(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        return (int) s.replaceAll("\\s+", "").length();
    }
}

