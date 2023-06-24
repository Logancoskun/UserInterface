package practice;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 5, 6, 5, 7, 8, 7};
        int[] result = removeDuplicates(numbers);
        System.out.println(Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] nums) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (uniqueSet.add(num)) {
                result[index++] = num;
            }
        }

        return Arrays.copyOf(result, index);
    }
}




