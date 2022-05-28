public class Exp1_2 {
    public static void main(String[] args)
    {
        char answer;
        answer='A';
        switch (answer)
        {
            case 'A':
            {
                System.out.println("答案错误");
            }break;
            case 'B':
            {
                System.out.println("答案正确");
            }break;
            case 'C':
            {
                System.out.println("答案错误");
            }break;
            case 'D':
            {
                System.out.println("答案错误");
            }break;
            default:
                System.out.println("不存在此项");
        }
    }
}
