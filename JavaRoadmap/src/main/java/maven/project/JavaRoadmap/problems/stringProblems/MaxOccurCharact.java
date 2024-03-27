package maven.project.JavaRoadmap.problems.stringProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * The MaxOccurCharact class provides a method to find the maximum occurring character in a string.
 */
public class MaxOccurCharact {

    /**
     * Finds the maximum occurring character in the given string and returns it with its count.
     *
     * @param str The input string.
     * @return A map containing the maximum occurring character as the key and its count as the value.
     */
    public static Map<Character, Integer> getMaximumOccurrCharact(String str) {
        Map<Character, Integer> res = new HashMap<>();
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

