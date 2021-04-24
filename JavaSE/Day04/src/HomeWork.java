import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/25-19:10
 * @Since:jdk1.8
 * @Description: 
 */
public class HomeWork {
    static Scanner sc = new Scanner(System.in);

    /**
     * 1.	从键盘接受10个整数保存在数组中，将10个数中最大的与第一个元素交换，最小的与最后一个元素交换，其余元素位置不变，输出数组元素的值
     */
    public static void num01() {
//        int[] ints = new int[10];
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println("请输入第" + (i + 1) + "个数:");
//            int nextInt = sc.nextInt();
//            ints[i] = nextInt;
//        }
        int[] ints = {1, 43, 543, 23, 534, 233, 322, 12, 2334, 5232};

        int MaxCur = 0;
        int MinCur = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > ints[MaxCur]) {
                MaxCur = i;
            }
            if (ints[i] < ints[MinCur]) {
                MinCur = i;
            }
        }
        //最大值
        int temp1 = ints[0];
        ints[0] = ints[MaxCur];
        ints[MaxCur] = temp1;

        //最小值
        int temp2 = ints[ints.length - 1];
        ints[ints.length - 1] = ints[MinCur];
        ints[MinCur] = temp2;
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 2.	定义一个数组来存储12个学生的成绩{72,89,65,58,87,91,53,82,71,93,76,68}，
     * 统计各成绩等级（90分以上为‘A’，80~89分为‘B’，70~79分为‘C’，60~69分为‘D’，60分以下为E）学生人数，
     * 并将其放入到数组count中，其中：count[0]存E级的人数，count[1]存D级的人数，……，count[4]存A级的人数。
     */
    public static void num02() {
        int[] scores = {72, 89, 65, 58, 87, 91, 53, 82, 71, 93, 76, 68};
        int[] count = new int[5];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        for (int score : scores) {
            if (score >= 90) {
                a++;
            }
            if (score >= 80 && score < 90) {
                b++;
            }
            if (score >= 70 && score < 80) {
                c++;
            }
            if (score >= 60 && score < 70) {
                d++;
            }
            if (score < 60) {
                e++;
            }
        }
        count[0] = a;
        count[1] = b;
        count[2] = c;
        count[3] = d;
        count[4] = e;

        System.out.println(Arrays.toString(count));
    }

    /**
     * 3.	从键盘输入8个整数存放在一个数组中，然后将奇数和偶数分别存入到两个不同的数组中，并按奇数
     * 偶数交替的顺序输出这两个数组中的所有数据
     */
    public static void num03() {
        int[] ints = new int[8];
        int oddNumber = 0;//奇数
        int evenNumber = 0;//偶数
        for (int i = 0; i < ints.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数:");
            int nextInt = sc.nextInt();
            if (nextInt % 2 == 0) {
                oddNumber++;
            } else {
                evenNumber++;
            }
            ints[i] = nextInt;
        }
        int[] oddNumbers = new int[oddNumber];//奇数
        int[] evenNumbers = new int[evenNumber];//偶数
        int oddCur = 0;//奇数
        int evenCru = 0;//偶数
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                oddNumbers[oddCur] = ints[i];
                oddCur++;
            } else {
                evenNumbers[evenCru] = ints[i];
                evenCru++;
            }
        }
        System.out.println("oddNumbers = " + Arrays.toString(oddNumbers));
        System.out.println("evenNumbers = " + Arrays.toString(evenNumbers));
        for (int i = 0, j = 0; i < oddNumber || j < evenNumber; i++, j++) {
            if (i < oddNumber) {
                System.out.println(oddNumbers[i]);
            }
            if (j < evenNumber) {
                System.out.println(evenNumbers[j]);
            }
        }

    }

    /**
     * 1.	定义一个二维数组，存储每个科目的成绩。
     * 要求录入几个科目，然后根据科目录入分数。然后求出每个科目的最高分和最低分。
     */
    public static void num21() {
        System.out.println("请输入录入几个科目:");
        //科目数
        int subNum = sc.nextInt();

        float[][] scoreSubs = new float[subNum][];
        for (int i = 0; i < subNum; i++) {
            System.out.println("请输入录入第" + (i + 1) + "个科目的人数");
            //科目人数
            int subNumPer = sc.nextInt();

            float[] subScore = new float[subNumPer];
            for (int j = 0; j < subNumPer; j++) {
                System.out.println("请输入录入第" + (j + 1) + "个人的分数");
                subScore[j] = sc.nextFloat();
            }
            scoreSubs[i] = subScore;
        }
        for (int i = 0; i < scoreSubs.length; i++) {
            System.out.println("第" + (i + 1) + "科目");
            int MaxCur = 0;
            int MinCur = 0;
            for (int j = 0; j < scoreSubs[i].length; j++) {
                if (scoreSubs[i][j] > scoreSubs[i][MaxCur]) {
                    MaxCur = j;
                }
                if (scoreSubs[i][j] < scoreSubs[i][MinCur]) {
                    MinCur = j;
                }
            }
            System.out.println("第" + (i + 1) + "科目的最高分为:" + scoreSubs[i][MaxCur] + "\n最低分为:" + scoreSubs[i][MinCur]);
        }
        System.out.println();

    }

    /**
     * 2.	标准答案是：ABDCD，每道题2分，求出每个学生的成绩分别是多少？5位同学的答案分别是：小白【ABCCD】、小黑【ABDDC】、
     * 小兰【ABDCC】、小绿【ABBBC】、小青【ACCC】
     * 【提示：将正确答案存储到一个一维数组中，将学生的成绩存储到二维数组中。
     * 然后进行比较。】
     */
    public static void num2_2() {
        char[] standard = {'A', 'B', 'C', 'D', 'E'};
        char[][] scoreStu = {
                {'A', 'B', 'C', 'C', 'D'},
                {'A', 'B', 'D', 'D', 'C'},
                {'A', 'B', 'D', 'C', 'C'},
                {'A', 'B', 'B', 'B', 'C'},
                {'A', 'C', 'C', 'C'}
        };
        for (int i = 0; i < scoreStu.length; i++) {
            int sum = 0;
            for (int j = 0; j < scoreStu[i].length; j++) {
                if (standard[j] == scoreStu[i][j]) {
                    sum += 2;
                }
            }
            System.out.println("第" + (i + 1) + "个同学的成绩为:" + sum);
        }
        System.out.println();
    }

    /**
     * 进入点餐系统，依次录入你要点的菜单名称。显示对应的价格。
     * 点完一个菜之后，询问是否继续？直到退出点餐。然后进行结算！
     */
    public static void num31() {
        String[][] menu = {{"大米", "1"}, {"鱼香肉丝", "16"}, {"酸溜土豆丝", "12"}, {"鱼", "20"}};
        boolean b = true;
        int price = 0;
        while (b) {
            System.out.println("请输入订购的食物(大米.鱼香肉丝.酸溜土豆丝.鱼)");
            String food = sc.next();
            for (int i = 0; i < menu.length; i++) {
                if (food.equals(menu[i][0])) {
                    price += Integer.parseInt(menu[i][1]);

                }
            }
            System.out.println("是否继续点餐(y/n)");
            String next = sc.next();
            if ("n".equals(next) || "N".equals(next)) {
                b = false;
            }
            System.out.println("现在的价格为:" + price);
        }
    }


    public static void main(String[] args) {
//        Num01();
//        Num02();
//        Num03();
//        Num21();
        num2_2();
//        Num31();


    }


}
