import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/3/25-15:57
 * @Since:jdk1.8
 * @Description:demo
 */
public class Demo02 {
    static Scanner sc = new Scanner(System.in);

    public static void prt(String string) {
        System.out.println(string);
    }

    //add
    public static String[] add(String[] names) {
        while (true) {
            prt("请输入姓名:");
            String name = sc.next();
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = name;
            prt("是否继续输入(y/n)");
            String next = sc.next();
            if ("n".equals(next) || "N".equals(next)) {
                break;
            }
        }
        return names;
    }

    //delete
    public static String[] delete(String[] names) {

        prt("请输入删除的姓名:");
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
        //缺少判断  
        names = Arrays.copyOf(names, names.length - 1);

        return names;
    }

    //更新
    public static String[] update(String[] names) {
        prt("请输入要修改的姓名:");
        String name = sc.next();
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                prt("请输入要修改成的姓名:");
                String next = sc.next();
                names[i] = next;
                index = 1;
            }
        }
        if (index == 0) {
            prt("查无此人！");
        }
        if (index == 1) {
            prt("修改成功！");
        }
        return names;
    }

    //显示
    public static void show(String[] strings) {
        prt(Arrays.toString(strings));
    }

    public static void main(String[] args) {
        String[] names = {"xiao", "bai", "123", "23112"};
        prt("welcome to name manage system");
        boolean b = true;
        while (b) {
            prt("请输入选择:");
            prt("1:增加");
            prt("2:删除");
            prt("3:显示");
            prt("4:修改");
            prt("5:退出");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    names = add(names);
                    break;
                case 2:
                    names = delete(names);
                    break;
                case 3:
                    show(names);
                    break;
                case 4:
                    names = update(names);
                    break;
                case 5:
                    b = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }


    }
}