package Exp6;

import java.util.HashSet;

public class Example2 {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        Person p1 = new Person("18", "Jack"); // 创建Student对象
        Person p2 = new Person("19", "Rose");
        Person p3 = new Person("20", "Rose");
        hs.add(p1); // 向集合存入对象
        hs.add(p2);
        hs.add(p3);
        System.out.println(hs); // 打印集合中的元素
    }
}
