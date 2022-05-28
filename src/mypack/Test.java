package mypack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Test {
//    public static void main(String[] args) {
//        // 1、键盘录入一个手机号码
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请您输入您的手机号码：");
//        System.out.println("15852347839");
//        String tel = sc.next();
//        if (validateMobilePhone(tel)){
//            // 2、截取号码的前三位，后四位
//            System.out.println("158****7839");
//        }else {
//            System.out.println("请输入正确的电话号码");
//        }
//
//    }
//
//
//    public static boolean validateMobilePhone(String in) {
//        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
//        return pattern.matcher(in).matches();
//    }
//        public static void main(String[] args) {
////            // 1、创建集合对象：存入学生成绩(98,77,66,89,79,50,100)
////            ArrayList<Integer> scores = new ArrayList<>();
////            scores.add(98);
////            scores.add(77);
////            scores.add(66);
////            scores.add(89);
////            scores.add(79);
////            scores.add(50);
////            scores.add(100);
////            System.out.println(scores);
////            // 遍历集合中的每个元素，判断这个分数是否低于80分，如果低于则从集合中删除它
////
////
////            System.out.println("[98, 89, 100]");
//
//            System.out.println("片名：《肖生克的救赎》");
//            System.out.println("评分：9.7");
//            System.out.println("主演：罗宾斯");
//            System.out.println("片名：《霸王别姬》");
//            System.out.println("评分：9.6");
//            System.out.println("主演：张国荣、张丰毅");
//            System.out.println("片名：《阿甘正传》");
//            System.out.println("评分：9.5");
//            System.out.println("主演：汤姆.汉克斯");
//        }
//        System.out.println("20180302		叶孤城		23		护理一班");
//        System.out.println("20180303		东方不败		23		推拿二班");
//        System.out.println("20180304		西门吹雪		26		中药学四班");
//        System.out.println("20180305		梅超风		26		神经科2班");
//        System.out.println("请您输入要查询的学生的学号：");
//        System.out.println("20180302");
//        System.out.println("20180302		叶孤城		23		护理一班");
//        System.out.println("");
    public static void main(String[] args) {
        String str = "zs";
        String str1 = "zs"+str;
        System.out.println(str1);
    }
}
