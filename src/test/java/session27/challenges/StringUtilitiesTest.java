package session27.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * <h1>Exercise 1: Testing a String Utility Class</h1>
 * <ol><li>Create a class with utility methods that perform string manipulation operations
 * (e.g., reversing a string, counting occurrences, truncating, etc.).</li>
 * <li>Write test cases using JUnit to verify the correctness of each utility method.</li>
 * <li>Use JUnit assertions to check the expected results for different input strings and edge cases.</li></ul>
 */
public class StringUtilitiesTest {

    private final StringUtilities stringUtilities = new StringUtilities();

    @Test
    void givenNullOrEmptyString_whenReverseString_thenStringIsReturned() {
        String[] test = {null, ""};

        int counter = 0;

        for(String entry: test) {
            Assertions.assertEquals(stringUtilities.reverseString(entry),
                    entry,
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNonNullOrEmptyString_whenReverseString_thenReverseStringIsReturned() {
        String[][] test = {
                {"\uD83D\uDE04\uD83E\uDD14abcd\uD83E\uDD17efgh\uD83E\uDD14",   //😄🤔abcd🤗efgh🤔
                 "\uD83E\uDD14hgfe\uD83E\uDD17dcba\uD83E\uDD14\uD83D\uDE04"},  //🤔hgfe🤗dcba🤔😄

                {"\uD83D\uDE04a1-b2c3d4\uD83E\uDD14",  //😄a1-b2c3d4🤔
                 "\uD83E\uDD144d3c2b-1a\uD83D\uDE04"}  //🤔4d3c2b-1a😄
        };

        int counter = 0;

        for (String[] entry: test) {
            Assertions.assertEquals(stringUtilities.reverseString(entry[0]),
                    entry[1],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNullOrEmptyStringOrNegativePosition_whenTruncateString_thenStringIsReturned() {

        Object[][] test = {
                {null, -1},
                {"", 1},
                {"abc", -1}
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.truncateString((String) entry[0], (Integer) entry[1]),
                    entry[0],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenStringAndPosition_whenTruncateString_thenTruncatedStringAtPositionIsReturned() {

        Object[][] test = {
                {"\uD83D\uDE04\uD83D\uDE04abcd\uD83E\uDD17efgh\uD83E\uDD14",  //😄😄abcd🤗efgh🤔
                        4,
                        "\uD83D\uDE04\uD83D\uDE04ab" //😄😄ab
                },
                {"\uD83D\uDE04\uD83D\uDE04abcd\uD83E\uDD17efgh\uD83E\uDD14",  //😄😄abcd🤗efgh🤔
                        0,
                        ""
                },
                {"\uD83D\uDE04\uD83D\uDE04abcd\uD83E\uDD17efgh\uD83E\uDD14",  //😄😄abcd🤗efgh🤔
                        13,
                        "\uD83D\uDE04\uD83D\uDE04abcd\uD83E\uDD17efgh\uD83E\uDD14"  //😄😄abcd🤗efgh🤔
                },
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.truncateString((String) entry[0], (Integer) entry[1]),
                    entry[2],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNullOrEmptyOperands_whenCountOccurrences_thenZeroIsReturned() {

        Object[][] test = {
                {null, null, 0},
                {null, "", 0},
                {null, "aaa", 0},
                {"", null, 0},
                {"", "", 0},
                {"", "aaa", 0},
                {"abc", null, 0},
                {"aB", "", 0}
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.countOccurrences((String) entry[0], (String) entry[1]),
                    (Integer) entry[2],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNonNullOrEmptyOperands_whenCountOccurrences_thenOccurrencesAreReturned() {

        Object[][] test = {
                {"\uD83E\uDD14\uD83D\uDE04\uD83E\uDD14abcd\uD83E\uDD17efgh\uD83E\uDD14",  //🤔😄🤔abcd🤗efgh🤔
                        "\uD83E\uDD14",  //🤔
                        3
                },
                {"Apartment", "a", 1},
                {"lollipop", "li", 1},
                {"Customer", "cu", 0}
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.countOccurrences((String) entry[0], (String) entry[1]),
                    (Integer) entry[2],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNullOrEmptyOperands_whenIsInString_thenFalseIsReturn() {

        Object[][] test = {
                {null, null, false},
                {null, "", false},
                {null, "aaa", false},
                {"", null, false},
                {"", "", false},
                {"", "aaa", false},
                {"abc", null, false},
                {"aB", "", false}
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.isInString((String) entry[0], (String) entry[1]),
                    (Boolean) entry[2],
                    "Failed at step " + ++counter);
        }
    }

    @Test
    void givenNonNullOrEmptyOperands_whenIsInString_thenExistenceIsReturn() {

        Object[][] test = {
                {"\uD83E\uDD14\uD83D\uDE04\uD83E\uDD14abcd\uD83E\uDD17efgh\uD83E\uDD14",  //🤔😄🤔abcd🤗efgh🤔
                        "\uD83E\uDD14",  //🤔
                        true
                },
                {"Apartment", "a", true},
                {"lollipop", "li", true},
                {"Customer", "cu", false}
        };

        int counter = 0;

        for (Object[] entry: test) {
            Assertions.assertEquals(stringUtilities.isInString((String) entry[0], (String) entry[1]),
                    (Boolean) entry[2],
                    "Failed at step " + ++counter);
        }
    }
}
