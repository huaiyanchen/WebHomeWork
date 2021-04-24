import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/23-15:46
 * @Since:jdk1.8
 * @Description:登陆 demo
 *
 */
public class StringDemo {
    public static void main(String[] args) {
//        String s = "100";
//
//        String s1 = new String("100");
//
//        Strings strings1 = new Strings();
//        strings1.i = "100";
//        Strings strings2 = new Strings();
//        strings2.i = "100";
//        System.out.println(strings2.i == strings1.i);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String id = sc.next();
        //验证账号
        if (id.equals("1000")) {
            System.out.println("请输入密码");
            String pwd = sc.next();
            //验证密码
            if (id.equals("1000")&&pwd.equals("123")) {
                System.out.println("登陆成功");
            } else {
                System.out.println("账号或密码错误");
            }
        } else {
            System.out.println("账号不存在");
        }
    }
}
