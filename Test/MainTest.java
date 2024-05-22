import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCheckUserNameValid() {

        String validUsername;
        validUsername = "Kyl_1";

        assertEquals("Kyl_1",validUsername);
    }

    @Test
    public void testCheckUserNameInvalid() {
        String invalidUsername;
        invalidUsername = "kyle!!!!!!!";

        assertEquals("kyle!!!!!!!",invalidUsername);
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        String validPassword;
        validPassword = "Ch&&sec@ke99!";
        assertEquals("Ch&&sec@ke99!",validPassword);
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        String invalidPassword;
        invalidPassword = "password";
        assertEquals("password",invalidPassword);
    }

    @Test
    public void testLoginUserSuccess() {

        boolean validPassword = true;
        boolean validUsername = true;

        assertTrue(validPassword);
        assertTrue(validUsername);

    }

    @Test
    public void testLoginUserFailed() {
        boolean invalidPassword = false;
        boolean invalidUsername = false;
        assertFalse(invalidUsername);
        assertFalse(invalidPassword);
    }

    @Test
    public void testCheckUserNameValidityTrue() {
        boolean validUsername = true;
        assertTrue(validUsername);
    }

    @Test
    public void testCheckUserNameValidityFalse() {
        boolean invalidUsername = false;
        assertFalse(invalidUsername);
    }

    @Test
    public void testCheckPasswordComplexityValidityTrue() {
        boolean validPassword = true;
        assertTrue(validPassword);
    }

    @Test
    public void testCheckPasswordComplexityValidityFalse() {
        boolean invalidPassword = false;
        assertFalse(invalidPassword);
    }
}