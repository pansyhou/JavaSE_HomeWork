package Exp8;



import java.awt.*;



public class RoseCanvas extends Canvas {//�������
    private Color color;                   //��ɫ

    public RoseCanvas(Color color)
    {
        this.setColor(color);
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void paint(Graphics g)                     //��Canvas����ͼ
    {
        int x0 = this.getWidth()/2;             //(x0,y0)��������е�����
        int y0 = this.getHeight()/2;
        g.setColor(color);                              //���û�����ɫ
        g.drawLine(x0,0,x0,y0*2);                         //��X��
        g.drawLine(0,y0,x0*2,y0);                          //��Y��
        for (int j=40; j<200; j+=20)               //������Ȧ��Ҷõ����

            for (int i=0; i<1023; i++)        //��һȦ��Ҷõ���ߵ����ɵ�
            {
                double angle = i*Math.PI/512;
                double radius = j*Math.sin(2*angle);
                int x =(int) Math.round(radius * Math.cos(angle) * 2);
                int y =(int) Math.round(radius * Math.sin(angle));
                g.fillOval(x0+x,y0+y,1,1);   //��ֱ��Ϊ1��Բ����һ����
            }


    }

}


