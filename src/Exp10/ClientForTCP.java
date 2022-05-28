package Exp10;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientForTCP {

    public ClientForTCP() throws IOException {
        //创建一个Socket对象
        Socket client = new Socket(InetAddress.getLocalHost(),7567);

        //发送数据，或接收
        InputStream inputStream=client.getInputStream();

        byte[] buf = new byte[1024];
        int len=inputStream.read(buf);

        System.out.println(new String(buf,0,len));

        client.close();
    }

    public static void main(String[] args) throws IOException {
        new ClientForTCP();
    }
}
