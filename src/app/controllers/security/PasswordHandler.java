package app.controllers.security;

import javax.crypto.spec.SecretKeySpec;
import lombok.val;

import java.security.KeyPair;

/**
 * A final class that consists exclusively of static methods for password handling.
 */
public final class PasswordHandler {

    private static final Hasher hasher;

    static {
        hasher = new Hasher();
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
    public static boolean areEquals(String password, String encryptedPassword, String salt) {
        return PasswordHandler.encrypt(password, salt).equals(encryptedPassword);
    }

    public static String generateSalt() {
        return hasher.generateSalt();
    }

    /**
     * Intermediary method for encrypting a given String for a password.
     *
     * @param password A String for the password to be encrypted.
     * @return A String for encrypted password.
     */
    public static String encrypt(String password, String salt) {
        String firstEncryption = hasher.encrypt(password, salt);
        String secondEncryption = hasher.encrypt(salt, "sYFogZTsRywTQ9aa");
        return hasher.encrypt(firstEncryption, secondEncryption.substring(0, 24));
    }
}
