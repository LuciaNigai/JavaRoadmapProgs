package maven.project.JavaRoadmap.problems.stringProblems;


/**
 * Utility class to check if a specific character is present in a given string.
 */
public class CheckCharacterPresent {

    /**
     * Checks if the specified character is present in the given string.
     *
     * @param s The input string to search for the character.
     * @param a The character to search for in the string.
     * @return {@code true} if the character is present in the string, {@code false} otherwise.
     */
    public static boolean isCharacterPresent(String s, char a) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                return true;
            }
        }
        return false;
    }
}
