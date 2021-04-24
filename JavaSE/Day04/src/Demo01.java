import java.util.Arrays;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/25-9:48
 * @Since:jdk1.8
 * @Description: 
 */
public class Demo01 {
    static int[] c = {1, 3, 2, 8, 5, 3, 4};

    //冒泡
    public static void Num01() {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length - 1 - i; j++) {
                if (c[j] > c[j + 1]) {
                    int temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(c));
    }

    //选择
//    public static void Num02() {
//        int[] c = {1, 3, 2, 8, 5, 3, 4};
//        for (int i = 0; i < c.length; i++) {
//            for (int j = i; j < c.length; j++) {
//                if (c[i] > c[j]) {
//                    int temp = c[i];
//                    c[i] = c[j];
//                    c[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(c));
//    }


    public static void Num02() {
        for (int i = 0; i < c.length; i++) {
            int MinTarget = i;
            int j;
            for (j = i + 1; j < c.length; j++) {
                if (c[MinTarget] > c[j]) {
                    MinTarget = j;
                }
            }
            c[MinTarget] = c[i];
        }
        System.out.println(Arrays.toString(c));

    }

    public static void main(String[] args) {
        Num01();
        Num02();

    }
}
