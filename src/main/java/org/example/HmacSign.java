package org.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacSign {

    public static void main(String[] args) throws Exception {
        String document ="Bonjours tout le monde";
        String secret = "123456";
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] signature = mac.doFinal(document.getBytes());
        System.out.println("** Signature **");
        System.out.println(Base64.getEncoder().encodeToString(signature));

    }
}