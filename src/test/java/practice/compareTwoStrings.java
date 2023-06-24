package practice;

public class compareTwoStrings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "HELLO";

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");

            /////////OR I can use just equals();
        }
        if (str1.equals(str2)) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }
}