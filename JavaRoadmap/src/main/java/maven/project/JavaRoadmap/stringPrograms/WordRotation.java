package maven.project.JavaRoadmap.stringPrograms;

public class WordRotation {
	
	public static boolean checkIfRotation(String s1, String s2) {
		if (s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()) {
			System.out.println("Second string is not a rotation of a first string");
			return false;
		}

		s1 = s1.concat(s1);
		if (s1.indexOf(s2) != -1) {
			System.out.println("Second string is a rotation of first string");
			return true;
		}
		else {
			System.out.println("SEcond string is not a rotation of forst string");
			return false;
		}
	}

}
