package practice;

import java.util.HashSet;
import java.util.Set;

public class dublicateString {


    public static Set<Character> findDuplicateCharacters(String str) {
            Set<Character> duplicates = new HashSet<>();
            Set<Character> uniqueChars = new HashSet<>();

            for (char ch : str.toCharArray()) {
                if (!uniqueChars.add(ch)) {
                    duplicates.add(ch);
                }
            }

            return duplicates;
        }

        public static void main(String[] args) {
            String inputString = "Hello, World!";
            Set<Character> result = findDuplicateCharacters(inputString);
            System.out.println("Duplicate characters: " + result);
        }
    }




