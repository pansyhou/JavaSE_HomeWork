package Exp9;

//public class MyThread extends Thread {
//
//    //��1��ͨ���̳�Thread�࣬ʵ�ֶ��߳�
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
//��2��ͨ��ʵ��Runnable�ӿڣ�ʵ�ֶ��߳�
//public class MyThread implements Runnable{
//
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {//sleep�ᷢ���쳣Ҫ��ʾ����
//                Thread.sleep(20);//��ͣ20����
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "����:" + i + "��С��");
//        }
//    }
//
//    public static void main(String[] args) {
//        //����MyRunnable��
//        MyThread mr = new MyThread();
//        //����Thread����вι���,�������߳���
//        Thread t1 = new Thread(mr, "�ŷ�");
//        Thread t2 = new Thread(mr, "����");
//        Thread t3 = new Thread(mr, "����");
//        //�����߳�
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
//        //����MyRunnable��
//        MyThread mr = new MyThread();
//        //����Thread����вι���,�������߳���
//        Thread t1 = new Thread(mr, "�ŷ�");
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
                System.out.println(Thread.currentThread().getName() + "�����ɷ���" + count + "��ѧϰ�ʼ�");
                count--;
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread=new MyThread();
        Thread th1 = new Thread(thread,"������ʦ");
        Thread th2 = new Thread(thread,"������ʦ");
        Thread th3 = new Thread(thread,"������ʦ");
        th1.start();
        th2.start();
        th3.start();

    }
}