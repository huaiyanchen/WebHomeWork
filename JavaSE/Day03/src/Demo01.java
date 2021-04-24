/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/24-14:47
 * @Since:jdk1.8
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("======================");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("======================");
        for (int i = 1; i <= 10; i++) {
            for (int j = 10; j > i; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("======================");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("======================");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
        System.out.println("======================");
        for (int i = 0; i < 6; i++) {
            for (int j = 6; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            for (int j = 6; j >= i; j--) {
                System.out.print("* ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
