package maven.project.JavaRoadmap.javaStuff;

import java.util.Arrays;

/**
 * class demonstrates some methods of Character and String classes
 * @version 1.0
 * @since 26/03/2024
 */
public class ChractersAndStrings {

	public static void main(String[] args) {
		
//		Character class methods
		System.out.println("Charactr,isLetter()");
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetter('3'));
		
		System.out.println("Character.isWhitespace()");
		System.out.println(Character.isWhitespace('f'));
		System.out.println(Character.isWhitespace(' '));
		
		System.out.println("Character.isUpperCase()");
		System.out.println(Character.isUpperCase('c'));
		System.out.println(Character.isUpperCase('E'));
		
		System.out.println("Character.toUpperCase()");
		System.out.println(Character.toUpperCase('a'));
		
//		-----------------------Escape sequences--------------------
        // Newline character
        System.out.println("Hello\nWorld!");

        // Tab character
        System.out.println("Hello\tWorld!");

        // Double quote
        System.out.println("\"Hello, World!\"");

        // Single quote
        System.out.println("\'Hello, World!\'");

        // Backslash
        System.out.println("This is a backslash: \\");

        // Unicode character (example: Greek letter Pi)
        System.out.println("Greek letter Pi: \u03A0");

        // Carriage return
        System.out.println("Hello, World!\rNewLine");

        // Form feed
        System.out.println("Hello, World!\fNewPage");

        // Backspace
        System.out.println("Hello, World!\b");
        
//        --------------Formating strings
//        printf
        System.out.printf("The value of the float " +
                "variable is %f, while " +
                "the value of the " + 
                "integer variable is %d, " +
                "and the string is %s", 
                0.3, 12, "hehe"); 
        System.out.println();
//        format
        String fs;
        fs = String.format("The value of the float " +
                           "variable is %f, while " +
                           "the value of the " + 
                           "integer variable is %d, " +
                           "and the string is %s",
                           0.4, 33, "haha");
        System.out.println(fs);
        
//        ---------------------------------String methods-----------------------------------
        String str = " Hey how are you doing\nhehe\n  try this hey how are you hey";
//        -----------trim-------
        str=str.trim();
//       --------substring------
        String[] strArr = str.split("\\s+|\\n+");
        System.out.println(Arrays.toString(strArr));
//       --------subsequence------
        CharSequence subSeq = str.subSequence(0, 10);
        System.out.println(subSeq.toString());
//       regionMatches
        String math = "hey how are you";
        boolean foundIt = false;
        for(int i=0; i<=(str.length()-math.length());i++) {
        	if(str.regionMatches(i, math, 0, math.length())) {
        		foundIt=true;
        		System.out.println(str.substring(i,i+math.length()));
        		break;
        	}
        }
        if(!foundIt) {
        	System.out.println("No marh found");
        }
        
//        -------------------------------String comparison-------------------------
    	String a = "Lucy";
    	String b = "Lucy";
    	System.out.println(a==b);
    	
    	String a2 = new String("Lucy");
    	String b2 = new String("Lucy");
    	System.out.println(a2==b2);
    	System.out.println(a2.equals(b2));
	}

}
