package Exp8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements ActionListener {
    private TextField text_Source, text_Target;            //两个文本行
    private Button button_Clear, button_Copy, button_Close; //3个按钮

    public MyFrame() {
        super("My Frame");
        this.setBounds(300, 240, 500, 400);
        this.setBackground(Color.lightGray);                 //设置框架的背景颜色

        GridLayout gridLayout =new GridLayout(4,3);
        this.setLayout(gridLayout);//
        //声明新增3个面板panel
        Panel pl_Text1=new Panel();
        Panel pl_Text2=new Panel();
        Panel button=new Panel();
        pl_Text1.setLayout(new FlowLayout(1,30,50));
        pl_Text2.setLayout(new FlowLayout(1,32,10));
        button.setLayout(new FlowLayout(1,70,10));

        //文本框的标签和设置
        pl_Text1.add(new Label("Source"));
        text_Source = new TextField(10);
        pl_Text1.add(text_Source);

        pl_Text2.add(new Label("Target"));
        text_Target=new TextField(10);
        pl_Text2.add(text_Target);

        //第三个面板按钮设置
        button_Clear=new Button("Clear");
        button_Copy=new Button("Copy");
        button_Close=new Button("Close");
        button.add(button_Clear);
        button.add(button_Copy);
        button.add(button_Close);

        //按钮的事件监听
        button_Clear.addActionListener(this);
        button_Copy.addActionListener(this);
        button_Close.addActionListener(this);

        //将三个面板加到窗体中，交给GridLayout
        this.add(pl_Text1);
        this.add(pl_Text2);
        this.add(button);



        this.addWindowListener(new WinClose()); //为框架注册窗口事件监听器，委托WinClose类的对象处理事件

        this.setVisible(true);                             //显示框架
    }

    @Override//按钮事件监听
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Clear) {
            text_Source.setText("");
            text_Target.setText("");
        }
        if (e.getSource() == button_Close) {
            System.exit(0);
        }
        if (e.getSource()==button_Copy) {
            text_Target.setText(text_Source.getText());
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

    public static void main(String[] args) {
        new MyFrame();
    }
}
