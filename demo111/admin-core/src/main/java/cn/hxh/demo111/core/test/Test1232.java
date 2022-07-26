package cn.hxh.demo111.core.test;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.test.FixedSecureRandom;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.util.Base64;


/**
 * @author: xinhao.hu
 * @date: 2022/3/11 10:33 上午
 * @description:
 **/
public class Test1232 {

    public static void main(String[] args) throws Exception {
        // 注册BouncyCastle:
        Provider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
        MessageDigest md = MessageDigest.getInstance("SM3");
        md.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = kpg.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        Cipher cipher = Cipher.getInstance("RSA",provider);
        // 加密
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] rsaRes = cipher.doFinal("HelloWorld".getBytes("UTF-8"));
        System.out.println(new BigInteger(1, rsaRes).toString(16));
        // 解密
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte [] b = cipher.doFinal(rsaRes);
        System.out.println(new String(b));

        String str = "QvfqCU5sek8B1KH+TdqCCD/9/pXJHxG+IeP1hGgdBzy7a2RwYXNzd29yZA";
        System.out.println(str.length());

    }
}
