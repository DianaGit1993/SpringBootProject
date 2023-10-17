package org.example.Homework;

import org.junit.jupiter.api.*;

public class StringManipulationTest {

    private StringManipulation stringManipulation;

    //Count letter occurrence in string
    @BeforeEach
    void init() {
        stringManipulation = new StringManipulation();
    }

    @Nested
    @DisplayName("Testing Counting the occurrence of a given letter in a given string")
    class LetterOccurrenceCount{
        @Test
        @DisplayName("When a string and a letter are given")
        void testCountOccurrenceOfLetter() {
            String str = "Hello, my name is Eve. What are you up to today?";
            Assertions.assertAll(
                    () -> Assertions.assertEquals(4,stringManipulation.countOccurrence(str, 'a') ),
                    () ->Assertions.assertEquals(0,stringManipulation.countOccurrence(str,'b')),
                    () ->Assertions.assertEquals(4,stringManipulation.countOccurrence(str,'e')),
                    ()->Assertions.assertEquals(0,stringManipulation.countOccurrence(str,'-'),()->"Should count all types of characters."),
                    ()->Assertions.assertEquals(0,stringManipulation.countOccurrence(str,'5'),()->"Should count all types of characters.")
            );

        }

        @Test
        @DisplayName("When the Character contains a space and a string with a text is given")
        void testCountOccurrencesOfLetterWithEmptyChar(){
            String str = "Hello, my name is Eve. What are you up to today?";

            Assertions.assertEquals(stringManipulation.countOccurrence(str,' '),10);
        }

        @Test
        @DisplayName("When an empty string is passed and a Character")
        void testCountOccurencesOfLetterInEmptyString(){
            Assertions.assertEquals(stringManipulation.countOccurrence("",'a'),0);
        }

        @Test
        @DisplayName("When a null string is passed and a Character")
        void testCountOccurrencesOfLetterInNullString(){

            try {
                stringManipulation.countOccurrence(null,'a');
                Assertions.fail(() -> "Should not be able count letters in a null string");
            } catch (Exception e) {
                Assertions.assertTrue(e instanceof NullPointerException,
                        () -> "Should throw NullPointerException");
            }
        }

        @Test
        @DisplayName("When a string is passed and a null char")
        void testCountOccurrencesOfLetterWithNullChar(){
            String str = "Hello, my name is Eve. What are you up to today?";


            try {
                stringManipulation.countOccurrence(str,null);
                Assertions.fail(() -> "Should not attempt to count is the Character is null");
            } catch (Exception e) {
                Assertions.assertTrue(e instanceof NullPointerException,
                        () -> "Should throw NullPointerException");
            }
        }

    }







    @Nested
    @DisplayName("Testing Removing duplicate letters")
    class RemoveDuplicateLetters{

        @Test
        @DisplayName("When a string with a duplicated letter is passed - e.g. mommy -> moy")
        void testRemoveDuplicateLettersWithOneDuplicatedLetter(){


            Assertions.assertEquals(
                    "moy",
                    stringManipulation.removeDuplicates("mommy"));
        }

        @Test
        @DisplayName("When a string with multiple duplicated letters is passed - e.g. bananas -> bans")
        void testRemoveDuplicateLettersWithMultipleDuplicatedLetter(){
            Assertions.assertEquals(
                    "bans",
                    stringManipulation.removeDuplicates("bananas"));
        }

        @Test
        @DisplayName("When a string with no duplicated letter is passed - e.g. Smoke ->smoke")
        void testRemoveDuplicateLettersWithNoDuplicatedLetter(){
            Assertions.assertEquals(
                    "Smoke",
                    stringManipulation.removeDuplicates("Smoke"),
                    ()->"The given String does not contain duplicates.Should return the same String.");
        }



        @Test
        @DisplayName("When a string which contains multiple words is passed.")
        void testRemoveDuplicatesWhenMultipleWordsStringIsPassed(){
            Assertions.assertEquals(
                    "Helo, mynais.",
                    stringManipulation.removeDuplicates("Hello, my name is..."),
                    ()->"Should remove all duplicates from complex strings."
            );
        }

