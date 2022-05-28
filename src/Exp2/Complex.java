package Exp2;

public class Complex {
    private double real, im;                //实部，虚部

    public Complex(double real, double im) //构造方法
    {
        this.real = real;//对类里的成员变量进行赋值，用this关键字进行区别局部变量和成员变量
        this.im = im;
    }

    public Complex(double real)            //构造方法重载
    {
        this(real, 0);//当入参只有一个的时候会调用这个构造方法，然后再调用上面的构造方法
    }

    public Complex() {
        this(0, 0);//当没有入参时调用最上面的构造方法
    }

    public Complex(Complex c)              //拷贝构造方法
    {
        this(c.real, c.im);//当入参为一个complex类型时调用此构造方法
    }

    public boolean equals(Complex c)       //比较两个对象是否相等
    {
        return this.real == c.real && this.im == c.im;//运用短路与运算符判断是否相等，返回布尔类型
    }

    public String toString() {
        return "(" + this.real + "+" + this.im + "i)";//将Complex的数据打包成一个字符串
    }

    public void add(Complex c)             //两个对象相加
    {                                      //改变当前对象，没有返回新对象
        this.real += c.real;//将传入的complex类型的c里的变量加到成员变量里
        this.im += c.im;
    }

    public Complex plus(Complex c)         //两个对象相加，与add()方法参数一样不能重载
    {                                      //返回新创建对象，没有改变当前对象
        return new Complex(this.real + c.real, this.im + c.im);
    }

    public void subtract(Complex c)        //两个对象相减
    {                                      //改变当前对象，没有返回新对象
        this.real -= c.real;
        this.im -= c.im;
    }

    public Complex minus(Complex c)        //两个对象相减，与subtract()方法参数一样不能重载
    {                                      //返回新创建的对象，没有改变当前对象
        return new Complex(this.real - c.real, this.im - c.im);
    }
}

class Complex__ex {
    public static void main(String args[]) {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 5);
        Complex d = a.plus(b);             //plus方法返回新创建对象，赋予d这个引用变量
        System.out.println(a + " + " + b + " = " + d);
    }
}

