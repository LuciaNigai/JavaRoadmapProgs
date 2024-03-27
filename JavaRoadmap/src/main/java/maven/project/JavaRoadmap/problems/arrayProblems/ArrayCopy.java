package maven.project.JavaRoadmap.problems.arrayProblems;

import java.util.Arrays;

/**
 * The ArrayCopy class provides methods for copying elements from one array to another.
 */
public class ArrayCopy {

    /**
     * Copies elements from one array to another using a loop.
     *
     * @param arr1 The source array.
     * @param arr2 The destination array.
     * @return The destination array with elements copied from the source array.
     */
    public static int[] copyArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    /**
     * Copies elements from one array to another using {@link Arrays#copyOf(int[], int)} method.
     *
     * @param arr1 The source array.
     * @param arr2 The destination array.
     * @return The destination array with elements copied from the source array.
     */
    public static int[] copyArray2(int[] arr1, int[] arr2) {
        arr2 = Arrays.copyOf(arr1, arr2.length);
        return arr2;
    }
}

