package Exp7;
import java.io.*;

public class Exp7_1 {
    public static void main(String[] args) {
        try {
            File filea=new File("C:\\Users\\16771\\Desktop\\java\\test2\\src\\Exp7\\a.txt");
            File fileb=new File("C:\\Users\\16771\\Desktop\\java\\test2\\src\\Exp7\\b.txt");
            File filec=new File("C:\\Users\\16771\\Desktop\\java\\test2\\src\\Exp7\\c.txt");
            FileInputStream inputStreama=new FileInputStream(filea);
            FileInputStream inputStreamb=new FileInputStream(fileb);
            InputStreamReader inputStreamReadera=new InputStreamReader(inputStreama);
            FileOutputStream fos=new FileOutputStream(filec,true);
            byte[] b=new byte[1024];
            int  length=0;
            while((length=inputStreama.read(b))!=-1) {
                fos.write(b,0,length);
            }

            fos.write("\r\n".getBytes());

            while((length=inputStreamb.read(b))!=-1) {
                fos.write(b,0,b.length);
            }
            inputStreama.close();
            inputStreamb.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
