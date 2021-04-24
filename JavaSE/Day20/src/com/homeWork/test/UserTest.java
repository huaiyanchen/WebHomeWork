package com.homeWork.test;

import com.homeWork.bean.UserInfo;
import com.homeWork.dao.UserDao;
import com.homeWork.dao.impl.UserDaoImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/19-17:55
 * @Since:jdk1.8
 * @Description:
 */

public class UserTest {

    private Scanner scanner = new Scanner(System.in);
    private UserDao userDao = new UserDaoImpl();

    //菜单
    public void menu() {
        System.out.println("用户管理系统");
        boolean b = true;
        while (b) {
            System.out.println("请输入选择:");
            System.out.println("1,添加 2,修改  3,删除 4,查询所有, 5,根据手机号和身份证查询 6.退出");
            String choose = scanner.next();
            switch (choose) {
                case "1":
                    add();
                    break;
                case "2":
                    updateById();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    query();
                    break;
                case "5":
                    queryByIdAndTel();
                    break;
                case "6":
                    b = false;
                    System.out.println("正在退出ing......");
                    break;
                default:
                    System.out.println("输入错误,重新选择 ");
                    break;
            }
        }
    }

    //add
    private void add() {
        UserInfo userInfo = new UserInfo();
        System.out.println("请输入员工姓名");
        userInfo.setName(scanner.next());
        System.out.println("请输入员工年龄");
        userInfo.setAge(scanner.nextInt());
        userInfo.setLoginTime(new Date());
        List<String> allIdNumber = userDao.getAllIdNumber();
        String idNumber;
        //身份证号 查重
        while (true) {
            boolean b = true;
            System.out.println("请输入员工的身份证号码");
            idNumber = scanner.next();
            for (String s : allIdNumber) {
                if (idNumber.equals(s)) {
                    System.out.println("身份证号和已有员工的身份证号重复,请重新输入!");
                    b = false;
                }
            }
            if (b) {
                break;
            }
        }
        userInfo.setIdCardNumber(idNumber);
        System.out.println("请输入联系方式");
        userInfo.setTel(scanner.next());
        System.out.println("请输入家庭住址");
        userInfo.setAddress(scanner.next());

        boolean adds = userDao.add(userInfo);
        if (adds) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败");
        }
    }

    //删除
    private void delete() {
        System.out.println("请输入删除的Id");
        boolean b = userDao.deleteById(scanner.nextInt());
        if (b) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }

    //查询所有
    private void query() {
        List<UserInfo> allStu = userDao.findAllUsr();
        System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
        allStu.forEach(this::show);


    }

    // 根据身份证号 和 电话号码查询
    private void queryByNum() {
        System.out.println("请选择查询方式: 1,身份证号 2.电话号码 3.身份证号和电话号码");
        switch (scanner.next()) {
            case "1":
                System.out.println("请输入身份证号");
                String IdNum = scanner.next();
                List<UserInfo> byTelOrIdNum = userDao.findByIdNum(IdNum);
                System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
                byTelOrIdNum.forEach(this::show);
                break;
            case "2":
                System.out.println("请输入者电话号码");
                String TelNum = scanner.next();
                List<UserInfo> byTelOrIdTelNum = userDao.findByTel(TelNum);
                System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
                byTelOrIdTelNum.forEach(this::show);
                break;
            case "3":
                System.out.println("请输入电话号码");
                String TelNumber = scanner.next();
                System.out.println("请输入身份证号");
                String IdNumber = scanner.next();
                List<UserInfo> byTelOrIdTel = userDao.findByTelOrIdNum(IdNumber, TelNumber);
                System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
                byTelOrIdTel.forEach(this::show);
                break;
            default:
                System.out.println("不合法的输入");
                break;
        }
        menu();
    }

    // 根据身份证号 和 电话号码查询
    private void queryByIdAndTel() {
        System.out.println("请输入电话号码");
        String telNumber = scanner.nextLine();
        System.out.println("请输入身份证号");
        String idNumber = scanner.nextLine();
        List<UserInfo> userInfos = userDao.queryByIdAndTel(idNumber, telNumber);
        System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
        userInfos.forEach(this::show);
    }


    //根据序号修改
    private void updateById() {
        System.out.println("请输入id");
        int id = scanner.nextInt();

        //获取 id下的信息
        UserInfo userInfoById = userDao.getById(id);
        //获取自己的身份证号 查重排除使用
        String idCardNum = userInfoById.getIdCardNumber();
        System.out.println("序号\t姓名\t年龄\t身份证号\t联系方式\t家庭住址\t注册时间");
        show(userInfoById); //显示

        //收集修改的信息
        UserInfo userInfo = new UserInfo();
        System.out.println("请输入修改后的姓名");
        userInfo.setName(scanner.next());
        System.out.println("请输入员工年龄");
        userInfo.setAge(scanner.nextInt());

        List<String> allIdNumber = userDao.getAllIdNumber();
        //排除自己的身份证号
        allIdNumber.remove(idCardNum);

        String idNumber;
        //身份证号 查重 排除其他
        while (true) {
            boolean b = true;
            System.out.println("请输入员工的身份证号码");
            idNumber = scanner.next();
            for (String s : allIdNumber) {
                if (idNumber.equals(s)) {
                    System.out.println("身份证号和已有员工的身份证号重复,请重新输入!");
                    b = false;
                }
            }
            if (b) {
                break;
            }
        }
        userInfo.setIdCardNumber(idNumber);
        System.out.println("请输入联系方式");
        userInfo.setTel(scanner.next());
        System.out.println("请输入家庭住址");
        userInfo.setAddress(scanner.next());
        userInfo.setId(id);
        //修改方法
        boolean b = userDao.updateById(userInfo, id);
        if (b) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     *  @author: chy
     *  @Date: 2021/4/19 20:05
     *  @Description:  显示
     */
    private void show(UserInfo user) {
      System.out.println(user.getId() + "\t" +
                user.getName() + "\t" +
                user.getAge() + "\t" +
                user.getIdCardNumber() + "\t" +
                user.getTel() + "\t" +
                user.getAddress() + "\t" +
                user.getLoginTime());
    }

}