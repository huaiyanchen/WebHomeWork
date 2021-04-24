import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/23-18:57
 * @Since:jdk1.8
 * @Description:homework
 */
public class HomeWork {
    //录入会员信息
    public static void Num1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入4位整数会员号:");
        int idNum = 0;
        do {
            idNum = sc.nextInt();
            if (idNum > 9999 || idNum < 1000) {
                System.out.println("录入失败,重新输入正确的会员号:");
            }
        } while (idNum > 9999 || idNum < 1000);

        System.out.println("请输入生日:");
        String birthDay = sc.next();
        System.out.println("请输入积分:");
        int integral = sc.nextInt();
        System.out.println("会员号:" + idNum + "\n会员生日:" + birthDay + "\n会员积分" + integral);

        //2
        int random = (int) Math.random() * 10;
        //百位
        int hud = idNum / 100 % 10;
        if (random == hud) {
            System.out.println("恭喜你是幸运会员");
        } else {
            System.out.println("谢谢惠顾");
        }

        //3
        if (integral < 2000) {
            System.out.println("九折");
        }
        if (integral < 4000 && integral >= 2000) {
            System.out.println("八折");
        }
        if (integral < 8000 && integral >= 4000) {
            System.out.println("七折");
        }
        if (integral >= 8000) {
            System.out.println("六折");
        }
    }

    //抽奖
    public static void Num2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入4位数字会员号:");
        int idNum = sc.nextInt();
        int random = (int) Math.random() * 10;
        //百位
        int hud = idNum / 100 % 10;
        if (random == hud) {
            System.out.println("恭喜你是幸运会员");
        } else {
            System.out.println("谢谢惠顾");
        }
    }

    //会员根据积分享受不同折扣
    public static void Num3() {
        int integral = 2121;
        if (integral < 2000) {
            System.out.println("九折");
        }
        if (integral < 4000 && integral >= 2000) {
            System.out.println("八折");
        }
        if (integral < 8000 && integral >= 4000) {
            System.out.println("七折");
        }
        if (integral >= 8000) {
            System.out.println("六折");
        }
    }

    //小林子买了一筐鸡蛋，如果坏蛋少于5个，他就吃掉，否则他就去退货
    public static void Num4() {
        int brokenEggs = 3;
        if (brokenEggs < 5 && brokenEggs >= 0) {
            System.out.println("吃掉");
        } else {
            System.out.println("退货");
        }
    }

    //判断今天是星期几？然后根本星期几，吃什么
    public static void Num5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入今天是星期几:");
        int week = sc.nextInt();
        if (week > 0 && week <= 7) {
            switch (week) {
                case 1:
                    System.out.println("今天是周一，我们吃西红柿炒番茄");
                    break;
                case 2:
                    System.out.println("今天是周二，我们吃马铃薯炖土豆");
                    break;
                case 3:
                    System.out.println("今天是周三，我们吃大米蒸小米");
                    break;
                case 4:
                    System.out.println("今天是周四，我们吃老母鸡炖小母鸡");
                    break;
                case 5:
                    System.out.println("今天是周五，我们吃杏孢菇拌金针菇");
                    break;
                case 6:
                case 7:
                    System.out.println("今天是周天，食堂不开饭饿着！");
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("输入的日期不合格");
        }
    }

    //输入一个年份，判断是不是闰年
    public static void Num6() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份:");
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("普通闰年");
        }
        if (year % 400 == 0) {
            System.out.println("世纪闰年");
        } else {
            System.out.println("普通年份");
        }
    }

    //计算车费问题
    public static void Num7() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择车型1:顺风车,2:滴滴快车,3:特惠转车");
        int type = sc.nextInt();
        System.out.println("请输入公里数:");
        double km = sc.nextDouble();
        //判断小数点后面的值是大于0还是等于0的
        double judge = 0.0;
        if (km - (int) km > 0) {
            judge = 1;
        } else if (km - (int) km == 0) {
            judge = 0;
        }
        int price = 0;
        switch (type) {
            case 1:
                if (km < 3) {
                    price = 5;
                } else {
                    if (judge == 1) {
                        price = 5 + (int) (km - 3 + 1) * 3;
                    }
                    if (judge == 0) {
                        price = 5 + (int) (km - 3) * 3;
                    }

                }
            case 2:
                if (km < 3) {
                    price = 6;
                } else {
                    if (judge == 1) {
                        price = 6 + (int) (km - 3 + 1) * 4;
                    }
                    if (judge == 0) {
                        price = 6 + (int) (km - 3) * 4;
                    }

                }
            case 3:
                if (km < 3) {
                    price = 7;
                } else {
                    if (judge == 1) {
                        price = 7 + (int) (km - 3 + 1) * 5;
                    }
                    if (judge == 0) {
                        price = 7 + (int) (km - 3) * 5;
                    }

                }
        }

        System.out.println(price);
    }

    //已知2019年1月1日是星期二，从键盘输入2019年的任意一天，请判断它是星期几
    public static void Num8() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年月日以-分割如(2019-1-1)");
        String data = sc.nextLine();
        String[] split = data.split("-");
        if (split[0].equals("2019")) {
            //month
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);
            int week = 0;
            switch (month) {
                case 1:
                    if (day >= 1 && day <= 31) {
                        //
                        week = day % 7 + 1;

                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 2:
                    if (day >= 1 && day <= 28) {
                        //+31
                        week = (day + 31) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 3:
                    if (day >= 1 && day <= 31) {
                        //+31+28 = 59
                        week = (day + 59) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 4:
                    if (day >= 1 && day <= 30) {
                        //+31+28+31 = 90
                        week = (day + 90) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 5:
                    if (day >= 1 && day <= 31) {
                        //+31+28+31+30 = 120
                        week = (day + 120) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 6:
                    if (day >= 1 && day <= 30) {
                        //+31+28+31+30+31 = 151
                        week = (day + 151) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 7:
                    if (day >= 1 && day <= 31) {
                        //+31+28+31+30+31+30 = 181
                        week = (day + 181) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 8:
                    if (day >= 1 && day <= 31) {
                        //+31+28+31+30+31+30+31 = 212
                        week = (day + 212) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 9:
                    if (day >= 1 && day <= 30) {
                        //+31+28+31+30+31+30+31+31 = 243
                        week = (day + 243) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 10:
                    if (day >= 1 && day <= 31) {
                        //+31+28+31+30+31+30+31+31+30 = 273
                        week = (day + 273) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 11:
                    if (day >= 1 && day <= 30) {
                        //+31+28+31+30+31+30+31+31+30+31 = 304
                        week = (day + 304) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                case 12:
                    if (day >= 1 && day <= 31) {
                        //+31+28+31+30+31+30+31+31+30+31+30 = 334
                        week = (day + 334) % 7 + 1;
                    } else {
                        System.out.println("日期输入错误");
                    }
                    break;
                default:
                    System.out.println("月份输入错误");
                    break;
            }

            switch (week) {
                case 1:
                    System.out.println("周一");
                    break;
                case 2:
                    System.out.println("周二");
                    break;
                case 3:
                    System.out.println("周三");
                    break;
                case 4:
                    System.out.println("周四");
                    break;
                case 5:
                    System.out.println("周五");
                    break;
                case 6:
                    System.out.println("周六");
                    break;
                case 7:
                    System.out.println("周日");
                    break;

            }
        } else {
            System.out.println("请输入2019年");
        }


    }

    //求1到100之间所有能被3整除的整数的和以及个数
    public static void Num9() {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                sum += i;
                count++;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
    }

    //循环录入Java考试的成绩，求出分数大于80以及小于60分所占的比例为多少
    public static void Num10() {
        int talen = 0;
        int bad = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生数:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入java成绩:");
            int sccore = sc.nextInt();
            if (sccore > 80 && sccore <= 100) {

                talen++;
            }
            if (sccore < 60 && sccore >= 0) {
                bad++;
            }
            count++;
        }
        System.out.println("分数大于80所占的比例为:" + (float) talen / count * 100 + "%");
        System.out.println("分数小于60所占的比例为:" + (float) bad / count * 100 + "%");

    }

    //猴子吃桃子  peach/2 -1
    public static void Num11() {
        int lastPeach = 1;
        for (int i = 0; i < 9; i++) {
            lastPeach = (lastPeach + 1) * 2;
        }
        System.out.println(lastPeach);
    }

    //猜拳
    public static void Num12() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("请输入0~2之间的数字:");
            int i = sc.nextInt();
            switch (i) {
                case 0:
                    System.out.println("你出的是石头");
                    break;
                case 1:
                    System.out.println("你出的是剪刀");
                    break;
                case 2:
                    System.out.println("你出的是布");
                    break;
                default:
                    System.out.println("请输入0~2之间的数字!");
                    break;
            }
            System.out.println("是否要继续?");
            String next = sc.next();
            if (!next.equals("y")) {
                break;
            }
        } while (true);
    }

    //让计算机随机产生10个0到2之间的数
    public static void Num13() {
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 3);
            switch (random) {
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                case 2:
                    System.out.println("生成了一只红猪，有下酒菜了");
                    break;
                default:
                    break;
            }
        }
    }

    //循环输出以下结果
    public static void Num14() {
        int x = 2;
        int y = 5;

        while (y < 101) {
            System.out.println(x + "*" + y + "==" + x * y);
            x += 2;
            y += 5;
        }
    }

    //完成猜数字游戏
    public static void Num15() {
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        int count = 0;
        int random = 0;
        do {
            System.out.println("请输入0~100的数字:");
            guess = sc.nextInt();
            random = (int) (Math.random() * 100);
            if (guess != random) {
                System.out.println("猜错了!!!");
            }
            count++;
        } while (guess != random);
        if (count == 1) {
            System.out.println("你真是太聪明了，一次就猜对了！");
        } else if (count > 1 && count < 3) {
            System.out.println("你还是比较聪明的哦");
        } else if (count > 6) {
            System.out.println("：你真是太笨了！");
        }
    }

    //简单的ATM机的取款过程
    public static void Num16() {
        int count = 0;
        int target = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("请输入密码:");
            int pwd = sc.nextInt();
            if (pwd != 111111) {
                System.out.println("密码错误");
                count++;
            } else {//密码正确
                int amount = 0;
                do {
                    System.out.println("请输入取款金额:");
                    amount = sc.nextInt();
                    if (amount % 100 != 0) {
                        System.out.println("金额面额不对");
                    }
                    if (amount > 1000) {
                        System.out.println("超出最大面额！");
                    }
                } while (amount % 100 != 0 || amount > 1000);
                System.out.println("取出金额为:" + amount + "交易完成，请取卡");
                target = 1;
            }
            if (count == 3) {
                System.out.println("密码错误，请取卡");
                break;
            }
        } while (target == 0);
    }

    public static void main(String[] args) {
//       Num1();
//        Num2();
//        Num3();
//        Num4();
//        Num5();
//        Num6();
//        Num7();
        Num8();
//        Num9();
//        Num10();
//        Num11();
//        Num12();
//        Num13();
//        Num14();
//        Num15();
//        Num16();
    }
}


