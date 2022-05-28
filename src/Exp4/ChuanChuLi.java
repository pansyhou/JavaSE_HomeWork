package Exp4;

import java.util.Locale;

public class ChuanChuLi {
    public static void main(String[] args) {
        String string =new String("HelloWorld");
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<string.length();i++)
        {
            if(string.charAt(i)>'A'&&string.charAt(i)<'Z')
            {
                String t=new String(string.toLowerCase());
                char temp=t.charAt(i);
                stringBuffer.append(temp);

            }
            else if(string.charAt(i)>'a'&&string.charAt(i)<'z')
            {
                String t=new String(string.toUpperCase());
                char temp=t.charAt(i);
                stringBuffer.append(temp);
            }
        }
        System.out.println(stringBuffer);
    }
}
