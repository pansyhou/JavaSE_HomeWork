package Exp8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class RoseJFrame extends JFrame
{
    private RoseCanvas canvas;                             //�Զ��廭�����
    private JButton button_color;                          //ѡ����ɫ��ť

    public RoseJFrame()
    {
        super("��Ҷõ����");                                //��ܱ߲���
        Dimension dim=getToolkit().getScreenSize();        //�����Ļ�ֱ���
        this.setBounds(dim.width/4,dim.height/4,dim.width/2,dim.height/2);  //���ھ���
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addComponentListener(new ReSizeHandler());      //ע������¼�������

        JPanel jpanel = new JPanel();                      //��������֣�����
        this.getContentPane().add(jpanel,"North");
        button_color = new JButton("ѡ����ɫ");
        jpanel.add(button_color);
        button_color.addActionListener(new ColorChoseHandler());

        canvas = new RoseCanvas(Color.red);                //�����Զ��廭�����
        this.getContentPane().add(canvas,"Center");
        this.setVisible(true);
    }
    class ColorChoseHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)             //��ť�����¼�������
        {
            Color c=JColorChooser.showDialog(RoseJFrame.this,"ѡ����ɫ",Color.blue); //����JColorChooser��ɫѡ��Ի��򣬷���ѡ����ɫ
            canvas.setColor(c);
            canvas.repaint();                                  //�ػ�
        }
    }
    class ReSizeHandler implements ComponentListener
    {
        public void componentResized(ComponentEvent e)         //�ı������Сʱ
        {
            RoseJFrame.this.repaint();                                    //�ػ�
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