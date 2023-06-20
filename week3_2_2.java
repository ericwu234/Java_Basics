public class week3_2_2 
{
    public static void main(String[] args)
    {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("enter X:");
        int x = sc.nextInt();
        System.out.print("enter n power:");
        int n = sc.nextInt(), result;
        int i = 0;

        result = f(n, x, i);
        System.out.print("X^n=" + result);

    }

    public static int f(int n, int x, int i) 
    {
        i = i + 1;
        if (n == i) 
        {
            return x;
        } 
        else 
        {
            return f(n, x, i) * x;
        }

    }
}