public class week4_1_2{
    public static void main (String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int[] arr=new int[6];
        int max=0,max_a=0;
        System.out.println("enter 6 number that the range is 1~100:");
        for(int i=0;i<6;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<6;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                max_a=i;
            }
        }
        System.out.print("max:"+max+"=arr["+max_a+"]");
    }
}