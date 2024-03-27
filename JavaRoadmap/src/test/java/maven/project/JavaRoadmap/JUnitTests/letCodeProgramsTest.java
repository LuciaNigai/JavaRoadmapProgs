package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.letCodePrograms.*;

class letCodeProgramsTest {

	/**
	 * Tests {@link IndexOfTheFirstOccurence#findIndexOfFirstOccurence(String, String)}, 
	 * 		{@link IndexOfTheFirstOccurence#findIndexOfFirstOccurenceRegex(String, String)}, 
	 * 		{@link IndexOfTheFirstOccurence#findIndexOfFirstOccurrenceRegionMatches(String, String)} methods
	 * It verifies if the method returns the correct index of the first occurence of the substring in a string
	 */
	@Test
	void FirstOccurenceIndexTest() {
		int expected = 6;
		int actual1 = IndexOfTheFirstOccurence.findIndexOfFirstOccurence("Hello my friend", "my");
		int actual2 = IndexOfTheFirstOccurence.findIndexOfFirstOccurenceRegex("Hello my friend", "my");
		int actual3 = IndexOfTheFirstOccurence.findIndexOfFirstOccurrenceRegionMatches("Hello my friend", "my");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	}
	/**
	 * Tests {@link ValidParentheses#isValid(String)} and {@link ValidParentheses#isValid2(String)} methods
	 * It verifies if the method correctly checks if the string sequence is corrrect
	 */
	
	@Test
	void ValidParenthesesTest() {
		assertEquals(true, ValidParentheses.isValid("(){[]}"));
		assertEquals(true, ValidParentheses.isValid2("(){[]}"));
		assertEquals(false, ValidParentheses.isValid("(){[)]}"));
		assertEquals(false, ValidParentheses.isValid2("(){[)]}"));
	}
	
	/**
	 * Tests {@link LengthOfLastWord#getLastWordLength(String)} and {@link LengthOfLastWord#getLastWordLengthFaster(String)} methods
	 * It checks if the methods return the correct length of the last word in a given string
	 */
	
	@Test
	void LengthOfLastWordTest() {
		int expected = 6;
		int actual1 = LengthOfLastWord.getLastWordLength("Hello my friend");
		int actual2 = LengthOfLastWord.getLastWordLengthFaster("Hello my friend");
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@Test
	void AddBinary() {
		String expected = "100";
		String actual1 = AddBinary.addBinary("11", "1");
		String actual2 = AddBinary.addBinaryLetCode("11", "1");
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}

}
