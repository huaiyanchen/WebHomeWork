import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/24-17:19
 * @Since:jdk1.8
 * @Description:数组
 */
public class Demo03 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入人数:");
//        int count = sc.nextInt();
//        float[] arr = new float[count];
//        for (int i = 0; i < count; i++) {
//            System.out.println("请输入第" + (i + 1) + "个人的分数");
//            //分数
//            float score = sc.nextFloat();
//            arr[i] = score;
//        }
//        //总成绩
//        float sunScore = 0;
//        for (float v : arr) {
//            sunScore += v;
//            System.out.println("分数 = " + v);
//        }
//        System.out.println("总成绩:" + sunScore);
//        System.out.println("平均成绩:" + sunScore / count);

        int[] a = {2, 3};
        Array<Integer> array = new Array(14);
        array.add(0, 1);
        System.out.println("array = " + array);
        System.out.println(array.isEmpty());
        System.out.println("array.getSize() = " + array.getSize());
        System.out.println("array.getSize() = " + array.getCapacity());

    }
}
