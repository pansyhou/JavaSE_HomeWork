package mypack.sec;

import mypack.one.NikeOne;

public class NikeTwo {
    void methodB(){
        System.out.println(this.getClass().getName());
    }
}
class Cmain{

    public static void main(String[] args) {
        NikeOne nikeOne=new NikeOne();
        NikeTwo nikeTwo =new NikeTwo();

        nikeOne.methodA();
        nikeTwo.methodB();
    }
}