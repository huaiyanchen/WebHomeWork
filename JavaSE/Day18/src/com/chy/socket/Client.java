package com.chy.socket;

import com.chy.ThreadDemo.ReadThread;
import com.chy.ThreadDemo.WriteThread;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-17:14
 * @Since:jdk1.8
 * @Description:
 */

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localHost", 1234);
            new ReadThread(socket).start();
            new WriteThread(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}