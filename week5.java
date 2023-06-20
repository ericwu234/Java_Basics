public class week5{
	public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        System.out.print("(a*b matrix)*(b*a matrix)\na=");
        int a=sc.nextInt();
        System.out.print("b=");
        int b=sc.nextInt();
        int k=0;
        int[] n1=new int[a*b];
        int[] n2=new int[b*a];
        int[] ans=new int[a*a];
        for(int i=0;i<a*a;i++)
        {
            ans[i]=0;
        }
        System.out.print("first matrix:");
        for(int i=0;i<a*b;i++)
        {
            n1[i]=sc.nextInt();
        }
        System.out.print("second matrix:");
        for(int i=0;i<b*a;i++)
        {
            n2[i]=sc.nextInt();
        }
        for(int m=0;m<a;m++)
        {
            for(int j=0;j<a;j++)
            {
                for(int i=0;i<b;i++)
                {
                    ans[k]=ans[k]+n1[i+m*b]*n2[i*a+j];
                }
            k++;
            }
        
        }
        System.out.print("result matrix:");
        for(int i=0;i<a*a;i++)
        {
            System.out.print(ans[i]+" ");
        }
    }
}