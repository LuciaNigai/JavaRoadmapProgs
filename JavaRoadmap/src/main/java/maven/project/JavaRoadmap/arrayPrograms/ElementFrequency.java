package maven.project.JavaRoadmap.arrayPrograms;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {

    public static Map<Integer, Integer> getFrequency(int[] arr) {
        // Keep track of processed elements
        boolean[] processed = new boolean[arr.length];
        
//        defining a map to store elements frequency 
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // If the element is already processed, skip it
            if (processed[i])
                continue;

            int elem = arr[i];
            int counter = 1;

            // Mark the current element as processed
            processed[i] = true;

            // Count occurrences of the current element
            for (int j = i + 1; j < arr.length; j++) {
                if (elem == arr[j]) {
                    counter++;
                    // Mark the matching element as processed
                    processed[j] = true;
                }
            }
//		storing the element and its frequency in the map
            frequencyMap.put(elem, counter);
        }

        return frequencyMap;
    }
}

