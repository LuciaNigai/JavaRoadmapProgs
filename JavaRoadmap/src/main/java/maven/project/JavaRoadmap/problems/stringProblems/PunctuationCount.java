package maven.project.JavaRoadmap.problems.stringProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The PunctuationCount class provides methods to count the total number of punctuation symbols in a given string.
 */
public class PunctuationCount {

    /**
     * Counts the total number of punctuation symbols in the given string using regular expressions.
     *
     * @param s The input string to count punctuation symbols.
     * @return The total number of punctuation symbols in the string.
     * @throws IllegalArgumentException if the input string is empty or null.
     */
    public static int countPunctuation(String s) {
        if (s.isEmpty() || s.equals(null)) {
            throw new IllegalArgumentException("The string is empty");
        }
        Pattern p = Pattern.compile("\\p{Punct}");
        Matcher m = p.matcher(s);
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println("There are " + count + " punctuation symbols in the string");
        return count;
    }

    /**
     * Counts the total number of punctuation symbols in the given string using character iteration.
     *
     * @param s The input string to count punctuation symbols.
     * @return The total number of punctuation symbols in the string.
     * @throws IllegalArgumentException if the input string is empty or null.
     */
    public static int countPunctuation2(String s) {
        if (s.isEmpty() || s.equals(null)) {
            throw new IllegalArgumentException("The string is empty");
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                continue;
            } else if (Character.isWhitespace(c)) {
                continue;
            } else {
                count++;
            }
        }
        System.out.println("There are " + count + " punctuation symbols in the string");
        return count;
    }

    /**
     * Counts the total number of punctuation symbols in the given string using Java streams.
     *
     * @param s The input string to count punctuation symbols.
     * @return The total number of punctuation symbols in the string.
     * @throws IllegalArgumentException if the input string is empty or null.
     */
    public static int countPunctuation3(String s) {
        if (s.isEmpty() || s.equals(null)) {
            throw new IllegalArgumentException("The string is empty");
        }
        long count = s.chars().mapToObj(c -> (char) c).filter(ch -> isPunctuation(ch)).count();
        System.out.println("There are " + count + " punctuation symbols in the string");
        return (int) count;
    }

    private static boolean isPunctuation(char ch) {
        return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
    }

    /**
     * Counts the total number of punctuation symbols in the given string using regular expressions.
     *
     * @param s The input string to count punctuation symbols.
     * @return The total number of punctuation symbols in the string.
     * @throws IllegalArgumentException if the input string is empty or null.
     */
    public static int countPunctuation4(String s) {
        if (s.isEmpty() || s.equals(null)) {
            throw new IllegalArgumentException("The string is empty");
        }
        int count = s.replaceAll("[^\\p{Punct}]", "").length();
        System.out.println("There are " + count + " punctuation symbols in the string");
        return count;
    }
}

