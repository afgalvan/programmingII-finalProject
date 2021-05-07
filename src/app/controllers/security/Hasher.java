package app.controllers.security;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import lombok.SneakyThrows;

class Hasher {

    private final Cipher eCipher;
    private final Cipher deCipher;

    /**
     * Class that encrypts and decrypts passwords as String using Cipher.
     *
     * @param key SecretKey for hashing in the encrypting process
     */
    @SneakyThrows
    protected Hasher(SecretKey key) {
        this.eCipher = Cipher.getInstance("AES");
        this.deCipher = Cipher.getInstance("AES");
        this.eCipher.init(Cipher.ENCRYPT_MODE, key);
        this.deCipher.init(Cipher.DECRYPT_MODE, key);
    }

    /**
     * Encrypt a given String for a password.
     *
     * @param password A String for the password to be encrypted.
     * @return A String for encrypted password.
     */
    @SneakyThrows
    protected String encrypt(String password) {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedBytes = this.eCipher.doFinal(passwordBytes);
        return java.util.Base64.getEncoder().encodeToString(hashedBytes);
    }

    /**
     * Decrypt a given String for an encrypted password.
     *
     * @param password A encrypted password to be decrypted.
     * @return A string with the decrypted equivalent.
     */
    @SneakyThrows
    protected String decrypt(String password) {
        byte[] passwordDecoded = java.util.Base64.getDecoder().decode(password);
        byte[] passwordUTF8 = this.deCipher.doFinal(passwordDecoded);
        return new String(passwordUTF8, StandardCharsets.UTF_8);
    }
}
