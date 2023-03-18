package org.example;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSACrypt {
    public static void main(String[] args) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        String encodePK = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIWGkKRXV0vYSu20wrDNY2gXqCCJveYpx058fX7lP2vGnzjF95kjqZuxt2uex6DHJ88fZWdfZ6jOAniWueJBZxsCAwEAAQ==";
        byte[] decodedPK = Base64.getDecoder().decode(encodePK);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodedPK));
        String message = "Le message en clair";
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        String encodedMSG = Base64.getEncoder().encodeToString(encryptedMessage);
        System.out.println(encodedMSG);

    }
}