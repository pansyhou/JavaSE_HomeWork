package Exp2;

public class Outer {
    static class Inner{
        static String staticField="静态内部类的静态变量";
        static void staticMethod(){
            System.out.println(staticField);
        }
    }
}
class Test_For_Inner{
    public static void main(String[] args) {
        System.out.println(Outer.Inner.staticField);
        Outer.Inner.staticMethod();
    }
}