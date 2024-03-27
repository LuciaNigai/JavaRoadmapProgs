package maven.project.JavaRoadmap.javaStuffOOP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates various scenarios of using lambda expressions in Java, including iterating and filtering collections,
 * and sorting the elements of collections.
 *
 * @version 1.0
 * @since 2024-03-24
 */
public class LambdaExpressionsUseScenarios {

    public static void main(String[] args) {

        // Iterating and filtering collections
        List<String> letters = Arrays.asList("a", "b", "c");

        // Without lambdas
        for (String letter : letters) {
            if (letter.endsWith("c")) {
                System.out.println(letter);
            }
        }

        // Using lambdas
        letters.stream()
                .filter(letter -> letter.endsWith("c"))
                .forEach(System.out::println);

        // Sorting the elements of collection
        List<String> names = Arrays.asList("Bobby", "Charlotte", "Aaron");

        // Without lambdas
        Collections.sort(names, new Comparator<String>() {
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });
        System.out.println(names);

        // Using lambdas
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println(names);
    }
}

