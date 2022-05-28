public class Exp1_5 {
    public static void main(String[] args)
    {
        char [][]f=new char[4][7];
        int hang=1;
        for(int i=0;i<4;i++)
        {
            
            for(int t=0;t<hang;t++)
            {
                f[i][t]='*';
            }
            hang=hang+2;
        }
        {
            for(int i=0;i<4;i++)
            {
                for(int t=0;t<7;t++)
                {
                    System.out.print(f[i][t]);
                }
                System.out.println();
            }
        }
    }
}
