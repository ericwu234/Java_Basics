import java.util.ArrayList;
class ClassManage{
    //private Student std;
    private ArrayList<Student> std = new ArrayList<Student>();
    public static String teacherNo="T100";
    private static int count=0;
    public static int getStudentCount(){
        return count;
    }
    public void addstd(Student st)
    {
        std.add(st);
        count++;
    }
    public void printClassInfo()
    {
        System.out.println("Teacher number:"+teacherNo);
        System.out.println("Student quality:"+getStudentCount());
        for(int i=0;i<getStudentCount();i++)
        {
            System.out.println("==student data "+(i+1)+"=================");
            System.out.println("Student number:"+std.get(i).getstdno());
            System.out.println("Student test1:"+std.get(i).gettest1());
            System.out.println("Student test2:"+std.get(i).gettest2());
            System.out.println("Student test3:"+std.get(i).gettest3());
        }
        
    }
}
class Student{
    //public static String teacherNo="T100";
    //private static int count=0;
    private int stdno;
    private double test1,test2,test3;
    //public ClassManage cm;
    public Student(int no,double t1,double t2,double t3){
        this.stdno=no;
        this.test1=t1;
        this.test2=t2;
        this.test3=t3;
       // count++;
        //ClassManage.addstd(this);
    }
    public int getstdno()
    {
        return this.stdno;
    }
    public double gettest1()
    {
        return this.test1;
    }
    public double gettest2()
    {
        return this.test2;
    }
    public double gettest3()
    {
        return this.test3;
    }

    /*public static int getStudentCount(){
        return count;
    }*/
    private double getAverage(){
        return (this.test1+this.test2+this.test3)/3;
    }
    public void printStudent(){
        System.out.println("==student data=================");
        System.out.println("Student number:"+this.stdno);
        System.out.println("Student test1:"+this.test1);
        System.out.println("Student test2:"+this.test2);
        System.out.println("Student test3:"+this.test3);
        System.out.println("test average"+getAverage());
    }
}

public class week7_2 {
    public static void main(String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        Student std1=new Student(1,68.0,88.0,56.0);
        Student std2=new Student(2,75.0,46.0,90.0);
        ClassManage one=new ClassManage();
        one.addstd(std1);
        one.addstd(std2);
        //System.out.println("teacher number(Student):"+ClassManage.teacherNo);
        //std1.printStudent();
        //std2.printStudent();
        //System.out.println("Student quality(std1):"+ClassManage.getStudentCount());
       // System.out.println("Student quality(std2):"+ClassManage.getStudentCount());
        //System.out.println("Student quality(Student):"+ClassManage.getStudentCount());
        //ClassManage.teacherNo="T101";
        one.teacherNo="T102";
       // System.out.println("teacher number(std1):"+one.teacherNo);
        //System.out.println("teacher number(std2):"+one.teacherNo);
        //System.out.println("teacher number(Student):"+ClassManage.teacherNo);
        one.printClassInfo();

    }
}