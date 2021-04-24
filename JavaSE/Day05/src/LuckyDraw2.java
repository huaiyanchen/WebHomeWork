import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/26-19:31
 * @Since:jdk1.8
 * @Description:LuckyDraw2
 */
public class LuckyDraw2 {
    static boolean loginState = false;
    static int loginCur = 0;
    static Scanner sc = new Scanner(System.in);

    static void prt(String string) {
        System.out.println(string);
    }

    /**
     * @Author chy
     * @Date 2021/3/26 21:09
     * @Description login
     * @Since version-1.0
     */
    public static void login(PersonInfo personInfo) {
        if (personInfo.accountNumbers.length == 0) {
            prt("还没有注册,请去注册");
            register(personInfo);

        }
        prt("请输入登陆账号:");
        String loginAccount = sc.next();
        prt("请输入登陆密码:");
        String loginPwd = sc.next();
        boolean b = false;
        for (int i = 0; i < personInfo.accountNumbers.length; i++) {
            if (loginAccount.equals(personInfo.accountNumbers[i])
                    && loginPwd.equals(personInfo.pwds[i])) {
                prt("登陆成功");
                loginState = true;
                b = true;
                loginCur = i;
                break;
            }
        }
        if (!b) {
            prt("登录失败!!!!!!");
        }
    }

    /**
     * @Author chy
     * @Date 2021/3/26 21:09
     * @Description 注册
     * @Since version-1.0
     */
    public static void register(PersonInfo personInfo) {
        String accountNumberPrt = null;
        String pwdPrt = null;
        String cardNumber = String.valueOf((int) (Math.random() * 9000 + 1000));
        prt("注册>>>>>>>>>>>>");
        //账号
        boolean b = true;
        while (b) {
            prt("请输入账号");
            accountNumberPrt = sc.next();
            int cur = 0;
            //判断账号重复
            for (String accountNumber : personInfo.accountNumbers) {
                if (accountNumber.equals(accountNumberPrt)) {
                    prt("账号重复");
                    cur = 1;
                }
            }
            if (cur == 0) {
                b = false;
            }
        }
        //密码
        boolean c = true;
        while (c) {
            prt("请输入大于六位数密码");
            pwdPrt = sc.next();
            if (pwdPrt.length() < 6) {
                prt("密码必须大于六位数");
            } else {
                c = false;
            }
        }
        //卡号
        boolean d = true;
        while (d) {
            int cur = 0;
            //判断账号重复
            for (String card : personInfo.cardNumbers) {
                if (card.equals(cardNumber)) {
                    cur = 1;
                    cardNumber = String.valueOf((int) (Math.random() * 9000 + 1000));
                }
            }
            if (cur == 0) {
                d = false;
            }
        }
        //扩容
        personInfo.accountNumbers = Arrays.copyOf(personInfo.accountNumbers, personInfo.accountNumbers.length + 1);
        personInfo.pwds = Arrays.copyOf(personInfo.pwds, personInfo.pwds.length + 1);
        personInfo.cardNumbers = Arrays.copyOf(personInfo.cardNumbers, personInfo.cardNumbers.length + 1);
        personInfo.numberOfWins = Arrays.copyOf(personInfo.numberOfWins, personInfo.numberOfWins.length + 1);
        //存入
        personInfo.accountNumbers[personInfo.accountNumbers.length - 1] = accountNumberPrt;
        personInfo.pwds[personInfo.pwds.length - 1] = pwdPrt;
        personInfo.cardNumbers[personInfo.cardNumbers.length - 1] = cardNumber;
        personInfo.numberOfWins[personInfo.numberOfWins.length - 1] = 0;


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

    /**
     * @Author chy
     * @Date 2021/3/26 21:45
     * @Description 抽奖
     * @Since version-1.0
     */
    public static void draw(PersonInfo personInfo) {
        prt("请选择抽奖方式");
        prt("（1）幸运数字抽奖");
        prt("（2）幸运日抽奖");
        prt("（3）幸运色抽奖");
        String chooseDraw = sc.next();
        switch (chooseDraw) {
            case "1":
                luckyNum(personInfo);
                break;
            case "2":
                luckyDay(personInfo);
                break;
            case "3":
                luckyColor(personInfo);
                break;
            default:
                prt("重新输入!");
        }
        prt("personInfo = " + Arrays.toString(personInfo.accountNumbers));
        prt("personInfo = " + Arrays.toString(personInfo.pwds));
        prt("personInfo = " + Arrays.toString(personInfo.cardNumbers));
        prt("personInfo = " + Arrays.toString(personInfo.numberOfWins));
    }

    //（2）幸运日抽奖
    public static void luckyDay(PersonInfo personInfo) {
        prt("请输入一个日期");
        int day = sc.nextInt();
        int card = Integer.parseInt(personInfo.cardNumbers[loginCur]);
        if (card % day == 0) {
            prt("中奖了");
            personInfo.numberOfWins[loginCur]++;
        } else {
            prt("没中奖");
        }
    }

    //（1）幸运数字抽奖
    public static void luckyNum(PersonInfo personInfo) {
        int[] nums = randomNum();
        int winCur1 = 0;
        for (int num : nums) {
            if (personInfo.cardNumbers[loginCur].equals(num)) {
                prt("中奖了");
                personInfo.numberOfWins[loginCur]++;
                winCur1++;
            }
        }
        if (winCur1 == 0) {
            prt("没中奖");
        }
    }

    //（3）幸运色抽奖"
    public static void luckyColor(PersonInfo personInfo) {
        int colorInt = (int) (Math.random() * 10);
        int card = Integer.parseInt(personInfo.cardNumbers[loginCur]) % 10;
        if (colorInt == card) {
            prt("中奖了");
            personInfo.numberOfWins[loginCur]++;
        }
        else {
            prt("没有中奖");
        }
    }

    public static void main(String[] args) {
        PersonInfo personInfo = new PersonInfo();
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
                    login(personInfo);
                    break;
                case "2":
                    register(personInfo);
                    break;
                case "3":
                    draw(personInfo);
                    break;
                default:
                    prt("谢谢使用!bye");
                    b = false;
                    break;
            }

        }
    }
}

/**
 * @Author chy
 * @Date 2021/3/26 21:09
 * @Description 用户信息类
 * @Param
 * @Return
 * @Since version-1.0
 */
class PersonInfo {
    String[] accountNumbers = new String[0];
    String[] pwds = new String[0];
    String[] cardNumbers = new String[0];
    int[] numberOfWins = new int[0];
}