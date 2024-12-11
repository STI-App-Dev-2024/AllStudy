package com.jtdev.all_study;

import org.junit.Test;
import static org.junit.Assert.*;

public class SignInTest {

    @Test
    public void testValidEmail() {
        LogIn_or_SignUp signup = new LogIn_or_SignUp();
        String email = "user@example.com";
        assertTrue(signup.isValidEmail(email));
    }

    @Test
    public void testInvalidEmail() {
        LogIn_or_SignUp signup = new LogIn_or_SignUp();
        String email = "invalid-email";
        assertFalse(signup.isValidEmail(email));
    }

}
