package practice;

public class reversedString {

    public static void main(String[] args) {
        String str = "Lokman";
        String reversed = "";

        StringBuffer sb = new StringBuffer(str);

        reversed = sb.reverse().toString();

        System.out.println(reversed);
    }
}

