package maven.project.JavaRoadmap.stringPrograms;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsonantsAndVowels {

    public static int[] countConsonantsVowelsNumber(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("The string is null or empty");
        }
        s = s.toLowerCase(); // Correct way to convert to lowercase and assign back
        int vowels = 0, consonants = 0;
        Set<Character> encountered = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isLetter(ch)) {
                continue;
            }
            // Avoid counting the same letter twice
            if (encountered.contains(ch)) {
                continue;
            }
            encountered.add(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        int[] number = new int[2];
        number[0] = vowels;
        number[1] = consonants;
        // Removed print statement
        return number;
    }
    
	public static int[] countConsonantsVowelsNumber2(String s) {
		if (s.isEmpty() || s.equals(null)) {
			throw new IllegalArgumentException("The stiring is empty");
		}
		s.toLowerCase();
		int vowels = 0, consonants = 0;
		Pattern p1 = Pattern.compile("[aeiou]");
		Matcher m1 = p1.matcher(s);
		Pattern p2 = Pattern.compile("[bcdfghjklmnprstvwxyz]");
		Matcher m2 = p2.matcher(s);
		while (m1.find()) {
			vowels++;
		}
		while (m2.find()) {
			consonants++;
		}
		
		int[] numb = new int[2];
		numb[0]=vowels;
		numb[1]=consonants;
		System.out.println("The string has " + vowels + " vowels, and " + consonants + " consonants");
		return numb;
	}
}
