package maven.project.JavaRoadmap.stringPrograms;

public class Palindrome {

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
