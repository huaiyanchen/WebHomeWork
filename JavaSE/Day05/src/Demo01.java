import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/26-9:38
 * @Since:jdk1.8
 * @Description: 
 */
public class Demo01 {
    public static String calc(int num1, int num2, String operator) {
        String result;
        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    result = "除数不能为零";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
            default:
                result = "暂无该运算";
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数:");
        int num2 = sc.nextInt();
        System.out.println("请输入运算操作 ");
        String operator = sc.next();
        String calc = calc(num1, num2, operator);
        System.out.println("calc = " + calc);
    }
}