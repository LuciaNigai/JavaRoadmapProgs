package maven.project.JavaRoadmap.stringPrograms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationCount {
	/*
	 * count total number of punct in string
	 */

	public static int countPunctuation(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		Pattern p = Pattern.compile("\\p{Punct}");
		Matcher m = p.matcher(s);
		int count = 0;
		while (m.find()) {
			count++;
		}
		System.out.println("There are " + count + " punctuation simbols in a string");
		return count;
	}

	public static int countPunctuation2(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
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

	public static int countPunctuation3(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		long count = s.chars().mapToObj(c -> (char) c).filter(ch -> isPunctuation(ch)).count();
		System.out.println("There are " + count + " punctuation symbols in the string");
		return (int)count;
	}

	private static boolean isPunctuation(char ch) {
		return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
	}

	public static int countPunctuation4(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		int count = s.replaceAll("[^\\p{Punct}]", "").length();
		System.out.println("There are " + count + " punctuation symbols in the string");
		return count;
	}

}
