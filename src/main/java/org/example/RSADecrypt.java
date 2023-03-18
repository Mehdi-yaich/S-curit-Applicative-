package org.example;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSADecrypt {
    public static void main(String[] args) throws Exception {
        String encodedCryptedMsg = "Zx3BuIXB0Lc3ffYZangAF00MazRtxgTreS4ZcdG/vDoKDZOUrI9/Tt1NKZ82QMeuUySEKn512T41HLNBTTzdxQ==";
        byte[] decodedeMSG = Base64.getDecoder().decode(encodedCryptedMsg);
        String encodedPrivateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAhYaQpFdXS9hK7bTCsM1jaBeoIIm95inHTnx9fuU/a8afOMX3mSOpm7G3a57HoMcnzx9lZ19nqM4CeJa54kFnGwIDAQABAkAejU1ARTnUwV9Xp5IaqUwzD6KpG0tHxEx10XdXlzXdP2cTOqA91FQDdps0TZkbsq+Mozk9n7uv69DbLKVVJdc5AiEAsOESKOjfGyLLafRIfS3j/wwJweM0VxyxtaHLR5DrzgkCIQDBQPWV4gfnNNl0Bjs3as6vmRmv0+B5AccdoI6/aK1VAwIgZxUkcjcVH0lt5vf47ws5nsAzR43USRht8P6z66dn5ZECIQC2067DApi5en0yz+Zb0jcBV1U+y7L0p+LpO4lwuiYpYwIgCsba0CpWiiA3iXTEvHVAF8DJ/6mlvWdzReVV9FbtEh0=";
        byte[] decodedPrivateKey = Base64.getDecoder().decode(encodedPrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodedPrivateKey));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMSG = cipher.doFinal(decodedeMSG);
        System.out.println(new String(decryptedMSG));

    }
}