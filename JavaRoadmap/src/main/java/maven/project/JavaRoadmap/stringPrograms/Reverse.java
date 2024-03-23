package maven.project.JavaRoadmap.stringPrograms;

import java.util.Stack;

public class Reverse {
	
	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	public static String reverseString1(String s) {
		String s2="";
		for(int i=s.length()-1; i>=0; i--) {
			s2+=s.charAt(i);
		}
		return s2;
	}
	
	public static String revserseStringUsingStack(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));
		}
		s="";
		while(!stack.isEmpty()) {
			s+=stack.pop();
		}
		return s;
	}

}
