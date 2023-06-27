package practice;

public class reversed_Name {
    public static void main(String[] args) {
        // Replace with the name you want to reverse
        String str = "Logan Coskun";
        str = str.toUpperCase();
        System.out.println(str);

        StringBuilder reversedName = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedName.append(str.charAt(i));
        }
        System.out.println(reversedName);
    }
}
