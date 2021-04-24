import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/23-16:38
 * @Since:jdk1.8
 * @Description:偶数和
 */
public class Demo03 {
    public static void main(String[] args) {
//        int sum = 0;
//        int count = 0;
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0) {
//                sum += i;
//                count++;
//            }
//        }
//        System.out.println("count = " + count);
//        System.out.println("sum = " + sum);


        //计算金钱
        int day = 2;
        long money = 1L;
        do {
            money += money;
            System.out.println(day + "~~" + money);
            day++;
        } while (day <= 30);

        //表白
//        String word = "";
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.println("男孩说:你喜不喜欢我?");
//            System.out.println("女孩说:");
//            word = sc.nextLine();
//        } while (!"喜欢".equals(word));
//        System.out.println("表白成功");

        //水仙花
        for (int i = 100; i < 999; i++) {
            int unit = i % 10;
            int decade = i / 10 % 10;
            int hund = i / 100;
            if (unit * unit * unit + decade * decade * decade + hund * hund * hund == i) {
                System.out.println("水仙花数为:" + i);
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 9; j > 0; j--) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }
}
