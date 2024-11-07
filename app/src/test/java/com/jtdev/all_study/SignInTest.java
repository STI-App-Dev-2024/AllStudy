package com.jtdev.all_study;

import org.junit.Test;
import static org.junit.Assert.*;
import com.jtdev.all_study.Signin_SignUp;
import android.accounts.Account;

public class SignInTest {

    @Test
    public void testValidEmail() {
        Signin_SignUp signup = new Signin_SignUp();
        String email = "user@example.com";
        assertTrue(signup.isValidEmail(email));
    }

    @Test
    public void testInvalidEmail() {
        Signin_SignUp signup = new Signin_SignUp();
        String email = "invalid-email";
        assertFalse(signup.isValidEmail(email));
    }

}
