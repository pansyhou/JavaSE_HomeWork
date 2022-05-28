package Exp6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class Example3 {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();// 传入一个自定义比较器
        tm.put("1", "Jack"); // 向集合存入学生的学号和姓名
        tm.put("2", "Rose");
        tm.put("5", "Lucy");
        tm.put("3", "Lucy");
        tm.put("4", "Rose");

        // 获取键的集合
        HashSet hashSet=new HashSet<>(tm.keySet());
        // 获得迭代器对象
        Iterator it=hashSet.iterator();
        while (it.hasNext()) {
            //获得一个键
            String key= (String) it.next();
            /// 获得键对应的值
            String value=(String)tm.get(key);
            System.out.println(key + ":" + value);
                //冒泡
        }
    }

}
