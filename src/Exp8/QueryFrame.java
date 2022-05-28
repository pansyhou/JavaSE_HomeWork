package Exp8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//1.搭建界面
public class QueryFrame extends Frame {                 //框架窗口响应单击事件
    private TextField text_char, text_uni;                 //两个文本行
    private Button button_char, button_uni;                //两个按钮

    public QueryFrame() {
        super("Unicode字符查询器");                       //窗口标题
        this.setBounds(300, 240, 300, 100); //设置框架的位置和尺寸
        this.setBackground(Color.lightGray);                 //设置框架的背景颜色
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));    //框架流布局且左对齐

        QueryHandler q= new QueryHandler();                  //生成监听器对象
        this.add(new Label("字符"));
        //新增文本行
        text_char = new TextField("汉", 10);
        this.add(text_char);
        //新增按钮
        button_char = new Button("查询Unicode码");
        this.add(button_char);
        button_char.addActionListener(q);  //为按钮注册单击事件监听器

        this.add(new Label("Unicode码"));
        text_uni = new TextField(10);
        this.add(text_uni);
        button_uni = new Button("     查询字符      ");
        this.add(button_uni);
        button_uni.addActionListener(q);   //为按钮注册单击事件监听器
        this.setVisible(true);                             //显示框架

        //为框架注册窗口事件监听器，委托WinClose类的对象处理事件
        this.addWindowListener(new WinClose());
    }

    //为相应控件设置事件处理类
    class QueryHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)  //单击事件处理方法，实现ActionListener接口
        {
            if (e.getSource()==button_char)  //e.getSource()获得当前事件源组件，比较引用
            {
                String str = text_char.getText();        //获得文本行的字符串
                char ch=str.charAt(0);             //获得首字符
                text_char.setText(""+ch);          //重新设置文本，显示字符
                text_uni.setText(""+(int)ch);    //显示ch的Unicode码
            }
            if (e.getSource()==button_uni)
            {
                int uni=Integer.parseInt(text_uni.getText());  //将文本行字符串转换成整数，未捕获NumberFormatException异常
                text_char.setText(""+(char)uni);               //显示uni中Unicode码对应的字符
            }
        }
    }

    class WinClose implements WindowListener   //实现窗口事件监听器接口
    {
        public void windowClosing(WindowEvent e) //窗口关闭事件处理方法
        {
            System.exit(0);                          //结束程序运行
        }

        public void windowOpened(WindowEvent e)         {  }
        public void windowActivated(WindowEvent e)      {  }
        public void windowDeactivated(WindowEvent e)    {  }
        public void windowClosed(WindowEvent e)         {  }
        public void windowIconified(WindowEvent e)      {  }
        public void windowDeiconified(WindowEvent e)    {  }
    }

    public static void main(String arg[]) {
        new QueryFrame();
    }
}

