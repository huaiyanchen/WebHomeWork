import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/25-14:56
 * @Since:jdk1.8
 * @Description: 
 */
public class ArrayAdd {
    public static void add1() {
        String[] names = new String[100];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入姓名:");
            String name = sc.next();
            for (int i = 0; i < names.length; i++) {
                if (names[i] == null) {
                    names[i] = name;
                    break;
                }
            }

            System.out.println("是否继续输入(y/n)");
            String next = sc.next();
            if ("n".equals(next) || "N".equals(next)) {
                break;
            }
        }
        for (String name : names) {
            if (name != null) {
                System.out.println("name = " + name);
            }
        }
    }

    public static String[]  add2() {
        String[] names = {"xiao", "bai"};
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入姓名:");
            String name = sc.next();
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = name;
            System.out.println("是否继续输入(y/n)");
            String next = sc.next();
            if ("n".equals(next) || "N".equals(next)) {
                break;
            }
        }
        System.out.println("names = " + Arrays.toString(names));
        return names;
    }


    public static String[] delete1() {
        String[] names = {"xiao", "bai","123","23112"};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的姓名:");
        String name = sc.next();
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                //后一个给前一个
                for (int j = i; j < names.length - 1; j++) {
                    names[j] = names[j + 1];
                }
            }
        }
        //最后的数组长度减一
        names = Arrays.copyOf(names, names.length - 1);
        System.out.println("names = " + Arrays.toString(names));
        return names;
    }

    public static void main(String[] args) {

        // add1();
        // add2();
        delete1();

    }
}
