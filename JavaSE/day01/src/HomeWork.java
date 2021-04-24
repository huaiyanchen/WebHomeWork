
/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/22-19:16
 * @Since:jdk1.8
 * @Description: 作业1
 */
public class HomeWork {
    public static void Title1(){
        System.out.println("欢迎来到尚马教育");
        System.out.println("下面请自我介绍");
        System.out.println("我叫陈怀颜");
        System.out.println("今年25岁");
        System.out.println("对于这个是零基础");
        System.out.println("希望可以找到一个好的工作");
    }

    public static void Title2(){
        String name = "虞姬";
        String position = "射手";
        int money = 13888;
        String skills = "远程物理攻击";
        byte level = 6;
        boolean isHave = true;
        System.out.println("欢迎来到王者荣耀");
        System.out.println("英雄名称:" + name);
        System.out.println("英雄定位:" + position);
        System.out.println("英雄价格:" + money);
        System.out.println("英雄技能:" + skills);
        System.out.println("英雄难度:" + level + "颗星");
        System.out.println("是否拥有:"+isHave);

    }

    public static void Title3_c(int year) {
        Long lSpeed = 299792458L;
        Long time = (long) year * 12 * 30 * 24 * 60 * 60;
        System.out.println(lSpeed * time/1000);

    }

    public static void Title3_d(int day) {
        int week = day / 7;
        int TheRemainingNumberOfDays = day % 7;
        System.out.println("week = " + week);
        System.out.println("TheRemainingNumberOfDays = " + TheRemainingNumberOfDays);

    }

    public static void Title3_e() {
        float radius = 1.5f;
        float c = 3.14f;
        float area = radius * c * c;
        System.out.println(area);

    }

    public static void Title3_f() {
        float areaA = (float) (3.14 * 26.5 * 26.5 * (134.6 / 360));
        float areaB = (float) (3.14 * (36.5 - 12.3) * ((36.5 - 12.3)/2));
        boolean result = areaA > areaB ? true : false;
        if (true) {
            System.out.println("选择A");
        } else {
            System.out.println("选择B");
        }
    }

    public static void Title3_g() {
        int a = 20, b = 10;
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    public static void Title3_h() {
        int a = 123;
        int b = 123 % 10;
        int c = 123 / 10 % 10;
        int d = 123 / 100;
        int result = b + c + d;
        System.out.println("result = " + result);

    }

    public static void Title3_i() {
        int t = 22;
        float k = t * 9 / 5 + 32;
        System.out.println("k = " + k);
    }

    public static void main(String[] args) {
        Title1();
        Title2();
        Title3_c(1);
        Title3_d(46);
        Title3_e();
        Title3_f();
        Title3_g();
        Title3_h();
        Title3_i();
    }
}
