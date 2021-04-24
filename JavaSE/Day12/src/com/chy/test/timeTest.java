package com.chy.test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;

/**
 * @Author：chy
 * @Version：1.0
 * @Date：2021/4/6-15:17
 * @Since:jdk1.8
 * @Description: 
 */
public class timeTest {

    public void Calendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);

        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        System.out.println("calendar.get(1) = " + calendar.get(1));
        System.out.println("calendar.get(Calendar.SECOND) = " + calendar.get(Calendar.SECOND));
        System.out.println("Calendar.YEAR = " + Calendar.YEAR);
        System.out.println("Calendar.MONTH = " + Calendar.MONTH);
    }

    public void Instant() {
        Instant is = Instant.now();
        System.out.println("is = " + is);

        System.out.println("Instant.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(8))) = "
                + Instant.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(8))));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        System.out.println("格式化之后：" + dtf.format(Instant.now()));  // 2021-04-06T15:11:25.148Z

        System.out.println("将字符串转换成日期类型：" + dtf.parse("2021-04-06 15:31:30"));  //字符串格式必须与设定的格式一模一样

    }

    public void random() {
        Random random = new Random();
        System.out.println(random.nextInt(10));

    }

    public void Base64() {
        Base64.Encoder  encoder = Base64.getEncoder();
        String pwd = "我是";
        byte[] encode = encoder.encode(pwd.getBytes());
        String s = new String(encode);
        System.out.println(s);

        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        String s2 = new String(decode);
        System.out.println(s2);
    }

    public static void main(String[] args) {

        new timeTest().Base64();

    }
}