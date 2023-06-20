public class week5_2_2{
	public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        final int len=10;
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        numCount(arr);
    }
    static void numCount(int[] arr)
    {
        int even=0,odd=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0)
            {
                even++;
            }
            else
            {
                odd++;
            }
        }
        System.out.print("even:"+even+" odd:"+odd);
    }
}