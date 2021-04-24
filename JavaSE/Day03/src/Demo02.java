import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/24-15:56
 * @Since:jdk1.8
 * @Description:素数
 */
public class Demo02 {

    public static void Num1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int num = sc.nextInt();
        boolean b = false;
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0) {
                b = true;
                i = num;
            }
        }
        if (b) {
            System.out.println(num + "不是素数");
        } else {
            System.out.println(num + "是素数");
        }
    }

    public static void Num2() {
        //计数
        int count = 0;
        //外层数值
        for (int i = 3; i <= 100; i++) {
            //判断条件
            boolean b = false;
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                System.out.println(i + "是素数");
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        Num2();
    }

}
