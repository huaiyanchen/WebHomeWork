/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/23-10:26
 * @Since:jdk1.8
 * @Description:work
 */
public class Demo01 {
    public static void main(String[] args) {
        int age = 16;
        String s = age > 18 ? "成年了" : "未成年 ";
        System.out.println("s = " + s);

        if (age > 18) {
            System.out.println("成年");
        } else {
            System.out.println("未成年");
        }

        //判断月份
        int month = 2;
        if (month <= 0 || month > 12) {

            System.out.println("月份错误");
        } else {
            if (month >= 3 && month <= 5) {
                System.out.println("春");
            } else if (month >= 6 && month <= 8) {
                System.out.println("夏");
            } else if (month >= 9 && month <= 11) {
                System.out.println("秋");
            } else if (month == 12 || (month <= 2 && month > 0)) {
                System.out.println("冬");
            }
        }

        //判断成绩
        int score = 80;
        if (score >= 0 && score <= 100) {
            if (score <= 100 && score > 80) {
                System.out.println("优秀");
            }
            else if (score <= 80 && score > 70) {
                System.out.println("良好");
            }
            else if (score <= 70 && score >= 60) {
                System.out.println("及格");
            }
            else if (score < 60) {
                System.out.println("不及格");
            }
        } else {
            System.out.println("成绩错误");
        }

        //判断三角形
        int a = 10, b = 15, c = 20;
        if (a > 0 && b > 0 && c > 0) {
            if (a + b > c && a + c > b && b + c > a) {
                System.out.println("是三角形");
            } else {
                System.out.println("不是三角形");
            }
        } else {
            System.out.println("三遍大于0");
        }

        //switch case
        int sum = 0;
        int months = 3;
        switch (months) {
            case 1:
                sum =  31;
                break;
            case 2:
                sum = 31 + 28;
                break;
            case 3:
                sum = 31 + 28 + 31;
                break;
        }
        System.out.println(sum+23);

    }
}
