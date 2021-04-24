package com.homeWork.test;

import com.homeWork.bean.CardRecord;
import com.homeWork.bean.Dept;
import com.homeWork.bean.EmpInfo;
import com.homeWork.bean.vo.CardRecordVO;
import com.homeWork.dao.CardRecordDao;
import com.homeWork.dao.DeptDao;
import com.homeWork.dao.EmpInfoDao;
import com.homeWork.dao.impl.CardRecordDaoImpl;
import com.homeWork.dao.impl.DeptDaoImpl;
import com.homeWork.dao.impl.EmpInfoDaoImpl;
import com.homeWork.utils.ChineseCharacterUtil;
import com.homeWork.utils.DateUtils;
import com.homeWork.utils.PageInfo;
import com.homeWork.utils.PageInfoUtils;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/20-19:34
 * @Since:jdk1.8
 * @Description:
 */
@SuppressWarnings("all")
public class Test {
    private Scanner sc = new Scanner(System.in);
    private DeptDao deptDao = new DeptDaoImpl();
    private CardRecordDao cardRecordDao = new CardRecordDaoImpl();
    private EmpInfoDao empInfoDao = new EmpInfoDaoImpl();

    // menu
    public void menu() {

        boolean b = true;
        while (b) {
            System.out.println("欢迎使用XX公司打卡系统");
            System.out.println("1.登陆");
            System.out.println("2.注册");
            System.out.println("0.退出");
            switch (sc.next()) {
                case "1":
                    login();
                    break;
                case "2":
                    registry();
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    System.out.println("非法输入");
                    break;
            }
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/20 20:28
     * @Description: 登陆调用
     */
    private void login() {
        System.out.println("登陆");
        System.out.println("请输入账号:");
        String account = sc.next();
        System.out.println("请输入密码:");
        String pwd = sc.next();
        List<EmpInfo> allEmp = empInfoDao.getAllEmp();
        //判断接收登陆成功的用户
        EmpInfo empInfo = new EmpInfo();
        boolean b = true;
        for (EmpInfo info : allEmp) {
            if (info.getAccount().equals(account) && info.getPwd().equals(pwd)) {
                empInfo = info;
                b = false;
            }
        }
        if (!b) {
            System.out.println("登陆成功");
            loginSucMenu(empInfo);

        } else {
            System.out.println("登录失败，账号或密码错误");
            menu();
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/20 20:29
     * @Description: 登陆成功后的操作菜单
     */
    private void loginSucMenu(EmpInfo empInfo) {
        boolean b = true;
        while (b) {
            System.out.println("1.上班打卡");
            System.out.println("2.修改自己的个人信息 ");
            System.out.println("3.显示自己的打卡记录(分页) ");
            System.out.println("0.返回主菜单");
            switch (sc.next()) {
                case "1":
                    punchCard(empInfo);
                    break;
                case "2":
                    updateInfo(empInfo);
                    break;
                case "3":
                    showCardRecode(empInfo);
                    break;
                case "0":
                    b = false;
                    break;
                default:
                    System.out.println("非法输入");
                    break;
            }
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/20 20:37
     * @Description: 上班打卡
     */
    private void punchCard(EmpInfo empInfo) {
        CardRecord cardRecord = new CardRecord();
        System.out.println("正在打卡...");
        Integer empId = empInfo.getId();
        Date cardTime = DateUtils.getNow();
        boolean bigByEight = DateUtils.isBigByEight(cardTime);
        int i = 0;
        if (bigByEight) {
            System.out.println(empInfo.getName() + "在" + DateUtils.dataFormate(cardTime) + "打卡 迟到");
        } else {
            i = 1;
            System.out.println(empInfo.getName() + "在" + DateUtils.dataFormate(cardTime) + "打卡 正常");
        }
        cardRecord.setEmpId(empId);
        cardRecord.setCardTime(cardTime);
        cardRecord.setIsNormal(i);
        if (cardRecordDao.addCardRecord(cardRecord)) {
            System.out.println("打卡记录插入成功");
        } else {
            System.out.println("打卡记录插入失败");
        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/20 21:20
     * @Description: 修改自己的个人信息
     */
    private void updateInfo(EmpInfo empInfo) {
        System.out.println(empInfo);
        System.out.println("修改密码:");
        empInfo.setPwd(sc.next());
        System.out.println("修改部门:");
        System.out.println("请选择部门");
        List<Dept> allDept = deptDao.getAllDept();
        allDept.forEach(c -> System.out.print(c.getDeptId() + " " + c.getDeptName()));
        System.out.println("");
        empInfo.setDeptId(sc.nextInt());
        System.out.println("修改姓名:");
        empInfo.setName(sc.next());
        System.out.println("修改性别:");
        empInfo.setSex(sc.next());
        if (empInfoDao.updateEmp(empInfo)) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

    }

    /**
     * @author: chy
     * @Date: 2021/4/20 21:35
     * @Description: 显示自己的打卡记录
     */
    private void showCardRecode(EmpInfo empInfo) {
        PageInfo pageInfo = new PageInfo();
        //设置总数
        pageInfo.setAllCount(cardRecordDao.getCount());
        int i = 0;
        while (true){
            if (i == -1) {
                break;

            }
            System.out.println("--------第" + (i + 1) + "页----------");
            pageInfo.setPage(i);
            List<CardRecordVO> recordByEmpId = cardRecordDao.getRecordByEmpIdAndPage(empInfo.getId(), pageInfo);
            System.out.println("编号\t姓名\t性别\t入职时间\t\t   \t打卡时间\t\t\t  \t\t  是否正常打卡");
            for (CardRecordVO cardRecordVO : recordByEmpId) {
                String mes = "";
                if (cardRecordVO.getIsNormal() == 1) {
                    mes = "正常打卡";
                } else {
                    mes = "迟到打卡";
                }
                System.out.println(cardRecordVO.getId() + "\t" +
                        cardRecordVO.getName() + "\t" +
                        cardRecordVO.getSex() + "\t" +
                        cardRecordVO.getEntryTime() + "\t" +
                        cardRecordVO.getCardTime() + "\t" + mes);
            }
            i =  PageInfoUtils.pageForNextPage(i, pageInfo);

        }
    }

    /**
     * @author: chy
     * @Date: 2021/4/20 19:38
     * @Description: 注册调用
     */
    private void registry() {
        System.out.println("注册");
        //员工
        EmpInfo emp = new EmpInfo();
        System.out.println("请输入姓名:");
        String name = sc.next();
        emp.setName(name);
        System.out.println("请输入密码:");
        String pwd = sc.next();
        emp.setPwd(pwd);
        System.out.println("请输入性别");
        emp.setSex(sc.next());
        System.out.println("请选择部门");
        List<Dept> allDept = deptDao.getAllDept();
        allDept.forEach(c -> System.out.print("\t" + c.getDeptId() + " " + c.getDeptName()));
        System.out.println();
        int chooseDept = sc.nextInt();
        int deptId = 0;
        for (Dept dept : allDept) {
            if (dept.getDeptId().equals(chooseDept)) {
                deptId = dept.getDeptId();
            }
        }
        emp.setDeptId(deptId);
        emp.setEntryTime(DateUtils.getNow());
        //注册账号的生成 汉转拼音
        String account = ChineseCharacterUtil.convertHanzi2Pinyin(name, false).toLowerCase(Locale.ROOT);
        emp.setAccount(account);
        if (empInfoDao.regEmp(emp)) {
            System.out.println("注册成功,请记住你的账号密码!!!!!!!!!!");
            System.out.println("你的账号:" + account);
            System.out.println("你的密码:" + pwd);
        } else {
            System.out.println("注册失败");
        }
    }
}