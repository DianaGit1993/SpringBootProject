package challenge;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.Assert.*;
import static org.junit.platform.commons.util.StringUtils.*;

public class Challenge1Test {

    @Test
    public void testReverseString(){
        assertEquals("gnirts", Challenge1.reverseString("string"));
        assertEquals("", Challenge1.reverseString(""));
        assertEquals("a", Challenge1.reverseString("a"));
        assertNull(Challenge1.reverseString(null));
    }

    @Test
    public void testCountOccurrences(){
        assertEquals(2, Challenge1.countOccurrences("hello, hello, hello world", "hello" ));
        assertEquals(0, Challenge1.countOccurrences("This is a test", "banana"));
        assertEquals(0, Challenge1.countOccurrences("test", ""));
        assertThrows(IllegalArgumentException.class, () -> Challenge1.countOccurrences(null, "test"));
    }

    @Test
    public void testTruncateString(){
        assertEquals("This is a", Challenge1.truncateString("This is a test", 10));
        assertEquals("Testing", Challenge1.truncateString("Testing", 7));
        assertNull(Challenge1.truncateString(null, 5));
        assertThrows(IllegalArgumentException.class, () -> Challenge1.truncateString("Test", -1));

    }
}
