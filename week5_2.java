public class week5_2{
	public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        final int len=10;
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        reverse(arr);
        for(int i=0;i<len;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    static void reverse(int[] arr)
    {
        int temp;
        for(int i=0,j=arr.length-1;i<arr.length/2;i++,j--)
        {
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}