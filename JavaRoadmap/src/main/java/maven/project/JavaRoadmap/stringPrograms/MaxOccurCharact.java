package maven.project.JavaRoadmap.stringPrograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxOccurCharact {

	public static Map<Character,Integer> getMaximumOccurrCharact(String str){
		Map<Character, Integer> res = new HashMap<Character, Integer>();
		str = str.replaceAll("\\s", "");
		char[] ch = str.toLowerCase().toCharArray();
		Arrays.sort(ch);
		System.out.println(Arrays.toString(ch));
		char max = ch[0];
		int number = 1, n = 0;
		for (int i = 0; i < ch.length; i++) {
			for (int j = i; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					n++;
				}
			}
			if (n > number) {
				max = ch[i];
				number = n;
			}
			n = 0;
		}
		res.put(max, number);
		return res;

	}
}
