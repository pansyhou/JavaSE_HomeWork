public class Exp1_4 {
    public static void main(String[] args) 
	{
		int[] arr = {23,87,45,36,56,17};
		System.out.println("排序前");
		printArray(arr);
		bubbleSort(arr);
	    System.out.println("排序后");
		printArray(arr);
	}
      public static void bubbleSort(int[] arr)  
	{
        int i=0,t=0;
        for(;i<arr.length;i++)
        {
            for(t=0;t<arr.length-1;t++)
            {
                if(arr[t]>arr[t+1])
                {
                    int temp=arr[t];
                    arr[t]=arr[t+1];
                    arr[t+1]=temp;
                }
            }
        }
	}
     public static  void printArray(int[] arr)
	{
        for(int p=0;p<arr.length;p++)
        {
            System.out.print(arr[p]+" ");
        }
	}
}
