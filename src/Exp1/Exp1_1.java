package Exp1;
public class Exp1_1 {

    public static void main(String[] args) {
        Exp1_1 a1 = new Exp1_1();
        a1.print();
        a1.print2();
        a1.print3();
        //可根据需要使用不同的三个方法，因为题有三个
    }

    void print() {
        int i;
        i = 1;
        for (; i < 51; i++) {
            if (i % 5 == 0)
                System.out.println(i);
            else
                System.out.print(i);
        }   
    }

    void print2() {
        int i;
        i = 1;
        for (; i < 51;  i++) {
            if (i % 5 == 0)
                System.out.println(i);
            else if (i == 47)
                break;
            else
                System.out.print(i);
        }
    }

    void print3() {
        int i;
        i = 1;
        for (; i < 51; i++) {
            if (i % 5 == 0)
                System.out.println(i);
            else if (i == 47)
                continue;
            else
                System.out.print(i);
        }
    }
}
