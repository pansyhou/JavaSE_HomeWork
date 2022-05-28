package Exp6;

import java.util.ArrayList;
import java.util.Iterator;

public class Exampal1 {
    public static void main(String[] args) {
        ArrayList list =new ArrayList();
        for (int i = 1; i < 10; i++) {
            list.add("stu"+i);
        }
        list.add("stu0");

        Iterator it= list.iterator();

        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
    }
}
