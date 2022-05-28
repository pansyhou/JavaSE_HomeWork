package Exp10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendTaks implements Runnable {
    private final int sendport;

    public SendTaks(int port) {
        this.sendport = port;
    }

    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            while (true) {
                String data = sc.nextLine();
                byte[] buf = data.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), sendport);
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
