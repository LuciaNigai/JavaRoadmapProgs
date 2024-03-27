package maven.project.JavaRoadmap.problems.stringProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for finding words in a string 
 * all words from 5 to 7 characters
 * all words occuring 5 to 10 times
 * all words that have letter a and don't have letter y
 */



public class StringMatchesSomeRules {
	/**
	 * Method returns two dimensional array with all words that have 5 to 7 characters, all words that occur 5 to 10 times and all words atht have 'a' and don't have 'y'
	 * @param str the given string to check
	 * @return 
	 */

	public static void getWordsFromString(String str){
		List<String> fiveToSeven=new ArrayList<>(); 
		List<String> fiveToTen=new ArrayList<>(); 
		List<String> haveAdonthaveY=new ArrayList<>(); 
		
		str=str.trim();
		String[] arr = str.split("[\\s\\n\\p{Punct}]+");
		for(int i=0; i<arr.length;i++) {
			if(arr[i].length()>=5 && arr[i].length()<=7 && !fiveToSeven.contains(arr[i]))
			{
					fiveToSeven.add(arr[i]);
			}
			
		}
		 for (int i = 0; i < arr.length; i++) {
	            int counter = 1;
	            // Count occurrences of arr[i]
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i].equals(arr[j])) {
	                    counter++;
	                }
	            }
	            // Add arr[i] to fiveToTen if its count is between 5 and 7
	            if (counter >= 5 && counter <= 7 && !fiveToTen.contains(arr[i])) {
	                fiveToTen.add(arr[i]);
	            }
		}
		
		 for(String s :arr) {
			 if(s.matches(".*a[^y].*") && !haveAdonthaveY.contains(s)) {
				 haveAdonthaveY.add(s);
			 }
		 }
		 
		System.out.println(fiveToSeven);
		System.out.println(fiveToTen);
		System.out.println(haveAdonthaveY);
	}
	
	public static void main(String...strings) {
		getWordsFromString("Hello my dear friend, Hello my dear friend, Hello my Vlad dear friend, Hello my dear friend, Hello my dear friend");
	}
}
