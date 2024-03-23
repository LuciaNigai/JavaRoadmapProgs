package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.stringPrograms.*;

class StringProgramsTest {

	@Test
	void characterNumberTest() {
		int expected =8;
		int actual1 = CharactersNumber.getCharactNumb("Hello you");
		int actual2 = CharactersNumber.getCharactNumb2("Hello you");
		int actual3 = CharactersNumber.getCharactNumb3("Hello you");
		int actual4 = CharactersNumber.getCharactNumb4("Hello you");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
	}
	
	@Test
	void PunctuationCountTest() {
		int expected = 2;
		int actual1 = PunctuationCount.countPunctuation("Hello! How are you?");
		int actual2 = PunctuationCount.countPunctuation("Hello! How are you?");
		int actual3 = PunctuationCount.countPunctuation("Hello! How are you?");
		int actual4 = PunctuationCount.countPunctuation("Hello! How are you?");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
	}
	
	@Test
	void ConsonantsVowelsCountTest() {
		int[] expected = new int[] {2,2};
		int[] actual1 = ConsonantsAndVowels.countConsonantsVowelsNumber("Hello");	
		int[] actual2 = ConsonantsAndVowels.countConsonantsVowelsNumber2("Hello");	
		assertArrayEquals(expected, actual1);
		assertArrayEquals(expected, actual2);
		
	}
	
	@Test
	void AnagramTest() {
		boolean expected = true;
		boolean actual = Anagram.checkAnagram("angel", "glean");
		assertEquals(expected, actual);
	}
	
	@Test
	void RemoveWhitespaceTest() {
		String expected = "Hellomyfriend";
		String actual1 = RemoveWhitespaces.removeWhitespace("Hello my friend");
		String actual2 = RemoveWhitespaces.removeWhitespace1("Hello my friend");
		String actual3 = RemoveWhitespaces.removeWhitespace2("Hello my friend");
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	}
	
	@Test
	void PalindromeTest() {
		boolean expected = true;
		boolean actual = Palindrome.isPalindrome("apa apa");
		boolean actual2 = Palindrome.isPalindrome2("apa apa");
		
		assertEquals(expected, actual);
		assertEquals(expected, actual2);
		
	}
	
	@Test
	void RotationTest() {
		boolean expected = true;
		boolean actual = WordRotation.checkIfRotation("baba", "abab");
		assertEquals(expected, actual);
	}
	
	@Test
	void MaxOccurCharacterTest() {
		Map<Character, Integer> expected = new HashMap<Character, Integer>();
		expected.put('l', 2);
		Map<Character,Integer> actual = MaxOccurCharact.getMaximumOccurrCharact("Hello");
		assertEquals(expected, actual);
	}
	
	@Test
	void ReverseTest() {
		String expected = "evoba";
		String actual1 = Reverse.reverseString("above");
		String actual2 = Reverse.reverseString1("above");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
}
