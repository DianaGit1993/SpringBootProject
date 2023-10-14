package session27.challenges;

/**
 * <h1>Exercise 1: Testing a String Utility Class</h1>
 * <ol><li>Create a class with utility methods that perform string manipulation operations
 * (e.g., reversing a string, counting occurrences, truncating, etc.).</li>
 * <li>Write test cases using JUnit to verify the correctness of each utility method.</li>
 * <li>Use JUnit assertions to check the expected results for different input strings and edge cases.</li></ul>
 */
public class StringUtilities {
    public String reverseString(String text) {
        if (text == null || text.isEmpty()) return text;

        return text.codePoints()
                .mapToObj(c -> new StringBuilder(Character.toString(c)))
                .reduce(new StringBuilder(), (a, b) -> b.append(a)).toString();
    }

    public String truncateString(String text, int position) {
        if (text == null || text.isEmpty() || position < 0) return text;

        return text.codePoints()
                .limit(position)
                .mapToObj(c -> new StringBuilder(Character.toString(c)))
                .reduce(new StringBuilder(), StringBuilder::append).toString();
    }

    public int countOccurrences(String text, String lookup) {
        if (text == null || lookup == null
                || text.isEmpty() || lookup.isEmpty()) return 0;

        int result = 0, index = -1;

        while (true) {
            if ((index = text.indexOf(lookup, index + 1)) > -1) result++;
            else break;
        }

        return result;
    }

    public boolean isInString(String text, String lookup) {
        return countOccurrences(text, lookup) > 0;
    }
}