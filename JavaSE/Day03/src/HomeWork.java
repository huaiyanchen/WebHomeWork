import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/24-18:59
 * @Since:jdk1.8
 * @Description: 
 */
public class HomeWork {
    //从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和。	从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和。	从键盘接收一个整数N，统计出1~N之间能被7整除的整数的个数，以及这些能被7整除的数的和。
    public static void Num1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数;");
        int nextInt = sc.nextInt();
        int count = 0;
        int sum = 0;
        for (int i = 1; i < nextInt; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                sum += i;
                count++;
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("count = " + count);
    }

    //	声明一个字符串的数组，空间为5个。使用循环接收五个学生的姓名。再使用循环输出这五个学生的姓名。
    public static void Num2() {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            String name = sc.next();
            names[i] = name;
        }
        for (String name : names) {
            System.out.println("name = " + name);

        }
    }

    //	定义一个数组，录入一组数字。然后再输入一个数字，判断该数字是否在刚刚那个数组中出现过。如果出现过，统计出该数字出现的次数？
    public static void Num3() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int i = sc.nextInt();
        //计数
        int count = 0;
        for (int j = 0; j < intArray.length; j++) {
            if (intArray[j] == i) {
                System.out.println("出现了" + j);
                count++;
            }
        }
        System.out.println(i + "出现了" + count + "次");
    }

    //的0项去掉
    public static void Num4() {
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        //计算为零的个数
        int count = 0;
        for (int i : oldArr) {
            if (i == 0) {
                count++;
            }
        }
        int[] newArr = new int[oldArr.length - count];
        int target = 0;
        for (int i : oldArr) {
            if (i != 0) {
                newArr[target] = i;
                target++;
            }
        }
        for (int i : newArr) {
            System.out.println("i = " + i);

        }
    }

    //求某选手的得分
    public static void Num5() {
        Scanner sc = new Scanner(System.in);
        double[] scores = new double[10];
        //十位评委的总和
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "位评委的评分:");
            double score = sc.nextDouble();
            sum += score;
            scores[i] = score;
        }
//        OptionalDouble max = Arrays.stream(scores).max();
//        OptionalDouble min = Arrays.stream(scores).min();
        double temp = 0.0;
        //冒泡排序
        for (int i = 0; i < scores.length; i++) {
            //j是数组的最后一个角标
            for (int j = scores.length - 1; j > i; j--) {
                if (scores[j] < scores[j - 1]) {
                    //从后往前进行比较，小数往前，一轮之后最小数就在最前面了23
                    temp = scores[j - 1];
                    scores[j - 1] = scores[j];
                    scores[j] = temp;
                }
            }
        }
        double sum2 = sum - scores[0] - scores[scores.length - 1];
        System.out.println("该选手得分为:" + sum2 / 8);

    }

    //	有一整数数组，{1,3,-1,5,-2}; 将数据复制到新数组中 ，要求逆序输出新数组中的数，同时并将小于0的元素按0存储。
    public static void Num6() {
        int[] arr = {1, 3, -1, 5, -2};
        int[] arrInt = new int[arr.length];
        int cur = 0;
        for (int i : arr) {
            if (i < 0) {
                i = 0;
            }
            arrInt[cur] = i;
            cur++;
        }
        for (int i = arrInt.length; i > 0; --i) {
            System.out.println(arrInt[i - 1]);
        }
    }

    //	定义一个长度为10的数组，然后依次的往数组中录入数字。但是需要判断如果某个数字已经存在了，则需要重新录入该数字。直到所有的数字都不重复再显示数组中的内容。
    public static void Num7() {
        Scanner sc = new Scanner(System.in);
        int[] arrs = new int[10];
        //判断用
        int cur = 0;
        //第一层终止
        boolean b = true;
        while (b) {
            System.out.println("请输入一个数字：");
            int i = sc.nextInt();
            //第二层终止
            boolean c = true;
            for (int arr : arrs) {
                if (arr == i) {
                    c = false;
                    System.out.println("您输入的数字重复,请重新输入!");
                    break;
                }
            }
            if (c) {
                arrs[cur] = i;
                cur++;
            }
            if (cur == 10) {
                b = false;
            }
        }

        for (int arr : arrs) {
            System.out.println("arr = " + arr);
        }
    }

    public static void Num8() {
        int[] array = {2, 432, 5221, 235, 2, 5352, 1, 53, 5, 3,
                5364, 2, 2, 63, 3533, 2, 53, 532, 532};
        int sum = 0;
        //求和
        for (int i : array) {
            sum += i;
        }
        ///	输出所有下标为奇数的元素
        // 计算奇数个数
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                System.out.println("array[" + i + "] = " + array[i]);
                count++;
            }
        }
        //	输出所有元素中，值为奇数的
        ////cur 定位用
        int[] b = new int[9];//奇数位置
        int curb = 0;

        for (int i : array) {
            if (i % 2 != 0) {
                System.out.println("奇数为" + i);
                b[curb] = i;
                curb++;
            }
        }
        //	将所有元素乘二。
        for (int i : array) {
            i *= 2;
            System.out.println("数组*2= " + i);
        }

        array[0] = sum;

        //	偶数元素存到C数组中
        int[] c = new int[array.length - count];
        int cur2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                c[cur2] = i;
                cur2++;
            }
        }
        //	分别逆序输出B数组和C数组。
        for (int i = b.length; i > 0; --i) {
            System.out.println("b" + b[i - 1]);
        }
        for (int i = c.length; i > 0; --i) {
            System.out.println("c" + c[i - 1]);
        }
    }

    public static void main(String[] args) {
//        Num1();
//        Num2();
//        Num3();
//        Num4();
//        Num5();
//        Num6();

        Num7();
//        Num8();

    }
}
