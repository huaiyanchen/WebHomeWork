import java.util.Collection;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/25-17:17
 * @Since:jdk1.8
 * @Description:二维数组的赋值
 */
public class Demo03 {


    public static void main(String[] args) {
//        int[][] nums = {{1, 2}, {2, 3}, {3, 4}};
//        int[][] nums2 = new int[][]{{1, 2}, {2, 3}, {3, 4}};
//        Integer[][] nums3 = new Integer[][]{{1, 2}, {2, 3}, {3, 4}};
//        for (Integer[] num : nums3) {
//            System.out.println((Arrays.toString(num)));
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级数量");
        int classNum = sc.nextInt();
        float[][] classScore = new float[classNum][];
        for (int i = 0; i < classNum; i++) {
            System.out.println("请输入第" + (i + 1) + "个班级有多少学生");
            int studentNum = sc.nextInt();
            float[] scores = new float[studentNum];
            for (int j = 0; j < studentNum; j++) {
                System.out.println("请输入第" + (j + 1) + "个学生的成绩");
                float score = sc.nextFloat();
                scores[j] = score;
            }
            classScore[i] = scores;
        }
        for (float[] floats : classScore) {
            for (float aFloat : floats) {
                System.out.print("aFloat = " + aFloat);
            }
            System.out.println();
        }
    }
}
