package app.controllers.security;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import lombok.SneakyThrows;

/**
 * Class that encrypts and decrypts passwords as String using Cipher.
 */
class Hasher {

    /**
     *
     * @return
     */
    @SneakyThrows
    public String generateSalt() {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     *
     * @param salt
     * @return
     */
    @SneakyThrows
    public Cipher generateCipher(String salt) {
        SecretKey key = new SecretKeySpec(salt.getBytes(), "AES");
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
