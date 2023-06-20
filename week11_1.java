public class week11_1 {
    public static void main(String[] args){
        int n=0;
        java.util.Scanner sc=new java.util.Scanner(System.in);
        //while(n>=0){
        try{
            n=sc.nextInt();
            printNum(n);
        }
        catch(IllegalArgumentException e){
            System.out.println("exception explanation:"+e.getMessage());
            System.out.println("exception reason:");
            e.printStackTrace();
        }
        catch(ArithmeticException e){
            System.out.println("exception explanation:"+e.getMessage());
            System.out.println("exception reason:");
            e.printStackTrace();
        }
        finally{

        }
    //}
    }

static void printNum(int n)
    throws IllegalArgumentException,ArithmeticException{
    int i=0;
    if(n<0)
    {
        throw new IllegalArgumentException("n may not <0");
    }
    if(n>100)
    {
        throw new ArithmeticException("n may not >100");
    }
    while(i<=n)
    {
    System.out.print((2*i+1)+" ");
    i++;
    }
}
}