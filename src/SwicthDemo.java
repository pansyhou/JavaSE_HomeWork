import java.util.Scanner;

public class SwicthDemo {
    public static void main(String[] args) {
        System.out.println("请输入月份：");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();

        switch (n)
        {
            case 1:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 3:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 2:
            {
                System.out.print("2月份闰年为29天，非闰年为28天！\n");
            }break;
            case 5:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 7:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 8:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 10:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 12:
            {
                System.out.println("1、3 、5、 7 、 8、 10、 12月份是 31天");
            }break;
            case 4:
            {
                System.out.println("4 、6 、9、 11月份 是30天");
            }break;
            case 6:
            {
                System.out.println("4 、6 、9、 11月份 是30天");
            }break;
            case 9:
            {
                System.out.println("4 、6 、9、 11月份 是30天");
            }break;
            case 11:
            {
                System.out.println("4 、6 、9、 11月份 是30天");
            }break;
            default:
            System.out.println("数据错误");
            break;
        }
        input.close();
    }
}