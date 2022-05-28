package Exp10;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerForTCP {



    public ServerForTCP() throws IOException {
        //����serversocket,��ʾ������
        ServerSocket serverSocket=new ServerSocket(7567);

        while (true) {
            final Socket client=serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //��ȡ�ͻ��˵������
                        OutputStream op = client.getOutputStream();
                        //ͨ������� д���ݵ�buf
                        System.out.println("��ʼ�Ϳͻ��˽�������");
                        op.write("�ͻ��˷���1".getBytes());
                        System.out.println("��������");
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
