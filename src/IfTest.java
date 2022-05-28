import java.util.Scanner;

public class IfTest {
    
    public static void main(String[] args) {
        String a;
        int n;
        Scanner input2 =new Scanner(System.in);
        n=input2.nextInt();
        if(n<100&&n>95)
        {
            System.out.println("山地自行车一辆");
        }
        else if(n<92&&n>94)
        {
            System.out.println("游乐场玩一次");
        }
        else if(n<80&&n>89)
        {
            System.out.println("变形金刚玩具一个");

        }
        else{
            System.out.println("胖揍一顿");

        }
    }
}