package org.example.Ex1;

public class StringManipulation {
    public String reverse(String toReverse) {
        System.out.println(toReverse);
        StringBuilder reversed = new StringBuilder();
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            reversed.append(toReverse.charAt(i));
        }
        System.out.println(reversed);
        return reversed.toString();
    }
}
