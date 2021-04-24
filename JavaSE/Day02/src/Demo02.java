import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/23-14:57
 * @Since:jdk1.8
 * @Description:demo02 Scanner
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("name:");
        String name = sc.nextLine();

        System.out.println("sex:");
        String sex = sc.nextLine();

        System.out.println("name:" + name + "\tsex:" + sex);
    }
}

