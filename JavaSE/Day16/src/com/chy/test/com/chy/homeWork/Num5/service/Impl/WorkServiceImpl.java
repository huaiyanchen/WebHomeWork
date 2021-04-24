package com.chy.test.com.chy.homeWork.Num5.service.Impl;

import com.chy.test.com.chy.homeWork.Num5.bean.User;
import com.chy.test.com.chy.homeWork.Num5.service.WorkService;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/13-14:30
 * @Since:jdk1.8
 * @Description:
 */

public class WorkServiceImpl implements WorkService {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addUser(List<User> userList) {
        User user = new User();
        System.out.println("请输入学号:");
        int id = scanner.nextInt();
        System.out.println("请输入姓名:");
        String name = scanner.next();
        System.out.println("请输入年龄:");
        int age = scanner.nextInt();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        userList.add(user);
        writeList(userList);
    }


    @Override
    public void deleteById(Integer id, List<User> userList) {
        int removeId = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (id.equals(userList.get(i).getId())) {
                removeId = i;
            }
        }
        if (removeId == -1) {
            System.out.println("移除失败 ");
        } else {
            userList.remove(removeId);
        }
        writeList(userList);
    }

    @Override
    public void updateUser(List<User> userList) {

    }

    @Override
    public void findAllUser(List<User> userList) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("2.txt"))) {
            User user = null;
            while ((user = (User) objectInputStream.readObject()) != null) {
                System.out.println(user);
            }
        } catch (EOFException e) {
            System.out.println("读取完毕！"+e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }


    /**
     * @author: chy
     * @Date: 2021/4/13 15:18
     * @Description: 根据列表直接写入 抽取方法
     */
    private void writeList(List<User> userList) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("2.txt"))) {
            for (User user : userList) {
                objectOutputStream.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}