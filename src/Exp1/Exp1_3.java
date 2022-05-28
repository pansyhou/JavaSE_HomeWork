public class Exp1_3 {

    int Cal_Area(int longg,int width)//计算矩形的方法
    {
        int sum;
        sum=longg*width;
        return sum;
    }
    double Cal_Area(double r)//计算圆的方法
    {
        return 3.14*r*r;
    }
    public static void main(String[] args)
    {
        int a1;
        double a2;
        Exp1_3 Cal_Area1=new Exp1_3();//创建对象
        a1=Cal_Area1.Cal_Area(30, 20);
        a2=Cal_Area1.Cal_Area(6);
        System.out.println(a1);
        System.out.println(a2);
    }
}
