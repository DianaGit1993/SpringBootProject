package org.example.Tema1.challenge1;

public class StringUtility
{
    /*Create a class with utility methods that perform string manipulation operations (e.g.,
    reversing a string, counting occurrences, truncating, etc.).
    2. Write test cases using JUnit to verify the correctness of each utility method.
    3. Use JUnit assertions to check the expected results for different input strings and edge cases.*/

    public String reverseString(String a)
    {
        return new StringBuilder(a).reverse().toString();
    }
    public int countOccurrences(Character litera, String cuvant) {
        int contor = 0;
        for (char c : cuvant.toCharArray()) {
            if (c == litera) {
                contor++;
            }
        }
        return contor;
    }



}
