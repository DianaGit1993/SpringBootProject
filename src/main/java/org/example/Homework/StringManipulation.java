package org.example.Homework;

import java.util.*;
import java.util.stream.Collectors;

public class StringManipulation {



    /**
     * Counts the occurrences of the given Character in the given String.
     * @param str a given String
     * @param letter a given Character
     * @return the number (int) of occurences
     */
    public int countOccurrence(String str, Character letter){
       if(str==null || letter==null) throw new NullPointerException();

       return (int)str.chars().filter(ch->ch==letter).count();

    }
    //Remove duplicate letters

    /**
     * Creates a new String with only one occurrence of a Character.
     * All duplicates are removed.
     * @param str a given String
     * @return the new String
     */
    public String removeDuplicates(String str){
        if(str==null) throw new NullPointerException();

        List<Character> resultCharacters=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(!resultCharacters.contains(str.charAt(i))){
                resultCharacters.add(str.charAt(i));
            }
        }
        return resultCharacters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

    }


    /**
     * Creates a new String from the given String removing duplicates of the given Character.
     * First occurrence of the given Character is kept.
     * @param str a given String
     * @param character a given Character
     * @return the new String
     */
    public String removeDuplicatesOfLetter(String str, Character character){
        if(str==null || character==null) throw new NullPointerException();
       String result="";
       int countOccurrences=0;
      for(int i=0;i<str.length();i++){
          if(str.charAt(i)!=character){
              result+=str.charAt(i);
          }
          if(str.charAt(i)==character && countOccurrences==0){
              countOccurrences++;
              result+=str.charAt(i);

          }


      }
      return result;

    }

    //Is palindrome

    /**
     * Checks is a given string is a palindrome
     * @param str given String
     * @return true if the string is palindrome; false if the String is not a palindrome
     */
    public boolean isPalindrome(String str){
        if(str==null) throw new NullPointerException();

        String trimmedStr=str.replaceAll(" ","");
        String reversed="";
        for(int i=trimmedStr.length()-1;i>=0;i--){

            reversed+=trimmedStr.charAt(i);
        }


        return trimmedStr.equalsIgnoreCase(reversed);
    }



}
