package Exp10;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientForTCP {

    public ClientForTCP() throws IOException {
        //����һ��Socket����
        Socket client = new Socket(InetAddress.getLocalHost(),7567);

        //�������ݣ������
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
