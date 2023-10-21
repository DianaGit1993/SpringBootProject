package challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge1 {
    public static String reverseString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static int countOccurrences(String input, String subString) {
        if (input == null || subString == null) {
            throw new IllegalArgumentException("Input and substring cannot be null.");
        }
        int count = 0;
        Pattern pattern = Pattern.compile(Pattern.quote(subString));
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static String truncateString(String input, int maxLength) {
        if (input == null || maxLength < 0) {
            throw new IllegalArgumentException("Input string cannot be null, and maxLength must be non-negative.");
        }
        return input.length() <= maxLength ? input : input.substring(0, maxLength);
    }
}
