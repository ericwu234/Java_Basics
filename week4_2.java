public class week4_2{
    public static void main (String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int[] arr=new int[20];
        int min=21,c=0;
        for(int i=0;i<20;i++)
        {
            arr[i]=(int)(Math.random()*20+1);
        }
        for(int i=0;i<20;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n");
        for(int i=0;i<20;i++)
        {
            for(int j=i+1;j<20;j++)
            {
                if(arr[j]<min)
                {
                    min=arr[j];
                    c=j;
                }
            }
            if(arr[i]>min)
            {
            arr[c]=arr[i];
            arr[i]=min;
            }
            min=21;
        }
        for(int i=0;i<20;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}