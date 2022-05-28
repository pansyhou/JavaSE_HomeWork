package Exp10;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerForTCP {



    public ServerForTCP() throws IOException {
        //创建serversocket,表示服务器
        ServerSocket serverSocket=new ServerSocket(7567);

        while (true) {
            final Socket client=serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取客户端的输出流
                        OutputStream op = client.getOutputStream();
                        //通过输出流 写数据的buf
                        System.out.println("开始和客户端交换数据");
                        op.write("客户端发送1".getBytes());
                        System.out.println("结束交互");
                        op.close();
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        new ServerForTCP();
    }
}
