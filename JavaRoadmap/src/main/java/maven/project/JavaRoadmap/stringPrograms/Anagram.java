package maven.project.JavaRoadmap.stringPrograms;

import java.util.Arrays;

public class Anagram {
	public static boolean checkAnagram(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty() || s1.equals(null) || s2.equals(null) || s1.length() != s2.length()) {
			System.out.println("The strings are not anagrams");
			return false;
		}
		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (Arrays.equals(c1, c2) == true) {
			return true;
		}
		return false;
	}

}
