package challenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class Challenge3Test {
    @Test
    public void testValidEmail(){
        assertTrue(EmailValidator3.isValidEmail("example@email.com"));
    }

    @Test
    public void testInvalidEmail(){
        try {
            EmailValidator3.isValidEmail("invalid_email");
            fail("Expected IllegalArgumentException ");
        }catch (IllegalArgumentException e){
            assertEquals("Invalid email address", e.getMessage());
        }
    }
    @Test
    public void testNullEmail(){
        try {
            EmailValidator3.isValidEmail(null);
            fail("Expected IllegalArgumentException");
        }catch (IllegalArgumentException e){
            assertEquals("Invalid email address", e.getMessage());
        }
    }
}
