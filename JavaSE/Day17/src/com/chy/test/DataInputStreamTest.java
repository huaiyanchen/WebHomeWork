package com.chy.test;

import java.io.*;
import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-10:04
 * @Since:jdk1.8
 * @Description: 
 */

public class DataInputStreamTest {


    public static void main(String[] args) {
        File file = new File("1.txt");
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file, true));
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        ) {

            dataOutputStream.writeInt(new Random().nextInt(100));
            dataOutputStream.writeUTF("test dataOutPutStream" + new Random().nextInt(100));
            dataOutputStream.writeByte(new Random().nextInt(100));
            while (true) {
                System.out.println("=========================================================");
                System.out.println("dataInputStream.readInt() = " + dataInputStream.readInt());
                System.out.println("dataInputStream.readUTF() = " + dataInputStream.readUTF());
                System.out.println("dataInputStream.readByte() = " + dataInputStream.readByte());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "????");
        }
    }
}