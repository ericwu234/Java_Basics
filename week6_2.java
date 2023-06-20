class Box{
    private int width;
    private int height;
    private int length;
    public Box(int w,int h,int l)
    {
        this.width=w;
        this.height=h;
        this.length=l;
    }
    public int volume()
    {
        int v;
        v=width*height*length;
        return v;
    }
    public int area()
    {
        int a;
        a=width*height*2+width*length*2+length*height*2;
        return a;
    }
}
public class week6_2 {
    public static void main(String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int w,h,l,v,a;
        System.out.println("Enter width height and length:");
        w=sc.nextInt();
        h=sc.nextInt();
        l=sc.nextInt();
        Box first=new Box(w,h,l);
        v=first.volume();
        a=first.area();
        System.out.println("box volume:"+v+" area:"+a);
    }
}