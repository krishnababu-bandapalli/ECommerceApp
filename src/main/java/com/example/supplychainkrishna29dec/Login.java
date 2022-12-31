package com.example.supplychainkrishna29dec;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Objects;

public class Login {
    public static byte[] getSHA(String input) {
        try {
            MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getEncryptedPassword(String password) {
        try {
            BigInteger number = new BigInteger(1, Objects.requireNonNull(getSHA(password)));
            return number.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Login login = new Login();
//        System.out.println(login.getEncryptedPassword("abc123"));
//    }
}
