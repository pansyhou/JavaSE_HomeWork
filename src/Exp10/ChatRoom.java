package Exp10;


import java.util.Scanner;

public class ChatRoom {

    public static void main(String[] args) {
        System.out.println("��ӭ����������");
        Scanner sc = new Scanner(System.in);
        System.out.println("���뷢�Ͷ˿ں�");
        int sendPort=sc.nextInt();
        System.out.println("������ն˿ں�");
        int recPort = sc.nextInt();
        System.out.println("����");
        new Thread(new SendTaks(sendPort),"���Ͷ�����").start();
        new Thread(new ReciveTask(recPort),"���ն�����").start();
    }
}


