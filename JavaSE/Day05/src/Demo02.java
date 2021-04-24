import java.util.Arrays;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/26-15:44
 * @Since:jdk1.8
 * @Description: 
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] c = {2, 3, 5, 7, 2, 6, 7,};
        for (int i = 0; i < c.length - 1; i++) {
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
}