package practice;

public class p {

    public static void main(String[] args) {

        String str = "Lokman";
        str = str.toLowerCase();
        int count= 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == 'l' || ch == 'k' || ch == 'm' || ch == 'n') {
                System.out.println("");{

                }
                count++;

            }
        }
        System.out.println("True");
        System.out.println(count);

        }
    }
