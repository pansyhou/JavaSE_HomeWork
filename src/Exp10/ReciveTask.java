package Exp10;

import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReciveTask implements Runnable {

    private int recPort;

    public ReciveTask(int recPort) {
        this.recPort= recPort;
    }
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(recPort);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            while (true) {
                ds.receive(dp);
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println("收到" + dp.getAddress().getHostAddress() + "  发来的数据：" + str);

            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}