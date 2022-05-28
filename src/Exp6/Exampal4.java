package Exp6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Exampal4 {
    private HashSet KeyNum;
    private Random num;

    public void CreatSet() {
        this.KeyNum = new HashSet();
        this.num= new Random();
        while (KeyNum.size() != 7) {
            KeyNum.add(num.nextInt(29) + 1);
        }
    }

    @Override
    public String toString() {
        return "调试用透视彩票号码" +
                 KeyNum ;
    }

    public static void main(String[] args) {
        int[] ball = new int[7];
        Exampal4 keySet = new Exampal4();
        keySet.CreatSet();
        System.out.println(keySet);
        System.out.println("请逐个输入彩票号码，回车下一个");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            ball[i] = scanner.nextInt();
        }

        int count = 0;
        Iterator iterator = keySet.KeyNum.iterator();
        for (int i = 0; i < 7; i++) {
            while (iterator.hasNext()) {
                if(ball[i]==(int)iterator.next())count++;
            }
            iterator = keySet.KeyNum.iterator();
        }
        switch (count)
        {
            case 5: {
                System.out.println("三等奖");
                break;
            }case 6: {
                System.out.println("二等奖");
                break;
            }case 7: {
                System.out.println("一等奖");
                break;
            }
        }

    }
}
