package Exp9;

//public class MyThread extends Thread {
//
//    //法1：通过继承Thread类，实现多线程
//    @Override
//    public void run() {
//        System.out.println(getName() + " is running");
//
//    }
//
//    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//
//        Thread thread1=new Thread("Thread1");
//        Thread thread2=new Thread("Thread2");
//
//        myThread1.start();
//        myThread2.start();
//    }
//}
//法2：通过实现Runnable接口，实现多线程
//public class MyThread implements Runnable{
//
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {//sleep会发生异常要显示处理
//                Thread.sleep(20);//暂停20毫秒
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "打了:" + i + "个小兵");
//        }
//    }
//
//    public static void main(String[] args) {
//        //创建MyRunnable类
//        MyThread mr = new MyThread();
//        //创建Thread类的有参构造,并设置线程名
//        Thread t1 = new Thread(mr, "张飞");
//        Thread t2 = new Thread(mr, "貂蝉");
//        Thread t3 = new Thread(mr, "吕布");
//        //启动线程
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
//
//public class MyThread implements Runnable {
//    private int count=50;
//    public void run() {
//        while (true) {
//            if (count > 0) {
//                System.out.println("new");
//                count--;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        //创建MyRunnable类
//        MyThread mr = new MyThread();
//        //创建Thread类的有参构造,并设置线程名
//        Thread t1 = new Thread(mr, "张飞");
//        t1.start();
//
//        for (int x = 100; x > 0; x--) {
//            System.out.println("main");
//        }
//
//    }
//}

public class MyThread implements Runnable {
    private int count=80;
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "正在派发第" + count + "份学习笔记");
                count--;
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread=new MyThread();
        Thread th1 = new Thread(thread,"张三老师");
        Thread th2 = new Thread(thread,"李四老师");
        Thread th3 = new Thread(thread,"王五老师");
        th1.start();
        th2.start();
        th3.start();

    }
}