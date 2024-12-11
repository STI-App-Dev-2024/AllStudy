package com.jtdev.all_study;

public class Password_Validator {

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        return password.matches(".*[a-z].*");
    }
}
