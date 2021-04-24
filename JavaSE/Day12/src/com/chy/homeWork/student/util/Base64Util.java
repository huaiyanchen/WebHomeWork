package com.chy.homeWork.student.util;

import java.util.Base64;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-20:31
 * @Since:jdk1.8
 * @Description: 
 */
public class Base64Util {
    public static String  Base64Encode(String text) {
        Base64.Encoder encode = Base64.getEncoder();
        return encode.encodeToString(text.getBytes());
    }

    public static String Base64Decode(String text) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(text);
        return new String(decode);
    }

}