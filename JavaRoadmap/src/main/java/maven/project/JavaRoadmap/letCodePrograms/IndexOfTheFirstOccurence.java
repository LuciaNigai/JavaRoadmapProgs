package maven.project.JavaRoadmap.letCodePrograms;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * A utility class for finding the index of first occurence of the substring in
 * a string
 * 
 * @version 1.0
 * @since 2024-03-27
 */
public class IndexOfTheFirstOccurence {

	/**
	 * Finds the index of first occurence of the substring in a string using the
	 * indexOf method
	 * 
	 * @param string    the string in which the search is performed
	 * @param substring the string that we are searhing for
	 * @return returns the index of the firs occurence, if the string is not found
	 *         returns -1
	 */
	public static int findIndexOfFirstOccurence(String string, String substring) {
		System.out.println("The index of \"" + substring + " in " + string + " is " + string.indexOf(substring));
		return string.indexOf(substring);
	}
	
	

	/**
	 * Finds the index of the first occurence of the string using regular expression
	 * 
	 * @param string    the string in which the search is prformed
	 * @param substring the string we are seraching for
	 * @return the index of first occurence of the substring or -1 if the string is
	 *         not found
	 */
	public static int findIndexOfFirstOccurenceRegex(String string, String substring) {
		Pattern pattern = Pattern.compile(Pattern.quote(substring));
		Matcher matcher = pattern.matcher(string);
		if (matcher.find())
			return matcher.start();
		else
			return -1;
	}
	
	
	/**
	 * Finds the index of the first occurrence of the substring in a string using regionMatches.
	 * 
	 * @param string    the string in which the search is performed
	 * @param substring the substring that we are searching for
	 * @return the index of the first occurrence of the substring, or -1 if not found
	 */
	public static int findIndexOfFirstOccurrenceRegionMatches(String string, String substring) {
	    int strLen = string.length();
	    int subLen = substring.length();
	    
	    for (int i = 0; i <= strLen - subLen; i++) {
	        if (string.regionMatches(i, substring, 0, subLen)) {
	            return i;
	        }
	    }
	    return -1; // Substring not found
	}
	
}
