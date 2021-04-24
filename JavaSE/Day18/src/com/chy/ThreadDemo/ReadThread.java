package com.chy.ThreadDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/14-17:29
 * @Since:jdk1.8
 * @Description: 
 */

public class ReadThread extends Thread {

    private Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println("dataInputStream.readUTF() = " + dataInputStream.readUTF());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}