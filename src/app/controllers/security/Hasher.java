package app.controllers.security;

import app.models.annotations.SideTest;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.SneakyThrows;

/**
 * Class that encrypts and decrypts passwords as String using Cipher.
 */
@SideTest(PasswordHandler.class)
class Hasher {

    /**
     * @return A {@code String} of random bytes that's used for hashing user's passwords.
     */
    @SneakyThrows
    public String generateSalt() {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * @param salt A {@code String} of random characters that's used as second key for hashing user's passwords.
     * @return A {@code Cipher} that encrypts user's password using AES.
     */
    @SneakyThrows
    public Cipher generateCipher(String salt) {
        SecretKey key = new SecretKeySpec(Arrays.copyOf(salt.getBytes(), 16), "AES");
        Cipher encryptor = Cipher.getInstance("AES");
        encryptor.init(Cipher.ENCRYPT_MODE, key);

        return encryptor;
    }

    /**
     * Encrypt a given String for a password.
     *
     * @param password A String for the password to be encrypted.
     * @return A String for encrypted password.
     */
    @SneakyThrows
    protected String encrypt(String password, String salt) {
        Cipher encryptor = generateCipher(salt);

        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedBytes = encryptor.doFinal(passwordBytes);
        return java.util.Base64.getEncoder().encodeToString(hashedBytes);
    }
}
