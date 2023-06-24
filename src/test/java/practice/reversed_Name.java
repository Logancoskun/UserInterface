package practice;

public class reversed_Name {
    public static void main(String[] args) {
        // Replace with the name you want to reverse
        String name = "Logan Coskun";
        name = name.toUpperCase();
        System.out.println(name);

        StringBuilder reversedName = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            reversedName.append(name.charAt(i));
        }
        System.out.println(reversedName);
    }
}
