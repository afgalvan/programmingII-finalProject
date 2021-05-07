package app.controllers.security;

import javax.crypto.spec.SecretKeySpec;
import lombok.val;

/**
 * A final class that consists exclusively of static methods for password handling.
 */
public final class PasswordHandler {

    private static final Hasher hasher;

    static {
        val stringKey = "sYFogZTsRywTQ9aa";
        val key = new SecretKeySpec(stringKey.getBytes(), "AES");
        hasher = new Hasher(key);
    }

    private PasswordHandler() {}

    /**
     * Check if a decrypted password is equal to an encrypted one.
     *
     * @param password A String for a the decrypted password to check.
     * @param encryptedPassword A String of the encrypted password to be compare with.
     *
     * @return If both passwords are equals.
     */
    public static boolean areEquals(String password, String encryptedPassword) {
        return hasher.encrypt(password).equals(encryptedPassword);
    }

    /**
     * Intermediary method for encrypting a given String for a password.
     *
     * @param password A String for the password to be encrypted.
     * @return A String for encrypted password.
     */
    public static String encrypt(String password) {
        return hasher.encrypt(password);
    }
}
