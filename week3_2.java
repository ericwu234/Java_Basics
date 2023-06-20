public class week3_2{
    public static void main (String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n=sc.nextInt(),result;
        
        for(int i=1;i<=n;i++)
        {
            result=fibonacci(i);
            System.out.print(result+" ");
        }
    }
    public static int fibonacci(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        else
        {
            return fibonacci(n-1)+fibonacci(n-2);
        }
        
    }
}