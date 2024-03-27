package maven.project.JavaRoadmap.letCodePrograms;

/**
 * A utility class that returns the length of the last word in the string
 * @version 1.0
 * @since 2024-03-27
 */
public class LengthOfLastWord {
	
	/**
	 * Method returns the length of the last word in a string
	 * @param s the string to be checked
	 * @return the length of the last word in a string
	 */
	
	public static int getLastWordLength(String s) {
		String[] array =s.split("\\s");
		System.out.println("The last word is "+array[array.length-1]+" and its posiiton is array[array.length-1].length()");
		return array[array.length-1].length();
		
	}
	
	/**
	 * Method also returns the length of the last word in a string. 
	 * It is more efficient since it does not create a new array.
	 * @param s string to be checked
	 * @return the length of the last word in a string
	 */
	public static int getLastWordLengthFaster(String s) {
	    int length = 0;
	    s=s.trim();
	    for (int i = s.length() - 1; i >= 0; i--) {
	    	if(s.charAt(i)==' ') break;
	        length++;
	    }

	    return length;
	}
	
	
}
