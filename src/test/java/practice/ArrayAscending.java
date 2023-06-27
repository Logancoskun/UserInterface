package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayAscending {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, -2, -3, 10, -10};

        //printing the originals
        System.out.println("original arrays; " + Arrays.toString(numbers));

        //sorting the numbers in ascending orders

        Arrays.sort(numbers);
        System.out.println("Sorted Ascending order; " + Arrays.toString(numbers));
    }
}

