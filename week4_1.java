public class week4_1{
    public static void main (String[] args){
        final int len=12;
        int[] arr=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=i;
        }
        int sum=0;
        float ave=0;
        for(int i=0;i<len;i++)
        {
            sum+=arr[i];
        }
        ave=(float)sum/len;
        System.out.print("sum:"+sum+" average:"+ave);
    }
}