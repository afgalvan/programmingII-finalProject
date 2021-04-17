package app.controllers.security;

import lombok.val;

import java.util.Arrays;

public final class Hasher {

    public static String password(String password) {
        val passwordBytes = password.getBytes();
        val hashedBytes = password.getBytes();
        return Arrays.toString(hashedBytes);
    }

    public static boolean areEqualPasswords(String hashedPassword, String password) {
        return hashedPassword.equals(password);
    }
}
