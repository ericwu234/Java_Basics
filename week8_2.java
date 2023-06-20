class Student{
    private int stdNo;
    private String name;
    private String address;
    public double score;
    public Student(int sn,String n,String a,double s){
        this.stdNo=sn;
        this.name=n;
        this.address=a;
        this.score=s;
    }
    public int getNo(){
        return this.stdNo;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }

}
class GraduateStudent extends Student{
    private double score;
    private String department;
    public GraduateStudent(int sn,String n,String a,double s,String d){
        super(sn,n,a,s);
        this.department=d;
    }
    public void printGraduate(){
        System.out.println("==[imformation]===========");
        System.out.println("stdNo:"+getNo());
        System.out.println("name::"+getName());
        System.out.println("address:"+getAddress());
        System.out.println("score:"+super.score);
        System.out.println("department:"+this.department);

    }
}
public class week8_2 {
    public static void main(String[] args) {
        GraduateStudent Eric=new GraduateStudent(32,"Eric","Taipei",90.0,"CSIE");
        GraduateStudent jack=new GraduateStudent(28, "Jack", "New Taipei",87.0,"CSIE");
        jack.printGraduate();
        Eric.printGraduate();
    }
}