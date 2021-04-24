package com.chy.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/12-17:34
 * @Since:jdk1.8
 * @Description:
 */

public class FileReaderWriter {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("Day16\\resource\\1.txt");
            fileWriter = new FileWriter("1.txt");
            char[] chars = new char[1024];

            int read = fileReader.read(chars);
            System.out.println(read);
            fileWriter.write(chars, 0, read);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}