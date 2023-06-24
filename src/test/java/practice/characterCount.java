package practice;

public class characterCount {
    public static void main(String[] args) {
        String str = "Welcome to Automation";
        int lowercaseCount = 0;
        int uppercaseCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            } else if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            }
        }

        System.out.println("Number of lowercase characters: " + lowercaseCount);
        System.out.println("Number of uppercase characters: " + uppercaseCount);
    }
}

