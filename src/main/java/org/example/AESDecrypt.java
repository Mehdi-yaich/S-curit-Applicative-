package org.example;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecrypt {
    public static void main(String[] args) throws Exception {
        String encodedEncryptedMsg = "Z9jht/SXwvB001AePXGtazvGmTq++iBxtelrw0S5W3s=";
        byte[] decodedEncryptedMsg = Base64.getDecoder().decode(encodedEncryptedMsg);
        String secret = "abcd_abcd_abcd_a";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), 0, secret.length(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedMsg = cipher.doFinal(decodedEncryptedMsg);
        System.out.println(new String(decryptedMsg));

    }
}