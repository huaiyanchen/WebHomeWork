import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/26-17:40
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    static Scanner scanner = new Scanner(System.in);
    static String userPwd, userName;  //注册密码   注册名称  null
    static int userNumber; //注册卡号  0
    static boolean loginState;  //假设一开始是没有登录状态  false

    /**
     * 导航菜单
     */
    public static void menu() {
        boolean b = true;
        while (b) {
            System.out.println("欢迎进入抽奖系统....");
            System.out.println("1、注册");
            System.out.println("2、登录");
            System.out.println("3、抽奖");
            System.out.println("其他任意数字退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();

            //判断
            switch (choose) {
                case 1:
                    reg();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    chouJiang();
                    break;
                default:
                    System.out.println("谢谢使用！");
                    b = false;
                    break;
            }
        }
    }

    /**
     * 注册
     */
    public static void reg() {
        System.out.println("抽奖系统>>>注册");
        System.out.println("请填写个人信息：");
        userName = scanner.next();
        userPwd = scanner.next();
        //随机生成一个四位数的卡号  1000-9999   0-8999 + 1000  1000 9999
        userNumber = (int) (Math.random() * 9000 + 1000);
        System.out.println("注册成功，请记住你的卡号！");
        System.out.println("用户名\t密码\t用户卡号");
        System.out.println(userName + "\t" + userPwd + "\t" + userNumber);
    }

    /**
     * 登录
     */
    public static void login() {
        System.out.println("抽奖>>>用户登录");
        /*
            验证卡号和密码是否正确？登录之前：判断这个人是否注册？
            没有注册：提醒用户去注册。
            如果已经注册：输入卡号和密码  和 注册的卡号密码比对
         */
        //判断密码有没有值？
        if (userPwd == null) {
            System.out.println("你还没有注册，请先注册！");
            reg();  //直接调用注册的方法
        } else {
            //验证登录
            System.out.println("请输入卡号和密码：");
            int inputNumber = scanner.nextInt();
            String inputPwd = scanner.next();

            //比对
            if (inputNumber == userNumber && inputPwd.equals(userPwd)) {
                System.out.println("登录成功！欢迎您：" + userName);
                loginState = true; //已经登录了
            } else {
                System.out.println("登录失败，账号或密码错误！");
            }
        }
    }

    /**
     * 产生随机数
     *
     * @return
     */
    public static int[] suiJiNumber() {
        int[] resultNum = new int[5];
        for (int i = 0; i < resultNum.length; i++) {
            //产生随机数，填充到数组中
            resultNum[i] = (int) (Math.random() * 9000 + 1000);
        }
        return resultNum;
    }

    /**
     * 抽奖
     */
    public static void chouJiang() {
        System.out.println("抽奖系统>>>抽奖");
        if (!loginState) {
            System.out.println("你还没有登录，请先登录！");
            login();  //直接调用登录的方法
        } else {
            //直接抽奖
            int[] numbers = suiJiNumber();
            System.out.println("本日的幸运数字有：" + Arrays.toString(numbers));
            //比对
            boolean b = false; //假设没有中奖
            for (int number : numbers) {
                if (number == userNumber) {
                    System.out.println("恭喜你，中奖了！");
                    b = true;
                    break;
                }
            }
            //判断是否中奖？
            if (!b) {
                System.out.println("抱歉！你没有中奖！");
            }
        }
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        menu();
    }
}