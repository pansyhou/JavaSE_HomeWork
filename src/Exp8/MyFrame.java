package Exp8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements ActionListener {
    private TextField text_Source, text_Target;            //�����ı���
    private Button button_Clear, button_Copy, button_Close; //3����ť

    public MyFrame() {
        super("My Frame");
        this.setBounds(300, 240, 500, 400);
        this.setBackground(Color.lightGray);                 //���ÿ�ܵı�����ɫ

        GridLayout gridLayout =new GridLayout(4,3);
        this.setLayout(gridLayout);//
        //��������3�����panel
        Panel pl_Text1=new Panel();
        Panel pl_Text2=new Panel();
        Panel button=new Panel();
        pl_Text1.setLayout(new FlowLayout(1,30,50));
        pl_Text2.setLayout(new FlowLayout(1,32,10));
        button.setLayout(new FlowLayout(1,70,10));

        //�ı���ı�ǩ������
        pl_Text1.add(new Label("Source"));
        text_Source = new TextField(10);
        pl_Text1.add(text_Source);

        pl_Text2.add(new Label("Target"));
        text_Target=new TextField(10);
        pl_Text2.add(text_Target);

        //��������尴ť����
        button_Clear=new Button("Clear");
        button_Copy=new Button("Copy");
        button_Close=new Button("Close");
        button.add(button_Clear);
        button.add(button_Copy);
        button.add(button_Close);

        //��ť���¼�����
        button_Clear.addActionListener(this);
        button_Copy.addActionListener(this);
        button_Close.addActionListener(this);

        //���������ӵ������У�����GridLayout
        this.add(pl_Text1);
        this.add(pl_Text2);
        this.add(button);



        this.addWindowListener(new WinClose()); //Ϊ���ע�ᴰ���¼���������ί��WinClose��Ķ������¼�

        this.setVisible(true);                             //��ʾ���
    }

    @Override//��ť�¼�����
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

    class WinClose implements WindowListener   //ʵ�ִ����¼��������ӿ�
    {
        public void windowClosing(WindowEvent e) //���ڹر��¼�������
        {
            System.exit(0);                          //������������
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
