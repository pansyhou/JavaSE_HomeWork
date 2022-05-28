package Exp4;

import java.util.Random;

public class RandomNumberCreator {
    Random random=new Random();
    int num0=random.nextInt(30)+20;
    int num1=random.nextInt(30)+20;
    int num2=random.nextInt(30)+20;
    int num3=random.nextInt(30)+20;
    int num4=random.nextInt(30)+20;

    public static void main(String[] args) {
        RandomNumberCreator r=new RandomNumberCreator();
        System.out.println(r.num0);
        System.out.println(r.num1);
        System.out.println(r.num2);
        System.out.println(r.num3);
        System.out.println(r.num4);
    }
}
