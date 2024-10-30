package com.jtdev.all_study;

import org.junit.Test;
import static org.junit.Assert.*;

public class SignInTest {

    @Test
    public void testValidEmail() {
        Login_SignUp signup = new Login_SignUp();
        String email = "user@example.com";
        assertTrue(signup.isValidEmail(email));
    }

    @Test
    public void testInvalidEmail() {
        Login_SignUp signup = new Login_SignUp();
        String email = "invalid-email";
        assertFalse(signup.isValidEmail(email));
    }

}
