import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/26-16:47
 * @Since:jdk1.8
 * @Description:LuckyDraw
 */
public class LuckyDraw {

    static boolean loginState = false;
    static Scanner sc = new Scanner(System.in);

    static void prt(String string) {
        System.out.println(string);
    }

    //导航
    public static void menu(String[] registerInfo) {
        boolean b = true;
        while (b) {
            prt("1、登陆");
            prt("2、注册");
            prt("3、抽奖");
            prt("按任一键退出");
            prt("请选择菜单:");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    login(registerInfo);
                    break;
                case "2":
                    register(registerInfo);
                    break;
                case "3":
                    draw(registerInfo);
                    break;
                default:
                    prt("谢谢使用!bye");
                    b = false;
                    break;
            }

        }
    }

    //登陆
    public static void login(String[] registerInfo) {

        if (registerInfo[2] == null) {
            prt("您还没有注册,请先注册");
            register(registerInfo);
        }
        prt("登陆>>>>>");
        prt("请输入卡号:");
        String prtNo = sc.next();
        prt("请输入密码:");
        String prtPwd = sc.next();
        if (registerInfo[1].equals(prtPwd) && registerInfo[2].equals(prtNo)) {
            prt("登陆成功");
            loginState = true;
        } else {
            prt("登陆失败,重新选择");
        }


    }

    //注册
    public static void register(String[] userInfo) {
        prt("注册 >>>>>");
        prt("请填写个人信息（姓名,密码）");
        String userName = sc.next();
        String userPwd = sc.next();
        int userNo = (int) (Math.random() * 8900 + 1000);
        prt("注册成功,请记住会员号");
        prt("用户名\t密码\t会员卡号");
        System.out.println(userName + "\t" + userPwd + "\t" + userNo);
        userInfo[0] = userName;
        userInfo[1] = userPwd;
        userInfo[2] = String.valueOf(userNo);

    }

    /**
     * @Author chy
     * @Date 2021/3/26 19:32
     * @Description 随机数
     * @Since version-1.0
     */
    public static int[] randomNum() {
        int[] resultNum = new int[5];
        for (int i = 0; i < resultNum.length; i++) {
            //产生随机数，填充到数组中
            resultNum[i] = (int) (Math.random() * 9000 + 1000);
        }
        return resultNum;
    }

    //抽奖
    public static void draw(String[] registerInfo) {
        if (loginState) {
            int[] nums = randomNum();
            System.out.println("本期随机数有:" + Arrays.toString(nums));
            boolean b = false; //假设没有中奖
            for (int num : nums) {
                if (num == Integer.parseInt(registerInfo[2])) {
                    prt("恭喜中奖");
                    b = true;
                    break;
                }
            }
            if (!b) {
                prt("没有中奖");
            }
        }
    }

    public static void main(String[] args) {
        String[] registerInfo = new String[3];

        prt("欢迎使用抽奖系统");
        menu(registerInfo);

    }
}