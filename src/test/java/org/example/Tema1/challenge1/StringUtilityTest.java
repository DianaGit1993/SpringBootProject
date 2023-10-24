package org.example.Tema1.challenge1;

import org.example.Tema1.challenge1.StringUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringUtilityTest
{
    StringUtility stringUtility=new StringUtility();
    @Test
    public void Reverse()
    {
        String result=stringUtility.reverseString("ROXANA");
        Assertions.assertEquals("ANAXOR",result);
    }
    @Test
    public void countingOccurrences() {
        int result = stringUtility.countOccurrences('a', "anaMaria");
        Assertions.assertEquals(4, result);
    }


}
