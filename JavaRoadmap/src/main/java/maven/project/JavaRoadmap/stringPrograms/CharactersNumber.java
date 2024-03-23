package maven.project.JavaRoadmap.stringPrograms;

public class CharactersNumber {

	/*
	 * count number of characters in the string
	 */

	public static int getCharactNumb(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			count++;
		}
		return count;
	}

	public static int getCharactNumb2(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		return (int)s.chars().mapToObj(ch -> (char) ch).filter(ch -> ch != ' ').count();
	}

	public static int getCharactNumb3(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		return (int)s.chars().filter(ch -> ch != ' ').count();
	}

	public static int getCharactNumb4(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		return (int) s.replaceAll(" ", "").chars().count();
	}
}
