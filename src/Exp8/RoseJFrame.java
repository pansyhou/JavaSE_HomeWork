package Exp8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class RoseJFrame extends JFrame
{
    private RoseCanvas canvas;                             //自定义画布组件
    private JButton button_color;                          //选择颜色按钮

    public RoseJFrame()
    {
        super("四叶玫瑰线");                                //框架边布局
        Dimension dim=getToolkit().getScreenSize();        //获得屏幕分辨率
        this.setBounds(dim.width/4,dim.height/4,dim.width/2,dim.height/2);  //窗口居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addComponentListener(new ReSizeHandler());      //注册组件事件监听器

        JPanel jpanel = new JPanel();                      //面板流布局，居中
        this.getContentPane().add(jpanel,"North");
        button_color = new JButton("选择颜色");
        jpanel.add(button_color);
        button_color.addActionListener(new ColorChoseHandler());

        canvas = new RoseCanvas(Color.red);                //创建自定义画布组件
        this.getContentPane().add(canvas,"Center");
        this.setVisible(true);
    }
    class ColorChoseHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)             //按钮单击事件处理方法
        {
            Color c=JColorChooser.showDialog(RoseJFrame.this,"选择颜色",Color.blue); //弹出JColorChooser颜色选择对话框，返回选中颜色
            canvas.setColor(c);
            canvas.repaint();                                  //重画
        }
    }
    class ReSizeHandler implements ComponentListener
    {
        public void componentResized(ComponentEvent e)         //改变组件大小时
        {
            RoseJFrame.this.repaint();                                    //重画
        }
        public void componentMoved(ComponentEvent e) {}
        public void componentHidden(ComponentEvent e) {}
        public void componentShown(ComponentEvent e) {}
    }

    public static void main(String arg[])
    {
        new RoseJFrame();
    }
}