package Exp2;

public class Exp2_2 {
    Exp2_2() {
        System.out.println("HI,这是无参构造方法");
    }
    Exp2_2(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Exp2_2[] args1 ;//创建对象引用变量，并没有实际创建一个对象，所以并不会用到构造方法

        Exp2_2[] args2=new Exp2_2[2];
        args2[0] = new Exp2_2("对象1");//将实例对象给对象引用变量，就能用到构造方法
        args2[1] = new Exp2_2("对象2");

    }
}
