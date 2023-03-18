package org.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacVerify {
    public static void main(String[] args) throws Exception {
        String receivedDoc ="Bonjour tout le monde"+"-__-"+"W7hjGaSQ7OSn4VigpURDWbq5Enmfgex4MGYV16FqfXc=";
        String[] splitedDoc = receivedDoc.split("-__-");
        String receivedSignature=splitedDoc[1];
        String document=splitedDoc[0];
        String secret1="123456";
        SecretKeySpec secretKeySpec1=new SecretKeySpec(secret1.getBytes(), "HmacSHA256");;
        Mac mac1=Mac.getInstance("HmacSHA256");
        mac1.init(secretKeySpec1);
        byte[] signature1 = mac1.doFinal(document.getBytes());
        String calculatedSignature = Base64.getEncoder().encodeToString(signature1);
        System.out.println(receivedSignature.equals(calculatedSignature)?"Signature OK":"Signature non OK");

    }
}
