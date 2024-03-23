package maven.project.JavaRoadmap.stringPrograms;

public class RemoveWhitespaces {
	
	/*
	 * remove whitespaces from the string
	 */

	public static String removeWhitespace(String s) {
		s = s.replace(" ", "");
		return s;
	}

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
