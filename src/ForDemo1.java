import java.util.ArrayList;

import java.util.Iterator;


public class ForDemo1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();  // 创建ArrayList集合
        list.add("Tom");     // 向该集合中添加字符串
        list.add("Jerry");
        Iterator it = list.iterator();  //获取迭代器
        it.next();
        it.next();
        System.out.println(it.next());
        }
}
