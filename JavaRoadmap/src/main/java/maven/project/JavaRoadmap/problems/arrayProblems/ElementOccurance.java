package maven.project.JavaRoadmap.problems.arrayProblems;

import java.util.HashMap;
import java.util.Map;


/**
 * The ElementOccurance class provides a method to find duplicate elements in an array and their occurrences.
 */
public class ElementOccurance {
    
    /**
     * Finds duplicate elements in the given array and their occurrences.
     *
     * @param array The input array.
     * @return A map containing the duplicate elements as keys and their occurrences as values.
     */
    public static Map<Integer,Integer> printArrayDuplicates(int[] array) {
        boolean[] checked = new boolean[array.length];
        Map<Integer, Integer> occurrence = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if(checked[i] == true) {
                continue;
            }
            int count = 1;
            checked[i] = true;
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] == array[j]) {
                    checked[j] = true;
                    count++;
                }
            }
            if(count > 1) {
                occurrence.put(array[i], count);
            }
        }
        return occurrence;
    }
}

