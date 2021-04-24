package com.chy.test;

import com.chy.bean.User;

import java.util.Base64;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-16:38
 * @Since:jdk1.8
 * @Description: 
 */
public class UserTest {
    private User user = new User();
    public static Scanner scanner = new Scanner(System.in);

    public void reg() {
        System.out.println("用户注册>>>>>>>>");
        System.out.println("请输入用户信息：");
        String inputName = scanner.next();
        String inputPwd = scanner.next();

        //密码进行加密操作
        Base64.Encoder encoder = Base64.getEncoder();//获取加密器
        String encodePwd = encoder.encodeToString(inputPwd.getBytes());
        //存入到对象
        user.setName(inputName);
        user.setPwd(encodePwd);

        login();
    }

    public void login() {
        System.out.println("用户登录>>>>>>>>");
        //先判断是否注册？
        if (user != null && user.getName() != null) {
            System.out.println("请输入登录的信息：");
            String inputName = scanner.next();
            String inputPwd = scanner.next();
            //解密    账号里面加密的密码
            Base64.Decoder decode = Base64.getDecoder();
            byte[] decodePwd = decode.decode(user.getPwd());
            String decoderPwds = new String(decodePwd);
            //比较
            if (inputName.equals(user.getName()) && inputPwd.equals(decoderPwds)) {
                System.out.println("登录成功！");
            } else {
                System.out.println("登录失败！");
            }
        } else {
            System.out.println("请先注册！");
            reg();
        }
    }
    public static void main(String[] args) {
        new UserTest().login();

    }
}