        @Test
        @DisplayName("When a null is passed as argument")
        void testRemoveDuplicatesWhenANullIsPassed(){

            try {
                stringManipulation.removeDuplicates(null);
                Assertions.fail(() -> "Should not run with a null argument.");
            } catch (Exception e) {
                Assertions.assertTrue(e instanceof NullPointerException,
                        () -> "Should throw NullPointerException");
            }
        }
    }
    //Remove a given duplicate letter

    @Nested
    @DisplayName("Testing removing duplicates of a given letter")
    class RemoveAGivenDuplicateLetter{

        @Test
        @DisplayName("Removes correctly the duplicates of the given letter - e.g. (mommy,m)->moy")
        void testRemoveDuplicatesOfGivenLetter(){


            Assertions.assertAll(
                    ()->Assertions.assertEquals(
                            "moy",
                            stringManipulation.removeDuplicatesOfLetter("mommy",'m')
                    ),
                    ()->Assertions.assertEquals(
                            "mommy",
                            stringManipulation.removeDuplicatesOfLetter("mommy",'o')
                    ),
                    ()->Assertions.assertEquals(
                            "mommy",
                            stringManipulation.removeDuplicatesOfLetter("mommy",'-')
                    )
            );
        }

        @Test
        @DisplayName("Removes the duplicates of only the given letter - e.g. (bananas,n) -> banaas")
        void testRemoveDuplicatesOfOnlyTheGivenLetter(){
            Assertions.assertAll(
                    ()->Assertions.assertEquals(
                            "banaas",
                            stringManipulation.removeDuplicatesOfLetter("bananas",'n')
                    ),
                    ()->Assertions.assertEquals(
                            "bananas ananas ananas",
                            stringManipulation.removeDuplicatesOfLetter("bananas bananas bananas",'b')
                    )

            );
        }

        @Test
        @DisplayName("When a null is passed as one of the  argument")
        void testRemoveAGivenLetterDuplicatesWhenANullIsPassed(){

            try {
                stringManipulation.removeDuplicatesOfLetter(null,'a');
                Assertions.fail(() -> "Should not run with a null argument.");
            } catch (Exception e) {
                Assertions.assertTrue(e instanceof NullPointerException,
                        () -> "Should throw NullPointerException");
            }
        }

    }


    @Nested
    @DisplayName("Testing if a given String is a palindrome")
    class StringIsPalindrome{

        @Test
        @DisplayName("Returns true if a String (word, sentence, numbers, characters) is a palindrome.")
        void testIsPalindromeReturnsTrueForPalindromeStrings(){
            Assertions.assertAll(
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("mom"),()->"Should return true for 'mom'"),
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("a santa at nasa"),()->"Should return true for 'a santa at nasa'"),
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("12321"),()->"Should return true for '12321'"),
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("%^&^%"),()->"Should return true for '%^&^%'")
            );
        }

        @Test
        @DisplayName("Returns false if a String is NOT a palindrome.")
        void testIsPalindromeReturnsFalseForNonPalindromeStrings(){
            Assertions.assertAll(
                    ()->Assertions.assertFalse(stringManipulation.isPalindrome("mommy"),()->"Should return true for 'mommy'"),
                    ()->Assertions.assertFalse(stringManipulation.isPalindrome("not a palindrome"),()->"Should return false for 'not a palindrome'")
            );
        }

        @Test
        @DisplayName("Returns true if a String is a palindrome that contains both lower and upper case letters.")
        void testIsPalindromeReturnsTrueForPalindromeStringsWithLowerAndUpperCaseLetters(){
            Assertions.assertAll(
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("Mom"),()->"Should return true for 'mommy'"),
                    ()->Assertions.assertTrue(stringManipulation.isPalindrome("A Santa at NASA"),()->"Should return false for 'not a palindrome'")
            );
        }
    }


}
