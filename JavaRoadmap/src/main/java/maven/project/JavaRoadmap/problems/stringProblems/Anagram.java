package maven.project.JavaRoadmap.problems.stringProblems;

import java.util.Arrays;

/**
 * Utility class to check if two strings are anagrams of each other.
 */
public class Anagram {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return {@code true} if the two strings are anagrams, {@code false} otherwise.
     */
    public static boolean checkAnagram(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s1.equals(null) || s2.equals(null) || s1.length() != s2.length()) {
            System.out.println("The strings are not anagrams");
            return false;
        }
        char[] c1 = s1.toLowerCase().toCharArray();
        char[] c2 = s2.toLowerCase().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}

