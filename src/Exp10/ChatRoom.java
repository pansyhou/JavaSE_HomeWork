package Exp10;


import java.util.Scanner;

public class ChatRoom {

    public static void main(String[] args) {
        System.out.println("欢迎来到聊天室");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入发送端口号");
        int sendPort=sc.nextInt();
        System.out.println("输入接收端口号");
        int recPort = sc.nextInt();
        System.out.println("启动");
        new Thread(new SendTaks(sendPort),"发送端任务").start();
        new Thread(new ReciveTask(recPort),"接收端任务").start();
    }
}


