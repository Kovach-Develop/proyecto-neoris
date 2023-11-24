package com.api.proyect.nero.Utils;

public class PasswordValidator {

    private static final int MIN_LENGTH = 8;

    public static boolean isValidPassword(String password) {
        return password.length() >= MIN_LENGTH;
    }
}