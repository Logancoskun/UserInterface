package practice;

public class find_wovels {

    public static void main(String[] args) {

        String str = "Welcome";
        str = str.toLowerCase(); // Convert the string to lowercase for case-insensitive matching

        int vowelCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("True");
                System.out.println(ch);
                vowelCount++;
            }
        }
        System.out.println("Total vowels: " + vowelCount);

    }
}
