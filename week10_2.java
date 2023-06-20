public class week10_2 {
    public static void main(String[] args){
        int t1,t2,s1,n1=10;
        double s2,n2=10.5;
        Square sq=new Square();
        s1=sq.square(n1);
        s2=sq.square(n2);
        t1=sq.getMax(2,3,8,4);
        t2=sq.getMax(4,7,2);
        System.out.println(s1+" "+s2+" "+t1+" "+t2);
    }
}
class Square{
    public int square(int n){
        return n*n;
    }
    public double square(double n){
        return n*n;
    }
    public int getMax(int n1,int n2,int n3,int n4){
        int max=0;
        max=getMax(n1, n2, n3);
        max=max(max,n4);
        return max;
    }
    public int getMax(int n1,int n2,int n3){
        int max=0;
        max=max(n1,n2);
        max=max(max,n3);
        return max;
    }
    public int max(int n1,int n2){
        int max=0;
        if(n1>n2){
            return n1;
        }
        else{
            return n2;
        }
    }

}
