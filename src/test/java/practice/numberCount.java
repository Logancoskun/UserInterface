package practice;

public class numberCount {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 8, 5, 10, 12, 3, 9, 6, 4};

        int evenCount = 0;
        int oddCount = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of odd numbers: " + oddCount);
    }
}


