package maven.project.JavaRoadmap.problems.stringProblems;

/**
 * The WordRotation class provides methods to check if one string is a rotation of another string.
 */
public class WordRotation {

    /**
     * Checks if one string is a rotation of another string.
     *
     * @param s1 The first string.
     * @param s2 The second string to be checked if it's a rotation of the first string.
     * @return true if s2 is a rotation of s1, otherwise false.
     */
    public static boolean checkIfRotation(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
            System.out.println("Second string is not a rotation of the first string");
            return false;
        }

        s1 = s1.concat(s1);
        if (s1.indexOf(s2) != -1) {
            System.out.println("Second string is a rotation of the first string");
            return true;
        } else {
            System.out.println("Second string is not a rotation of the first string");
            return false;
        }
    }
}

