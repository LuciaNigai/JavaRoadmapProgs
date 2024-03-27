package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.problems.stringProblems.*;


class StringProgramsTest {

	 /**
	 * Tests the {@link CharactersNumber#getCharactNumb(String)}, {@link CharactersNumber#getCharactNumb2(String)}, {@link CharactersNumber#getCharactNumb3(String)}, {@link CharactersNumber#getCharactNumb4(String)} methods
     * Test case  verifies if the methods return correct character count in a string 
     */
    @Test
    void characterNumberTest() {
        int expected = 8;
        int actual1 = CharactersNumber.getCharactNumb("Hello you");
        int actual2 = CharactersNumber.getCharactNumb2("Hello you");
        int actual3 = CharactersNumber.getCharactNumb3("Hello you");
        int actual4 = CharactersNumber.getCharactNumb4("Hello you");
        
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
        assertEquals(expected, actual4);
    }
    
    /**
     * Tests {@link PunctuationCount#countPunctuation(String)}, {@link PunctuationCount#countPunctuation2(String)}, {@link PunctuationCount#countPunctuation3(String)}, {@link PunctuationCount#countPunctuation4(String)} methods
     * Test case verifies that methods return the correct number of punctuation simbols in a string
     */
    @Test
    void PunctuationCountTest() {
        int expected = 2;
        int actual1 = PunctuationCount.countPunctuation("Hello! How are you?");
        int actual2 = PunctuationCount.countPunctuation2("Hello! How are you?");
        int actual3 = PunctuationCount.countPunctuation3("Hello! How are you?");
        int actual4 = PunctuationCount.countPunctuation4("Hello! How are you?");
        
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
        assertEquals(expected, actual4);
    }
    
    /**
     * Tests {@link ConsonantsAndVowels#countConsonantsVowelsNumber(String)} and {@link ConsonantsAndVowels#countConsonantsVowelsNumber2(String)} methods
     * Test case verifies that the methods return the correct number of consonants and vowels in a string
     */
    @Test
    void ConsonantsVowelsCountTest() {
        int[] expected = new int[] {2, 2};
        int[] actual1 = ConsonantsAndVowels.countConsonantsVowelsNumber("Hello");    
        int[] actual2 = ConsonantsAndVowels.countConsonantsVowelsNumber2("Hello");    
        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
    }
	
    /**
     * Tests {@link Anagram#checkAnagram(String, String)} method
     * Test verifies if the method correctly determines if the string is an anagram or not
     */
	@Test
	void AnagramTest() {
		boolean expected = true;
		boolean actual = Anagram.checkAnagram("angel", "glean");
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests {@link RemoveWhitespaces#removeWhitespace(String)}, 
	 * 		{@link RemoveWhitespaces#removeWhitespace1(String)}, and 
	 * 		{@link RemoveWhitespaces#removeWhitespace2(String)} methods
	 * Test verifies if methods correctly remove the whitespaces form a given string
	 */
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
	
	/**
	 * Tests {@link Palindrome#isPalindrome(String)} 
	 * 		and {@link Palindrome#isPalindrome2(String)} methods
	 * Test verifies if methods correclty determine if the string is a palindrome
	 */
	
	@Test
	void PalindromeTest() {
		boolean expected = true;
		boolean actual = Palindrome.isPalindrome("apa apa");
		boolean actual2 = Palindrome.isPalindrome2("apa apa");
		
		assertEquals(expected, actual);
		assertEquals(expected, actual2);
		
	}
	
	/**
	 * Tests {@link WordRotation#checkIfRotation(String, String)} method
	 * Test verifies if the method determines corectly if one string is a rotation of another
	 */
	@Test
	void RotationTest() {
		boolean expected = true;
		boolean actual = WordRotation.checkIfRotation("baba", "abab");
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests {@link MaxOccurCharact#getMaximumOccurrCharact(String)} method
	 * Test verifies if the method fins the maximum occuring character in the string correctly
	 */
	
	@Test
	void MaxOccurCharacterTest() {
		Map<Character, Integer> expected = new HashMap<Character, Integer>();
		expected.put('l', 2);
		Map<Character,Integer> actual = MaxOccurCharact.getMaximumOccurrCharact("Hello");
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests {@link Reverse#reverseString(String)} 
	 * 		and {@link Reverse#reverseString1(String)} methods
	 * Test verifies if the methods reverse the string correctly
	 */
	
	@Test
	void ReverseTest() {
		String expected = "evoba";
		String actual1 = Reverse.reverseString("above");
		String actual2 = Reverse.reverseString1("above");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	/**
	 * Tests {@link CheckCharacterPresent#isCharacterPresent(String, char)} method
	 * Test verifies if the method corectly determines whethjer a character is present in a string
	 */
	
	@Test
	void CharacterIsPresent() {
		String s = "Hello";
		char ch1 = 'e';
		char ch2 = 'a';
		assertEquals(true, CheckCharacterPresent.isCharacterPresent(s, ch1));
		assertEquals(false, CheckCharacterPresent.isCharacterPresent(s, ch2));
	}
	
}
