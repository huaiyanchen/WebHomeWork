package com.chy.exception;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/3-14:44
 * @Since:jdk1.8
 * @Description: 
 */
@SuppressWarnings("all")
public class UserException extends Exception {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);

    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void main(String[] args) {
        int a = 10;
        Integer b = 10;
        Integer c = 10;
        System.out.println(Character.MIN_RADIX);
        System.out.println(Character.MAX_RADIX);
    }


}