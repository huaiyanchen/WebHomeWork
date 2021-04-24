package com.chy.homeWork.student.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-20:31
 * @Since:jdk1.8
 * @Description: 
 */
public class mD5Util {
    public static String MD5Encode(String text) {
        String code = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(text.getBytes());
            byte[] digest = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, digest);
            code = bigInteger.toString(16);
            for (int i = 0; i < 32 - code.length(); i++) {
                code = "0" + code;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return code;
    }

    public static String MD5Decode(String text) {

        char[] cArray = text.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] >= 48 && cArray[i] <= 57) {
                cArray[i] = (char) (105 - cArray[i]);
            }
        }
        return String.valueOf(cArray);
    }
}