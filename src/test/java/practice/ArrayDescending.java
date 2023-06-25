package practice;

import java.util.Arrays;
import java.util.Collections;

public class ArrayDescending {
    public static void main(String[] args) {
        Integer[] numbers = {-3, 7, 0, -5, 2, 4, -1};

        System.out.println("Original array: " + Arrays.toString(numbers));

        // Sorting the numbers in descending order
        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.println("Sorted array in descending order: " + Arrays.toString(numbers));
    }
}

