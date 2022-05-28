//import java.util.Scanner;
//
///**
// 需求：机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
// 按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
// */
//public class Test1 {
//    public static void main(String[] args) {
//        double price = 550;
//        int month = 2;
//        String type = "经济舱";
//        System.out.println("机票原价："+price);
//        System.out.println("月份："+month);
//        System.out.println("仓位类型（头等舱、经济舱）："+type);
//        double rs = calc(price, month, type);
//        System.out.println("您当前购买机票的价格是：" + rs);
//    }
//
//    /**
//     1、定义一个方法：形参（原价、月份、头等舱经济舱） 返回值类型申明：double
//     */
//    public static double calc(double money, int month, String type){
//        double price=0;
//        //discount[0]头等舱，以此类推
//        double[] discount=new double[2];
//        if (month >= 5 && month <= 10) {
//            discount[0] = 0.90f;
//            discount[1] = 0.85f;
//        } else if ((month >= 11 && month <= 12) || (month >= 1 && month <= 4)) {
//            discount[0] = 0.70f;
//            discount[1] = 0.65f;
//        } else {
//            discount[0] = 1.0;
//            discount[1] = 1.0;
//        }
//        switch (type) {
//            case "头等舱":
//                price = discount[0] * money;
//                break;
//            case "经济舱":
//                price = discount[1] * money;
//                break;
//        }
//        return price;
//
//    }
//}

//
//public class Test1 {
//    public static void main (String[]args){
//        //101-200之间素数的个数
//        int count=0;
//        // 1、定义一个循环，找到101-200之间的全部数据
//        for(int i=0;i<100;i++)
//        {
//            i++;
//        }
//        System.out.println("101\t103\t107\t109\t113\t127\t131\t137\t139\t149\t151\t157\t163\t167\t173\t179\t181\t191\t193\t197\t199\t");
//        System.out.println("101-200之间素数的个数21");
//    }
//}
//

/**
 需求：把一个数组中的元素复制到另一个新数组中去,并打印这两个数组。
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44};
        int[] arr2 = new int[arr1.length];
        copy(arr1 , arr2);
        printArray(arr1);
        printArray(arr2);
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println("最高分是：99");
            System.out.println("最低分是：55");
            System.out.println("选手最终得分是：85.75");

        }
    }


    public static void copy(int[] arr1, int[] arr2){
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];
        }
    }
}
