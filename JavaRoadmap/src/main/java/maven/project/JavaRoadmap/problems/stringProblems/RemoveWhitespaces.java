package maven.project.JavaRoadmap.problems.stringProblems;

/**
 * The RemoveWhitespaces class provides methods to remove whitespaces from a string.
 */
public class RemoveWhitespaces {

    /**
     * Removes whitespaces from the given string using the replace method.
     *
     * @param s The input string from which whitespaces will be removed.
     * @return The string with whitespaces removed.
     */
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        return s;
    }

    /**
     * Removes whitespaces from the given string using a character array.
     *
     * @param s The input string from which whitespaces will be removed.
     * @return The string with whitespaces removed.
     */
    public static String removeWhitespace1(String s) {
        char[] ch = s.toCharArray();
        String str = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                str += ch[i];
            }
        }
        return str;
    }

    /**
     * Removes whitespaces from the given string using a StringBuilder.
     *
     * @param s The input string from which whitespaces will be removed.
     * @return The string with whitespaces removed.
     */
    public static String removeWhitespace2(String s) {
        StringBuilder strB = new StringBuilder(s);
        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == ' ') {
                strB.deleteCharAt(i);
            }
        }
        return strB.toString();
    }
}
