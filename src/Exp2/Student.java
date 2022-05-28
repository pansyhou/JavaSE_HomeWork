package Exp2;

import java.util.Random;

public class Student {

    String name;//定义成员变量
    int mark;

    Student() {
        System.out.println("这个是无参的构造方法");
    }

    Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark= mark;
    }
}

class Test_For_Student {
    public static void main(String[] args) {
//        //采用无参构造方法
//        Student student=new Student();//创建对象
//        student.setName("卖鱼哥");
//        student.setMark(100);
//        //有参的构造方法
//        Student student1=new Student("王雷",100);
//        String abc=new String("abcdefg");
//        System.out.println(abc.substring(2,5));
//        StringBuffer stringBuffer=new StringBuffer();
//        stringBuffer.append(
        Integer in1 = new Integer(10);
        Integer in2 = new Integer(10);

        Integer in3 = 10;
        Integer in4 = 10;

        System.out.println(in1 == in2);
        System.out.println(in1 == in3);
        System.out.println(in3 == in4);
    }

}