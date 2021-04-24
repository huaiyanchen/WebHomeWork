package com.chy.socket;

import com.chy.ThreadDemo.ReadThread;
import com.chy.ThreadDemo.WriteThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-17:14
 * @Since:jdk1.8
 * @Description:
 */

public class Service {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket accept = serverSocket.accept();

            new ReadThread(accept).start();
            new WriteThread(accept).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}